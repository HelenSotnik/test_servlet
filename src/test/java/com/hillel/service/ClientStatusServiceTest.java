package com.hillel.service;

import com.hillel.dao.ClientStatusDao;
import com.hillel.dto.ClientStatusDto;
import com.hillel.entity.ClientStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientStatusServiceTest {

    @InjectMocks
    private ClientStatusService clientStatusService;

    @Mock
    private ClientStatusDao clientStatusDao;

    private ClientStatus clientStatus = new ClientStatus();

    @BeforeEach
    private void clientStatusInitialization() {
        clientStatus.setClientId(6);
        clientStatus.setStatusId(3);
        when(clientStatusDao.findNameEmailAlias()).thenReturn(Collections.singletonList(clientStatus));
    }

    @Test
    public void findClientNameEmailStatusMethodCheckBySizeCorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertSame(1, actualList.size());
    }

    @Test
    public void findClientNameEmailStatusMethodCheckBySizeIncorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertNotEquals(90, actualList.size());
        assertFalse(actualList.size() == 70);
        assertNotSame(2, actualList.size());
    }

    @Test
    public void findClientNameEmailStatusMethodCheckByClientIdCorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertTrue(actualList.get(0).getClientId() == 6);
    }

    @Test
    public void findClientNameEmailStatusMethodCheckByClientIdIncorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertTrue(actualList.get(0).getClientId() != 7);
        assertNotEquals(4, actualList.get(0).getClientId());
        assertNotSame(1, actualList.get(0).getClientId());
    }

    @Test
    public void findClientNameEmailStatusMethodCheckByStatusIdCorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertEquals(3, actualList.get(0).getStatusId());
    }

    @Test
    public void findClientNameEmailStatusMethodCheckByStatusIdIncorrectValuesTest() {
        List<ClientStatusDto> actualList = clientStatusService.findClientNameEmailStatus();

        assertNotEquals(2, actualList.get(0).getStatusId());
        assertFalse(actualList.get(0).getStatusId() == 5);
        assertNotSame(1, actualList.get(0).getStatusId());
    }
}
