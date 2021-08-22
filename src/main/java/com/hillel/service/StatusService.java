package com.hillel.service;

import com.hillel.dao.StatusDao;
import com.hillel.dto.StatusDto;
import com.hillel.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private StatusDao statusDao;

    public StatusService(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusDao.findAllStatuses();
        List<StatusDto> result = new ArrayList<>();

        for (Status status : statuses) {
            StatusDto dto = new StatusDto();
            dto.setId(status.getId());
            dto.setAlias(status.getAlias());
            dto.setDescription(status.getDescription());
            result.add(dto);
        }
        return result;
    }
}
