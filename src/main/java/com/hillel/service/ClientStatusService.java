package com.hillel.service;

import com.hillel.dao.ClientStatusDao;
import com.hillel.dto.ClientStatusDto;
import com.hillel.entity.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private final ClientStatusDao clientStatusDao;

    public ClientStatusService() {
        clientStatusDao = new ClientStatusDao();
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
        return result;
    }
}
