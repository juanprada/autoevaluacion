package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Estudiante;
import co.com.poli.autoevaluacion.repositories.EstudiantesRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudiantesRepository estudiantesRepository;
	
	public void guardarEstudiante(Estudiante estudiante){
		estudiantesRepository.save(estudiante);
	}
	
	public List<Estudiante> listarEstudiantes(Long programaID){
		return estudiantesRepository.findAllByProgramaProgramasIDOrderByEstudianteID(programaID);
	}
	
	public void eliminarEstudiante(Long estudianteID){
		estudiantesRepository.delete(estudianteID);
	}
	
}
