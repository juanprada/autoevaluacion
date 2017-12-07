package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.poli.autoevaluacion.domain.AutoevaluacionDetalle;
import co.com.poli.autoevaluacion.dto.InformesDto;

public interface AutoevaluacionDetalleRepository extends CrudRepository<AutoevaluacionDetalle, Long>{

	List<AutoevaluacionDetalle> findByAutoevaluacionAutoevaluacionID(Long autoevaluacionID);

	AutoevaluacionDetalle findOneByIndicadorIndicadorIDAndAutoevaluacionAutoevaluacionID(Long indicadorID,
			Long autoevaluacionID);

	@Query(value="select new co.com.poli.autoevaluacion.dto.InformesDto(t.indicador.caracteristica.factor.nombre, AVG(calificacion)) from AutoevaluacionDetalle t "
			+ "WHERE t.autoevaluacion.autoevaluacionID = :autoevaluacionID AND t.calificacion != -1 GROUP BY t.indicador.caracteristica.factor")
	List<InformesDto> informeFactores(@Param("autoevaluacionID") Long autoevaluacionID);

	@Query(value="select new co.com.poli.autoevaluacion.dto.InformesDto(t.indicador.caracteristica.nombre, AVG(calificacion)) from AutoevaluacionDetalle t "
			+ "WHERE t.autoevaluacion.autoevaluacionID = :autoevaluacionID AND t.indicador.caracteristica.factor.factorID = :factorID AND t.calificacion != -1 "
			+ "GROUP BY t.indicador.caracteristica")
	List<InformesDto> informeCaracteristicas(@Param("autoevaluacionID") Long autoevaluacionID, @Param("factorID") Long factorID);

	List<AutoevaluacionDetalle> findByIndicadorIndicadorID(Long indicadorID);	
}
