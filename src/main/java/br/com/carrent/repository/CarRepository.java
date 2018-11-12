package br.com.carrent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrent.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

	Car findByPlaca(String placa);

	List<Car> findByModelo(String modelo);

}
