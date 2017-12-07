package co.com.poli.autoevaluacion.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.com.poli.autoevaluacion.domain.AutoevaluacionDetalle;
import co.com.poli.autoevaluacion.domain.DocumentoIndicador;
import co.com.poli.autoevaluacion.domain.Indicador;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionDetalleRepository;
import co.com.poli.autoevaluacion.repositories.DocumentosIndicadoresRepository;
import co.com.poli.autoevaluacion.repositories.IndicadoresRepository;

@Service
public class DocumentoIndicadorService {

	private static final String PATH_FILES_WINDOWS = "C:\\xampp\\htdocs\\autoevaluacion\\files\\";
	
	private static final String PATH_FILES_LINUX = "/opt/lampp/htdocs/autevaluacion/files/";
	
	@Autowired
	private DocumentosIndicadoresRepository documentosIndicadoresRepository;
	
	@Autowired
	private IndicadoresRepository indicadoresRepository;
	
	@Autowired
	private AutoevaluacionDetalleRepository autoevaluacionDetalleRepository;
	
	public void guardarDocumentoIndicador(DocumentoIndicador documentoIndicador){
		documentosIndicadoresRepository.save(documentoIndicador);
	}
	
	public List<DocumentoIndicador> listarDocumentosPorIndicador(Long indicadorID){
		return documentosIndicadoresRepository.findByIndicadorIndicadorIDAndAutoevaluacionDetalleIsNull(indicadorID);
	}
	
	public void cargarDocumento(Long indicadorID, MultipartFile archivo) throws Exception{
		guardarArchivo(archivo);
		Indicador indicador = indicadoresRepository.findOne(indicadorID);
		guardarDocumentoIndicador(indicador, archivo.getOriginalFilename(), null);
	}
	
	private void guardarDocumentoIndicador(Indicador indicador, String archivo, AutoevaluacionDetalle autoevaluacionDetalle){
		DocumentoIndicador documentoIndicador = new DocumentoIndicador();
		documentoIndicador.setIndicador(indicador);
		documentoIndicador.setArchivo(archivo);
		documentoIndicador.setAutoevaluacionDetalle(autoevaluacionDetalle);
		guardarDocumentoIndicador(documentoIndicador);
	}
	
	private void guardarArchivo(MultipartFile archivo) throws IllegalStateException, IOException{
		File file = new File(PATH_FILES_WINDOWS + archivo.getOriginalFilename());
		archivo.transferTo(file);
	}
	
	public void eliminarArchivo(Long documentoIndicadorID){
		DocumentoIndicador documentoIndicador = documentosIndicadoresRepository.findOne(documentoIndicadorID);
		documentosIndicadoresRepository.delete(documentoIndicador);
		File file = new File(PATH_FILES_LINUX + documentoIndicador.getArchivo());
		file.delete();
		
	}

	public List<DocumentoIndicador> listarDocumentosPorDetalleAutoevaluacion(Long detalleAutoevaluacionID) {
		AutoevaluacionDetalle autoevaluacionDetalle = autoevaluacionDetalleRepository.findOne(detalleAutoevaluacionID);
		return documentosIndicadoresRepository.findByAutoevaluacionDetalleAutoevaluacionDetalleIDOrIndicadorIndicadorID(detalleAutoevaluacionID, autoevaluacionDetalle.getIndicador().getIndicadorID());
	}

	public void cargarAutoevaluacionDocumento(Long detalleAutoevaluacionID, MultipartFile documento) throws Exception {
		guardarArchivo(documento);
		AutoevaluacionDetalle autoevaluacionDetalle = autoevaluacionDetalleRepository.findOne(detalleAutoevaluacionID);
		guardarDocumentoIndicador(autoevaluacionDetalle.getIndicador(), documento.getOriginalFilename(), autoevaluacionDetalle);
		
	}
}
