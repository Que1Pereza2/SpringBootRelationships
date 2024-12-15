package com.salesianos.spring.NicolaeMihai.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Playlist model class
 * @author Baljeet
 */
@Entity
@Table(name = "playlist")
public class Playlist {

    /**
     * Id of the Playlist
     */    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    /**
     * Name of the Playlist
     */
    @Column(name = "name")
    private String name;
    
    /**
     * Name of the creator of the Playlist
     */
    @Column(name ="creator")
    private String creator;
    
    /**
     * List of the Playlist's songs
     * we ignore the playlists property in order to avoid an infinite loop
     */    
    @JsonIgnoreProperties("playlists")
    @ManyToMany( mappedBy = "playlists")
    private List<Song> songs;
    
    /**
     *  Creates an empty Playlist
     */
    public Playlist(){
        
    }

    /**
     * Creates a new Playlist
     * @param name Playlist's name
     * @param creator Playlist's creator name
     */
    public Playlist(String name, String creator) {
        this.name = name;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
