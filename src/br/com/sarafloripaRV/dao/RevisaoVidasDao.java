package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.ConectionFactory;

public class RevisaoVidasDao {

	public Revisaovidas salvar(Revisaovidas revisaovidas) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		revisaovidas = manager.merge(revisaovidas);
		tx.commit();
		manager.close();
		return revisaovidas;
	}

	public Revisaovidas consultar(int idrevisaovidas) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select r from Revisaovidas r where r.idrevisaovidas=" + idrevisaovidas);
		Revisaovidas equipe = null;
		if (q.getResultList().size() > 0) {
			equipe = (Revisaovidas) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return equipe;
	}

	@SuppressWarnings("unchecked")
	public List<Revisaovidas> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Revisaovidas> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
