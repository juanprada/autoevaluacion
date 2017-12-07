package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Long>{

	List<Profesor> findAllByProgramaProgramasIDOrderByProfesorID(Long programaID);
}
