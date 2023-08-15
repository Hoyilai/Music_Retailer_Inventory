package com.album.bootstrap;


import com.album.model.ApplicationUser;
import com.album.repository.AlbumRepository;
import com.album.repository.ApplicationUserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {


    private final AlbumRepository albumRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader(AlbumRepository albumRepository, ApplicationUserRepository applicationUserRepository) {


        this.albumRepository = albumRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("This will run when Spring starts!");


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("123456"), true);
        ApplicationUser user2 = new ApplicationUser("larry", encoder.encode("123456"), false);
        this.applicationUserRepository.addUser(user1);
        this.applicationUserRepository.addUser(user2);
    }
}
