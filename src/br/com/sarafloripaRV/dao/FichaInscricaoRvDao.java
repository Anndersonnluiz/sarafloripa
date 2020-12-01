package br.com.sarafloripaRV.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.util.ConectionFactory;

public class FichaInscricaoRvDao {

	public Fichainscricaorv salvar(Fichainscricaorv fichainscricaorv) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		fichainscricaorv = manager.merge(fichainscricaorv);
		tx.commit();
		manager.close();
		return fichainscricaorv;
	}

	public Fichainscricaorv consultar(int idfichainscricaorv) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Query q = manager.createQuery("select f from Fichainscricaorv f where f.idfichainscricaorv=" + idfichainscricaorv);
		Fichainscricaorv fichainscricaorv = null;
		if (q.getResultList().size() > 0) {
			fichainscricaorv = (Fichainscricaorv) q.getResultList().get(0);
		}
		tx.commit();
		manager.close();
		return fichainscricaorv;
	}

	@SuppressWarnings("unchecked")
	public List<Fichainscricaorv> lista(String sql) {
		EntityManager manager;
		manager = ConectionFactory.getConnection();
		Query q = manager.createQuery(sql);
		List<Fichainscricaorv> lista = q.getResultList();
		manager.close();
		return lista;
	}
	
	 public void excluir(int idfichainscricaorv) {
	    	EntityManager manager;
	    	manager = ConectionFactory.getConnection();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
	        Query q = manager.createQuery("Select f from Fichainscricaorv f where f.idfichainscricaorv=" + idfichainscricaorv);
	        if (q.getResultList().size()>0){
	        	Fichainscricaorv fichainscricaorv = (Fichainscricaorv) q.getResultList().get(0);
	            manager.remove(fichainscricaorv);
	        }
	        tx.commit();
	        
	    }
}
