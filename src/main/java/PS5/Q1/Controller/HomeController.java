package PS5.Q1.Controller;

import PS5.Q1.model.Album;
import PS5.Q1.service.AlbumService;
import PS5.Q1.service.impl.AlbumServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
//        albumService = new AlbumServiceImpl();

    }

    @GetMapping("/")
    public String home(Model model){
//        var albums = new ArrayList<Album>();
//        albums.add(new Album(1, "1989", "Taylor Swift", 2012, 19, 15));
//        List<Album> albums = albumService.getAlbums();
//        model.addAttribute("album", albums);
        return "home";
    }
}
