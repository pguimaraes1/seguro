package br.com.ebix.seguro.persistence;

import javax.persistence.EntityManager;

import br.com.ebix.seguro.entity.User;
import br.com.ebix.seguro.util.JPAUtil;

public class TesteList {
	
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().geEntityManager();
		
		em.getTransaction().begin();
			User user = em.find(User.class, 1);
			String login = user.getLogin();
			String senha = user.getSenha();
		em.getTransaction().commit();
		
	}
	
}
