package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Indicador;
import co.com.poli.autoevaluacion.repositories.IndicadoresRepository;

@Service
public class IndicadorService {

	@Autowired
	private IndicadoresRepository indicadoresRepository;
	
	public void guardarIndicador(Indicador indicador){
		indicadoresRepository.save(indicador);
	}
	
	public List<Indicador> listarIndicadores(){
		return indicadoresRepository.findAllByOrderByIndicadorID();
	}
	
	public void eliminarIndicador(Long indicadorID){
		indicadoresRepository.delete(indicadorID);
	}
	
}
