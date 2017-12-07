package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Programa;
import co.com.poli.autoevaluacion.repositories.ProgramasRepository;

@Service
public class ProgramaService {

	@Autowired
	private ProgramasRepository programasRepository;
	
	public void guardarPrograma(Programa programa){
		programasRepository.save(programa);
	}
	
	public List<Programa> listarProgramas(){
		return programasRepository.findAllByOrderByProgramasID();
	}
	
	public void eliminarPrograma(Long programaID){
		programasRepository.delete(programaID);
	}
}
