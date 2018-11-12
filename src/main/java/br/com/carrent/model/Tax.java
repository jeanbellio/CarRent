package br.com.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tax {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nomeTaxa;

	private double valorBase;

	public Tax() {
		super();
	}

	public Tax(Long id, String nomeTaxa, double valorBase) {
		super();
		this.id = id;
		this.nomeTaxa = nomeTaxa;
		this.valorBase = valorBase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}

	public String getNomeTaxa() {
		return nomeTaxa;
	}

	public void setNomeTaxa(String nomeTaxa) {
		this.nomeTaxa = nomeTaxa;
	}
	

}
