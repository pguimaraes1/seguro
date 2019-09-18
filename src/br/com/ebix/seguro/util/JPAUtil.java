package br.com.ebix.seguro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("seguros");
	
	public EntityManager geEntityManager() {
		return emf.createEntityManager();
	}
	
}
