package com.album.controller;

import com.album.model.Album;
import com.album.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    private final AlbumService albumService;
    public IndexController(AlbumService albumService) {

        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Album> albums = albumService.getAlbums();
        model.addAttribute("albums", albums);
        return "index";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam("term") String term) {
        List<Album> albums = albumService.findAllFilteredAlbums(term);
        model.addAttribute("albums", albums);
        return "index";
    }


}
