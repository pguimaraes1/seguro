package br.com.ebix.seguro.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.ebix.seguro.entity.Seguro;
import br.com.ebix.seguro.util.JPAUtil;

public class SeguroPersistence {
	TypedQuery<Seguro> query;
	EntityTransaction transaction;
	static EntityManager em = new JPAUtil().geEntityManager();
	static {
		if (em == null || em.isOpen()) {
			em = new JPAUtil().geEntityManager();
		}
	}

	public void create(Seguro seguro) throws Exception {
		transaction = em.getTransaction();
		transaction.begin();
		em.persist(seguro);
		transaction.commit();
	}
	
	public Seguro findById(Integer id) {
        Seguro seguro = em.find(Seguro.class, id);
        if (seguro == null) {
            throw new EntityNotFoundException("Nenhum seguro encontrado com id: "
                + seguro);
        }
        return seguro;
    }
	
	public List<Seguro> findAll() {
		query = em.createQuery("select seg from Seguro as seg", Seguro.class);
		List<Seguro> seguros = query.getResultList();
		return seguros;
	}
	
	public void delete(Integer id) {
		try {
			transaction = em.getTransaction();
			transaction.begin();
			Seguro seguro = em.find(Seguro.class, id);
			em.remove(seguro);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void update (Seguro seguro) {
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(seguro);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
	}

}
