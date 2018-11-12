package br.com.carrent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrent.model.Car;
import br.com.carrent.response.Response;
import br.com.carrent.service.CarService;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin(origins = "*")
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/{placa}")
	public ResponseEntity<Response<Car>> findByPlaca(@PathVariable(name = "placa") String placa) {
		return ResponseEntity.ok(new Response<Car>(this.carService.findByPlaca(placa)));
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Car>>> findAll(){
		return ResponseEntity.ok(new Response<List<Car>>(this.carService.findAll()));
	}
	
	@GetMapping(path = "/modelo/{modelo}")
	public ResponseEntity<Response<List<Car>>> findByName(@PathVariable("modelo") String modelo) {
		return ResponseEntity.ok(new Response<List<Car>>(this.carService.findByModelo(modelo)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Car>> create(@Valid @RequestBody Car car, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Car>(erros));
		}
		
		return ResponseEntity.ok(new Response<Car>(this.carService.create(car)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Car>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Car car, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Car>(erros));
		}
		
		car.setPlaca(id);
		return ResponseEntity.ok(new Response<Car>(this.carService.update(car)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String placa) {
		this.carService.delete(placa);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	

}
