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
@Table(name = "fichainscricaorv")
public class Fichainscricaorv implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfichainscricaorv")
    private Integer idfichainscricaorv;
    @Column(name = "nome")
    private String nome;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "nomeamigo1")
	private String nomeamigo1;
	@Column(name = "nomeamigo2")
	private String nomeamigo2;
	@Column(name = "nomeamigo3")
	private String nomeamigo3;
	@Column(name = "telefoneamigo1")
	private String telefoneamigo1;
	@Column(name = "telefoneamigo2")
	private String telefoneamigo2;
	@Column(name = "telefoneamigo3")
	private String telefoneamigo3;
	@Column(name = "formapagamento")
	private String formapagamento;
	@Column(name = "lider")
	private String lider;
	@Column(name = "presenca")
	private boolean presenca;
	@Column(name = "descricaopresenca")
	private String descricaopresenca;
	@Column(name = "pagou")
	private String pagou;
	@Column(name = "corpagou")
	private String corpagou;
	@Column(name = "datanasc")
	@Temporal(TemporalType.DATE)
	private Date datanasc;
	@JoinColumn(name = "equipe_idequipe", referencedColumnName = "idequipe")
	@ManyToOne(optional = false)
	private Equipe equipe;
	@JoinColumn(name = "revisaovidas_idrevisaovidas", referencedColumnName = "idrevisaovidas")
	@ManyToOne(optional = false)
	private Revisaovidas revisaovidas;
	
	
	public Fichainscricaorv() {
	
	}


	public Integer getIdfichainscricaorv() {
		return idfichainscricaorv;
	}


	public void setIdfichainscricaorv(Integer idfichainscricaorv) {
		this.idfichainscricaorv = idfichainscricaorv;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getNomeamigo1() {
		return nomeamigo1;
	}


	public void setNomeamigo1(String nomeamigo1) {
		this.nomeamigo1 = nomeamigo1;
	}


	public String getNomeamigo2() {
		return nomeamigo2;
	}


	public void setNomeamigo2(String nomeamigo2) {
		this.nomeamigo2 = nomeamigo2;
	}


	public String getNomeamigo3() {
		return nomeamigo3;
	}


	public void setNomeamigo3(String nomeamigo3) {
		this.nomeamigo3 = nomeamigo3;
	}


	public String getTelefoneamigo1() {
		return telefoneamigo1;
	}


	public void setTelefoneamigo1(String telefoneamigo1) {
		this.telefoneamigo1 = telefoneamigo1;
	}


	public String getTelefoneamigo2() {
		return telefoneamigo2;
	}


	public void setTelefoneamigo2(String telefoneamigo2) {
		this.telefoneamigo2 = telefoneamigo2;
	}


	public String getTelefoneamigo3() {
		return telefoneamigo3;
	}


	public void setTelefoneamigo3(String telefoneamigo3) {
		this.telefoneamigo3 = telefoneamigo3;
	}


	public Date getDatanasc() {
		return datanasc;
	}


	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public Revisaovidas getRevisaovidas() {
		return revisaovidas;
	}


	public void setRevisaovidas(Revisaovidas revisaovidas) {
		this.revisaovidas = revisaovidas;
	}
	
	
	public String getFormapagamento() {
		return formapagamento;
	}


	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}


	public String getLider() {
		return lider;
	}


	public void setLider(String lider) {
		this.lider = lider;
	}

	


	public boolean isPresenca() {
		return presenca;
	}


	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}
	
	


	public String getDescricaopresenca() {
		return descricaopresenca;
	}


	public void setDescricaopresenca(String descricaopresenca) {
		this.descricaopresenca = descricaopresenca;
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


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idfichainscricaorv != null ? idfichainscricaorv.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Fichainscricaorv)) {
			return false;
		}
		Fichainscricaorv other = (Fichainscricaorv) object;
		if ((this.idfichainscricaorv == null && other.idfichainscricaorv != null)
				|| (this.idfichainscricaorv != null && !this.idfichainscricaorv.equals(other.idfichainscricaorv))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Fichainscricaorv[ idfichainscricaorv=" + idfichainscricaorv + " ]";
	}
}
