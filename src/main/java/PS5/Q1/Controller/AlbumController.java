package PS5.Q1.Controller;

import PS5.Q1.model.Album;
import PS5.Q1.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin/albums/add")
    public String add(Model model){
        return "add";
    }

    @PostMapping("/admin/albums/add")
    public String addAlbumSubmit(Model model, @RequestParam String AlbumID, @RequestParam String AlbumTitle,@RequestParam String AlbumArtist,@RequestParam String AlbumDate,@RequestParam String AlbumGenre,@RequestParam String AlbumTrackNo,@RequestParam String AlbumPrice){
        try{
            this.albumService.addAlbum(AlbumID, AlbumTitle, AlbumArtist, AlbumDate, AlbumGenre, AlbumTrackNo, AlbumPrice);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return "redirect:/admin/albums/view";
    }

    @GetMapping("/admin/albums/edit/{albumID}")
    public String edit(@PathVariable int albumID, Model model){
        Album album = albumService.getAlbumByID(albumID);
        model.addAttribute("albumID", albumID);
        model.addAttribute("albumName", album.getTitle());
        model.addAttribute("albumArtist", album.getArtist());
        model.addAttribute("albumDate", album.getDateReleased());
        model.addAttribute("albumGenre", album.getGenre());
        model.addAttribute("numTracks", album.getNoOfTracks());
        model.addAttribute("albumPrice", album.getPrice());
        return "edit";
    }

    @PostMapping("/admin/albums/edit")
    public String editSubmit(@RequestParam int albumID, @RequestParam String albumTitle, @RequestParam String albumArtist,@RequestParam String albumDate, @RequestParam String albumGenre, @RequestParam String albumTrackNo, @RequestParam String albumPrice, Model model){
        try{
            this.albumService.editAlbum(albumID, albumTitle, albumArtist, albumDate, albumGenre, albumTrackNo, albumPrice);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            model.addAttribute("error", ex.getMessage());
        }
        return "redirect:/admin/albums/view";
    }
    

//    @GetMapping("/admin/albums/editConfirmed/{albumID}")
//    public String editConfirmed(Model model, @PathVariable int albumID, @RequestParam String AlbumTitle,@RequestParam String AlbumArtist,@RequestParam String AlbumDate,@RequestParam String AlbumGenre,@RequestParam String AlbumTrackNo,@RequestParam String AlbumPrice){
//        try{
//            this.albumService.editAlbum(albumID, AlbumTitle, AlbumArtist, AlbumDate, AlbumGenre, AlbumTrackNo, AlbumPrice);
//        } catch (Exception ex){
//            System.err.println(ex.getMessage());
//        }
//        return "editConfirmed";
//    }

    @GetMapping("/admin/albums/delete/{albumID}")
    public String delete(@PathVariable int albumID, Model model){
        model.addAttribute("ID", albumID);
        return "delete";
    }

    @GetMapping("/admin/albums/deleteConfirmed/{albumID}")
    public String confirmedDelete(@PathVariable int albumID, Model model){
        albumService.deleteAlbum(albumID);
        return "deleteConfirmed";
    }

    @GetMapping("/admin/albums/view")
    public String view(Model model){
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "view";
    }
}
