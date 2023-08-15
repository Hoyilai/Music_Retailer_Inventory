package com.album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    @GetMapping("/contact-us")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact-us")
    public String sendEmail(Model model, @RequestParam("email") String email, @RequestParam("name") String name,
                            @RequestParam("subject") String subject, @RequestParam("body") String body) {

        model.addAttribute("sendEmail", "send Email Success");
        return "contact";
    }
}
