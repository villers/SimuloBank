package com.instic.controller;

import com.instic.entity.User;
import com.instic.services.SecurityService;
import com.instic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @ModelAttribute("page")
    public String module() {
        return "user";
    }

    @GetMapping("/signup")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signup/signup";
    }

    @PostMapping("/signup")
    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup/signup";
        }

        try {
            userForm.setAccounts(new ArrayList<>());
            userService.save(userForm);
        }catch (RuntimeException ex) {
            bindingResult.addError(new ObjectError("login","this user already exists"));
            return "signup/signup";
        }


        securityService.autologin(userForm.getLogin(), userForm.getPassword());

        return "redirect:/welcome";
    }

    @GetMapping("/signin")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your login and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "signin/signin";
    }
}
