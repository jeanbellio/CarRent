package br.com.carrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.carrent.model.Car;
import br.com.carrent.service.CarService;

@RestController
@RequestMapping("/carro")
@CrossOrigin(origins = "*")
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/cadastro")
    public ModelAndView listarEstoque() {
        ModelAndView modelAndView = new ModelAndView("CadastroCarro");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }
	
	@GetMapping(path = "/{placa}")
	public ModelAndView findByPlaca(@PathVariable(name = "placa") String placa) {
		ModelAndView modelAndView = new ModelAndView("CadastroCarro");
        modelAndView.addObject("car", this.carService.findByPlaca(placa));
        return modelAndView;
	}
	
	@GetMapping(path = "/todos")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView("ListaCarro");
		modelAndView.addObject("carros", this.carService.findAll());
        return modelAndView;
	}
	
	@PostMapping(value = "/add")
    public ModelAndView create(Car car) {
		String menssagem = this.carService.create(car);
		ModelAndView modelAndView = new ModelAndView("CadastroCarro");
		modelAndView.addObject("message", menssagem);
		return modelAndView;
	}
	
}
