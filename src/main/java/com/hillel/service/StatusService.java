package com.hillel.service;

import com.hillel.dao.StatusDao;
import com.hillel.dto.StatusDto;
import com.hillel.entity.Status;
import com.hillel.service.util.LogServiceMessageUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private static final Logger LOG = Logger.getLogger(StatusService.class.getName());
    private static final String METHOD_NAME = "findAllStatuses()";
    private static final String DAO = StatusDao.class.getName();

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
        if (result == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(METHOD_NAME, DAO));
        }

        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(METHOD_NAME, DAO));
        return result;
    }
}
