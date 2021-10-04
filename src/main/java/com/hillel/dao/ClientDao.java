package com.hillel.dao;

import com.hillel.database.util.HibernatePropertiesUtil;
import com.hillel.database.util.HibernateUtil;
import com.hillel.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    private static final String FROM_CLIENTS = "FROM clients";
    private static final String PHONE_QUERY = "FROM clients where phone = :phone";
    private static final String PHONE = "phone";


    public List<Client> findAllClients() {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.createQuery(FROM_CLIENTS).list();
        }
    }

    public Client findById(Integer id) {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.byId(Client.class).getReference(id);
        }
    }

    public void save(Client client) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.save(client);
            transaction.commit();
        }
    }

    public void delete(Client client) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.delete(client);
            transaction.commit();
        }
    }

    public void update(Client client) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.update(client);
            transaction.commit();
        }
    }

    public List<Client> getByPhoneNumber(Long phone) {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.createQuery(PHONE_QUERY).setParameter(PHONE, phone).list();
        }
    }
}
