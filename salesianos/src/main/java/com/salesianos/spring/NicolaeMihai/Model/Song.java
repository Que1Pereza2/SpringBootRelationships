/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Baljeet
 */
@Entity
@Table(name = "song")
public class Song {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "song_artist_FK")
    private Artist artist;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="song_Playlist",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name ="id")}
    )
    private List<SongPlaylist> songPlaylist;
    
    public Song(String name, Artist artist){
        this.name=name;
        this.artist=artist;
    }

    public List<SongPlaylist> getSongPlaylist() {
        return songPlaylist;
    }

    public void setSongPlaylist(List<SongPlaylist> songPlaylist) {
        this.songPlaylist = songPlaylist;
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

    public Artist getIdArtist() {
        return artist;
    }

    public void setIdArtist(Artist artist) {
        this.artist = artist;
    }

}
