/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Controller;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
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
 *
 * @author Baljeet
 */
@RestController
public class SongController {
    
    @Autowired
    private SongService repository;
    
    @GetMapping("/Songs")
    public List<Song> getAllSongs(){
        return repository.getAllSongs();
    }
    
    @GetMapping("/Song/{id}")
    public Song getSong(@PathVariable Long id){
        return repository.getSong(id);
    }
    
    @PostMapping("/Insert/Song/")
    public Song insertSong(@RequestBody String name, @RequestBody Artist artist){
        return repository.addSong(name, artist);
    }
    
    @PutMapping("/Modify/Song/{id}")
    public Song modifySong(@PathVariable Long id, @RequestBody String name){
          Song songToModify = repository.getSong(id);
          songToModify.setName(name);
          return repository.updateSong(id,name);
    }
    
    @DeleteMapping("/Delete/Song/{id}")
    public Song deleteSong(@PathVariable Long id){
        return repository.deleteSong(id);
    }
}
