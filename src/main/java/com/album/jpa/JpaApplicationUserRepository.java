package com.album.jpa;

import org.springframework.data.repository.CrudRepository;
import com.album.model.ApplicationUser;


public interface JpaApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
