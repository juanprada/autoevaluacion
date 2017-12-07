package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Profesor;
import co.com.poli.autoevaluacion.repositories.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorRepository profesorRepository;
	
	public void guardarProfesor(Profesor profesor){
		profesorRepository.save(profesor);
	}
	
	public List<Profesor> listarProfesores(Long programaID){
		return profesorRepository.findAllByProgramaProgramasIDOrderByProfesorID(programaID);
	}
	
	public void eliminarProfesor(Long profesorID){
		profesorRepository.delete(profesorID);
	}
}
