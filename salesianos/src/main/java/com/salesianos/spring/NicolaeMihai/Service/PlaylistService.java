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
    
    public Playlist getPlaylist(Long id);
    public List<Playlist> getAllPlaylist();
    public Playlist addPlaylist(String name, String nameCreator);
    public Playlist updatePlaylist(Long id,String name);
    public Playlist deletePlaylist(Long id);
}
