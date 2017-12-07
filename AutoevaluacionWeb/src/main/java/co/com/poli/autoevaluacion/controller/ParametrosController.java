package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Parametros;
import co.com.poli.autoevaluacion.services.ParametrosServices;

@RestController
@RequestMapping("parametros")
public class ParametrosController {

	@Autowired
	private ParametrosServices parametrosServices;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarParametro(@RequestBody Parametros parametro){
		parametrosServices.guardarParametro(parametro);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar")
	public List<Parametros> listarParametros(){
		return parametrosServices.listarParametros();
	}
}
