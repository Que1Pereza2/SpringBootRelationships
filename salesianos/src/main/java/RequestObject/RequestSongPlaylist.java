/*
 * 
 * 
 * 
 */
package RequestObject;

/**
 * Class that implements the object RequestSongPlaylist used to insert songs 
 * into Playlists.
 * @author Baljeet
 */
public class RequestSongPlaylist {
    
    /**
     * ID of the Playlist where the song will be inserted.
     */
    Long playlistId;
    
    /**
     * ID of the Song that will be inserted.
     */
    Long songId;
    
    /**
     * Constructor for RequestSongPlaylist
     * @param playlistId The ID of the Playlist where the song will be inserted.
     * @param songId  The ID of  the Song that will be inserted into the Playlist.
     */
    public RequestSongPlaylist(Long playlistId, Long songId){
        this.playlistId=playlistId;
        this.songId=songId;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }
}
