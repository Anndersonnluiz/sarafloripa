package br.com.sarafloripaRV.managebean.eventos;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.MembrosEventoFacade;
import br.com.sarafloripaRV.model.Evento;
import br.com.sarafloripaRV.model.Membrosevento;

@Named
@ViewScoped
public class AlterarPagamentoEventoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private Membrosevento membrosevento;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		evento = (Evento) session.getAttribute("evento");
		session.removeAttribute("evento");
		membrosevento = (Membrosevento) session.getAttribute("membrosevento");
		session.removeAttribute("membrosevento");
	}



	public Evento getEvento() {
		return evento;
	}



	public void setEvento(Evento evento) {
		this.evento = evento;
	}



	public Membrosevento getMembrosevento() {
		return membrosevento;
	}



	public void setMembrosevento(Membrosevento membrosevento) {
		this.membrosevento = membrosevento;
	}
	
	
	
	public String cancelar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("evento", evento);
		return "consMembrosEvento";
	}
	
	
	public String salvar() {
		MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
		membrosEventoFacade.salvar(membrosevento);
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("evento", evento);
		return "consMembrosEvento";
	}
	
	
	
	

}
