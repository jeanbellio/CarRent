package br.com.carrent.service;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carrent.model.Car;
import br.com.carrent.model.Rent;
import br.com.carrent.repository.RentRepository;
import br.com.carrent.repository.TaxRepository;

@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private TaxRepository taxRepository;

	public Rent create(Rent rent) {
		Car carroAluguel = rent.getCarro();
		if(rent.getCarro() == null) {
			return null;
		}
		
		calculaAluguelPorClasse(rent);
		return rentRepository.save(rent);
	}

	private Rent calculaAluguelPorClasse(Rent rent) {
		long daysBetween = ChronoUnit.DAYS.between(rent.getDataEntrada(), rent.getDataSaida());
		double valorTaxa = 1;
		
		if(rent.getCarro().getClasse().equals("A")) {
			valorTaxa = taxRepository.findByNomeTaxa("TAXA_A");
		} else if (rent.getCarro().getClasse().equals("B")) {
			valorTaxa = taxRepository.findByNomeTaxa("TAXA_B");
		} else if (rent.getCarro().getClasse().equals("C")) {
			valorTaxa = taxRepository.findByNomeTaxa("TAXA_C");
		}
		
		rent.setValorFinal((rent.getTaxa().getValorBase() * daysBetween) * valorTaxa);
		return rent;
	}

}
