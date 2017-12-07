package co.com.poli.autoevaluacion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Autoevaluacion;
import co.com.poli.autoevaluacion.domain.AutoevaluacionDetalle;
import co.com.poli.autoevaluacion.domain.Indicador;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionDetalleRepository;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionRepository;

@Service
public class AutoevaluacionService {

	@Autowired
	private AutoevaluacionRepository autoevaluacionRepository;
	
	@Autowired
	private AutoevaluacionDetalleRepository autoevaluacionDetalleRepository;
	
	@Autowired
	private IndicadorService indicadorService;
	
	public void guardarAutoevaluacion(Autoevaluacion autoevaluacion){
		autoevaluacionRepository.save(autoevaluacion);
	}
	
	public void guardarDetalleAutoevaluacion(List<AutoevaluacionDetalle> autoevaluacionDetalleList){
		autoevaluacionDetalleRepository.save(autoevaluacionDetalleList);
	}

	public Autoevaluacion buscarAutoevaluacion(Autoevaluacion autoevaluacion) {
		return autoevaluacionRepository.findOneByPeriodoAndProgramaProgramasID(autoevaluacion.getPeriodo(), autoevaluacion.getPrograma().getProgramasID());
	}
	
	public Autoevaluacion buscarAutoevaluacion(Long autoevaluacionID) {
		return autoevaluacionRepository.findOne(autoevaluacionID);
	}

	public List<AutoevaluacionDetalle> buscarAutoevaluacionDetalle(Long autoevaluacionID) {
		crearDetalle(autoevaluacionID);
		return autoevaluacionDetalleRepository.findByAutoevaluacionAutoevaluacionID(autoevaluacionID);
	}
	
	private void crearDetalle(Long autoevaluacionId){
		List<Indicador> indicadores = indicadorService.listarIndicadores();
		Autoevaluacion autoevaluacion = autoevaluacionRepository.findOne(autoevaluacionId);
		List<AutoevaluacionDetalle> detallesAutoevaluacion = indicadores.stream().filter(i -> noExisteIndicadorEnEvaluacion(i, autoevaluacion)).map(i->crearDetalleAutoevaluacion(i, autoevaluacion)).collect(Collectors.toList());
		autoevaluacionDetalleRepository.save(detallesAutoevaluacion);
	}
	
	private boolean noExisteIndicadorEnEvaluacion(Indicador indicador, Autoevaluacion autoevaluacion) {
		AutoevaluacionDetalle autoevaluacionDetalle = autoevaluacionDetalleRepository.findOneByIndicadorIndicadorIDAndAutoevaluacionAutoevaluacionID(indicador.getIndicadorID(), autoevaluacion.getAutoevaluacionID());
		return autoevaluacionDetalle == null;
	}
	
	private AutoevaluacionDetalle crearDetalleAutoevaluacion(Indicador indicador, Autoevaluacion autoevaluacion){
		AutoevaluacionDetalle autoevaluacionDetalle = new AutoevaluacionDetalle();
		autoevaluacionDetalle.setAutoevaluacion(autoevaluacion);
		autoevaluacionDetalle.setCalificacion(null);
		autoevaluacionDetalle.setIndicador(indicador);
		return autoevaluacionDetalle;
	}

	public List<AutoevaluacionDetalle> buscarIndicadorAutoevaluacion(Long indicadorID) {
		return autoevaluacionDetalleRepository.findByIndicadorIndicadorID(indicadorID);
	}
}
