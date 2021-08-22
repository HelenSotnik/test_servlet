package com.hillel.service;

import com.hillel.dao.AccountDao;
import com.hillel.dto.AccountDto;
import com.hillel.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountDao accountDao;

    private Account account = new Account();

    @BeforeEach
    private void accountInitialization() {
        account.setId(1);
        account.setClientId(1);
        account.setNumber("1237 8890 8765 1123");
        account.setValue(1043.88);
    }

    @Test
    public void findAllAccountsListCheckBySizeCorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertTrue(actualList.size() == 1);
    }

    @Test
    public void findAllAccountsMethodCheckBySizeIncorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertNotEquals(5, actualList.size());
        assertTrue(actualList.size() != 3);
        assertNotSame(10, actualList.size());
    }

    @Test
    public void findAllAccountsMethodCheckByClientIdCorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertSame(1, actualList.get(0).getClientId());
    }

    @Test
    public void findAllAccountsMethodCheckByClientIdIncorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertFalse(actualList.get(0).getClientId() == 0);
    }

    @Test
    public void findAllAccountsMethodCheckByAccountIdCorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertEquals(1, actualList.get(0).getId());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountIdIncorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertNotSame(10998, actualList.get(0).getId());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountNumberCorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertEquals("1237 8890 8765 1123", actualList.get(0).getNumber());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountNumberIncorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertFalse(actualList.get(0).getNumber() == "9999 8890");
    }

    @Test
    public void findAllAccountsMethodCheckByAccountValueCorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertEquals(1043.88, actualList.get(0).getValue());
    }

    @Test
    public void findAllAccountsMethodCheckByAccountValueIncorrectValueTest() {
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertNotEquals(104388, actualList.get(0).getValue());
    }
}
