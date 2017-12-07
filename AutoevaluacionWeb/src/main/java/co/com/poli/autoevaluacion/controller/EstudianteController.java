package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Estudiante;
import co.com.poli.autoevaluacion.services.EstudianteService;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarEstudiante(@RequestBody Estudiante estudiante){
		estudianteService.guardarEstudiante(estudiante);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar/{programaID}")
	public List<Estudiante> listarEstudiantes(@PathVariable("programaID") Long programaID){
		return estudianteService.listarEstudiantes(programaID);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarEstudiante(@RequestBody Estudiante estudiante){
		estudianteService.guardarEstudiante(estudiante);;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{estudianteID}")
	public void eliminarEstudiante(@PathVariable(name="estudianteID") Long estudianteID){
		estudianteService.eliminarEstudiante(estudianteID);
	}
}
