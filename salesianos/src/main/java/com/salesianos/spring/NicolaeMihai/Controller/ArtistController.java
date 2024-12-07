/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Controller;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import com.salesianos.spring.NicolaeMihai.Service.ArtistService;
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
public class ArtistController {
    
    @Autowired
    private ArtistService repository;
    
    @GetMapping("/Artists")
    public List<Artist> getAllArtists(){
        return repository.getAllArtist();
    }
    
    @GetMapping("/Artist/{id}")
    public Artist getArtist(@PathVariable Long id){
        return repository.getArtist(id);
    }
    
    @PostMapping("/Insert/Artist/")
    public Artist insertArtist(@RequestBody String name){
        return repository.addArtist(name);
    }
    
    @PutMapping("/Modify/Artist/{id}")
    public Artist modifyArtist(@PathVariable Long id, @RequestBody String name){
          Artist artistToModify = repository.getArtist(id);
          artistToModify.setName(name);
          return repository.updateArtist(id,name);
    }
    
    @DeleteMapping("/Delete/Artist/{id}")
    public Artist deleteArtist(@PathVariable Long id){
        return repository.deleteArtist(id);
    }
}