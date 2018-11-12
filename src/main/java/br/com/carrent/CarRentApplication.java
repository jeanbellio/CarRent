package br.com.carrent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.carrent.model.Car;
import br.com.carrent.repository.CarRepository;

@SpringBootApplication
public class CarRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			List<Car> carros = new ArrayList<Car>();
			carros.add(new Car("AAA-0000", "Mustang", "Ford", "A", 2018));
			repository.save(carros);
			repository.findAll().forEach(System.out::println);
		};
	};
}
