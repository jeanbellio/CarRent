package br.com.carrent.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@ComponentScan("com.carrent.model")
public class Rent {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Car carro;
	private double valorFinal;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEntrada;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataSaida;

	public Rent() {
		super();
	}


	public Rent(Car carro, LocalDate dataEntrada, LocalDate dataSaida) {
		super();
		this.carro = carro;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Car getCarro() {
		return carro;
	}

	public void setCarro(Car carro) {
		this.carro = carro;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

}
