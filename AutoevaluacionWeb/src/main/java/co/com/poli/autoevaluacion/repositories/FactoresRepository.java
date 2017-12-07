package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Factor;

public interface FactoresRepository extends CrudRepository<Factor, Long>{

	List<Factor> findAllByOrderByFactorID();
}
