package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private AccountService accountService;

    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/";
    }

}
