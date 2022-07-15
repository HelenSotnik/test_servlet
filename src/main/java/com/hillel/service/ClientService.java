package com.hillel.service;

import com.hillel.dao.ClientDao;
import com.hillel.dto.ClientDto;
import com.hillel.entity.Client;
import com.hillel.service.util.LogServiceMessageUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final Logger LOG = Logger.getLogger(ClientService.class.getName());
    private static final String METHOD_NAME = "findAllClients()";
    private static final String DAO = ClientDao.class.getName();

    private ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<ClientDto> findAllClients() {
        List<Client> clients = clientDao.findAllClients();
        List<ClientDto> result = new ArrayList<>();

        for (Client client : clients) {
            ClientDto dto = new ClientDto();
            dto.setId(client.getId());
            dto.setName(client.getName());
            dto.setEmail(client.getEmail());
            dto.setPhone(client.getPhone());
            dto.setAbout(client.getAbout());
            dto.setAge(client.getAge());

            result.add(dto);
        }
        if (result == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(METHOD_NAME, DAO));
        }

        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(METHOD_NAME, DAO));
        return result;
    }
}
