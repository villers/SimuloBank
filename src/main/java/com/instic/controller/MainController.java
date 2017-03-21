package com.instic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
@Controller
public class MainController {

    @ModelAttribute("page")
    public String module() {
        return "home";
    }

    @GetMapping(value = {"/", "/welcome"})
    public String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
}
