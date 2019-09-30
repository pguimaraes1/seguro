package br.com.ebix.seguro.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.ebix.seguro.entity.User;
import br.com.ebix.seguro.util.JPAUtil;

public class LoginPersistence {

	static EntityManager em = new JPAUtil().geEntityManager();

	// verifica se o usuario existe
	public User userExist(User user) {
		try {

			if (em == null || !em.isOpen()) {
				em = new JPAUtil().geEntityManager();
			}
			em.getTransaction().begin();
			List listaUsuarios = em.createQuery("select u from User as u where u.login = :login and u.senha = :senha")
					.setParameter("login", user.getLogin()).setParameter("senha", user.getSenha()).getResultList();
			if (listaUsuarios != null && listaUsuarios.size() == 1) {

				User userCheck = (User) listaUsuarios.get(0);
				if (userCheck != null) {
					return userCheck;
				} else {
					return null;
				}

			} else {
				return null;
			}

		} catch (Exception e) {

			return null;

		} finally {
			em.close();
		}

	}

}
