package br.com.ebix.seguro.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Segurado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "id_segurado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String rg;
	@Enumerated(EnumType.STRING)
	private TipoSexo sexo;
	@Enumerated(EnumType.STRING)
	private TipoSegurado tipoSegurado;
	@Column
	private String diasVisita;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAlteracao;

	@ManyToMany
	@JoinTable(name = "segurados_seguros", joinColumns = {
			@JoinColumn(name = "id_segurado", referencedColumnName = "id_segurado") }, inverseJoinColumns = {
					@JoinColumn(name = "id_seguro", referencedColumnName = "id_seguro") })
	private List<Seguro> seguros = new ArrayList<Seguro>();
	
	@Transient
	private DiasVisita eDiasVisita;
	@Transient
	private BigDecimal totalValue; 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public TipoSegurado getTipoSegurado() {
		return tipoSegurado;
	}

	public void setTipoSegurado(TipoSegurado tipoSegurado) {
		this.tipoSegurado = tipoSegurado;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public String getDiasVisita() {
		return diasVisita;
	}

	public void setDiasVisita(String diasVisita) {
		this.diasVisita = diasVisita;
	}

	public DiasVisita geteDiasVisita() {
		return eDiasVisita;
	}

	public void seteDiasVisita(DiasVisita eDiasVisita) {
		this.eDiasVisita = eDiasVisita;
	}

	public BigDecimal getTotalValue() {
		BigDecimal totalValor = this.seguros.stream().map(x -> x.getValorSeguro()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		this.totalValue = totalValor;
		return this.totalValue;
	}

	public void checkSexo(String sexo) {
		if (TipoSexo.MASC.getValue().equals(sexo)) {
			this.setSexo(TipoSexo.MASC);
		} else {
			this.setSexo(TipoSexo.FEM);
		}
	}

	public void checkTipoSegurado(String tipoSegurado) {
		if (TipoSegurado.CORRENTISTA.getValue().equals(tipoSegurado)) {
			this.setTipoSegurado(TipoSegurado.CORRENTISTA);
		} else {
			this.setTipoSegurado(TipoSegurado.NAOCORRENTISTA);
		}
	}

	public String stringVec(String[] vec) {
		StringBuffer buffer = new StringBuffer();
		for (String seguro : vec) {
			buffer.append(seguro);
			buffer.append(" | ");
		}
		return buffer.toString();
	}
	
	/*
	 * public List<String> diasVisita(String[] dias){ DiasVisita[] diasv =
	 * diasVisita.values(); List<String> lista = new ArrayList<String>(); for
	 * (DiasVisita dia : diasv) { lista.add(dia.getValue().toString()); }
	 * 
	 * return lista; }
	 */

	/*
	 * public String stringVec(String[] vec) { StringBuffer buffer = new
	 * StringBuffer(); for (String seguro : vec) { buffer.append(seguro);
	 * buffer.append(" | "); } return buffer.toString(); }
	 */

	/*
	 * List<BigDecimal> valores = (List<BigDecimal>) this.seguros.stream().map(x ->
	 * x.getValorSeguro()); BigDecimal totalValor =
	 * valores.stream().reduce(BigDecimal.ZERO, BigDecimal::add); return totalValor;
	 * https://stackoverflow.com/questions/22635945/adding-up-bigdecimals-using-
	 * streams
	 */
}
