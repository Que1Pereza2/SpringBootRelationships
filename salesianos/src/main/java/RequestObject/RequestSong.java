/*
 * 
 * 
 * 
 */
package RequestObject;

import com.salesianos.spring.NicolaeMihai.Model.Song;

/**
 * Class that creates the Object RequestSong used to insert Songs into the 
 * database and link it with the desired Artist.
 * @author Baljeet
 */
public class RequestSong {
    
    /**
     * The song that is going to be inserted in the database.
     */
    private Song song;
    
    /**
     * The ID of the artist that created the song.
     */
    private Long artistId;
    
    /**
     * Constructor for RequestSong.
     * @param song The song that will be inserted.
     * @param artistId ID of the author of the song.
     */
    public RequestSong(Song song, Long artistId){
        this.song=song;
        this.artistId=artistId;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}
