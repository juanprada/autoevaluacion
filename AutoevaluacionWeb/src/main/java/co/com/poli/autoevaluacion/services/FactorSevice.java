package co.com.poli.autoevaluacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Factor;
import co.com.poli.autoevaluacion.repositories.FactoresRepository;

@Service
public class FactorSevice {

	@Autowired
	private FactoresRepository factoresRepository;
	
	public void guardarFactor(Factor factor){
		factoresRepository.save(factor);
	}
	
	public List<Factor> listarFactores(){
		return factoresRepository.findAllByOrderByFactorID();
	}
	
	public void eliminarFactor(Long factorID){
		factoresRepository.delete(factorID);
	}
}
