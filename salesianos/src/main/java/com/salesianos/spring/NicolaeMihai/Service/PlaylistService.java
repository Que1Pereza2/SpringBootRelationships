/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import java.util.List;

/**
 *
 * @author Baljeet
 */
public interface PlaylistService {
    
    public List<Playlist> getAllPlaylists();
    public Playlist getPlaylist(Long id);
    public Playlist addPlaylist(String name, String nameCreator);
    public Playlist updatePlaylist(Long id,String name);
    public Playlist deletePlaylist(Long id);
}
