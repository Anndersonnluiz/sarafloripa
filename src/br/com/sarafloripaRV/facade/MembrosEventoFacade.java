package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.MembrosEventosDao;
import br.com.sarafloripaRV.model.Membrosevento;


public class MembrosEventoFacade {
	
	MembrosEventosDao membrosEventosDao;

	public Membrosevento salvar(Membrosevento membrosevento) {
		 membrosEventosDao = new MembrosEventosDao();
		return membrosEventosDao.salvar(membrosevento);
	}

	public Membrosevento consultar(int idmembro) {
		membrosEventosDao = new MembrosEventosDao();
		return membrosEventosDao.consultar(idmembro);
	}

	public List<Membrosevento> listar(String sql) {
		membrosEventosDao = new MembrosEventosDao();
		return membrosEventosDao.lista(sql);
	}
	
	public void excluir(int idMembrosevento) {
		membrosEventosDao = new MembrosEventosDao();
		membrosEventosDao.excluir(idMembrosevento);
	}
}
