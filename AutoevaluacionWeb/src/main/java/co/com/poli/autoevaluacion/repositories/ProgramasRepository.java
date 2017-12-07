package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Programa;

public interface ProgramasRepository extends CrudRepository<Programa, Long>{

	List<Programa> findAllByOrderByProgramasID();

}
