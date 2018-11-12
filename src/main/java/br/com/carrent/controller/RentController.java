package br.com.carrent.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrent.model.Rent;
import br.com.carrent.response.Response;
import br.com.carrent.service.RentService;

@RestController
@RequestMapping("/api/aluguel")
@CrossOrigin(origins = "*")
public class RentController {
	@Autowired
	private RentService rentService;

	@PostMapping
	public ResponseEntity<Response<Rent>> create(@Valid @RequestBody Rent rent, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Rent>(erros));
		}
		
		return ResponseEntity.ok(new Response<Rent>(this.rentService.create(rent)));
	}
	
}
