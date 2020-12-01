package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Tipoevento;
import br.com.sarafloripaRV.util.ConectionFactory;

public class TipoEventoDao {

	public Tipoevento salvar(Tipoevento tipoevento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		tipoevento = manager.merge(tipoevento);
		tx.commit();
		manager.close();
		return tipoevento;
	}

	public Tipoevento consultar(int idtipoevento) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select t from Tipoevento t where t.idtipoevento=" + idtipoevento);
		Tipoevento tipoevento = null;
		if (q.getResultList().size() > 0) {
			tipoevento = (Tipoevento) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return tipoevento;
	}

	@SuppressWarnings("unchecked")
	public List<Tipoevento> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Tipoevento> lista = q.getResultList();
		manager.close();
		return lista;
	}
}
