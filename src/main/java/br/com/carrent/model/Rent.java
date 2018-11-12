package br.com.carrent.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.ComponentScan;

@Entity
@ComponentScan("com.carrent.model")
public class Rent {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Car carro;
	private double valorFinal;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;

	@OneToOne
	private Tax taxa;

	public Rent() {
		super();
	}

	public Rent(Long id, Car carro, double valorFinal, Tax taxa) {
		super();
		this.id = id;
		this.carro = carro;
		this.valorFinal = valorFinal;
		this.taxa = taxa;
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

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Tax getTaxa() {
		return taxa;
	}

	public void setTaxa(Tax taxa) {
		this.taxa = taxa;
	}

}
