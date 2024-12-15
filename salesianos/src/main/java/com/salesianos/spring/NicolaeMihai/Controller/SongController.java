package com.salesianos.spring.NicolaeMihai.Controller;

import RequestObject.RequestSong;
import RequestObject.RequestSongPlaylist;
import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Service.ArtistService;
import com.salesianos.spring.NicolaeMihai.Service.PlaylistService;
import com.salesianos.spring.NicolaeMihai.Service.SongService;
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
 * Class that implements an Song Controller
 * @author Baljeet
 */
@RestController
public class SongController {
    
     /**
     * Link with Song service
     */
    @Autowired
    private SongService repository;
    
    /**
    * Link with Artist service
    */    
    @Autowired
    private ArtistService artistRepository;

    /**
    * Link with Playlist service
    */    
    @Autowired
    private  PlaylistService playlistRepository;
    
     /**
     * Get method to obtain all the Songs 
     * @return a list of all the Songs stored in the database
     */
    @GetMapping("/Songs")
    public List<Song> getAllSongs(){
        return repository.getAllSongs();
    }
    
    /**
     * Get method to obtain an Song
     * @param id identifier of the Song you want to obtain
     * @return the Song whose id coincides with {id}
     */
    @GetMapping("/Song/{id}")
    public Song getSong(@PathVariable Long id){
        return repository.getSong(id);
    }
    
    /**
     * Post method to modify insert an Song
     * @param requestSong the name that the Song will have
     * @return a JSON of the created Song
     */
    @PostMapping("/Insert/Song/")
    public Song insertSong(@RequestBody RequestSong requestSong){
        requestSong.getSong().setArtist(artistRepository.getArtist(requestSong.getArtistId()));
        return repository.addSong(requestSong.getSong());
    }
    
    /**
     * Put method to modify an Song name
     * @param id identifier of the Song
     * @param name the new name of the Song
     * @return the updated Song
     */
    @PutMapping("/Modify/Song/{id}")
    public Song modifySong(@PathVariable Long id, @RequestBody String name){
          Song songToModify = repository.getSong(id);
          songToModify.setName(name);
          return repository.updateSong(id,name);
    }
    
    /**
     * Put method that inserts a song into a playlist
     * @param rsp RequestSongPlaylist that contains the Id of the song and the playlist
     * @return the modified playlist
     */
    @PutMapping("/Modify/Song/Playlist/")
    public Playlist insertSongToPlaylist(@RequestBody RequestSongPlaylist rsp){
        return playlistRepository.addSongToPlaylist(rsp);
    }
    
    /**
     * Delete method that deletes a Song
     * @param id identifier of the Song to delete
     * @return the deleted Song
     */
    @DeleteMapping("/Delete/Song/{id}")
    public Song deleteSong(@PathVariable Long id){
        Song songToDelete= repository.getSong(id);
        repository.deleteSong(id);
        return songToDelete;
    }
}
