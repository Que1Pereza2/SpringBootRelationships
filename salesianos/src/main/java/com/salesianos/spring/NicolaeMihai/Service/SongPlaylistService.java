/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Model.SongPlaylist;
import java.util.List;

/**
 *
 * @author Baljeet
 */
public interface SongPlaylistService {
    
    public SongPlaylist getSongPlaylist(Long id);
    public List<SongPlaylist> getAllSongPlaylist();
    public SongPlaylist addSongPlaylist( List<Song> songId, List<Playlist> playlistId);
    public SongPlaylist deleteSongPlaylist(Long id);
}
