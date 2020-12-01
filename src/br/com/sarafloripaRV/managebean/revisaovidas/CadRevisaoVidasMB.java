package br.com.sarafloripaRV.managebean.revisaovidas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


import br.com.sarafloripaRV.facade.EquipeFacade;
import br.com.sarafloripaRV.facade.RevisaoVidasFacade;
import br.com.sarafloripaRV.model.Equipe;
import br.com.sarafloripaRV.model.Revisaovidas;

@Named
@ViewScoped
public class CadRevisaoVidasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Revisaovidas revisaovidas;
	private List<Equipe> listaEquipe;
	private Equipe equipe;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		revisaovidas = (Revisaovidas) session.getAttribute("revisaovidas");
		session.removeAttribute("revisaovidas");
		if (revisaovidas == null) {
			revisaovidas = new Revisaovidas();
			revisaovidas.setNpreenchido(0);
		}else {
			equipe = revisaovidas.getEquipe();
		}
		listaEquipe();
	}



	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}



	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
	}



	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}



	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	
	
	public boolean validarDados() {
		if (revisaovidas.getDatafin() == null) {
			return false;
		}
		if (revisaovidas.getDataini() == null) {
			return false;
		}
		if (revisaovidas.getEquipe() == null) {
			return false;
		}
		return true;
	}
	
	
	public void listaEquipe() {
		EquipeFacade equipeFacade = new EquipeFacade();
		listaEquipe = equipeFacade.listar("Select e From Equipe e");
		if (listaEquipe == null) {
			listaEquipe = new ArrayList<Equipe>();
		}
	}
	
	
	public String salvar() {
		revisaovidas.setEquipe(equipe);
		if (validarDados()) {
			RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
			revisaovidas = revisaoVidasFacade.salvar(revisaovidas);
			return "consRevisaoVidas";
		}
		return "";
	}
	
	
	public String cancelar() {
		return "consRevisaoVidas";
	}
	
	

}
