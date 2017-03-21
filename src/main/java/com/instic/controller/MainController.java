package com.instic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
@Controller
public class MainController {

    @GetMapping("/")
    String index() {
        return "index";
    }
}
