package com.album.service;

import com.album.model.Album;

import java.text.ParseException;
import java.util.List;

public interface AlbumService {

    List<Album> getAlbums();

    Album addAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price)  throws ParseException;

    Album editAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price) throws ParseException;


    List<Album> findAllFilteredAlbums(String filter);

    Album findAlbumById(Integer albumId);

    boolean deleteAlbumById(Integer albumId);

}

