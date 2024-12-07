/*
 * 
 * 
 * 
 */
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
 *
 * @author Baljeet
 */
@Service
public class ArtistServiceIMPL implements  ArtistService{

    @Autowired
   private final ArtistRepository repository;
    
    public ArtistServiceIMPL(ArtistRepository repository){
        this.repository=repository;
    }
    
    @Override
    public Artist getArtist(@PathVariable Long id) {
       return repository.findById(id).get();
    }

    @Override
    public List<Artist> getAllArtist() {
       return repository.findAll();
    }

    @Override
    public Artist addArtist( @RequestBody String nombre) {
        Artist newArtist = new Artist( nombre);
        repository.save(newArtist);
        
        return newArtist;
    }

    @Override
    public Artist updateArtist(@PathVariable Long id, @RequestBody String name) {
        Artist artistToModify=repository.findById(id).get();
        if( artistToModify.getName().equals(name))
            System.out.println("The Artist already has this name");
        else
            artistToModify.setName(name);
        
        return repository.save(artistToModify);
    }

    @Override
    public Artist deleteArtist(@PathVariable Long id) {
        Artist artistToDelete = repository.findById(id).get();
        repository.deleteById(id);
        
        return artistToDelete;
    }
    
}
