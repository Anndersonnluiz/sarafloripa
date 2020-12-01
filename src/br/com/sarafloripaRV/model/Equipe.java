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
@Table(name = "equipe")
public class Equipe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipe")
    private Integer idequipe;
    @Column(name = "nome")
    private String nome;
	@Column(name = "rede")
	private boolean rede;
	
	
	public Equipe() {
	
	}


	public Integer getIdequipe() {
		return idequipe;
	}


	public void setIdequipe(Integer idequipe) {
		this.idequipe = idequipe;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean isRede() {
		return rede;
	}


	public void setRede(boolean rede) {
		this.rede = rede;
	}
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idequipe != null ? idequipe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Equipe)) {
			return false;
		}
		Equipe other = (Equipe) object;
		if ((this.idequipe == null && other.idequipe != null)
				|| (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Equipe[ idequipe=" + idequipe + " ]";
	}

}
