package co.com.poli.autoevaluacion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.autoevaluacion.domain.AutoevaluacionDocumento;

public interface AutoevaluacionDocumentosRepository extends CrudRepository<AutoevaluacionDocumento, Long>{

	List<AutoevaluacionDocumento> findByAutoevaluacionAutoevaluacionID(Long autoevaluacionID);
}
