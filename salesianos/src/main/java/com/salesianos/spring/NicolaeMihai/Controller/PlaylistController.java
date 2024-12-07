/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Controller;

import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Baljeet
 */
@RestController
public class PlaylistController {
 
    
    @Autowired
    private PlaylistService repository;
    
    @GetMapping("/Playlist")
    public List<Playlist> getAllPlaylists(){
        return repository.getAllPlaylists();
    }
    
    @GetMapping("/Playlist/{id}")
    public Playlist getPlaylist(@PathVariable Long id){
        return repository.getPlaylist(id);
    }
    
    @PostMapping("/Insert/Playlist/")
    public Playlist insertPlaylist(@RequestBody String name, @RequestBody String nameCreator){
        return repository.addPlaylist(name, nameCreator);
    }
    
    @PutMapping("/Modify/Playlist/{id}")
    public Playlist modifyPlaylist(@PathVariable Long id, @RequestBody String name){
          Playlist playlistToModify = repository.getPlaylist(id);
          playlistToModify.setName(name);
          return repository.updatePlaylist(id,name);
    }
    
    @DeleteMapping("/Delete/Playlist/{id}")
    public Playlist deletePlaylist(@PathVariable Long id){
        return repository.deletePlaylist(id);
    }
}
