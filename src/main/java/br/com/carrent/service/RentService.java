package br.com.carrent.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carrent.model.Car;
import br.com.carrent.model.ParametrosGerais;
import br.com.carrent.model.Rent;
import br.com.carrent.repository.CarRepository;
import br.com.carrent.repository.RentRepository;

@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;
	@Autowired
	private CarRepository carRepository;

	public String create(Rent rent) {
		if(rent.getCarro() == null) {
			return "Nenhum carro foi localizado";
		}
		
		calculaAluguelPorClasse(rent);
		atualizaCarro(rent);
		rentRepository.save(rent);
		return "Aluguel salvo com sucesso.";
	}

	private void atualizaCarro(Rent rent) {
		Car car = carRepository.findFirstByPlaca(rent.getCarro().getPlaca());
		if(rent.getDataSaida() == null) {
			car.setDisponivel(false);
		} else {
			car.setDisponivel(true);
		}
		carRepository.save(car);
	}

	private Rent calculaAluguelPorClasse(Rent rent) {
		long daysBetween = ChronoUnit.DAYS.between(rent.getDataSaida(), rent.getDataEntrada());
		double valorTaxa = 1;
		
		if(rent.getCarro().getClasse().equals("A")) {
			valorTaxa = ParametrosGerais.findValorByNome("TAXA_A");
		} else if (rent.getCarro().getClasse().equals("B")) {
			valorTaxa = ParametrosGerais.findValorByNome("TAXA_B");
		} else if (rent.getCarro().getClasse().equals("C")) {
			valorTaxa = ParametrosGerais.findValorByNome("TAXA_C");
		}
		
		rent.setValorFinal((ParametrosGerais.findValorByNome("TAXA_FIXA") * daysBetween) * valorTaxa);
		return rent;
	}
	
	public List<Rent> findAll() {
		return rentRepository.findAll();
	}

	public Rent findById(Long id) {
		return rentRepository.findOne(id);
	}


}
