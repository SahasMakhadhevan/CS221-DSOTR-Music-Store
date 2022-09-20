package PS5.Q1.Controller;

import PS5.Q1.model.Album;
import PS5.Q1.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {
    private final AlbumService albumService;

    public SiteController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/search")
    public String search(Model model/*, @RequestParam String term*/){
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "search";
    }

    @GetMapping("/outsearch")
    public String outSearch(@RequestParam String term, Model model){
//        List<Album> albums = albumService.getAlbums();
        List<Album> albums = albumService.searchAlbums(term);
        model.addAttribute("albums", albums);
        return "outsearch";
    }


    @GetMapping("/contact-us")
    public String contactUs(){
        return "contact-us";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
