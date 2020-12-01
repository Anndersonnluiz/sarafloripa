package br.com.sarafloripaRV.managebean.tipoacesso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.TipoAcessoFacade;
import br.com.sarafloripaRV.model.Tipoacesso;

@Named
@ViewScoped
public class AcessoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tipoacesso> listaAcesso;
	
	
	
	@PostConstruct
	public void init() {
		listarAcesso();
	}



	public List<Tipoacesso> getListaAcesso() {
		return listaAcesso;
	}



	public void setListaAcesso(List<Tipoacesso> listaAcesso) {
		this.listaAcesso = listaAcesso;
	}
	
	
	
	public void listarAcesso() {
		TipoAcessoFacade tipoAcessoFacade = new TipoAcessoFacade();
		listaAcesso = tipoAcessoFacade.listar("Select t From Tipoacesso t");
		if (listaAcesso == null) {
			listaAcesso = new ArrayList<Tipoacesso>();
		}
	}
	
	
	public String novo() {
		return "cadAcesso";
	}
	
	
	public String editar(Tipoacesso tipoacesso) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("tipoacesso", tipoacesso);
		return "cadAcesso";
	}
	
	
	
	

}
