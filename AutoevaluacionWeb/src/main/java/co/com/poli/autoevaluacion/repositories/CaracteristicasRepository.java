package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Caracteristica;

public interface CaracteristicasRepository extends CrudRepository<Caracteristica, Long>{

	List<Caracteristica> findAllByOrderByCaracteristicaID();
}
