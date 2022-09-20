package PS5.Q1.repository.impl;

import PS5.Q1.model.Album;
import PS5.Q1.model.Genre;
import PS5.Q1.repository.AlbumRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private List<Album> albums;

    public AlbumRepositoryImpl() {
        albums = new ArrayList<>();
    }

    @Override
    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public void addAlbum(Album album) {
        albums.add(album);
    }

    @Override
    public List<Album> searchAlbumName(String term) {
        return albums.stream().filter(a->a.getTitle().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    @Override
    public List<Album> searchAlbumID(String term) {
        return albums.stream().filter(a->a.getAlbumIDasString().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    @Override
    public List<Album> searchAlbumArtist(String term) {
        return albums.stream().filter(a->a.getArtist().toLowerCase(Locale.ROOT).contains(term.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }

    @Override
    public Album getAlbumByID(int albumID) {
        var albums = getAlbums();
        Album tmpalbum = null;
        for (int i = 0; i<albums.size(); i++){
            if (albumID == albums.get(i).getAlbumID()){
                tmpalbum = albums.get(i);
            }
        }
        return tmpalbum;
    }

    @Override
    public void deleteAlbum(int albumID) {
        var albums = getAlbums();
        int tmpint = 0;
        for (int i = 0; i<albums.size(); i++){
            if (albumID == albums.get(i).getAlbumID()){
                tmpint = i;
            }
        }
        albums.remove(tmpint);
    }

    @Override
    public void editAlbum(Album album, int albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice) {
        album.setTitle(albumTitle);
        album.setArtist(albumArtist);
        try {
            album.setDateReleased(new SimpleDateFormat("yyyy-MM-dd").parse(albumDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        album.setGenre(Genre.valueOf(albumGenre.toUpperCase(Locale.ROOT)));
        album.setNoOfTracks(Integer.parseInt(albumTrackNo));
        album.setPrice(Double.parseDouble(albumPrice));
    }
}
