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
@Table(name = "revisaovidas")
public class Revisaovidas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrevisaovidas")
    private Integer idrevisaovidas;
    @Column(name = "vagas")
    private int vagas;
	@Column(name = "ativo")
	private boolean ativo;
	@Column(name = "rede")
	private boolean rede;
    @Column(name = "npreenchido")
    private int npreenchido;
    @Column(name = "valorrevisao")
    private float valorrevisao;
	@Column(name = "dataini")
	@Temporal(TemporalType.DATE)
	private Date dataini;
	@Column(name = "datafin")
	@Temporal(TemporalType.DATE)
	private Date datafin;
	@JoinColumn(name = "equipe_idequipe", referencedColumnName = "idequipe")
	@ManyToOne(optional = false)
	private Equipe equipe;
	
	
	public Revisaovidas() {
		
	}


	public Integer getIdrevisaovidas() {
		return idrevisaovidas;
	}


	public void setIdrevisaovidas(Integer idrevisaovidas) {
		this.idrevisaovidas = idrevisaovidas;
	}


	public int getVagas() {
		return vagas;
	}


	public void setVagas(int vagas) {
		this.vagas = vagas;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public boolean isRede() {
		return rede;
	}


	public void setRede(boolean rede) {
		this.rede = rede;
	}


	public Date getDataini() {
		return dataini;
	}


	public void setDataini(Date dataini) {
		this.dataini = dataini;
	}


	public Date getDatafin() {
		return datafin;
	}


	public void setDatafin(Date datafin) {
		this.datafin = datafin;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	public int getNpreenchido() {
		return npreenchido;
	}


	public void setNpreenchido(int npreenchido) {
		this.npreenchido = npreenchido;
	}


	public float getValorrevisao() {
		return valorrevisao;
	}


	public void setValorrevisao(float valorrevisao) {
		this.valorrevisao = valorrevisao;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idrevisaovidas != null ? idrevisaovidas.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//
		if (!(object instanceof Revisaovidas)) {
			return false;
		}
		Revisaovidas other = (Revisaovidas) object;
		if ((this.idrevisaovidas == null && other.idrevisaovidas != null)
				|| (this.idrevisaovidas != null && !this.idrevisaovidas.equals(other.idrevisaovidas))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sarafloripaRV.model.Revisaovidas[ idrevisaovidas=" + idrevisaovidas + " ]";
	}

}
