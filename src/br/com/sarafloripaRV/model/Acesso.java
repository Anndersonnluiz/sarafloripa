package br.com.sarafloripaRV.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name =  "acesso")
public class Acesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacesso")
    private Integer idacesso;
	@Column(name = "cadusuario")
    private boolean cadusuario;
	@Column(name = "cadrevisao")
    private boolean cadrevisao;
	@Column(name = "exrevisionista")
    private boolean exrevisionista;
	@Column(name = "cadastro")
    private boolean cadastro;
	@Column(name = "cadacesso")
    private boolean cadacesso;
	
	
	public Acesso() {
	
	}


	public Integer getIdacesso() {
		return idacesso;
	}


	public void setIdacesso(Integer idacesso) {
		this.idacesso = idacesso;
	}


	public boolean isCadusuario() {
		return cadusuario;
	}


	public void setCadusuario(boolean cadusuario) {
		this.cadusuario = cadusuario;
	}


	public boolean isCadrevisao() {
		return cadrevisao;
	}


	public void setCadrevisao(boolean cadrevisao) {
		this.cadrevisao = cadrevisao;
	}


	public boolean isExrevisionista() {
		return exrevisionista;
	}


	public void setExrevisionista(boolean exrevisionista) {
		this.exrevisionista = exrevisionista;
	}


	public boolean isCadastro() {
		return cadastro;
	}


	public void setCadastro(boolean cadastro) {
		this.cadastro = cadastro;
	}


	public boolean isCadacesso() {
		return cadacesso;
	}


	public void setCadacesso(boolean cadacesso) {
		this.cadacesso = cadacesso;
	}
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idacesso != null ? idacesso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Acesso)) {
			return false;
		}
		Acesso other = (Acesso) object;
		if ((this.idacesso == null && other.idacesso != null)
				|| (this.idacesso != null && !this.idacesso.equals(other.idacesso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Acesso[ idacesso=" + idacesso + " ]";
	}

	
	
	

}
