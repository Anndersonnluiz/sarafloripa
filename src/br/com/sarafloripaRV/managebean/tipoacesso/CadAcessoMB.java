package br.com.sarafloripaRV.managebean.tipoacesso;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.AcessoFacade;
import br.com.sarafloripaRV.facade.TipoAcessoFacade;
import br.com.sarafloripaRV.model.Acesso;
import br.com.sarafloripaRV.model.Tipoacesso;

@Named
@ViewScoped
public class CadAcessoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tipoacesso tipoacesso;
	private Acesso acesso;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		tipoacesso = (Tipoacesso) session.getAttribute("tipoacesso");
		session.removeAttribute("tipoacesso");
		if (tipoacesso == null) {
			tipoacesso = new Tipoacesso();
			acesso = new Acesso();
		}else {
			acesso = tipoacesso.getAcesso();
		}
	}


	public Tipoacesso getTipoacesso() {
		return tipoacesso;
	}


	public void setTipoacesso(Tipoacesso tipoacesso) {
		this.tipoacesso = tipoacesso;
	}


	public Acesso getAcesso() {
		return acesso;
	}


	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}
	
	
	
	public String cancelar() {
		return "consAcesso";
	}
	
	
	public String salvar() {
		TipoAcessoFacade tipoAcessoFacade = new TipoAcessoFacade();
		AcessoFacade acessoFacade = new AcessoFacade();
		acesso = acessoFacade.salvar(acesso);
		tipoacesso.setAcesso(acesso);
		tipoAcessoFacade.salvar(tipoacesso);
		return "consAcesso";
	}
	
	
	
	
	

}
