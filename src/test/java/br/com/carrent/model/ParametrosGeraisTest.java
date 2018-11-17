package br.com.carrent.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParametrosGeraisTest {

	@Test
	public void testFindValorByNomeParaTaxaA() {
		double valor = ParametrosGerais.findValorByNome("TAXA_A");
		assertEquals(1.3, valor, 0.1);
	}
	
	@Test
	public void testFindValorByNomeParaTaxaB() {
		double valor = ParametrosGerais.findValorByNome("TAXA_B");
		assertEquals(1.2, valor, 0.1);
	}
	
	@Test
	public void testFindValorByNomeParaTaxaC() {
		double valor = ParametrosGerais.findValorByNome("TAXA_C");
		assertEquals(1.1, valor, 0.1);
	}
	
	@Test
	public void testFindValorByNomeParaTaxaFixa() {
		double valor = ParametrosGerais.findValorByNome("TAXA_FIXA");
		assertEquals(100, valor, 0.1);
	}
	
	@Test
	public void testFindValorByNomeParaValorInexistente() {
		double valor = ParametrosGerais.findValorByNome("TESTE");
		assertEquals(0, valor, 0.1);
	}

}
