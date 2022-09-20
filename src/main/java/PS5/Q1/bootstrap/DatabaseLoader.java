package PS5.Q1.bootstrap;

import PS5.Q1.model.Album;
import PS5.Q1.model.Genre;
import PS5.Q1.repository.AlbumRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final AlbumRepository albumRepository;

    public DatabaseLoader(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Date tmpDate1, tmpDate2, tmpDate3, tmpDate4, tmpDate5, tmpDate6, tmpDate7, tmpDate8;
        try{
            tmpDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2014-10-27");
            tmpDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-05-17");
            tmpDate3 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-13");
            tmpDate4 = new SimpleDateFormat("yyyy-MM-dd").parse("1976-10-21");
            tmpDate5 = new SimpleDateFormat("yyyy-MM-dd").parse("1978-10-07");
            tmpDate6 = new SimpleDateFormat("yyyy-MM-dd").parse("1974-04-15");
            tmpDate7 = new SimpleDateFormat("yyyy-MM-dd").parse("1969-11-02");
            tmpDate8 = new SimpleDateFormat("yyyy-MM-dd").parse("1970-12-09");
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        albumRepository.addAlbum(new Album(1, "1989", "Taylor Swift", Genre.POP, tmpDate1, 12, 14.99));
        albumRepository.addAlbum(new Album(2, "Random Access Memories", "Daft Punk", Genre.ELECTRONIC, tmpDate2, 13, 19.99));
        albumRepository.addAlbum(new Album(3, "Heavy Is the Head", "Stormzy", Genre.GRIME, tmpDate3, 16, 24.99));
        albumRepository.addAlbum(new Album(4, "Leftoverture (Expanded Edition)", "Kansas", Genre.ROCK, tmpDate4, 10, 29.99));
        albumRepository.addAlbum(new Album(5, "Dire Straits", "Dire Straits", Genre.ROCK, tmpDate5, 9, 24.99));
        albumRepository.addAlbum(new Album(6, "Second Helping", "Lynyrd Skynyrd", Genre.ROCK, tmpDate6, 11, 29.99));
        albumRepository.addAlbum(new Album(7, "Willy And The Poor Boys", "CCR", Genre.ROCK, tmpDate7, 13, 34.99));
        albumRepository.addAlbum(new Album(8, "Pendulum", "CCR", Genre.ROCK, tmpDate8, 10, 34.99));

    }
}