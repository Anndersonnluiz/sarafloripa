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

@Named
@ViewScoped
public class RelatorioRevisaoEquipeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipe equipe;
	private List<Equipe> listaEquipe;
	private String sql;
	private List<Fichainscricaorv> listaRevisionistas;
	private int nTotal;
	private int nAdultos;
	private int nArena;
	private String nome;
	private int financeiro;
	
	
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


	public int getnTotal() {
		return nTotal;
	}


	public void setnTotal(int nTotal) {
		this.nTotal = nTotal;
	}


	public int getnAdultos() {
		return nAdultos;
	}


	public void setnAdultos(int nAdultos) {
		this.nAdultos = nAdultos;
	}


	public int getnArena() {
		return nArena;
	}


	public void setnArena(int nArena) {
		this.nArena = nArena;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getFinanceiro() {
		return financeiro;
	}


	public void setFinanceiro(int financeiro) {
		this.financeiro = financeiro;
	}


	public String retornarRede(boolean rede) {
		if (rede) {
			return "Arena";
		}else {
			return "Adultos";
		}
	}
	
	
	public void listaEquipe() {
		EquipeFacade equipeFacade = new EquipeFacade();
		listaEquipe = equipeFacade.listar("Select e From Equipe e");
		if (listaEquipe == null) {
			listaEquipe = new ArrayList<Equipe>();
		}
	}
	
	
	public void pesquisar() { 
		sql = "Select f From Fichainscricaorv f WHERE f.revisaovidas.ativo=true AND "
				+ "f.revisaovidas.dataini>='" + Formatacao.ConvercaoDataNfe(new Date()) + "'"
						+ " AND f.nome like '%" + nome + "%'";
		if (equipe != null && equipe.getIdequipe() != null) {
			sql = sql + " AND f.equipe.idequipe=" + equipe.getIdequipe();
		}
		if (financeiro == 1) {
			sql = sql + " AND f.pagou='thumbs-up'";
		}else if(financeiro == 2) {
			sql = sql + " AND f.pagou='thumbs-down'";
		}
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		listaRevisionistas = fichaInscricaoRvFacade.listar(sql);
		if (listaRevisionistas == null) {
			listaRevisionistas = new ArrayList<Fichainscricaorv>();
		}
		nTotal = listaRevisionistas.size();
		nAdultos = 0;
		nArena = 0;
		for (int i = 0; i < listaRevisionistas.size(); i++) {
			if (listaRevisionistas.get(i).getRevisaovidas().isRede()) {
				nArena = nArena + 1;
			}else {
				nAdultos = nAdultos + 1;
			}
		}
	}
	

}
