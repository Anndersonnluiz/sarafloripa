package br.com.sarafloripaRV.facade;

import java.util.List;

import br.com.sarafloripaRV.dao.FichaInscricaoRvDao;
import br.com.sarafloripaRV.model.Fichainscricaorv;


public class FichaInscricaoRvFacade {
	
	private FichaInscricaoRvDao fichaInscricaoRvDao;

	public Fichainscricaorv salvar(Fichainscricaorv fichainscricaorv) {
		 fichaInscricaoRvDao = new FichaInscricaoRvDao();
		return fichaInscricaoRvDao.salvar(fichainscricaorv);
	}

	public Fichainscricaorv consultar(int idficha) {
		fichaInscricaoRvDao = new FichaInscricaoRvDao();
		return fichaInscricaoRvDao.consultar(idficha);
	}

	public List<Fichainscricaorv> listar(String sql) {
		fichaInscricaoRvDao = new FichaInscricaoRvDao();
		return fichaInscricaoRvDao.lista(sql);
	}
	
	public void excluir(int idfichainscricaorv) {
		fichaInscricaoRvDao = new FichaInscricaoRvDao();
		fichaInscricaoRvDao.excluir(idfichainscricaorv);
	}
}
