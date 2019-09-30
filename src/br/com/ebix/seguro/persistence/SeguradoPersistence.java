package br.com.ebix.seguro.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.ebix.seguro.entity.Segurado;
import br.com.ebix.seguro.util.JPAUtil;

public class SeguradoPersistence {
	TypedQuery<Segurado> query;
	EntityTransaction transaction;
	static EntityManager em = new JPAUtil().geEntityManager();
	static {
		if (em == null || em.isOpen()) {
			em = new JPAUtil().geEntityManager();
		}
	}

	public void create(Segurado segurado) throws Exception {
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(segurado);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<Segurado> findAll() {
		try {
			query = em.createQuery("select seg from Segurado as seg", Segurado.class);
			List<Segurado> segurados = query.getResultList();
			return segurados;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} 
	}

	public void delete(Integer id) {
		try {
			transaction = em.getTransaction();
			transaction.begin();
			Segurado segurado = em.find(Segurado.class, id);
			em.remove(segurado);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
