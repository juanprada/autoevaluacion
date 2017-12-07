package co.com.poli.autoevaluacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.domain.Profesor;
import co.com.poli.autoevaluacion.services.ProfesorService;

@RestController
@RequestMapping("profesores")
public class ProfesorController {

	@Autowired
	private ProfesorService profesorService;
	
	@RequestMapping(method=RequestMethod.POST, value="guardar")
	public void guardarProfesor(@RequestBody Profesor profesor){
		profesorService.guardarProfesor(profesor);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listar/{programaID}")
	public List<Profesor> listarProfesores(@PathVariable("programaID") Long programaID){
		return profesorService.listarProfesores(programaID);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="actualizar")
	public void actualizarProfesor(@RequestBody Profesor profesor){
		profesorService.guardarProfesor(profesor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{profesorID}")
	public void eliminarProfesor(@PathVariable(name="profesorID") Long profesorID){
		profesorService.eliminarProfesor(profesorID);
	}
}
