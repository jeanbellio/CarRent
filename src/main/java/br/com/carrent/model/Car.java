package br.com.carrent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String placa;
	private String modelo;
	private String marca;
	private String classe;
	private int ano;
	private boolean disponivel;
	
	public Car() {
		super();
		disponivel = true;
	}
	
	public Car(String placa) {
		super();
		this.placa = placa;
	}


	public Car(String placa, String modelo, String marca, String classe, int ano, boolean disponivel) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.classe = classe;
		this.ano = ano;
		this.disponivel = disponivel;
	}
	
	@Override
	public String toString() {
		return placa + " - " + modelo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
