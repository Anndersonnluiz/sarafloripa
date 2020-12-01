package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Acesso;
import br.com.sarafloripaRV.util.ConectionFactory;

public class AcessoDao {

	
	public Acesso salvar(Acesso acesso) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		acesso = manager.merge(acesso);
		tx.commit();
		manager.close();
		return acesso;
	}

	public Acesso consultar(int idacesso) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select a from Acesso a where a.idacesso=" + idacesso);
		Acesso acesso = null;
		if (q.getResultList().size() > 0) {
			acesso = (Acesso) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return acesso;
	}

	@SuppressWarnings("unchecked")
	public List<Acesso> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Acesso> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
