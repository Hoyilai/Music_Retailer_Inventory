package com.album.jpa;

import com.album.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface JpaAlbumRepository extends CrudRepository<Album, Integer> {
}
