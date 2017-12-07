package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Parametros;
import co.com.poli.autoevaluacion.repositories.ParametrosRepository;

@Service
public class ParametrosServices {

	@Autowired
	private ParametrosRepository parametrosRepository;
	
	public void guardarParametro(Parametros parametros){
		parametrosRepository.save(parametros);
	}
	
	public List<Parametros> listarParametros(){
		return parametrosRepository.findAllByOrderByParametrosID();
	}
	
	public void eliminarParametro(Long parametroID){
		parametrosRepository.delete(parametroID);
	}
}
