package br.com.sarafloripaRV.managebean.eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.EquipeFacade;
import br.com.sarafloripaRV.facade.MembrosEventoFacade;
import br.com.sarafloripaRV.model.Equipe;
import br.com.sarafloripaRV.model.Evento;
import br.com.sarafloripaRV.model.Membrosevento;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class FormEventosMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private Equipe equipe;
	private List<Equipe> listaEquipe;
	private Membrosevento membrosevento;
	private boolean desabilitarPresencial = false;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		evento = (Evento) session.getAttribute("evento");
		session.removeAttribute("evento");
		listarEquipe();
		if (evento != null) {
			membrosevento = new Membrosevento();
			membrosevento.setEvento(evento);
			membrosevento.setPagou("thumbs-down");
			membrosevento.setCorpagou("red");
			if (evento.getVagaspresencial() <= evento.getNpreenchidopresencial()) {
				desabilitarPresencial = true;
			}
		}
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}


	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}


	public Membrosevento getMembrosevento() {
		return membrosevento;
	}


	public void setMembrosevento(Membrosevento membrosevento) {
		this.membrosevento = membrosevento;
	}
	
	

	
	
	
	
	public boolean isDesabilitarPresencial() {
		return desabilitarPresencial;
	}


	public void setDesabilitarPresencial(boolean desabilitarPresencial) {
		this.desabilitarPresencial = desabilitarPresencial;
	}


	public String salvar() {
		if (validarDados()) {
			membrosevento.setEquipe(equipe);
			MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
			membrosevento = membrosEventoFacade.salvar(membrosevento);
			return "conclusaoInscricaoEvento";
		}
		return "";
	}
	
	
	public boolean validarDados() {
		if (equipe == null) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe sua equipe");
			return false;
		}
		
		if (membrosevento.getNome() == null || membrosevento.getNome().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe seu nome");
			return false;
		}
		
		if (membrosevento.getTipopagamento() == null || membrosevento.getTipopagamento().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe o Tipo de Pagamento");
			return false;
		}
		
		if (membrosevento.getPresenca() == null || membrosevento.getPresenca().length() <= 0) {
			Mensagem.lancarMensagemInfo("Atenção", "Informe onde será sua participação");
			return false;
		}
		return true;
	}
	
	
	public void listarEquipe() {
		EquipeFacade equipeFacade = new EquipeFacade();
		listaEquipe = equipeFacade.listar("Select e From Equipe e");
		if (listaEquipe == null) {
			listaEquipe = new ArrayList<Equipe>();
		}
	}
	
	
	
	
	

}
