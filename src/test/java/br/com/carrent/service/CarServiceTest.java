package br.com.carrent.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.carrent.model.Car;
import br.com.carrent.repository.CarRepository;

public class CarServiceTest {
	private CarService carService;
	private Car carroTeste;
	@Mock
    CarRepository carRepositoryMock;
	
	@Before
	public void setup() {
		this.carService = new CarService();
		this.carroTeste = new Car("AAA-0000");
		carRepositoryMock = mock(CarRepository.class);
		carService.setCarRepository(carRepositoryMock);
		when(carRepositoryMock.save(any(Car.class))).thenReturn(new Car());
	}

	@Test
	public void testCarroClasseAComTresAnos() {
		carroTeste.setAno(2015);
		carroTeste.setClasse("A");
		assertEquals("Carro inserido com sucesso", this.carService.verificaAno(carroTeste, 2018));
	}
	
	@Test
	public void testCarroClasseAComMenosDeTresAnos() {
		carroTeste.setAno(2016);
		carroTeste.setClasse("A");
		assertEquals("Carro inserido com sucesso", this.carService.verificaAno(carroTeste, 2018));
	}
	
	@Test
	public void testCarroClasseAComMaisDeTresAnos() {
		carroTeste.setAno(2013);
		carroTeste.setClasse("A");
		assertEquals("Carro não corresponde aos requisitos mínimos", this.carService.verificaAno(carroTeste, 2018));
	}


}
