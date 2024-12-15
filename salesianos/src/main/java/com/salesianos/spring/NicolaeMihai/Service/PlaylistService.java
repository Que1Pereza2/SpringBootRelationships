/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import RequestObject.RequestSongPlaylist;
import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import java.util.List;

/**
 *  Class that creates the Playlist service interface
 * @author Baljeet
 */
public interface PlaylistService {
    
    public List<Playlist> getAllPlaylists();
    public Playlist getPlaylist(Long id);
    public Playlist addPlaylist(Playlist playlist);
    public Playlist addSongToPlaylist(RequestSongPlaylist rsp);
    public Playlist updatePlaylist(Long id,String name);
    public void deletePlaylist(Long id);
}
