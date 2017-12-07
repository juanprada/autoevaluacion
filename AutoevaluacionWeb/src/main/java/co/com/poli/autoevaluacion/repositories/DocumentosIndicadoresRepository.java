package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.DocumentoIndicador;

public interface DocumentosIndicadoresRepository extends CrudRepository<DocumentoIndicador, Long>{

	List<DocumentoIndicador> findByIndicadorIndicadorIDAndAutoevaluacionDetalleIsNull(Long indicadorID);

	List<DocumentoIndicador> findByAutoevaluacionDetalleAutoevaluacionDetalleIDOrIndicadorIndicadorID(Long detalleAutoevaluacionID,
			Long indicadorID);
}
