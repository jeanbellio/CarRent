package br.com.carrent.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.carrent.model.Car;
import br.com.carrent.model.Rent;
import br.com.carrent.repository.CarRepository;
import br.com.carrent.repository.RentRepository;

public class RentServiceTest {
	private RentService rentService;
	@Mock RentRepository rentRepositoryMock;
	@Mock CarRepository carRepositoryMock;
	
	@Before
	public void setup() {
		this.rentService = new RentService();
		this.rentRepositoryMock = mock(RentRepository.class);
		this.carRepositoryMock = mock(CarRepository.class);
		this.rentService.setRentRepository(rentRepositoryMock);
		this.rentService.setCarRepository(carRepositoryMock);
	}
	@Test
	public void test() {
		when(carRepositoryMock.save(any(Car.class))).thenReturn(new Car());
		when(carRepositoryMock.findFirstByPlaca(anyString())).thenReturn(new Car());
		
	}
	
	@Test
	public void testCalculoAluguelPorClasseComClasseAPor10Dias() {
		Car carTest = new Car();
		carTest.setClasse("A");
		Rent rentTeste = new Rent(carTest, LocalDate.of(2018, Month.APRIL, 30), LocalDate.of(2018, Month.APRIL, 20)); //10 dias
		Rent rentComValorFinalCalculado = new Rent();
		rentComValorFinalCalculado.setValorFinal(1300);
		
		assertEquals(rentService.calculaAluguelPorClasse(rentTeste).getValorFinal(), rentComValorFinalCalculado.getValorFinal(), 0.001);
	}
	
	@Test
	public void testCalculoAluguelPorClasseComClasseBPor10Dias() {
		Car carTest = new Car();
		carTest.setClasse("B");
		Rent rentTeste = new Rent(carTest, LocalDate.of(2018, Month.APRIL, 30), LocalDate.of(2018, Month.APRIL, 20)); //10 dias
		Rent rentComValorFinalCalculado = new Rent();
		rentComValorFinalCalculado.setValorFinal(1200);
		
		assertEquals(rentService.calculaAluguelPorClasse(rentTeste).getValorFinal(), rentComValorFinalCalculado.getValorFinal(), 0.001);
	}
	
	@Test
	public void testCalculoAluguelPorClasseComClasseCPor10Dias() {
		Car carTest = new Car();
		carTest.setClasse("C");
		Rent rentTeste = new Rent(carTest, LocalDate.of(2018, Month.APRIL, 30), LocalDate.of(2018, Month.APRIL, 20)); //10 dias
		Rent rentComValorFinalCalculado = new Rent();
		rentComValorFinalCalculado.setValorFinal(1100);
		
		assertEquals(rentService.calculaAluguelPorClasse(rentTeste).getValorFinal(), rentComValorFinalCalculado.getValorFinal(), 0.001);
	}
	
	@Test
	public void testAtualizaDisponibilidadeCarroComDataSaida() {
		Car carTest = new Car();
		when(carRepositoryMock.findFirstByPlaca(anyString())).thenReturn(carTest);
		when(carRepositoryMock.save(any(Car.class))).thenReturn(new Car());
		Rent rentTest = new Rent(carTest, LocalDate.of(2018, Month.APRIL, 30), LocalDate.of(2018, Month.APRIL, 20));
		rentService.atualizaDisponobilidadeCarro(rentTest);
		assertTrue(carTest.isDisponivel());
	}
	
	@Test
	public void testAtualizaDisponibilidadeCarroSemDataSaida() {
		Car carTest = new Car();
		when(carRepositoryMock.findFirstByPlaca(anyString())).thenReturn(carTest);
		Rent rentTest = new Rent(carTest, LocalDate.of(2018, Month.APRIL, 30), null);
		rentService.atualizaDisponobilidadeCarro(rentTest);
		assertFalse(carTest.isDisponivel());
	}
	
}
