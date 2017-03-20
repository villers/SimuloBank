package com.instic.controller;

import com.instic.entity.User;
import com.instic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String findAllUsers(Model model) {
        model.addAttribute("users", this.userRepository.findAll());

        return "user/index";
    }

    @GetMapping("/{email}")
    public String findOneUser(
            @PathVariable(value="email") String email,
            Model model
    ) {
        model.addAttribute("user", this.userRepository.findByEmail(email));
        return "user/one";
    }


    /*@RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        return this.userRepository.findAll();
    }*/
}
