/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Repository;

import com.salesianos.spring.NicolaeMihai.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class that implements the Playlist repository
 * @author Baljeet
 */
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    
}
