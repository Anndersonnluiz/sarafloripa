package br.com.sarafloripaRV.managebean.eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.EventoFacade;
import br.com.sarafloripaRV.model.Evento;

@Named
@ViewScoped
public class EventosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Evento> listaEventos;
	
	
	@PostConstruct
	public void init() {
		listarEventos();
	}


	public List<Evento> getListaEventos() {
		return listaEventos;
	}


	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	
	
	
	public void listarEventos() {
		EventoFacade eventoFacade = new EventoFacade();
		listaEventos = eventoFacade.listar("Select e From Evento e");
		if (listaEventos == null) {
			listaEventos = new ArrayList<Evento>();
		}
	}
	
	
	
	public String novo() {
		return "cadEventos";
	}
	
	
	public String editar(Evento evento) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("evento", evento);
		return "cadEventos";
	}
	
	
	public String listaMembros(Evento evento) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("evento", evento);
		return "consMembrosEvento";
	}
	
	
	
	

}
