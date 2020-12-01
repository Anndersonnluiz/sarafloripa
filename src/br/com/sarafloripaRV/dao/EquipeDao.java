package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Equipe;
import br.com.sarafloripaRV.util.ConectionFactory;


public class EquipeDao {

	public Equipe salvar(Equipe equipe) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		equipe = manager.merge(equipe);
		tx.commit();
		manager.close();
		return equipe;
	}

	public Equipe consultar(int idequipe) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select e from Equipe e where e.idequipe=" + idequipe);
		Equipe equipe = null;
		if (q.getResultList().size() > 0) {
			equipe = (Equipe) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return equipe;
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Equipe> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	
}
