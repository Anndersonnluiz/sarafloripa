package br.com.sarafloripaRV.managebean.revisaovidas;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.FichaInscricaoRvFacade;
import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.model.Revisaovidas;

@Named
@ViewScoped
public class AlterarFormaPagamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Revisaovidas revisaovidas;
	private Fichainscricaorv fichainscricaorv;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		revisaovidas = (Revisaovidas) session.getAttribute("revisaovidas");
		session.removeAttribute("revisaovidas");
		fichainscricaorv = (Fichainscricaorv) session.getAttribute("fichainscricaorv");
		session.removeAttribute("fichainscricaorv");
	}


	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}


	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
	}


	public Fichainscricaorv getFichainscricaorv() {
		return fichainscricaorv;
	}


	public void setFichainscricaorv(Fichainscricaorv fichainscricaorv) {
		this.fichainscricaorv = fichainscricaorv;
	}
	
	
	public String cancelar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("revisaovidas", revisaovidas);
		return "consFichasInscricoes";
	}
	
	public String salvar() {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		fichaInscricaoRvFacade.salvar(fichainscricaorv);
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("revisaovidas", revisaovidas);
		return "consFichasInscricoes";
	}
	
	
	
	

}
