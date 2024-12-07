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
    
    @ManyToMany(mappedBy = "songPlaylist")
    private List<SongPlaylist> songPlaylist;

    public Playlist(String name, String creator) {
        this.name = name;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}
