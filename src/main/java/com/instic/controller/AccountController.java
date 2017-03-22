package com.instic.controller;

import com.instic.entity.User;
import com.instic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @ModelAttribute("page")
    public String module() {
        return "account";
    }

    @GetMapping()
    public String index(Model model, Principal principal) {

        User user = userService.findByLogin(principal.getName());
        model.addAttribute("user", user);

        return "account/index";
    }


}
