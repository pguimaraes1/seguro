package br.com.ebix.seguro.entity;

import java.util.List;


public class Segurado {
	
	private Long idSegurado;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String correntista;
	private String[] diasVisita;
	private List<Seguro> seguros;
	public Long getIdSegurado() {
		return idSegurado;
	}
	public void setIdSegurado(Long idSegurado) {
		this.idSegurado = idSegurado;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorrentista() {
		return correntista;
	}
	public void setCorrentista(String correntista) {
		this.correntista = correntista;
	}
	public String[] getDiasVisita() {
		return diasVisita;
	}
	public void setDiasVisita(String[] diasVisita) {
		this.diasVisita = diasVisita;
	}
	public List<Seguro> getSeguros() {
		return seguros;
	}
	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	
	
	
}
