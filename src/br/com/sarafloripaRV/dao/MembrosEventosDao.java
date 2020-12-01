package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import br.com.sarafloripaRV.model.Membrosevento;
import br.com.sarafloripaRV.util.ConectionFactory;

public class MembrosEventosDao {

	public Membrosevento salvar(Membrosevento membrosevento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		membrosevento = manager.merge(membrosevento);
		tx.commit();
		manager.close();
		return membrosevento;
	}

	public Membrosevento consultar(int idMembrosevento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select e from Membrosevento t where t.idMembrosevento=" + idMembrosevento);
		Membrosevento membrosevento = null;
		if (q.getResultList().size() > 0) {
			membrosevento = (Membrosevento) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return membrosevento;
	}

	@SuppressWarnings("unchecked")
	public List<Membrosevento> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Membrosevento> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	public void excluir(int idmembrosevento) {
    	EntityManager manager;
    	manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
        Query q = manager.createQuery("Select m from Membrosevento m where m.idmembrosevento=" + idmembrosevento);
        if (q.getResultList().size()>0){
        	Membrosevento membrosevento = (Membrosevento) q.getResultList().get(0);
            manager.remove(membrosevento);
        }
        tx.commit();
        
    }
}
