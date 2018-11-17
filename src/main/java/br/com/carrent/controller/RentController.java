package br.com.carrent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.carrent.model.Car;
import br.com.carrent.model.Rent;
import br.com.carrent.service.CarService;
import br.com.carrent.service.RentService;

@RestController
@RequestMapping("/aluguel")
@CrossOrigin(origins = "*")
public class RentController {
	@Autowired
	private RentService rentService;
	@Autowired
	private CarService carService;
	
	@GetMapping(path = "/cadastro")
    public ModelAndView listarEstoque() {
        ModelAndView modelAndView = new ModelAndView("CadastroAluguel");
        modelAndView.addObject("rent", new Rent());
        modelAndView.addObject("cars", carService.findAllByDisponivelTrue());
        return modelAndView;
    }
	
	@GetMapping(path = "/{id}")
	public ModelAndView findById(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("CadastroAluguel");
		Rent rent = this.rentService.findById(id);
        modelAndView.addObject("rent", this.rentService.findById(id));
        List<Car> allDisponivel = carService.findAllByDisponivelTrue();
        allDisponivel.add(rent.getCarro());
        modelAndView.addObject("cars", allDisponivel);
        return modelAndView;
	}
	
	@GetMapping(path = "/todos")
	public ModelAndView findAll(){
		ModelAndView modelAndView = new ModelAndView("ListaAlugueis");
		modelAndView.addObject("alugueis", this.rentService.findAll());
        return modelAndView;
	}
	
	@PostMapping(value = "/add")
    public ModelAndView create(Rent rent) {
		String menssagem = this.rentService.create(rent);
		
		ModelAndView modelAndView = new ModelAndView("CadastroAluguel");
		modelAndView.addObject("rent", rent);
		modelAndView.addObject("cars", carService.findAllByDisponivelTrue());
		modelAndView.addObject("message", menssagem);
		return modelAndView;
	}
	
}
