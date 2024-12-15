/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Repository;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class that implements the Artist repository.
 * @author Baljeet
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{
    
}
