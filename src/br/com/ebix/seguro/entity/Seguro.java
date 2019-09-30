
package br.com.ebix.seguro.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Seguro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_seguro")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nomeSeguro;
	@Column
	private BigDecimal valorSeguro;
	@ManyToMany(mappedBy = "seguros", fetch = FetchType.EAGER)
	private List<Segurado> segurados = new ArrayList<Segurado>();

	public Integer getId() {
		return id;
	}

	public void setIdSeguro(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public List<Segurado> getSegurados() {
		return segurados;
	}

	public void setSegurados(List<Segurado> segurados) {
		this.segurados = segurados;
	}

	public String getNomeSeguro() {
		return nomeSeguro;
	}

	public void setNomeSeguro(String nomeSeguro) {
		this.nomeSeguro = nomeSeguro;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", nomeSeguro=" + nomeSeguro + ", valorSeguro=" + valorSeguro + ", segurados="
				+ segurados + "]";
	}
	
	

}
