/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.ServiceIMPL;

import com.salesianos.spring.NicolaeMihai.Model.Song;
import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import com.salesianos.spring.NicolaeMihai.Model.SongPlaylist;
import com.salesianos.spring.NicolaeMihai.Repository.SongPlaylistRepository;
import com.salesianos.spring.NicolaeMihai.Service.SongPlaylistService;
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
public class SongPlaylistServiceIMPL implements SongPlaylistService{

    @Autowired
       private final SongPlaylistRepository repository;
    
    public SongPlaylistServiceIMPL(SongPlaylistRepository repository){
        this.repository=repository;
    }
    
    @Override
    public SongPlaylist getSongPlaylist( @PathVariable Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<SongPlaylist> getAllSongPlaylist() {
        return repository.findAll();
    }

    @Override
    public SongPlaylist addSongPlaylist(@RequestBody List<Song> songs, @RequestBody List<Playlist> playlists) {
        SongPlaylist newSongPlaylist = new SongPlaylist(playlists, songs);
        return repository.save(newSongPlaylist);
        
    }

    @Override
    public SongPlaylist deleteSongPlaylist(@PathVariable Long id) {
        SongPlaylist songPlaylistToDelete=repository.findById(id).get();
        repository.delete(songPlaylistToDelete);
        return songPlaylistToDelete;
    }
    
}
