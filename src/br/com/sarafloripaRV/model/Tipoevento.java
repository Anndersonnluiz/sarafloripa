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
@Table(name = "tipoevento")
public class Tipoevento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoevento")
	private Integer idtipoevento;
    @Column(name = "descricao")
	private String descricao;
    
    
    
    public Tipoevento() {
	
	}



	public Integer getIdtipoevento() {
		return idtipoevento;
	}



	public void setIdtipoevento(Integer idtipoevento) {
		this.idtipoevento = idtipoevento;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtipoevento != null ? idtipoevento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Tipoevento)) {
			return false;
		}
		Tipoevento other = (Tipoevento) object;
		if ((this.idtipoevento == null && other.idtipoevento != null)
				|| (this.idtipoevento != null && !this.idtipoevento.equals(other.idtipoevento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Tipoevento[ idtipoevento=" + idtipoevento + " ]";
	}
    
    

}
