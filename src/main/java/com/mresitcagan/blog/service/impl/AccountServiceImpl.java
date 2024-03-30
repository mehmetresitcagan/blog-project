package com.mresitcagan.blog.service.impl;

import com.mresitcagan.blog.model.Account;
import com.mresitcagan.blog.repository.AccountRepository;
import com.mresitcagan.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mresitcagan.blog.config.WebSecurityConfig.passwordEncoder;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByEmail(String mail) {
        return accountRepository.findOneByEmail(mail);
    }


}
