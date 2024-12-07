/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Repository.SongRepository;
import com.salesianos.spring.NicolaeMihai.Service.SongService;
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
public class SongServiceIMPL implements SongService{

    @Autowired
       private final SongRepository repository;
    
    public SongServiceIMPL(SongRepository repository){
        this.repository = repository;
    }
    @Override
    public Song getSong(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Song> getAllSong() {
               return repository.findAll();

    }

    @Override
    public Song addSong(@RequestBody String nombre, @RequestBody Artist artist) {
        Song newSong= new Song(nombre, artist);
        repository.save(newSong);
        return newSong;
    }

    @Override
    public Song updateSong(@PathVariable Long id, @RequestBody String nombre) {
        Song songToUpdate= repository.findById(id).get();
        songToUpdate.setName(nombre);
        return repository.save(songToUpdate);
    }

    @Override
    public Song deleteSong(@PathVariable Long id) {
        Song songToDelete=repository.findById(id).get();
        repository.delete(songToDelete);
        return songToDelete;
    }
    
}
