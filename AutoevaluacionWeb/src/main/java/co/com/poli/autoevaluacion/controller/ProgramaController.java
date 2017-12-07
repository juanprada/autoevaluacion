package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Programa;
import co.com.poli.autoevaluacion.services.ProgramaService;

@RestController
@RequestMapping("programas")
public class ProgramaController {

	@Autowired
	private ProgramaService programaService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarPrograma(@RequestBody Programa programa){
		programaService.guardarPrograma(programa);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar")
	public List<Programa> listarProgramas(){
		return programaService.listarProgramas();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarPrograma(@RequestBody Programa programa){
		programaService.guardarPrograma(programa);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{programaID}")
	public void eliminarPrograma(@PathVariable(name="programaID") Long programaID){
		programaService.eliminarPrograma(programaID);
	}
}
