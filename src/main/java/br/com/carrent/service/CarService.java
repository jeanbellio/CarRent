package br.com.carrent.service;

import java.util.Date;
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
		return carRepository.findByPlaca(placa);
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

	
	public Car create(Car car) {
		if(car.getAno() < (new Date().getYear() - 5)) {
			return null;
		} else {
			return carRepository.save(car);
		}
	}

	public Car update(Car car) {
		return carRepository.save(car);
	}

	public void delete(String placa) {
		Car car = carRepository.findByPlaca(placa);
		carRepository.delete(car);
	}

}
