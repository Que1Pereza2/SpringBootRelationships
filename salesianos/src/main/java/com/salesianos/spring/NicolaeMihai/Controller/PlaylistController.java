/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Controller;

import RequestObject.RequestSongPlaylist;
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
 * Class that implements an Playlist Controller
 * @author Baljeet
 */
@RestController
public class PlaylistController {
 
     /**
     * Link with Playlist service
     */
    @Autowired
    private PlaylistService repository;
    
    /**
     * Get method to obtain all the Playlists 
     * @return a list of all the Playlists stored in the database
     */
    @GetMapping("/Playlists")
    public List<Playlist> getAllPlaylists(){
        return repository.getAllPlaylists();
    }
    
    /**
     * Get method to obtain an Playlist
     * @param id identifier of the Playlist you want to obtain
     * @return the Playlist whose id coincides with {id}
     */
    @GetMapping("/Playlist/{id}")
    public Playlist getPlaylist(@PathVariable Long id){
        return repository.getPlaylist(id);
    }
    
    /**
     * Post method to modify insert an Playlist
     * @param playlist the JSON of the Playlist
     * @return a JSON of the created Playlist
     */
    @PostMapping("/Insert/Playlist/")
    public Playlist insertPlaylist(@RequestBody Playlist playlist){
        return repository.addPlaylist(playlist);
    }
    
     /**
     * Put method to modify an Playlist name
     * @param id identifier of the Playlist
     * @param name the new name of the Playlist
     * @return the updated Playlist
     */
    @PutMapping("/Modify/Playlist/{id}")
    public Playlist modifyPlaylist(@PathVariable Long id, @RequestBody String name){
          Playlist playlistToModify = repository.getPlaylist(id);
          playlistToModify.setName(name);
          return repository.updatePlaylist(id,name);
    }
    
    /**
     * Put method that inserts a song into a playlist
     * @param rsp RequestSongPlaylist that contains the Id of the song and the playlist
     * @return the modified playlist
     */
    @PutMapping("/Modify/Playlist/Song/")
    public Playlist modifyPlaylist(@RequestBody RequestSongPlaylist rsp){
          return  repository.addSongToPlaylist(rsp);
    }
    
    /**
     * Delete method that deletes a Playlist
     * @param id identifier of the Playlist to delete
     * @return the deleted Playlist
     */
    @DeleteMapping("/Delete/Playlist/{id}")
    public Playlist deletePlaylist(@PathVariable Long id){
        Playlist playlistToDelete = repository.getPlaylist(id);
        repository.deletePlaylist(id);
        return playlistToDelete;
    }
}
