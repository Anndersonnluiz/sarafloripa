package br.com.sarafloripaRV.managebean.relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sarafloripaRV.facade.EquipeFacade;
import br.com.sarafloripaRV.facade.FichaInscricaoRvFacade;
import br.com.sarafloripaRV.model.Equipe;
import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.util.Formatacao;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class RelatorioContatoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipe equipe;
	private List<Equipe> listaEquipe;
	private String sql;
	private List<Fichainscricaorv> listaRevisionistas;
	
	
	@PostConstruct
	public void init() {
		listaEquipe();
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}


	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}
	
	
	public String getSql() {
		return sql;
	}


	public void setSql(String sql) {
		this.sql = sql;
	}


	public List<Fichainscricaorv> getListaRevisionistas() {
		return listaRevisionistas;
	}


	public void setListaRevisionistas(List<Fichainscricaorv> listaRevisionistas) {
		this.listaRevisionistas = listaRevisionistas;
	}
	
	
	public void listaEquipe() {
		EquipeFacade equipeFacade = new EquipeFacade();
		listaEquipe = equipeFacade.listar("Select e From Equipe e");
		if (listaEquipe == null) {
			listaEquipe = new ArrayList<Equipe>();
		}
	}
	
	
	public void pesquisar() {
		if (equipe != null && equipe.getIdequipe() != null) {
			sql = "Select f From Fichainscricaorv f WHERE f.revisaovidas.ativo=true AND "
					+ "f.revisaovidas.dataini>='" + Formatacao.ConvercaoDataNfe(new Date()) + "' AND "
					+ "f.equipe.idequipe=" + equipe.getIdequipe();
			FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
			listaRevisionistas = fichaInscricaoRvFacade.listar(sql);
			if (listaRevisionistas == null) {
				listaRevisionistas = new ArrayList<Fichainscricaorv>();
			}
		}else {
			Mensagem.lancarMensagemInfo("Informação da Equipe obrigatório", "");
		}
	}

}
