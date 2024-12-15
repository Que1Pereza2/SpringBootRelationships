/*
 * 
 * 
 * 
 */
package com.salesianos.spring.NicolaeMihai.Service;

import com.salesianos.spring.NicolaeMihai.Model.Artist;
import java.util.List;

/**
 *  Class that creates the Artist service interface
 * @author Baljeet
 */
public interface ArtistService {
    
    public Artist getArtist(Long id);
    public List<Artist> getAllArtist();
    public Artist addArtist(String nombre);
    public Artist updateArtist(Long id,String nombre);
    public void deleteArtist(Long id);
}
