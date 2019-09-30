package br.com.ebix.seguro.entity;

public enum TipoSexo {
	MASC("Masculino"), FEM("Feminino");

	private String value;

	TipoSexo(String value) {
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
