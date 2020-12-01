package br.com.sarafloripaRV.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "membrosevento")
public class Membrosevento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmembrosevento")
    private Integer idmembrosevento;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tipopagamento")
	private String tipopagamento;
	@Column(name = "presenca")
	private String presenca;
	@Column(name = "lider")
	private String lider;
	@Column(name = "pagou")
	private String pagou;
	@Column(name = "corpagou")
	private String corpagou;
	@Column(name = "ninscricao")
	private String ninscricao;
	@JoinColumn(name = "equipe_idequipe", referencedColumnName = "idequipe")
	@ManyToOne(optional = false)
	private Equipe equipe;
	@JoinColumn(name = "evento_idevento", referencedColumnName = "idevento")
	@ManyToOne(optional = false)
	private Evento evento;
	
	
	public Membrosevento() {
	
	}


	public Integer getIdmembrosevento() {
		return idmembrosevento;
	}


	public void setIdmembrosevento(Integer idmembrosevento) {
		this.idmembrosevento = idmembrosevento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipopagamento() {
		return tipopagamento;
	}


	public void setTipopagamento(String tipopagamento) {
		this.tipopagamento = tipopagamento;
	}


	public String getPresenca() {
		return presenca;
	}


	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}


	public String getLider() {
		return lider;
	}


	public void setLider(String lider) {
		this.lider = lider;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	
	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public String getPagou() {
		return pagou;
	}


	public void setPagou(String pagou) {
		this.pagou = pagou;
	}


	public String getCorpagou() {
		return corpagou;
	}


	public void setCorpagou(String corpagou) {
		this.corpagou = corpagou;
	}


	public String getNinscricao() {
		return ninscricao;
	}


	public void setNinscricao(String ninscricao) {
		this.ninscricao = ninscricao;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idmembrosevento != null ? idmembrosevento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Membrosevento)) {
			return false;
		}
		Membrosevento other = (Membrosevento) object;
		if ((this.idmembrosevento == null && other.idmembrosevento != null)
				|| (this.idmembrosevento != null && !this.idmembrosevento.equals(other.idmembrosevento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Membrosevento[ idmembrosevento=" + idmembrosevento + " ]";
	}
	
	
	
	
	
	

}
