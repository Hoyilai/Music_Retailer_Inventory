package com.album.controller;

import com.album.model.Album;
import com.album.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/admin/albums/view")
    public String getAll(Model model) {
        model.addAttribute("albums", albumService.getAlbums());
        return "album";
    }

    @GetMapping("/admin/albums/add")
    public String addAlbumForm(Model model, HttpServletRequest request) {
        request.getAttribute("name");
        return "add";
    }

    @PostMapping("/admin/albums/add")
    public String addAlbumSubmit(Model model, @RequestParam("title") String title, @RequestParam("artist") String artist,
                                 @RequestParam("dateReleased") String dateReleased, @RequestParam("genre") String genre,
                                 @RequestParam("tracks") Integer tracks, @RequestParam("price") double price) {

        try {
            this.albumService.addAlbum(100,title, artist, dateReleased, genre, tracks, price);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "add";
        }

        model.addAttribute("success", "Your album was successfully added");
        return "redirect:/admin/albums/view";
    }

    /*
        Edit game
     */
    @GetMapping("/admin/albums/edit/{albumId}")
    public String editAlbumPage(@PathVariable Integer albumId, Model model) {

        Album album = albumService.findAlbumById(albumId);
        if (null == album) {
            return "redirect:/admin/albums/view";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("albumId", album.getAlbumId());
        model.addAttribute("title", album.getTitle());
        model.addAttribute("artist", album.getArtist());
        model.addAttribute("dateReleased", sdf.format(album.getDateReleased()));
        model.addAttribute("genre", album.getGenre());
        model.addAttribute("tracks", album.getTracks());
        model.addAttribute("price", album.getPrice());
        return "edit";
    }

    @PostMapping("/admin/albums/edit")
    public String editAlbumSubmit(@RequestParam Integer albumId, @RequestParam("title") String title, @RequestParam("artist") String artist,
                                  @RequestParam("dateReleased") String dateReleased, @RequestParam("genre") String genre,
                                  @RequestParam("tracks") Integer tracks, @RequestParam("price") double price, Model model) {

        try {
            this.albumService.editAlbum(albumId, title, artist, dateReleased, genre, tracks, price);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "redirect:/admin/albums/view";
    }

    @GetMapping("/admin/albums/delete/{albumId}")
    public String deleteGamePage(@PathVariable Integer albumId, Model model) {
        albumService.deleteAlbumById(albumId);
        return "redirect:/admin/albums/view";
    }
}
