package org.oregami.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateJpaUtil {

    private static final EntityManagerFactory emf;

    static {
        try {
            // Create the EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("data");
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
