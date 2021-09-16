package com.hillel.service;

import com.hillel.dao.AccountDao;
import com.hillel.dto.AccountDto;
import com.hillel.entity.Account;

import java.util.ArrayList;
import java.util.List;

import com.hillel.service.util.LogServiceMessageUtil;
import org.apache.log4j.Logger;

public class AccountService {

    private static final Logger LOG = Logger.getLogger(AccountService.class.getName());
    private static final String METHOD_NAME = "findAllAccounts()";
    private static final String DAO = AccountDao.class.getName();

    private AccountDao accountDao;

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

        if (result == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(METHOD_NAME, DAO));
        }

        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(METHOD_NAME, DAO));
        return result;
    }
}
