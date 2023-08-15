package com.album.repository;

import com.album.model.Album;

import java.util.List;

public interface AlbumRepository {

    List<Album> getAlbum();

    Album addAlbum(Album album) ;

    Album editAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price);

    Album findAlbumById(Integer albumId);

    boolean deleteAlbumById(Integer albumId);
}
