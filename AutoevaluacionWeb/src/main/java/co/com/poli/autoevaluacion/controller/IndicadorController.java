package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Indicador;
import co.com.poli.autoevaluacion.services.IndicadorService;

@RestController
@RequestMapping("indicadores")
public class IndicadorController {

	@Autowired
	private IndicadorService indicadorService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarIndicador(@RequestBody Indicador indicador){
		indicadorService.guardarIndicador(indicador);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar")
	public List<Indicador> listarIndicadores(){
		return indicadorService.listarIndicadores();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarIndicador(@RequestBody Indicador indicador){
		indicadorService.guardarIndicador(indicador);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{indicadorID}")
	public void eliminarIndicador(@PathVariable(name="indicadorID") Long indicadorID){
		indicadorService.eliminarIndicador(indicadorID);
	}
}
