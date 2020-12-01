package br.com.sarafloripaRV.managebean.revisaovidas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.sarafloripaRV.facade.FichaInscricaoRvFacade;
import br.com.sarafloripaRV.facade.RevisaoVidasFacade;  
import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class FichaInscricoesMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Fichainscricaorv> listaRevisionistas;
	private Revisaovidas revisaovidas;
	
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		revisaovidas = (Revisaovidas) session.getAttribute("revisaovidas");
		session.removeAttribute("revisaovidas");
		listaRevisionistas();
	}



	public List<Fichainscricaorv> getListaRevisionistas() {
		return listaRevisionistas;
	}



	public void setListaRevisionistas(List<Fichainscricaorv> listaRevisionistas) {
		this.listaRevisionistas = listaRevisionistas;
	}



	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}



	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
	}
	
	
	
	
	public void listaRevisionistas() {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		listaRevisionistas = fichaInscricaoRvFacade.listar("Select f From Fichainscricaorv f Where "
				+ "f.revisaovidas.idrevisaovidas=" + revisaovidas.getIdrevisaovidas() + " order by f.equipe.nome,"
						+ " f.nome");
		
		if (listaRevisionistas == null) {
			listaRevisionistas = new ArrayList<Fichainscricaorv>();
		}
	}
	
	
	public void excluir(Fichainscricaorv fichainscricaorv) {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		fichaInscricaoRvFacade.excluir(fichainscricaorv.getIdfichainscricaorv());
		Mensagem.lancarMensagemInfo("Excluido com sucesso", "");
		listaRevisionistas.remove(fichainscricaorv);
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		revisaovidas.setNpreenchido(revisaovidas.getNpreenchido() - 1);
		revisaoVidasFacade.salvar(revisaovidas);
	}
	
	
	public String retornarRede(boolean rede) {
		if (rede) {
			return "Arena";
		}else {
			return "Adultos";
		}
	}
	
	public String voltar() {
		return "consRevisaoVidas";
	}
	
	
	public void ativarDesativar(Fichainscricaorv fichainscricaorv) {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		if (fichainscricaorv.isPresenca()) {
			fichainscricaorv.setPresenca(false);
			fichainscricaorv.setDescricaopresenca("x-circle");
		}else {
			fichainscricaorv.setPresenca(true);
			fichainscricaorv.setDescricaopresenca("check");
		}
		fichaInscricaoRvFacade.salvar(fichainscricaorv);
	}
	
	public void pagou(Fichainscricaorv fichainscricaorv) {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		if (fichainscricaorv.getPagou().equalsIgnoreCase("thumbs-down")) {
			fichainscricaorv.setPagou("thumbs-up");
			fichainscricaorv.setCorpagou("green");
		}else {
			fichainscricaorv.setPagou("thumbs-down");
			fichainscricaorv.setCorpagou("red");
		}
		fichaInscricaoRvFacade.salvar(fichainscricaorv);
	}
	
	
	public String alterarPagamento(Fichainscricaorv fichainscricaorv) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("revisaovidas", revisaovidas);
		session.setAttribute("fichainscricaorv", fichainscricaorv);
		return "alterarFormaPagamento";
	}
	
	
	

}
