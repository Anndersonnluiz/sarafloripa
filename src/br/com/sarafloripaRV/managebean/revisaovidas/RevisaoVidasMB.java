package br.com.sarafloripaRV.managebean.revisaovidas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.RevisaoVidasFacade;
import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.Formatacao;

@Named
@ViewScoped
public class RevisaoVidasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Revisaovidas> listaRevisao;
	
	
	@PostConstruct
	public void init() {
		listaRevisoes();
	}
	
	
	
	
	
	
	public List<Revisaovidas> getListaRevisao() {
		return listaRevisao;
	}






	public void setListaRevisao(List<Revisaovidas> listaRevisao) {
		this.listaRevisao = listaRevisao;
	}






	public void listaRevisoes() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		listaRevisao = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.dataini>='" 
				+ Formatacao.ConvercaoDataSql(new Date()) + "' and r.ativo=true");
		if (listaRevisao == null) {
			listaRevisao = new ArrayList<Revisaovidas>();
		}
	}
	
	public String retornarRede(boolean rede) {
		if (rede) {
			return "Arena";
		}else {
			return "Adultos";
		}
	}
	
	
	public String editar(Revisaovidas revisaovidas) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("revisaovidas", revisaovidas);
		return "cadRevisaoVidas";
	}
	
	
	public String novo() {
		return "cadRevisaoVidas";
	}
	
	
	public String revisionistas(Revisaovidas revisaovidas) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("revisaovidas", revisaovidas);
		return "consFichasInscricoes";
	}

}
