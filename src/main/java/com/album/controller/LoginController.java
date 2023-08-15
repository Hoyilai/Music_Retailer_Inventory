package com.album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(RedirectAttributes attributes, HttpServletRequest request, @RequestParam("username") String name, @RequestParam("userpass") String pwd) {
        if ("admin".equals(name) && "123456".equals(pwd)) {
            request.getSession(true).setAttribute("name", "admin");
            request.setAttribute("name", "admin");
            attributes.addFlashAttribute("name","admin");
            return "redirect:/admin/albums/view";
        } else {
            return "index";
        }

    }

    @GetMapping("/logout")
    public String logoutSuccess() {
        return "index";
    }
}
