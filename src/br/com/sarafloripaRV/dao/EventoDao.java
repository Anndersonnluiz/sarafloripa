package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Evento;
import br.com.sarafloripaRV.util.ConectionFactory;

public class EventoDao {

	public Evento salvar(Evento evento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		evento = manager.merge(evento);
		tx.commit();
		manager.close();
		return evento;
	}

	public Evento consultar(int idEvento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select e from Evento t where t.idevento=" + idEvento);
		Evento evento = null;
		if (q.getResultList().size() > 0) {
			evento = (Evento) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return evento;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Evento> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
