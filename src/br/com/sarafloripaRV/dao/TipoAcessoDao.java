package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Tipoacesso;
import br.com.sarafloripaRV.util.ConectionFactory;

public class TipoAcessoDao {

	public Tipoacesso salvar(Tipoacesso acesso) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		acesso = manager.merge(acesso);
		tx.commit();
		manager.close();
		return acesso;
	}

	public Tipoacesso consultar(int idacesso) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select t from Tipoacesso t where t.idtipoacesso=" + idacesso);
		Tipoacesso acesso = null;
		if (q.getResultList().size() > 0) {
			acesso = (Tipoacesso) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return acesso;
	}

	@SuppressWarnings("unchecked")
	public List<Tipoacesso> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Tipoacesso> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
