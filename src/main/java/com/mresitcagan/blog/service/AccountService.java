package com.mresitcagan.blog.service;

import com.mresitcagan.blog.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account save(Account account);

    Optional<Account> findByEmail(String mail);
}
