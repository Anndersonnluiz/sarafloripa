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

import br.com.sarafloripaRV.facade.EquipeFacade;
import br.com.sarafloripaRV.facade.FichaInscricaoRvFacade;
import br.com.sarafloripaRV.facade.RevisaoVidasFacade;
import br.com.sarafloripaRV.model.Equipe;
import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.Formatacao;
import br.com.sarafloripaRV.util.Mensagem;

@Named
@ViewScoped
public class FichaInscricaoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fichainscricaorv fichainscricaorv;
	private Revisaovidas revisaovidas;
	private Equipe equipe;
	private List<Equipe> listaEquipe;
	private int nInscricao;
	private List<Revisaovidas> listaRevisaoVidas;
	private String nomeRede;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		revisaovidas = (Revisaovidas) session.getAttribute("revisaovidas");
		session.removeAttribute("revisaovidas");
		//listaRevisoes();
		if (revisaovidas != null) {
			fichainscricaorv = new Fichainscricaorv();
			fichainscricaorv.setRevisaovidas(revisaovidas);
			nInscricao = revisaovidas.getNpreenchido() + 1;
			if (revisaovidas.isRede()) {
				nomeRede = "ARENA";
			}else {
				nomeRede = "ADULTO";
			}
			fichainscricaorv.setPresenca(false);
			fichainscricaorv.setDescricaopresenca("x-circle");
			fichainscricaorv.setPagou("thumbs-down");
			fichainscricaorv.setCorpagou("red");
		}
		listaEquipe();
	}


	public Fichainscricaorv getFichainscricaorv() {
		return fichainscricaorv;
	}


	public void setFichainscricaorv(Fichainscricaorv fichainscricaorv) {
		this.fichainscricaorv = fichainscricaorv;
	}


	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}


	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
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


	public int getnInscricao() {
		return nInscricao;
	}


	public void setnInscricao(int nInscricao) {
		this.nInscricao = nInscricao;
	}


	public List<Revisaovidas> getListaRevisaoVidas() {
		return listaRevisaoVidas;
	}


	public void setListaRevisaoVidas(List<Revisaovidas> listaRevisaoVidas) {
		this.listaRevisaoVidas = listaRevisaoVidas;
	}


	public String getNomeRede() {
		return nomeRede;
	}


	public void setNomeRede(String nomeRede) {
		this.nomeRede = nomeRede;
	}


	public void buscarRevisao() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		List<Revisaovidas> lista = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.dataini>='" 
				+ Formatacao.ConvercaoDataSql(new Date()) + "' and r.ativo=true");
		if (lista == null) {
			lista = new ArrayList<Revisaovidas>();
		}
		if (lista.size() > 0) {
			revisaovidas = lista.get(0);
		}else {
			revisaovidas = new Revisaovidas();
		}
	}
	
	
	public void listaEquipe() {
		EquipeFacade equipeFacade = new EquipeFacade();
		listaEquipe = equipeFacade.listar("Select e From Equipe e");
		if (listaEquipe == null) {
			listaEquipe = new ArrayList<Equipe>();
		}
	}
	
	
	public String salvar() {
		if (validardados()) {
			fichainscricaorv.setEquipe(equipe);
			FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
			fichainscricaorv = fichaInscricaoRvFacade.salvar(fichainscricaorv);
			if (fichainscricaorv.getIdfichainscricaorv() != null) {
				RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
				revisaovidas.setNpreenchido(revisaovidas.getNpreenchido() + 1);
				revisaoVidasFacade.salvar(revisaovidas);
			}
			return "conclusaoinscricao";
		}else {
			Mensagem.lancarMensagemInfo("Informações obrigatórias(*) não preenchidas", "");
		}
		return "";
	}
	
	
	public boolean validardados() {
		if (fichainscricaorv.getNomeamigo1() == null) {
			return false;
		}
		if (fichainscricaorv.getTelefoneamigo1() == null) {
			return false;
		}
		if (fichainscricaorv.getDatanasc() == null) {
			return false;
		}
		if (fichainscricaorv.getNome() == null) {
			return false;
		}
		if (fichainscricaorv.getTelefone() == null) {
			return false;
		}
		if (equipe == null) {
			return false;
		}
		return true;
	}
	
	public void listaRevisoes() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		listaRevisaoVidas = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.dataini>='" 
				+ Formatacao.ConvercaoDataSql(new Date()) + "' and r.ativo=true");
		if (listaRevisaoVidas == null) {
			listaRevisaoVidas = new ArrayList<Revisaovidas>();
		}
		if (listaRevisaoVidas.size() > 0) {
			revisaovidas = listaRevisaoVidas.get(0);
		}
	}
	
	

}
