package br.com.ebix.seguro.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ebix.seguro.entity.User;
import br.com.ebix.seguro.util.JPAUtil;

public class Test {

	public static void main(String[] args) {
		
		User usuario = new User();
		usuario.setLogin("ph");
		usuario.setSenha("1234");
		
		EntityManager em = new JPAUtil().geEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		em.close();
			
		
		
	}

}
