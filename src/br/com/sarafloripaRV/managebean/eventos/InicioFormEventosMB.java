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
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class InicioFormEventosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Evento> listaEvento;
	private Evento evento;
	
	
	@PostConstruct
	public void init() {
		listarEvento();
	}


	public List<Evento> getListaEvento() {
		return listaEvento;
	}


	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}
	
	
	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public void listarEvento() {
		EventoFacade eventoFacade = new EventoFacade();
		listaEvento = eventoFacade.listar("Select e From Evento e WHERE e.ativo=true");
		if (listaEvento == null) {
			listaEvento = new ArrayList<Evento>();
		}
	}
	
	
	public String formulario() {
		if (evento != null && evento.getIdevento() != null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("evento", evento);
			return "formEventos";
		}
		Mensagem.lancarMensagemInfo("Atenção", "Selecione um evento");
		return "";
	}
	
	
	

}
