package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import com.salesianos.spring.NicolaeMihai.Repository.ArtistRepository;
import com.salesianos.spring.NicolaeMihai.Service.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class that implements the Artist Service functions.
 * @author Baljeet
 */
@Service
public class ArtistServiceIMPL implements  ArtistService{

    /**
     * Links to the Artist repository.
     */
    @Autowired
   private final ArtistRepository repository;
    
    /**
     * Constructor for the Artist Service implementation
     * @param repository Artist repository instance
     */
    public ArtistServiceIMPL(ArtistRepository repository){
        this.repository=repository;
    }
    
        /**
     * Function that obtains all the Artists in the database.
     * @return returns a list of Artists
     */
    @Override
    public List<Artist> getAllArtist() {
       return repository.findAll();
    }
    
    /**
    *  Function that finds a specific Artist based by ID
    * @param id identifier of the Artist you wish to obtain
    * @return returns the Artist that matches the ID
    */
    @Override
    public Artist getArtist(@PathVariable Long id) {
       return repository.findById(id).get();
    }

        /**
     *  Function that inserts a Artist in the database
     * @param name Artist that you desire to be inserted in the database
     * @return returns the Artist that was just inserted
     */
    @Override
    public Artist addArtist( @RequestBody String name) {
        Artist newArtist = new Artist( name);
        repository.save(newArtist);
        
        return newArtist;
    }

    /**
     *  Function that modifies the selected Artist
     * @param id Identifier of the Artist that you wish to modify
     * @param name The new name of the Artist
     * @return returns the modified Artist
     */
    @Override
    public Artist updateArtist(@PathVariable Long id, @RequestBody String name) {
        Artist artistToModify=repository.findById(id).get();
        if( artistToModify.getName().equals(name))
            System.out.println("The Artist already has this name");
        else
            artistToModify.setName(name);
        
        return repository.save(artistToModify);
    }

    /**
     * Function that deletes a Artist.
     * @param id Identifier of the to be deleted song.
     */
    @Override
    public void deleteArtist(@PathVariable Long id) {
        Artist artistToDelete = repository.findById(id).get();
        repository.deleteById(artistToDelete.getId());
        
    }  
}
