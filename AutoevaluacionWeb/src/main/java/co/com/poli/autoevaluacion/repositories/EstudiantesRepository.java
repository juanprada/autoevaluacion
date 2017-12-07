package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.Estudiante;

public interface EstudiantesRepository extends CrudRepository<Estudiante, Long>{

	List<Estudiante> findAllByProgramaProgramasIDOrderByEstudianteID(Long programaID);

}
