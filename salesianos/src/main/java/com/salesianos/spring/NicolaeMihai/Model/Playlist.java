/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Baljeet
 */
@Entity
@Table(name = "playlist")
public class Playlist {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name ="creator")
    private String creator;
    
    @ManyToMany(mappedBy = "playlists")
    private List<Song> songs;
    
    public Playlist(){
        
    }

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
