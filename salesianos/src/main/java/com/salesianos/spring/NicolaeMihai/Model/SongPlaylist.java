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
@Table(name = "song_playlist")
public class SongPlaylist {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    @ManyToMany
    private List<Playlist> playlists;
    
    @ManyToMany
    private List<Song> songs;

    public SongPlaylist(List<Playlist> playlists, List<Song> songs){
        this.playlists=playlists;
        this.songs=songs;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongId(List<Song> songs) {
        this.songs = songs;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylistId(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}