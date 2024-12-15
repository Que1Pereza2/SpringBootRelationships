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
 * Class that implements an Artist Controller
 * @author Baljeet
 */
@RestController
public class ArtistController {
    
    /**
     * Link with Artist service
     */
    @Autowired
    private ArtistService repository;
    
    /**
     * Get method to obtain all the Artists 
     * @return a list of all the Artists stored in the database
     */
    @GetMapping("/Artists")
    public List<Artist> getAllArtists(){
        return repository.getAllArtist();
    }
    
    /**
     * Get method to obtain an Artist
     * @param id identifier of the Artist you want to obtain
     * @return the Artist whose id coincides with {id}
     */
    @GetMapping("/Artist/{id}")
    public Artist getArtist(@PathVariable Long id){
        return repository.getArtist(id);
    }
    
    /**
     * Post method to modify insert an Artist
     * @param name the name that the Artist will have
     * @return a JSON of the created Artist
     */
    @PostMapping("/Insert/Artist/")
    public Artist insertArtist(@RequestBody String name){
        return repository.addArtist(name);
    }
    
    /**
     * Put method to modify an Artist name
     * @param id identifier of the Artist
     * @param name the new name of the Artist
     * @return the updated Artist
     */
    @PutMapping("/Modify/Artist/{id}")
    public Artist modifyArtist(@PathVariable Long id, @RequestBody String name){
          Artist artistToModify = repository.getArtist(id);
          artistToModify.setName(name);
          return repository.updateArtist(id,name);
    }
    
    /**
     * Delete method that deletes a Artist
     * @param id identifier of the Artist to delete
     * @return the deleted Artist
     */
    @DeleteMapping("/Delete/Artist/{id}")
    public Artist deleteArtist(@PathVariable Long id){
        Artist artistToDelete =  repository.getArtist(id);
        repository.deleteArtist(id);
        return artistToDelete;
    }
}