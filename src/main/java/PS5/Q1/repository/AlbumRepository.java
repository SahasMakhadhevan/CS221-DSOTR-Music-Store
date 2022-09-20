package PS5.Q1.repository;

import PS5.Q1.model.Album;

import java.util.List;

public interface AlbumRepository {
    List<Album> getAlbums();

    void addAlbum(Album album);
    
    List<Album> searchAlbumName(String term);

    List<Album> searchAlbumID(String term);

    List<Album> searchAlbumArtist(String term);

    Album getAlbumByID(int albumID);

    void deleteAlbum(int albumID);

    void editAlbum(Album album, int albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice);

}
