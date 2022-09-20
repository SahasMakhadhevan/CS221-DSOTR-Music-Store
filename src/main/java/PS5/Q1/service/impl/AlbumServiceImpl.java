package PS5.Q1.service.impl;

import PS5.Q1.model.Album;
import PS5.Q1.model.Genre;
import PS5.Q1.repository.AlbumRepository;
import PS5.Q1.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.getAlbums();
    }

    @Override
    public List<Album> searchAlbums(String term) {
        if (!StringUtils.hasText(term)){
            throw new IllegalArgumentException("Search term can't be empty.");
        }
        List<Album> nameArray = albumRepository.searchAlbumName(term);
        List<Album> IDArray = albumRepository.searchAlbumID(term);
        List<Album> artistArray = albumRepository.searchAlbumArtist(term);
//        nameArray.addAll(IDArray);
//        nameArray.addAll(artistArray);

        List<Album> Final = new ArrayList<>(nameArray);
        Final.removeAll(IDArray);
        Final.addAll(IDArray);
        Final.removeAll(artistArray);
        Final.addAll(artistArray);

        Final.sort(Comparator.comparing(Album::getAlbumID));
        return Final;
    }

    @Override
    public void addAlbum(String albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice) {
        if (!StringUtils.hasText(albumID))
            throw new IllegalArgumentException("Album ID is required.");
        if (!StringUtils.hasText(albumTitle))
            throw new IllegalArgumentException("Album Title is required.");
        if (!StringUtils.hasText(albumArtist))
            throw new IllegalArgumentException("Album Artist is required.");
        if (!StringUtils.hasText(albumDate))
            throw new IllegalArgumentException("Album Date is required.");
        if (!StringUtils.hasText(albumGenre))
            throw new IllegalArgumentException("Album Genre is required.");
        if (!StringUtils.hasText(albumTrackNo))
            throw new IllegalArgumentException("Number of Tracks is required.");
        if (!StringUtils.hasText(albumPrice))
            throw new IllegalArgumentException("Album Price is required.");

        int ID;
        int trackNo;
        double price;
        Genre g;
        Date year;
        try{
            ID = Integer.parseInt(albumID);
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            year = ft.parse(albumDate);
            trackNo = Integer.parseInt(albumTrackNo);
            price = Double.parseDouble(albumPrice);
            g = Genre.valueOf(albumGenre.toUpperCase(Locale.ROOT));
//            albumGenre = g.toString();
        } catch (Exception exception){
            throw new IllegalArgumentException("Unable to parse the values");
        }

        var tempalbum = new Album(ID, albumTitle, albumArtist, g, year, trackNo, price);
        albumRepository.addAlbum(tempalbum);
    }

    @Override
    public Album getAlbumByID(int albumID) {
        if(albumID <= 0){
            throw new IllegalArgumentException("Album ID is required");
        }
        return albumRepository.getAlbumByID(albumID);
    }

    @Override
    public void deleteAlbum(int albumID) {
        if(albumID <= 0){
            throw new IllegalArgumentException("Album ID is required");
        }
        albumRepository.deleteAlbum(albumID);
    }

    @Override
    public void editAlbum(int albumID, String albumTitle, String albumArtist, String albumDate, String albumGenre, String albumTrackNo, String albumPrice) {
        var album = albumRepository.getAlbumByID(albumID);
        if(album == null){
            throw new IllegalArgumentException("Album not found");
        }
        albumRepository.editAlbum(album, albumID, albumTitle, albumArtist, albumDate, albumGenre, albumTrackNo, albumPrice);
    }

/*    @Override
    public void editAlbum(String albumID) {
        if(Integer.parseInt(albumID) <= 0){
            throw new IllegalArgumentException("Album ID is required");
        }
        albumRepository.editAlbum(Integer.parseInt(albumID));
    }*/
}
