package com.peixin.mapper;

import com.peixin.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();

}
