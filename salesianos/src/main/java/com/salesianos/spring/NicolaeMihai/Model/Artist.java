/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Artist model class
 * @author Baljeet
 */
@Entity
@Table(name="artist")
public class Artist {
    
    /**
     * Id of the Artist
     */
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;
    
    /**
     * Name of the Artist
     */
    @Column(nullable=false)
    private String name;

    /**
     * List of the Artist's songs
     * we ignore the artist property in order to avoid an infinite loop
     */
    @JsonIgnoreProperties("artist")
    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Song> songs;

    /**
     *  Creates an empty Artist
     */
    public Artist(){
        
    }
    
    /**
     * Creates a new Artist
     * @param name Artist's name
     */
    public Artist(String name){
     this.name=name;   
    }
    
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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
    
}
