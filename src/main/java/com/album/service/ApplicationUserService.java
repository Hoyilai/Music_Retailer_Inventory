package com.album.service;
import com.album.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findByUserName(String username);
}