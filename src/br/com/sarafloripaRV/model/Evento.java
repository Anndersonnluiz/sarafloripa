package br.com.sarafloripaRV.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "evento")
public class Evento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevento")
    private Integer idevento;
    @Column(name = "vagaspresencial")
    private int vagaspresencial;
    @Column(name = "vagasonline")
    private boolean vagasonline;
	@Column(name = "ativo")
	private boolean ativo;
	@Column(name = "estrutura")
	private String estrutura;
	@Column(name = "valor")
	private float valor;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datainicio")
	@Temporal(TemporalType.DATE)
	private Date datainicio;
    @Column(name = "npreenchidopresencial")
    private int npreenchidopresencial;
    @Column(name = "npreenchidoonline")
    private int npreenchidoonline;
    @Column(name = "conference")
    private boolean conference;
	@JoinColumn(name = "tipoevento_idtipoevento", referencedColumnName = "idtipoevento")
	@ManyToOne(optional = false)
	private Tipoevento tipoevento;
	
	
	
	public Evento() {
	
	}



	public Integer getIdevento() {
		return idevento;
	}



	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}



	public int getVagaspresencial() {
		return vagaspresencial;
	}



	public void setVagaspresencial(int vagaspresencial) {
		this.vagaspresencial = vagaspresencial;
	}



	public boolean isVagasonline() {
		return vagasonline;
	}



	public void setVagasonline(boolean vagasonline) {
		this.vagasonline = vagasonline;
	}



	public boolean isAtivo() {
		return ativo;
	}



	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}



	public String getEstrutura() {
		return estrutura;
	}



	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}



	public float getValor() {
		return valor;
	}



	public void setValor(float valor) {
		this.valor = valor;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public Tipoevento getTipoevento() {
		return tipoevento;
	}



	public void setTipoevento(Tipoevento tipoevento) {
		this.tipoevento = tipoevento;
	}



	public Date getDatainicio() {
		return datainicio;
	}



	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}



	public int getNpreenchidopresencial() {
		return npreenchidopresencial;
	}



	public void setNpreenchidopresencial(int npreenchidopresencial) {
		this.npreenchidopresencial = npreenchidopresencial;
	}



	public int getNpreenchidoonline() {
		return npreenchidoonline;
	}



	public void setNpreenchidoonline(int npreenchidoonline) {
		this.npreenchidoonline = npreenchidoonline;
	}



	public boolean isConference() {
		return conference;
	}



	public void setConference(boolean conference) {
		this.conference = conference;
	}



	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idevento != null ? idevento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Evento)) {
			return false;
		}
		Evento other = (Evento) object;
		if ((this.idevento == null && other.idevento != null)
				|| (this.idevento != null && !this.idevento.equals(other.idevento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Evento[ idevento=" + idevento + " ]";
	}
	
	
	

}
