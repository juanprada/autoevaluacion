package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Indicador;

public interface IndicadoresRepository extends CrudRepository<Indicador, Long>{

	List<Indicador> findAllByOrderByIndicadorID();

}
