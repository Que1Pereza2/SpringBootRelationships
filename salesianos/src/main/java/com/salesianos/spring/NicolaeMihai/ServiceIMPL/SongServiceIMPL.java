package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import RequestObject.RequestSongPlaylist;
import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Repository.PlaylistRepository;
import com.salesianos.spring.NicolaeMihai.Repository.SongRepository;
import com.salesianos.spring.NicolaeMihai.Service.SongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class that implements the Service functions for Song
 * @author Baljeet
 */

@Service
public class SongServiceIMPL implements SongService{

    /**
     * Link to the Song repository
     */
    @Autowired
       private final SongRepository repository;
    
    /**
     * Link to the Playlist repository
     */
    @Autowired
       private final PlaylistRepository repositoryPlaylist;
    
    /**
     * Constructor for the Song Service implementation
     * @param repository Song repository instance
     * @param repositoryPlaylist Playlist repository instance
     */
    public SongServiceIMPL(SongRepository repository, PlaylistRepository repositoryPlaylist){
        this.repository = repository;
        this.repositoryPlaylist = repositoryPlaylist;
    }
    
    /**
     * Function that obtains all the Songs in the database.
     * @return returns a list of Songs
     */
    @Override
    public List<Song> getAllSongs() {
               return repository.findAll();
    }

    /**
    *  Function that finds a specific Song based by ID
    * @param id identifier of the Song you wish to obtain
    * @return returns the Song that matches the ID
    */
    @Override
    public Song getSong( @PathVariable Long id) {
        return repository.findById(id).get();
    }

    /**
     *  Function that inserts a Song in the database
     * @param song Song that you desire to be inserted in the database
     * @return returns the Song that was just inserted
     */
    @Override
    public Song addSong( @RequestBody Song song) {
        return repository.save(song);
    }

    /**
     *  Function that modifies the selected Song
     * @param id Identifier of the Song that you wish to modify
     * @param name The new name of the Song
     * @return returns the modified Song
     */
    @Override
    public Song updateSong(@PathVariable Long id,  @RequestBody String name) {
        Song songToUpdate= repository.findById(id).get();
        songToUpdate.setName(name);
        
        return repository.save(songToUpdate);
    }
    
    /**
     * Function that inserts a Song into a playlist.
     * @param rsp The Song and  playlist desired.
     * @return returns the Song that was inserted to the playlist.
     */
    @Override
    public Song addSongToPlaylist(@RequestBody RequestSongPlaylist rsp) {
        Playlist playlistToModify = repositoryPlaylist.findById(rsp.getPlaylistId()).get();
        Song songToInsert = repository.findById(rsp.getSongId()).get();
        
        playlistToModify.getSongs().add(songToInsert);
        repositoryPlaylist.save(playlistToModify);
        
        songToInsert.getPlaylists().add(playlistToModify);
        
        return repository.save(songToInsert);
    }
    
    /**
     * Function that deletes a Song.
     * @param id Identifier of the to be deleted song.
     */
    @Override
    public void deleteSong( @PathVariable Long id) {
        Song songToDelete=repository.findById(id).get();
        repository.deleteById(songToDelete.getId());
    }
}