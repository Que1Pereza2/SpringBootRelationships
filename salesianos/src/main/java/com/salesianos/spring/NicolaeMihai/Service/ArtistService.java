/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import java.util.List;

/**
 *
 * @author Baljeet
 */
public interface ArtistService {
    
    public Artist getArtist(Long id);
    public List<Artist> getAllArtist();
    public Artist addArtist(String nombre);
    public Artist updateArtist(Long id,String nombre);
    public Artist deleteArtist(Long id);
}
