package com.salesianos.spring.NicolaeMihai.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Song model class
 * @author Baljeet
 */

@Entity
@Table(name = "song")
public class Song {

    /**
     * Id of the Song
     */   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    /**
     * Name of the Song
     */
    @Column(nullable = false)
    private String name;
    
    /**
     * The Artist that created the song
     */
    @JsonIgnoreProperties("songs")
    @ManyToOne
    @JoinColumn(name = "song_artist_FK")
    private Artist artist;

    /**
     * List of playlists in which the song is located
     * We ignore the songs property in order to avoid an infinite loop
     */
    @JsonIgnoreProperties("songs")
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name="songPlaylist",
            joinColumns = @JoinColumn(name = "idSong", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name ="idPlaylist", referencedColumnName = "id")
    )
    private List<Playlist> playlists;
    
    /**
     *  Creates an empty Song
     */
    public Song(){
    }
    
    /**
     * Creates a new Song
     * @param name Song's name
     */
    public Song(String name){
        this.name=name;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}