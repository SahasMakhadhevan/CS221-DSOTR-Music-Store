package PS5.Q1.model;

import java.util.Date;
import java.util.Locale;

public class Album {
    private int albumID;
    private String title, artist;
    private Genre genre;
    private Date dateReleased;
    private int noOfTracks;

    private double price;

    public Album(int albumID, String title, String artist, Genre genre, Date dateReleased, int noOfTracks, double price) {
        this.albumID = albumID;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.dateReleased = dateReleased;
        this.noOfTracks = noOfTracks;
        this.price = price;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAlbumIDasString() {
        return "" + this.albumID;
    }
}
