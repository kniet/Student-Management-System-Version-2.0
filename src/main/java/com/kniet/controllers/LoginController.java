package com.kniet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/")
    public String loginForm() {

        return "loginForm";
    }

    @PostMapping(value = "/checkLogin")
    public String processLoginForm(Model model, @RequestParam("Username") String userName,
                                   @RequestParam("Password") String password) {

        //simple login validation - better use spring security in future
        if (userName.equals("admin") && password.equals("admin")) {
            return "redirect:/HomePage/";
        }
        model.addAttribute("errorMsg", "Please provide the correct Username and Password");
        return "loginForm";
    }
}
