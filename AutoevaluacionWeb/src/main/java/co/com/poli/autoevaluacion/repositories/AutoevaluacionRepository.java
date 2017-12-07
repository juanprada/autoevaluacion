package co.com.poli.autoevaluacion.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Autoevaluacion;

public interface AutoevaluacionRepository extends CrudRepository<Autoevaluacion, Long>{

	Autoevaluacion findOneByPeriodoAndProgramaProgramasID(String periodo, Long programaID);
}
