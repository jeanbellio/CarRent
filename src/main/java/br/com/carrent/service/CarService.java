package br.com.carrent.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carrent.model.Car;
import br.com.carrent.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

	public Car findByPlaca(String placa) {
		return carRepository.findFirstByPlaca(placa);
	}

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Car findById(Long id) {
		return carRepository.findOne(id);
	}

	public List<Car> findByModelo(String modelo) {
		return carRepository.findByModelo(modelo);
	}

	
	public String create(Car car) {
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		if(carRepository.findFirstByPlaca(car.getPlaca()) == null) {
			return verificaAno(car, anoAtual);
		} else {
			return "Já existe um carro com a placa informada!";
		}
	}

	private String verificaAno(Car car, int anoAtual) {
		String menssagem = "Carro inserido com sucesso";
		switch (car.getClasse()) {
		case "A":
			if (anoAtual - car.getAno() < 3) {
				carRepository.save(car);
			}
			break;
		case "B":
			if (anoAtual - car.getAno() < 5) {
				carRepository.save(car);
			}
			break;
		case "C":
			if (anoAtual - car.getAno() < 7) {
				carRepository.save(car);
			}
			break;

		default:
			menssagem = "Carro não corresponde aos requisitos mínimos";
			break;
		}
		return menssagem;
	}

	public Car update(Car car) {
		return carRepository.save(car);
	}

	public void delete(String placa) {
		Car car = carRepository.findFirstByPlaca(placa);
		carRepository.deleteByPlaca(car);
	}

	public List<Car> findAllByDisponivelTrue() {
		return carRepository.findAllByDisponivelTrue();
	}

}
