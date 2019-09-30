package br.com.ebix.seguro.entity;

public enum TipoSegurado {

	CORRENTISTA("Sim"), NAOCORRENTISTA("Não");

	private String value;

	TipoSegurado(String value) {
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
