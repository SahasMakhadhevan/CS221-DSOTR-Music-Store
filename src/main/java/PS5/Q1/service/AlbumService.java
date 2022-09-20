package PS5.Q1.service;

import PS5.Q1.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbums();

    List<Album> searchAlbums(String term);

    void addAlbum(String albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice);

    Album getAlbumByID(int albumID);

    void deleteAlbum(int albumID);

    void editAlbum(int albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice);
}
