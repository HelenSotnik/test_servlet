package com.hillel.database.util;

import com.hillel.entity.Account;
import com.hillel.entity.Client;
import com.hillel.entity.PersonalData;
import com.hillel.entity.Status;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernatePropertiesUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Status.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(PersonalData.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }
}
