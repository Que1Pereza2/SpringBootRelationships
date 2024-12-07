/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Repository.PlaylistRepository;
import com.salesianos.spring.NicolaeMihai.Service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Baljeet
 */
@Service
public class PlaylistServiceIMPL implements PlaylistService{

    @Autowired
    private final PlaylistRepository repository;
    
    public PlaylistServiceIMPL(PlaylistRepository repository){
        this.repository=repository;
    }
    
    @Override
    public Playlist getPlaylist(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }

    @Override
    public Playlist addPlaylist(@RequestBody String name, @RequestBody String creatorName) {
        Playlist newPlaylist = new Playlist(name, creatorName);
        return repository.save(newPlaylist);
    }

    @Override
    public Playlist updatePlaylist(Long id, String nombre) {
        Playlist playlistToUpdate = repository.findById(id).get();
        playlistToUpdate.setName(nombre);
        return repository.save(playlistToUpdate);
    }

    @Override
    public Playlist deletePlaylist(Long id) {
        Playlist playlistToDelete = repository.findById(id).get();
        repository.delete(playlistToDelete);
        return playlistToDelete;
    }
    
}
