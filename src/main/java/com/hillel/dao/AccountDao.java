package com.hillel.dao;

import com.hillel.database.util.HibernatePropertiesUtil;
import com.hillel.database.util.HibernateUtil;
import com.hillel.entity.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountDao {
    private static final String FROM_ACCOUNTS = "FROM Account";

    public List<Account> findAllAccounts() {
        try (Session session = HibernatePropertiesUtil.getSessionFactory().openSession()) {
            return session.createQuery(FROM_ACCOUNTS).list();
        }
    }

    public Account findById(Integer id) {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.byId(Account.class).getReference(id);
        }
    }

    public void save(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(account);
            transaction.commit();
        }
    }

    public void delete(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(account);
            transaction.commit();
        }
    }

    public void update(Account account) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.update(account);
            transaction.commit();
        }
    }
}
