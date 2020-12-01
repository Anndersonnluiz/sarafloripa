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
import br.com.sarafloripaRV.facade.MembrosEventoFacade;
import br.com.sarafloripaRV.model.Evento;
import br.com.sarafloripaRV.model.Membrosevento;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class MembrosEventoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private List<Membrosevento> listaMembros;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		evento = (Evento) session.getAttribute("evento");
		session.removeAttribute("evento");
		listarMembrosEvento();
	}



	public Evento getEvento() {
		return evento;
	}



	public void setEvento(Evento evento) {
		this.evento = evento;
	}



	public List<Membrosevento> getListaMembros() {
		return listaMembros;
	}



	public void setListaMembros(List<Membrosevento> listaMembros) {
		this.listaMembros = listaMembros;
	}
	
	
	
	public void listarMembrosEvento() {
		MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
		listaMembros = membrosEventoFacade.listar("Select m From Membrosevento m WHERE m.evento.idevento=" + evento.getIdevento());
		if (listaMembros == null) {
			listaMembros = new ArrayList<Membrosevento>();
		}
	}
	
	
	public String voltar() {
		return "consEventos";
	}
	
	
	public void pagou(Membrosevento membrosevento) {
		MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
		if (membrosevento.getPagou().equalsIgnoreCase("thumbs-down")) {
			membrosevento.setPagou("thumbs-up");
			membrosevento.setCorpagou("green");
			if (membrosevento.getPresenca().equalsIgnoreCase("Presencial")) {
				evento.setNpreenchidopresencial(evento.getNpreenchidopresencial() + 1);
				membrosevento.setNinscricao("P-" + evento.getNpreenchidopresencial());
			}else {
				evento.setNpreenchidoonline(evento.getNpreenchidoonline() + 1);
				membrosevento.setNinscricao("O-" + evento.getNpreenchidoonline());
			}
		}else {
			membrosevento.setPagou("thumbs-down");
			membrosevento.setCorpagou("red");
			membrosevento.setNinscricao("");
			if (membrosevento.getPresenca().equalsIgnoreCase("Presencial")) {
				if (evento.getNpreenchidopresencial() > 0) {
					evento.setNpreenchidopresencial(evento.getNpreenchidopresencial() - 1);
				}
			}else {
				if (evento.getNpreenchidoonline() > 0) {
					evento.setNpreenchidoonline(evento.getNpreenchidoonline() - 1);
				}
			}
		}
		EventoFacade eventoFacade = new EventoFacade();
		eventoFacade.salvar(evento);
		membrosEventoFacade.salvar(membrosevento);
	}
	
	
	public void excluir(Membrosevento membrosevento) {
		MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
		if (membrosevento.getPagou().equalsIgnoreCase("thumbs-up")) {
			if (membrosevento.getPresenca().equalsIgnoreCase("Presencial")) {
				evento.setNpreenchidopresencial(evento.getNpreenchidopresencial() - 1);
			}else {
				evento.setNpreenchidoonline(evento.getNpreenchidoonline() - 1);
			}
		}
		membrosEventoFacade.excluir(membrosevento.getIdmembrosevento());
		Mensagem.lancarMensagemInfo("Excluido com sucesso", "");
		listaMembros.remove(membrosevento);
		EventoFacade eventoFacade = new EventoFacade();
		eventoFacade.salvar(evento);
	}
	
	
	public String alterarPagamento(Membrosevento membrosevento) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("evento", evento);
		session.setAttribute("membrosevento", membrosevento);
		return "alterarPagamentoEvento";
	}
	
	
	
	
	

}
