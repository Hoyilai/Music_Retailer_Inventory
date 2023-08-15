package com.album.service.impl;

import com.album.model.ApplicationUser;
import com.album.repository.ApplicationUserRepository;
import com.album.service.ApplicationUserService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
