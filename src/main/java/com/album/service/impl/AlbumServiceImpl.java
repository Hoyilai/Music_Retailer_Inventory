package com.album.service.impl;

import com.album.model.Album;
import com.album.service.AlbumService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {


    private static List<Album> dataBase = new ArrayList<>(16);

    @Override
    public List<Album> getAlbums() {
        return dataBase;
    }

    public Album addAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price) throws ParseException {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(10000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Album album = new Album(rand_int1, title, artist, sdf.parse(dateReleased), genre, tracks, price);
        dataBase.add(album);
        return album;
    }

    @Override
    public List<Album> findAllFilteredAlbums(String filter) {

        return dataBase.stream()
                .filter(g -> g.getTitle().toLowerCase().contains(filter) || g.getArtist().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(Integer albumId) {
        List<Album> temp = dataBase.stream()
                .filter(g -> g.getAlbumId().equals(albumId))
                .collect(Collectors.toList());
        if (temp != null && temp.size() > 0) {
            return temp.get(0);
        }
        return null;
    }


    public Album editAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Album album = dataBase.stream()
                .filter(g -> g.getAlbumId().equals(albumId))
                .collect(Collectors.toList()).get(0);
        album.setArtist(artist);
        album.setDateReleased(sdf.parse(dateReleased));
        album.setGenre(genre);
        album.setPrice(price);
        album.setTracks(tracks);
        album.setTitle(title);
        return album;
    }

    @Override
    public boolean deleteAlbumById(Integer albumId) {
        for (Album album : dataBase) {
            if (album.getAlbumId().equals(albumId)) {
                dataBase.remove(album);
                break;
            }
        }
        return true;
    }



}
