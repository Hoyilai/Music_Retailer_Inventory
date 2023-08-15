package com.album;


import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

//    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean h2ServletRegistrationBean() {

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

//    @Bean
//    public CommandLineRunner demo (@Qualifier("albumServiceImpl") AlbumService albumRepository)
//    {
//        CommandLineRunner commandLineRunner = (args) -> {
//
//            Album a1 = new Album(100,"abc","jay", null,"abc",10,39.99);
//
//            albumRepository.save(a1);
//
////            for (Object album : albumRepository.findAll()) {
////                System.out.println(album.toString());
////                log.info(album.toString());
////            }
////
////            Optional<Album> album2 = albumRepository.findById(2L);
////            if (album2.isPresent()) {
////                log.info("FOUND ALBUM2" + album2.get().toString());
////            } else {
////                log.info("NOT FOUND");
////            }
//
//
//        };
//        return commandLineRunner;
//
//    }

    }

