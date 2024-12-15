/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import RequestObject.RequestSongPlaylist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import java.util.List;

/**
 *  Class that creates the Song service interface
 * @author Baljeet
 */
public interface SongService {
    
    public List<Song> getAllSongs();
    public Song getSong(Long id);
    public Song addSong( Song song);
    public Song addSongToPlaylist( RequestSongPlaylist rsp);
    public Song updateSong(Long id,String nombre);
    public void deleteSong(Long id);
}
