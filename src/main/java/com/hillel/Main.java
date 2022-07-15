package com.hillel;

import com.hillel.dao.ClientDao;
import com.hillel.dao.StatusDao;
import com.hillel.entity.Account;
import com.hillel.entity.Client;
import com.hillel.entity.PersonalData;
import com.hillel.entity.Status;

import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ClientDao customerDao = new ClientDao();
        StatusDao statusDao = new StatusDao();

        PersonalData personalData = new PersonalData();
        personalData.setFirstName("Michel");
        personalData.setLastName("Killer");
        personalData.setIdCardNumber("IK771654");

        Status status = new Status();
        status.setAlias("VIP");
        status.setDescription("VIP service");

        Account account = new Account();
        account.setNumber("94844662233355");
        account.setValue(1999.75);

        Client client = new Client();
        client.setName("Micha");
        client.setEmail("gaad@gmail.com");
        client.setPhone(380956644211L);
        client.setAbout("Micha is ...");
        client.setAge(30);

        client.setAccounts(Collections.singleton(account));
        client.setStatuses(new HashSet<>(statusDao.findAllStatuses()));
        client.setPersonalData(personalData);

        customerDao.save(client);

        customerDao.findAllClients().forEach(System.out::println);
    }
}
