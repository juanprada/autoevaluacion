package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Caracteristica;
import co.com.poli.autoevaluacion.repositories.CaracteristicasRepository;

@Service
public class CaracteristicaService {

	@Autowired
	private CaracteristicasRepository caracteristicasRepository;
	
	public void guardarCaracteristica(Caracteristica caracteristica){
		caracteristicasRepository.save(caracteristica);
	}
	
	public List<Caracteristica> listarCaracteristicas(){
		return caracteristicasRepository.findAllByOrderByCaracteristicaID();
	}
	
	public void eliminarCaracteristica(Long caracteristicaID){
		caracteristicasRepository.delete(caracteristicaID);
	}
}
