package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Autoevaluacion;
import co.com.poli.autoevaluacion.domain.AutoevaluacionDetalle;
import co.com.poli.autoevaluacion.services.AutoevaluacionService;

@RestController
@RequestMapping("autoevaluacion")
public class AutoevaluacionController {

	@Autowired
	private AutoevaluacionService autoevaluacionService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarAutoevaluacion(@RequestBody Autoevaluacion autoevaluacion){
		autoevaluacionService.guardarAutoevaluacion(autoevaluacion);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="guardarAutoevaluacionDetalle")
	public void guardarAutoevaluacionDetalle(@RequestBody List<AutoevaluacionDetalle> autoevaluacionDetalleList){
		autoevaluacionService.guardarDetalleAutoevaluacion(autoevaluacionDetalleList);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="buscar")
	public Autoevaluacion buscarAutoevaluacion(@RequestBody Autoevaluacion autoevaluacion){
		return autoevaluacionService.buscarAutoevaluacion(autoevaluacion);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buscar/{autoevaluacionID}")
	public Autoevaluacion buscarAutoevaluacionID(@PathVariable(name="autoevaluacionID") Long autoevaluacionID){
		return autoevaluacionService.buscarAutoevaluacion(autoevaluacionID);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buscarDetalle/{autoevaluacionID}")
	public List<AutoevaluacionDetalle> buscarAutoevaluacionDetalle(@PathVariable(name="autoevaluacionID") Long autoevaluacionID){
		return autoevaluacionService.buscarAutoevaluacionDetalle(autoevaluacionID);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="buscarIndicadorAutoevaluacion/{indicadorID}")
	public List<AutoevaluacionDetalle> buscarIndicadorAutoevaluacion(@PathVariable(name="indicadorID") Long indicadorID){
		return autoevaluacionService.buscarIndicadorAutoevaluacion(indicadorID);
	}
	
}
