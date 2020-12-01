package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.RevisaoVidasDao;
import br.com.sarafloripaRV.model.Revisaovidas;


public class RevisaoVidasFacade {

	private RevisaoVidasDao revisaoVidasDao;
	
	public Revisaovidas salvar(Revisaovidas revisaovidas) {
		 revisaoVidasDao = new RevisaoVidasDao();
		return revisaoVidasDao.salvar(revisaovidas);
	}

	public Revisaovidas consultar(int idrevisao) {
		revisaoVidasDao = new RevisaoVidasDao();
		return revisaoVidasDao.consultar(idrevisao);
	}

	public List<Revisaovidas> listar(String sql) {
		revisaoVidasDao = new RevisaoVidasDao();
		return revisaoVidasDao.lista(sql);
	}
}
