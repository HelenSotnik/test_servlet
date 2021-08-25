package com.hillel.service;

import com.hillel.dao.AccountDao;
import com.hillel.dto.AccountDto;
import com.hillel.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private  AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = accountDao.findAllAccounts();
        List<AccountDto> result = new ArrayList<>();

        for (Account account : accounts) {
            AccountDto dto = new AccountDto();
            dto.setId(account.getId());
            dto.setClientId(account.getClientId());
            dto.setNumber(account.getNumber());
            dto.setValue(account.getValue());
            result.add(dto);
        }
        return result;
    }
}
