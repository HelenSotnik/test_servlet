package com.hillel.service;

import com.hillel.dao.ClientStatusDao;
import com.hillel.dto.ClientStatusDto;
import com.hillel.entity.ClientStatus;
import com.hillel.service.util.LogServiceMessageUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private static final Logger LOG = Logger.getLogger(ClientStatusService.class.getName());
    private static final String METHOD_NAME = "findClientNameEmailStatus()";
    private static final String DAO = ClientStatusDao.class.getName();

    private  ClientStatusDao clientStatusDao;

    public ClientStatusService(ClientStatusDao clientStatusDao) {
        this.clientStatusDao = clientStatusDao;
    }

    public List<ClientStatusDto> findClientNameEmailStatus() {
        List<ClientStatus> nameEmailAlias = clientStatusDao.findNameEmailAlias();
        List<ClientStatusDto> result = new ArrayList<>();

        for (ClientStatus cs : nameEmailAlias) {
            ClientStatusDto dto = new ClientStatusDto();
            dto.setClientId(cs.getClientId());
            dto.setStatusId(cs.getStatusId());
            result.add(dto);
        }
        if (result == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(METHOD_NAME, DAO));
        }

        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(METHOD_NAME, DAO));
        return result;
    }
}
