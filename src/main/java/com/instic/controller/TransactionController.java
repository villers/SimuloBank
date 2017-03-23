package com.instic.controller;

import com.instic.entity.Account;
import com.instic.entity.AccountHistory;
import com.instic.entity.TransactionType;
import com.instic.services.AccountHistoryService;
import com.instic.services.AccountService;
import com.instic.services.TransactionTypeService;
import com.instic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountHistoryService accountHistoryService;

    @Autowired
    private TransactionTypeService transactionTypeService;

    @ModelAttribute("page")
    public String module() {
        return "transaction";
    }

    @ModelAttribute("allTypes")
    public List<TransactionType> populateTypes() {
        return transactionTypeService.findAll();
    }

    @GetMapping()
    public String index(Model model, Principal principal) {
        model.addAttribute("user", userService.findByLogin(principal.getName()));

        return "account/index";
    }

    @GetMapping("/add/{idaccount}")
    public String registration(Model model, @PathVariable(value="idaccount") int id) {
        Account account = accountService.findOne(id);

        if (account == null)
            return "redirect:/account";

        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setAccount(account);


        model.addAttribute("accountForm", accountHistory);

        return "transaction/add";
    }

    @PostMapping("/add/{idaccount}")
    public String registration(@Valid @ModelAttribute("accountForm") AccountHistory accountForm, BindingResult bindingResult, @PathVariable(value="idaccount") int id) {
        Account account = accountService.findOne(id);

        if (account == null)
            return "redirect:/account";

        if (bindingResult.hasErrors()) {
            return "transaction/add";
        }

        BigDecimal balance = account.getBalance();
        if(accountForm.getType().getName().equals("Negative"))
            balance = balance.subtract(accountForm.getTransaction());
        else if (accountForm.getType().getName().equals("Positive"))
            balance = balance.add(accountForm.getTransaction());

        account.setBalance(balance);
        accountForm.setAccount(account);
        accountHistoryService.save(accountForm);

        return "redirect:/account";
    }


}
