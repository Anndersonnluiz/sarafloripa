package br.com.sarafloripaRV.managebean.tipoevento;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.TipoEventoFacade;
import br.com.sarafloripaRV.model.Tipoevento;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class CadTipoEventoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tipoevento tipoevento;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		tipoevento = (Tipoevento) session.getAttribute("tipoevento");
		session.removeAttribute("tipoevento");
		if (tipoevento == null) {
			tipoevento = new Tipoevento();
		}
	}



	public Tipoevento getTipoevento() {
		return tipoevento;
	}



	public void setTipoevento(Tipoevento tipoevento) {
		this.tipoevento = tipoevento;
	}
	
	
	
	public String cancelar() {
		return "consTipoEventos";
	}
	
	
	public String salvar() {
		if (tipoevento.getDescricao().length() > 0) {
			TipoEventoFacade tipoEventoFacade = new TipoEventoFacade();
			tipoEventoFacade.salvar(tipoevento);
			return "consTipoEventos";
		}
		Mensagem.lancarMensagemInfo("Atenção", "Insira uma descrição para este tipo de evento!!");
		return "";
	}
	
	

}
