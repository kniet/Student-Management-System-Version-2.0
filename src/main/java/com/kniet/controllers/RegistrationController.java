package com.kniet.controllers;

import com.kniet.user.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(" ", true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("myUser",new MyUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("myUser") MyUser myUser,
                                          BindingResult bindingResult,Model model) {

        String username = myUser.getUserName();

        if (bindingResult.hasErrors()) {
            model.addAttribute("myUser", new MyUser());
            model.addAttribute("registrationError", "Username/password can not be empty.");
            return "registration-form";
        }

        if (doesExist(username)) {
            model.addAttribute("myUser", new MyUser());
            model.addAttribute("registrationError", "User already exists.");
            return "registration-form";
        }

        String encodedPassword = passwordEncoder.encode(myUser.getPassword());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails userDetails = new User(username,encodedPassword,authorities);

        userDetailsManager.createUser(userDetails);

        return "registration-confirmation";
    }

    private boolean doesExist(String username) {
        return userDetailsManager.userExists(username);
    }

}
