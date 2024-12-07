/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Repository;

import com.salesianos.spring.NicolaeMihai.Model.SongPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface SongPlaylistRepository extends JpaRepository<SongPlaylist, Long>{
    
}
