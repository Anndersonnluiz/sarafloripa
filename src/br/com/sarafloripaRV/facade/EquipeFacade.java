package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.EquipeDao;
import br.com.sarafloripaRV.model.Equipe;


public class EquipeFacade {

	private EquipeDao equipeDao;
	
	public Equipe salvar(Equipe equipe) {
		 equipeDao = new EquipeDao();
		return equipeDao.salvar(equipe);
	}

	public Equipe consultar(int idequipe) {
		equipeDao = new EquipeDao();
		return equipeDao.consultar(idequipe);
	}

	public List<Equipe> listar(String sql) {
		equipeDao = new EquipeDao();
		return equipeDao.lista(sql);
	}

}
