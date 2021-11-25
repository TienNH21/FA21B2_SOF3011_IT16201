package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if ( factory == null || factory.isOpen() == false ) {
			factory = Persistence.createEntityManagerFactory("SOF3011_IT16201");
		}

		return factory;
	}
}
