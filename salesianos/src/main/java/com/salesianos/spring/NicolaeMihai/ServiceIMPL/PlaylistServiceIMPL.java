package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import RequestObject.RequestSongPlaylist;
import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Repository.PlaylistRepository;
import com.salesianos.spring.NicolaeMihai.Repository.SongRepository;
import com.salesianos.spring.NicolaeMihai.Service.PlaylistService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class that implements the Playlist Service functions.
 * @author Baljeet
 */

@Service
public class PlaylistServiceIMPL implements PlaylistService{

    /**
     * Links to the Playlist repository.
     */
    @Autowired
    private final PlaylistRepository repository;

    /**
     * Links to the Song repository.
     */
    @Autowired
    private final SongRepository repositorySong;
    
/**
     * Constructor for the Playlist Service implementation
     * @param repository Playlist repository instance
     * @param repositorySong Song repository instance
     */
    public PlaylistServiceIMPL(PlaylistRepository repository, SongRepository repositorySong){
        this.repository=repository;
        this.repositorySong= repositorySong;
    }

    /**
     * Function that obtains all the Playlists in the database.
     * @return returns a list of Playlists
     */
    @Override
    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }
    
    /**
    *  Function that finds a specific Playlist based by ID
    * @param id identifier of the Playlist you wish to obtain
    * @return returns the Playlist that matches the ID
    */
    @Override
    public Playlist getPlaylist(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    /**
     *  Function that inserts a Playlist in the database
     * @param newPlaylist Playlist that you desire to be inserted in the database
     * @return returns the Playlist that was just inserted
     */
    @Override
    public Playlist addPlaylist( @RequestBody Playlist newPlaylist) {
        return repository.save(newPlaylist);
    }

    /**
     *  Function that modifies the selected Playlist
     * @param id Identifier of the Playlist that you wish to modify
     * @param name The new name of the Playlist
     * @return returns the modified Playlist
     */
    @Override
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody String name) {
        Playlist playlistToUpdate = repository.findById(id).get();
        playlistToUpdate.setName(name);
        return repository.save(playlistToUpdate);
    }

     /**
     * Function that inserts a Song into a Playlist.
     * @param rsp The Song and  playlist desired.
     * @return returns the Playlist that was inserted to the playlist.
     */
    @Override
    public Playlist addSongToPlaylist(@RequestBody RequestSongPlaylist rsp) {
        Playlist playlistToModify = repository.findById(rsp.getPlaylistId()).get();
        Song songToInsert = repositorySong.findById(rsp.getSongId()).get();
        
        songToInsert.getPlaylists().add(playlistToModify);
        repositorySong.save(songToInsert);
        
        playlistToModify.getSongs().add(songToInsert);
        
        return repository.save(playlistToModify);
    }

    /**
     * Function that deletes a Playlist. First it removes the playlist from 
     * the song's playlist list and then clears all the songs in it's list.
     * @param id Identifier of the to be deleted song.
     */
    @Override
    public void deletePlaylist(@PathVariable Long id) {
        Playlist playlistToDelete = repository.findById(id).get();
        List<Song> songs= new ArrayList<>(playlistToDelete.getSongs());

        for(Song song : songs)
            song.getPlaylists().remove(playlistToDelete);
        
        playlistToDelete.getSongs().clear();
        
        repository.save(playlistToDelete);
        
        repository.deleteById(playlistToDelete.getId());        
    }
}