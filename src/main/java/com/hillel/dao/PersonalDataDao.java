package com.hillel.dao;

import com.hillel.database.util.HibernatePropertiesUtil;
import com.hillel.database.util.HibernateUtil;
import com.hillel.entity.PersonalData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonalDataDao {
    private static final String FROM_PERSONAL_DATA = "FROM PersonalData";

    public List<PersonalData> findAllPersonalData() {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.createQuery(FROM_PERSONAL_DATA).list();
        }
    }

    public PersonalData findById(Integer id) {
        try ( Session session = HibernatePropertiesUtil.getSessionFactory().openSession() ) {
            return session.byId(PersonalData.class).getReference(id);
        }
    }

    public void save(PersonalData personalData) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.save(personalData);
            transaction.commit();
        }
    }

    public void delete(PersonalData personalData) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.delete(personalData);
            transaction.commit();
        }
    }

    public void update(PersonalData personalData) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession() ) {
            Transaction transaction = session.beginTransaction();

            session.update(personalData);
            transaction.commit();
        }
    }
}
