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
        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));
    }

    @Test
    public void findAllStatusesMethodCheckBySizeCorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertEquals(1, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckBySizeIncorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame(3, actualList.size());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasCorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertSame("VIP", actualList.get(0).getAlias());
    }

    @Test
    public void findAllStatusesMethodCheckByAliasIncorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame("PREMIUM", actualList.get(0).getAlias());
        assertFalse(actualList.get(0).getAlias() == "STANDAND");
    }


    @Test
    public void findAllStatusesMethodCheckByDescriptionCorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertEquals("Very Important Person", actualList.get(0).getDescription());
    }

    @Test
    public void findAllStatusesMethodCheckByDescriptionIncorrectValuesTest() {
        List<StatusDto> actualList = statusService.findAllStatuses();

        assertNotSame("shsjsjjajak", actualList.get(0).getDescription());
        assertNotEquals("djjdjjsksks", actualList.get(0).getDescription());
    }
}
