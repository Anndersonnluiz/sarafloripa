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
@Table(name = "tipoacesso")
public class Tipoacesso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoacesso")
    private Integer idtipoacesso;
    @Column(name = "descricao")
    private String descricao;
	@JoinColumn(name = "acesso_idacesso", referencedColumnName = "idacesso")
	@ManyToOne(optional = false)
	private Acesso acesso;
	
	
	public Tipoacesso() {
	}


	public Integer getIdtipoacesso() {
		return idtipoacesso;
	}


	public void setIdtipoacesso(Integer idtipoacesso) {
		this.idtipoacesso = idtipoacesso;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Acesso getAcesso() {
		return acesso;
	}


	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtipoacesso != null ? idtipoacesso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Tipoacesso)) {
			return false;
		}
		Tipoacesso other = (Tipoacesso) object;
		if ((this.idtipoacesso == null && other.idtipoacesso != null)
				|| (this.idtipoacesso != null && !this.idtipoacesso.equals(other.idtipoacesso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Tipoacesso[ idtipoacesso=" + idtipoacesso + " ]";
	}
	
	
	
	

}
