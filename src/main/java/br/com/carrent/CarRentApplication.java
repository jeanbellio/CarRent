package br.com.carrent;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.carrent.model.Car;
import br.com.carrent.model.Rent;
import br.com.carrent.repository.CarRepository;
import br.com.carrent.service.RentService;

@SpringBootApplication
public class CarRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			List<Car> carros = new ArrayList<Car>();
			carros.add(new Car("AAA-2341", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("TRG-1010", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("GRE-0300", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("DFB-0010", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("UOK-6543", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("JYT-8746", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("NHH-2466", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("DFG-9987", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("QER-1234", "Mustang", "Ford", "A", 2018, true));
			carros.add(new Car("WQE-9698", "Mustang", "Ford", "A", 2018, true));
			repository.save(carros);
			repository.findAll().forEach(System.out::println);
		};
	};
}
