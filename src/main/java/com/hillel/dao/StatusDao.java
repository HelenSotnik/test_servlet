package com.hillel.dao;

import com.hillel.database.util.HibernatePropertiesUtil;
import com.hillel.database.util.HibernateUtil;
import com.hillel.entity.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StatusDao {
    private static final String FROM_STATUSES = "FROM statuses";

    public List<Status> findAllStatuses() {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.createQuery(FROM_STATUSES).list();
        }
    }

    public Status findById(Integer id) {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.byId(Status.class).getReference(id);
        }
    }

    public void save(Status status) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.save(status);
            transaction.commit();
        }
    }

    public void delete(Status status) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.delete(status);
            transaction.commit();
        }
    }

    public void update(Status status) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.update(status);
            transaction.commit();
        }
    }
}
