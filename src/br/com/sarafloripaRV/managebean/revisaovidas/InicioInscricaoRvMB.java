package br.com.sarafloripaRV.managebean.revisaovidas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.RevisaoVidasFacade;
import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.Formatacao;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class InicioInscricaoRvMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Revisaovidas> listaRevisao;
	private Revisaovidas revisaovidas;
	private boolean rede;
	
	
	
	@PostConstruct
	public void init() {
		//listaRevisoes();
	}
	
	
	
	
	public List<Revisaovidas> getListaRevisao() {
		return listaRevisao;
	}




	public void setListaRevisao(List<Revisaovidas> listaRevisao) {
		this.listaRevisao = listaRevisao;
	}




	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}




	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
	}




	public boolean isRede() {
		return rede;
	}




	public void setRede(boolean rede) {
		this.rede = rede;
	}




	public String fichainscricao() {
		listaRevisoes();
		if (this.revisaovidas != null && (revisaovidas.getNpreenchido()<revisaovidas.getVagas())) {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("revisaovidas", revisaovidas);
			return "fichainscricao";
		}else {
			Mensagem.lancarMensagemInfo("Sem Revisões disponiveis", "");
		}
		return "";
	}
	
	
	public void listaRevisoes() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		listaRevisao = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.dataini>='" 
				+ Formatacao.ConvercaoDataSql(new Date()) + "' and r.ativo=true and r.rede=" + rede);
		if (listaRevisao == null) {
			listaRevisao = new ArrayList<Revisaovidas>();
		}
		if (listaRevisao.size() > 0) {
			revisaovidas = listaRevisao.get(0);
		}
	}
	
	public String retornarRede(boolean rede) {
		if (rede) {
			return "Arena";
		}else {
			return "Adultos";
		}
	}
	
	public boolean revisaolotado(Revisaovidas revisaovidas) {
		if (revisaovidas.getVagas() <= revisaovidas.getNpreenchido()) {
			return false;
		}
		return true;
	}

}
