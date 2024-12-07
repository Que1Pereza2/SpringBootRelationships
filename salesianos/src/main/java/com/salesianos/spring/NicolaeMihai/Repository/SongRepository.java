/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Repository;

import com.salesianos.spring.NicolaeMihai.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Baljeet
 */
@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    
}
