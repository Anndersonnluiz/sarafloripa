package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.TipoEventoDao;
import br.com.sarafloripaRV.model.Tipoevento;

public class TipoEventoFacade {

	TipoEventoDao tipoEventoDao;
	
	public Tipoevento salvar(Tipoevento tipoevento) {
		 tipoEventoDao = new TipoEventoDao();
		return tipoEventoDao.salvar(tipoevento);
	}

	public Tipoevento consultar(int idtipoevento) {
		tipoEventoDao = new TipoEventoDao();
		return tipoEventoDao.consultar(idtipoevento);
	}

	public List<Tipoevento> listar(String sql) {
		tipoEventoDao = new TipoEventoDao();
		return tipoEventoDao.lista(sql);
	}
}
