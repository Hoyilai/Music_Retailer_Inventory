package com.album.repository;

import com.album.model.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser addUser(ApplicationUser user);

    ApplicationUser findByUserName(String username);
}
