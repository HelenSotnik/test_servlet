package com.hillel.service;

import com.hillel.dao.ClientDao;
import com.hillel.dto.ClientDto;
import com.hillel.entity.Client;
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
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientDao clientDao;

    private Client client = new Client();

    @BeforeEach
    private void clientInitialization() {
        client.setId(1);
        client.setName("Bogdan");
        client.setAge(32);
        client.setEmail("bb@yahoo.com");
        client.setPhone(380505273349L);
        client.setAbout("Bogdan is a housekeeper and works for Julia Roberts");
        when(clientDao.findAllClients()).thenReturn(Collections.singletonList(client));
    }

    @Test
    public void findAllClientsMethodCheckBySizeCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertEquals(1, actualList.size());
    }

    @Test
    public void findAllClientsMethodCheckBySizeIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertNotSame(15, actualList.size());
    }

    @Test
    public void findAllClientsMethodCheckByClientIdCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertEquals(1, actualList.get(0).getId());
    }

    @Test
    public void findAllClientsMethodCheckByClientIdIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertNotSame(15, actualList.get(0).getId());
    }

    @Test
    public void findAllClientsMethodCheckByAgeCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getAge() == 32);
    }

    @Test
    public void findAllClientsMethodCheckByAgeIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertNotEquals(18, actualList.get(0).getAge());
    }

    @Test
    public void findAllClientsMethodCheckByNameCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertSame("Bogdan", actualList.get(0).getName());
    }

    @Test
    public void findAllClientsMethodCheckByNameIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertNotSame(" ", actualList.get(0).getAge());
    }

    @Test
    public void findAllClientsMethodCheckByEmailCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertEquals("bb@yahoo.com", actualList.get(0).getEmail());
    }

    @Test
    public void findAllClientsMethodCheckByEmailIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertFalse(actualList.get(0).getEmail() == "wrong@mail.ru");
    }

    @Test
    public void findAllClientsMethodCheckByPhoneCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getPhone() == 380505273349L);
    }

    @Test
    public void findAllClientsMethodCheckByAboutCorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertSame("Bogdan is a housekeeper and works for Julia Roberts", actualList.get(0).getAbout());
    }

    @Test
    public void findAllClientsMethodCheckByAboutIncorrectValueTest() {
        List<ClientDto> actualList = clientService.findAllClients();

        assertTrue(actualList.get(0).getAbout() != "Brrrrrrrr");
    }
}
