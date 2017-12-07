package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Parametros;

public interface ParametrosRepository extends CrudRepository<Parametros, Long>{

	Parametros findOneByCodigo(String codigo);

	List<Parametros> findAllByOrderByParametrosID();
}
