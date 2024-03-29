package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.repository.AccountRepository;
import com.mresitcagan.blog.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String mail) {
        return accountRepository.findOneByEmail(mail);
    }


}
