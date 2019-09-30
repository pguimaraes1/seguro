package br.com.ebix.seguro.entity;

public enum DiasVisita {
	SEG("Segunda"), TER("Terça"), QUA("Quarta"), QUI("Quinta"), SEX("Sexta");

	private String value;

	private DiasVisita(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
