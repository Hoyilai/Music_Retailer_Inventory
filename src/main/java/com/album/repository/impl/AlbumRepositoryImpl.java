package com.album.repository.impl;

import com.album.jpa.JpaAlbumRepository;
import com.album.model.Album;
import com.album.repository.AlbumRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private final JpaAlbumRepository jpaAlbumRepository;

    public AlbumRepositoryImpl(JpaAlbumRepository jpaAlbumRepository) {
        this.jpaAlbumRepository = jpaAlbumRepository;
    }


    @Override
    public List<Album> getAlbum() {
        return (List<Album>) jpaAlbumRepository.findAll();
    }

    @Override
    public Album addAlbum(Album album) {

        return jpaAlbumRepository.save(album);
    }

    @Override
    public Album editAlbum(Integer albumId, String title, String artist, String dateReleased, String genre, Integer tracks, Double price) {

        Album existing = findAlbumById(albumId);
        existing.setTitle(title);
        existing.setArtist(artist);
        existing.setTracks(tracks);
        existing.setGenre(genre);
        existing.setPrice(price);

        return jpaAlbumRepository.save(existing);
    }


    @Override
    public Album findAlbumById(Integer albumId) {

        Optional<Album> album = jpaAlbumRepository.findById(albumId);
        if (album.isPresent()) {
            return album.get();
        }
        throw new IllegalStateException("Game with ID " + albumId + " is not found!");
    }



    @Override
    public boolean deleteAlbumById(Integer albumId) {

        jpaAlbumRepository.deleteById(albumId);
        return true;
    }
}
