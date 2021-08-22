package com.hillel.service;

import com.hillel.dao.StatusDao;
import com.hillel.dto.StatusDto;
import com.hillel.entity.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatusServiceTest {

    @InjectMocks
    private StatusService statusService;

    @Mock
    private StatusDao statusDao;

    private Status status = new Status();

    @BeforeEach
    private void statusInitialization() {
        status.setId(2);
        status.setAlias("VIP");
        status.setDescription("Very Important Person");
    }

    @Test
    public void findAllStatusesMethodCheckBySizeCorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertEquals(1, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckBySizeIncorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame(3, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasCorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertSame("VIP", actualList.get(0).getAlias());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasIncorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame("PREMIUM", actualList.get(0).getAlias());
        assertFalse(actualList.get(0).getAlias() == "STANDAND");
    }

    @Test
    public void findAllStatusesMethodCheckByIdCorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertEquals(2, actualList.get(0).getId());
    }

    @Test
    public void findAllStatusesMethodCheckByIdIncorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame(1, actualList.get(0).getId());
        assertNotEquals(3, actualList.get(0).getId());
    }

    @Test
    public void findAllStatusesMethodCheckByDescriptionCorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertEquals("Very Important Person", actualList.get(0).getDescription());
    }

    @Test
    public void findAllStatusesMethodCheckByDescriptionIncorrectValuesTest() {
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame("shsjsjjajak", actualList.get(0).getDescription());
        assertNotEquals("djjdjjsksks", actualList.get(0).getDescription());
    }
}