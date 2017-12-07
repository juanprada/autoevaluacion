package co.com.poli.autoevaluacion.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.com.poli.autoevaluacion.domain.Autoevaluacion;
import co.com.poli.autoevaluacion.domain.AutoevaluacionDocumento;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionDocumentosRepository;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionRepository;

@Service
public class AutoevaluacionDocumentosService {

	private static final String PATH_FILES_WINDOWS = "C:\\xampp\\htdocs\\autoevaluacion\\files\\";
	
	private static final String PATH_FILES_LINUX = "/opt/lampp/htdocs/autevaluacion/files/";
	
	@Autowired
	private AutoevaluacionDocumentosRepository autoevaluacionDocumentosRepository;
	
	@Autowired
	private AutoevaluacionRepository autoevaluacionRepository;
	
	public void guardarDocumentoIndicador(AutoevaluacionDocumento autoevaluacionDocumento){
		autoevaluacionDocumentosRepository.save(autoevaluacionDocumento);
	}
	
	public void cargarDocumento(Long autoevaluacionId, MultipartFile archivo) throws Exception{
		guardarArchivo(archivo);
		Autoevaluacion autoevaluacion = autoevaluacionRepository.findOne(autoevaluacionId);
		guardarDocumentoIndicador(autoevaluacion, archivo.getOriginalFilename());
	}
	
	private void guardarDocumentoIndicador(Autoevaluacion autoevaluacion, String archivo){
		AutoevaluacionDocumento autoevaluacionDocumento = new AutoevaluacionDocumento();
		autoevaluacionDocumento.setAutoevaluacion(autoevaluacion);
		autoevaluacionDocumento.setArchivo(archivo);
		guardarDocumentoIndicador(autoevaluacionDocumento);
	}
	
	private void guardarArchivo(MultipartFile archivo) throws IllegalStateException, IOException{
		File file = new File(PATH_FILES_WINDOWS + archivo.getOriginalFilename());
		archivo.transferTo(file);
	}
	
	public void eliminarArchivo(Long documentoAutoevaluacionID){
		AutoevaluacionDocumento autoevaluacionDocumento = autoevaluacionDocumentosRepository.findOne(documentoAutoevaluacionID);
		autoevaluacionDocumentosRepository.delete(autoevaluacionDocumento);
		File file = new File(PATH_FILES_WINDOWS + autoevaluacionDocumento.getArchivo());
		file.delete();
		
	}

	public List<AutoevaluacionDocumento> listarDocumentosAutoevaluacion(Long autoevaluacionID) {
		return autoevaluacionDocumentosRepository.findByAutoevaluacionAutoevaluacionID(autoevaluacionID);
	}
}
