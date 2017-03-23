package com.instic.controller;

import com.instic.entity.Account;
import com.instic.entity.AccountType;
import com.instic.services.AccountService;
import com.instic.services.AccountTypeService;
import com.instic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTypeService accountTypeService;

    @ModelAttribute("page")
    public String module() {
        return "account";
    }

    @ModelAttribute("allTypes")
    public List<AccountType> populateTypes() {
        return accountTypeService.findAll();
    }

    @GetMapping()
    public String index(Model model, Principal principal) {
        model.addAttribute("user", userService.findByLogin(principal.getName()));

        return "account/index";
    }

    @GetMapping("/add")
    public String registration(Model model) {
        model.addAttribute("accountForm", new Account());

        return "account/add";
    }

    @PostMapping("/add")
    public String registration(@Valid @ModelAttribute("accountForm") Account accountForm, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "account/add";
        }

        accountForm.setAccountHistory(new ArrayList<>());
        accountForm.setUser(userService.findByLogin(principal.getName()));
        accountService.save(accountForm);

        return "redirect:/account";
    }


}
