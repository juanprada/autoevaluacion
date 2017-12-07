package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Caracteristica;
import co.com.poli.autoevaluacion.services.CaracteristicaService;

@RestController
@RequestMapping("caracteristicas")
public class CaracteristicaController {
	
	@Autowired
	private CaracteristicaService caracteristicaService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarCaracteristica(@RequestBody Caracteristica caracteristica){
		caracteristicaService.guardarCaracteristica(caracteristica);
	}

	@RequestMapping(method=RequestMethod.GET, value="listar")
	public List<Caracteristica> listarCaracteristicas(){
		return caracteristicaService.listarCaracteristicas();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarCaracteristica(@RequestBody Caracteristica caracteristica){
		caracteristicaService.guardarCaracteristica(caracteristica);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{caracteristicaID}")
	public void eliminarCaracteristica(@PathVariable(name="caracteristicaID") Long caracteristicaID){
		caracteristicaService.eliminarCaracteristica(caracteristicaID);
	}
}
