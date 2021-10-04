package com.hillel;

import com.hillel.dao.ClientDao;
import com.hillel.entity.Client;

public class Main {
    public static void main(String[] args) {
        ClientDao customerDao = new ClientDao();

        Client client = new Client();
        client.setName("Micha");
        client.setEmail("gaad@gmail.com");
        client.setPhone(380956644211L);
        client.setAbout("Micha is ...");
        client.setAge(30);
        customerDao.save(client);

        customerDao.findAllClients().forEach(System.out::println);
    }
}
