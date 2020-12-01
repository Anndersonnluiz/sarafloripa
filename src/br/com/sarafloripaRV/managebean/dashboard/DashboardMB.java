package br.com.sarafloripaRV.managebean.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sarafloripaRV.facade.FichaInscricaoRvFacade;
import br.com.sarafloripaRV.facade.MembrosEventoFacade;
import br.com.sarafloripaRV.facade.RevisaoVidasFacade;
import br.com.sarafloripaRV.model.Fichainscricaorv;
import br.com.sarafloripaRV.model.Membrosevento;
import br.com.sarafloripaRV.model.Revisaovidas;
import br.com.sarafloripaRV.util.Formatacao;

@Named
@ViewScoped
public class DashboardMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nRevisoesArena;
	private int nVagasArena;
	private int nPreenchidasArena;
	private int nRevisoesAdulto;
	private int nVagasAdulto;
	private int nPreenchidasAdulto;;
	private float valorPAgo;
	private float valorNaoPago;
	private int nInscricoesPresenciais;
	private int nVagasPagasPresenciais;
	private int nVagasTotalPresenciais;
	private int nInscricoesOnline;
	private int nVagasPagasOnline;
	private int nVagasTotalOnline;
	
	
	
	@PostConstruct
	public void init() {
		calcularRevisoesArena();
		calcularRevisoesAdultos();
		calcularValoresNaoPagos();
		calcularValoresPagos();
		calcularInscricoesEnviadas();
	}
	
	
	
	
	public int getnRevisoesArena() {
		return nRevisoesArena;
	}





	public void setnRevisoesArena(int nRevisoesArena) {
		this.nRevisoesArena = nRevisoesArena;
	}





	public int getnVagasArena() {
		return nVagasArena;
	}





	public void setnVagasArena(int nVagasArena) {
		this.nVagasArena = nVagasArena;
	}





	public int getnPreenchidasArena() {
		return nPreenchidasArena;
	}





	public void setnPreenchidasArena(int nPreenchidasArena) {
		this.nPreenchidasArena = nPreenchidasArena;
	}





	public int getnRevisoesAdulto() {
		return nRevisoesAdulto;
	}





	public void setnRevisoesAdulto(int nRevisoesAdulto) {
		this.nRevisoesAdulto = nRevisoesAdulto;
	}





	public int getnVagasAdulto() {
		return nVagasAdulto;
	}





	public void setnVagasAdulto(int nVagasAdulto) {
		this.nVagasAdulto = nVagasAdulto;
	}





	public int getnPreenchidasAdulto() {
		return nPreenchidasAdulto;
	}





	public void setnPreenchidasAdulto(int nPreenchidasAdulto) {
		this.nPreenchidasAdulto = nPreenchidasAdulto;
	}

	

	
	public float getValorPAgo() {
		return valorPAgo;
	}




	public void setValorPAgo(float valorPAgo) {
		this.valorPAgo = valorPAgo;
	}




	public float getValorNaoPago() {
		return valorNaoPago;
	}




	public void setValorNaoPago(float valorNaoPago) {
		this.valorNaoPago = valorNaoPago;
	}




	public int getnInscricoesPresenciais() {
		return nInscricoesPresenciais;
	}




	public void setnInscricoesPresenciais(int nInscricoesPresenciais) {
		this.nInscricoesPresenciais = nInscricoesPresenciais;
	}




	public int getnVagasPagasPresenciais() {
		return nVagasPagasPresenciais;
	}




	public void setnVagasPagasPresenciais(int nVagasPagasPresenciais) {
		this.nVagasPagasPresenciais = nVagasPagasPresenciais;
	}




	public int getnVagasTotalPresenciais() {
		return nVagasTotalPresenciais;
	}




	public void setnVagasTotalPresenciais(int nVagasTotalPresenciais) {
		this.nVagasTotalPresenciais = nVagasTotalPresenciais;
	}




	public int getnInscricoesOnline() {
		return nInscricoesOnline;
	}




	public void setnInscricoesOnline(int nInscricoesOnline) {
		this.nInscricoesOnline = nInscricoesOnline;
	}




	public int getnVagasPagasOnline() {
		return nVagasPagasOnline;
	}




	public void setnVagasPagasOnline(int nVagasPagasOnline) {
		this.nVagasPagasOnline = nVagasPagasOnline;
	}




	public int getnVagasTotalOnline() {
		return nVagasTotalOnline;
	}




	public void setnVagasTotalOnline(int nVagasTotalOnline) {
		this.nVagasTotalOnline = nVagasTotalOnline;
	}




	public void calcularRevisoesArena() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		List<Revisaovidas> listaRevisao = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.ativo=true"
				+ " and r.rede=true and r.datafin>='" + Formatacao.ConvercaoDataNfe(new Date()) + "'");
		if (listaRevisao == null) {
			listaRevisao = new ArrayList<Revisaovidas>();
		}
		nRevisoesArena = listaRevisao.size();
		for (int i = 0; i < listaRevisao.size(); i++) {
			nPreenchidasArena = nPreenchidasArena + listaRevisao.get(i).getNpreenchido();
			nVagasArena = nVagasArena + listaRevisao.get(i).getVagas();
		}
	}
	
	
	public void calcularRevisoesAdultos() {
		RevisaoVidasFacade revisaoVidasFacade = new RevisaoVidasFacade();
		List<Revisaovidas> listaRevisao = revisaoVidasFacade.listar("Select r From Revisaovidas r Where r.ativo=true"
				+ " and r.rede=false and r.datafin>='" + Formatacao.ConvercaoDataNfe(new Date()) + "'");
		if (listaRevisao == null) {
			listaRevisao = new ArrayList<Revisaovidas>();
		}
		nRevisoesAdulto = listaRevisao.size();
		for (int i = 0; i < listaRevisao.size(); i++) {
			nPreenchidasAdulto = nPreenchidasAdulto + listaRevisao.get(i).getNpreenchido();
			nVagasAdulto = nVagasAdulto + listaRevisao.get(i).getVagas();
		}
	}
	
	public void calcularValoresPagos() {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		List<Fichainscricaorv> listaRevisionistas = fichaInscricaoRvFacade.listar("Select f From Fichainscricaorv f "
				+ "WHERE f.pagou='thumbs-up' and f.revisaovidas.ativo=true  and f.revisaovidas.datafin>='" + Formatacao.ConvercaoDataNfe(new Date()) + "'");
		if (listaRevisionistas == null) {
			listaRevisionistas = new ArrayList<Fichainscricaorv>();
		}
		valorPAgo = listaRevisionistas.size() * 50f;
	}
	 
	public void calcularValoresNaoPagos() {
		FichaInscricaoRvFacade fichaInscricaoRvFacade = new FichaInscricaoRvFacade();
		List<Fichainscricaorv> listaRevisionistas = fichaInscricaoRvFacade.listar("Select f From Fichainscricaorv f "
				+ "WHERE f.pagou='thumbs-down' and f.revisaovidas.ativo=true  and f.revisaovidas.datafin>='" + Formatacao.ConvercaoDataNfe(new Date()) + "'");
		if (listaRevisionistas == null) {
			listaRevisionistas = new ArrayList<Fichainscricaorv>();
		}
		valorNaoPago = listaRevisionistas.size() * 50f; 
	}
	
	
	public void calcularInscricoesEnviadas() {
		MembrosEventoFacade membrosEventoFacade = new MembrosEventoFacade();
		List<Membrosevento> listaMembros = membrosEventoFacade.listar("Select m From Membrosevento m WHERE m.evento.conference=true");
		if (listaMembros == null) {
			listaMembros = new ArrayList<Membrosevento>();
		}
		nInscricoesOnline = 0;
		nInscricoesPresenciais = 0;
		nVagasTotalPresenciais = 0;
		for (int i = 0; i < listaMembros.size(); i++) {
			if (listaMembros.get(i).getPresenca().equalsIgnoreCase("Presencial")) {
				nInscricoesPresenciais = nInscricoesPresenciais + 1;
				if (listaMembros.get(i).getPagou().equalsIgnoreCase("thumbs-up")) {
					nVagasPagasPresenciais = nVagasPagasPresenciais + 1;
				}
				if (nVagasTotalPresenciais <= 0) {
					nVagasTotalPresenciais = listaMembros.get(i).getEvento().getVagaspresencial();
				}
			}else {
				nInscricoesOnline = nInscricoesOnline + 1;
				if (listaMembros.get(i).getPagou().equalsIgnoreCase("thumbs-up")) {
					nVagasPagasOnline = nVagasPagasOnline + 1;
				}
			}
		}
	}
	
	
	
	
	
	
}
