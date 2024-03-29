package com.mresitcagan.blog.controller;

import com.mresitcagan.blog.dto.AccountDto;
import com.mresitcagan.blog.mapper.Mapper;
import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final Mapper<Account, AccountDto> mapper;

    public AccountController(AccountService accountService, Mapper<Account, AccountDto> mapper) {
        this.accountService = accountService;
        this.mapper = mapper;
    }


    @PostMapping()
    public ResponseEntity<AccountDto> createArticle(@RequestBody AccountDto accountDto){
        Account account = mapper.mapFrom(accountDto);
        Account savedAccountEntity = accountService.save(account);
        return new ResponseEntity<>(mapper.mapTo(savedAccountEntity), HttpStatus.CREATED);
    }
}
