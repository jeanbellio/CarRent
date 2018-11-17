package br.com.carrent.model;

public enum ParametrosGerais {
	TAXA_A(1.3, "Taxa A"),
	TAXA_B(1.2, "Taxa B"),
	TAXA_C(1.1, "Taxa C"),
	TAXA_FIXA(100, "Taxa fixa");
	
	private double valor;
	private String nome;
	
	private ParametrosGerais(double valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}
	
	public static double findValorByNome(String nome) {
		for (ParametrosGerais parametro : values()) {
			if(parametro.name().equals(nome)) {
				return parametro.getValor();
			}
		}
		return 0;
	}
	
}
