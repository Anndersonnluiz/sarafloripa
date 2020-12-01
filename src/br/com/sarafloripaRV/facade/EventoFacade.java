package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.EventoDao;
import br.com.sarafloripaRV.model.Evento;

public class EventoFacade {

	EventoDao eventoDao;
	
	public Evento salvar(Evento evento) {
		 eventoDao = new EventoDao();
		return eventoDao.salvar(evento);
	}

	public Evento consultar(int idevento) {
		eventoDao = new EventoDao();
		return eventoDao.consultar(idevento);
	}

	public List<Evento> listar(String sql) {
		eventoDao = new EventoDao();
		return eventoDao.lista(sql);
	}
}
