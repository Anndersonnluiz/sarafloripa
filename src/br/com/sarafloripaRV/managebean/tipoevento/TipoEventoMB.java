package br.com.sarafloripaRV.managebean.tipoevento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.TipoEventoFacade;
import br.com.sarafloripaRV.model.Tipoevento;

@Named
@ViewScoped
public class TipoEventoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tipoevento> listaTipoEvento;
	
	
	
	@PostConstruct
	public void init() {
		listarTipoEvento();
	}



	public List<Tipoevento> getListaTipoEvento() {
		return listaTipoEvento;
	}



	public void setListaTipoEvento(List<Tipoevento> listaTipoEvento) {
		this.listaTipoEvento = listaTipoEvento;
	}
	
	
	
	
	public void listarTipoEvento() {
		TipoEventoFacade tipoEventoFacade = new TipoEventoFacade();
		listaTipoEvento = tipoEventoFacade.listar("Select t From Tipoevento t");
		if (listaTipoEvento == null) {
			listaTipoEvento = new ArrayList<Tipoevento>();
		}
	}
	
	
	
	public String novo() {
		return "cadTipoEventos";
	}
	
	
	public String editar(Tipoevento tipoevento) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("tipoevento", tipoevento);
		return "cadTipoEventos";
	}
	
	
	

}
