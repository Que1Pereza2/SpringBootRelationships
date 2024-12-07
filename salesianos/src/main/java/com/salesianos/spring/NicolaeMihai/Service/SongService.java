/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import java.util.List;

/**
 *
 * @author Baljeet
 */
public interface SongService {
    
    public Song getSong(Long id);
    public List<Song> getAllSongs();
    public Song addSong( String nombre, Artist artist);
    public Song updateSong(Long id,String nombre);
    public Song deleteSong(Long id);
}
