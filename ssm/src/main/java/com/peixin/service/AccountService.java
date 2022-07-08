package com.peixin.service;

import com.peixin.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> findAll();

}
