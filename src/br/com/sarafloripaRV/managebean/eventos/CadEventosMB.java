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
import br.com.sarafloripaRV.facade.TipoEventoFacade;
import br.com.sarafloripaRV.model.Evento;
import br.com.sarafloripaRV.model.Tipoevento;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class CadEventosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tipoevento> listaTipoEvento;
	private Evento evento;
	private Tipoevento tipoevento;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		evento = (Evento) session.getAttribute("evento");
		session.removeAttribute("evento");
		listarTipoEventos();
		if (evento == null) {
			evento = new Evento();
			evento.setNpreenchidoonline(0);
			evento.setNpreenchidopresencial(0);
		}else {
			tipoevento = evento.getTipoevento();
		}
	}



	public List<Tipoevento> getListaTipoEvento() {
		return listaTipoEvento;
	}



	public void setListaTipoEvento(List<Tipoevento> listaTipoEvento) {
		this.listaTipoEvento = listaTipoEvento;
	}



	public Evento getEvento() {
		return evento;
	}



	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	
	
	public Tipoevento getTipoevento() {
		return tipoevento;
	}



	public void setTipoevento(Tipoevento tipoevento) {
		this.tipoevento = tipoevento;
	}



	public void listarTipoEventos() {
		TipoEventoFacade tipoEventoFacade = new TipoEventoFacade();
		listaTipoEvento = tipoEventoFacade.listar("Select t From Tipoevento t");
		if (listaTipoEvento == null) {
			listaTipoEvento = new ArrayList<Tipoevento>();
		}
	}
	
	
	public String cancelar() {
		return "consEventos";
	}
	
	
	public String salvar() {
		EventoFacade eventoFacade = new EventoFacade();
		if (validarDados()) {
			evento.setTipoevento(tipoevento);
			eventoFacade.salvar(evento);
			return "consEventos";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (tipoevento == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe o Tipo de Evento");
			return false;
		}
		return true;
	}
	
	
	
	
	

}
