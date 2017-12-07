package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Factor;
import co.com.poli.autoevaluacion.services.FactorSevice;

@RestController
@RequestMapping("factores")
public class FactorController {

	@Autowired
	private FactorSevice factorService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarFactor(@RequestBody Factor factor){
		factorService.guardarFactor(factor);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar")
	public List<Factor> listarFactores(){
		return factorService.listarFactores();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarFactor(@RequestBody Factor factor){
		factorService.guardarFactor(factor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{factorID}")
	public void eliminarFactor(@PathVariable(name="factorID") Long factorID){
		factorService.eliminarFactor(factorID);
	}
}
