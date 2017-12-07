package co.com.poli.autoevaluacion.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.poli.autoevaluacion.domain.AutoevaluacionDocumento;
import co.com.poli.autoevaluacion.services.AutoevaluacionDocumentosService;

@RestController
@RequestMapping("autoevaluacionDocumentos")
public class AutoevaluacionDocumentosController {

	@Autowired
	private AutoevaluacionDocumentosService autoevaluacionDocumentosService;
	
	@RequestMapping(method=RequestMethod.POST, value="cargarDocumento")
	public void cargarDocumento(@RequestParam("evaluacionID") Long evaluacionID, @RequestParam("documento") MultipartFile documento) throws Exception{
		autoevaluacionDocumentosService.cargarDocumento(evaluacionID, documento);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listarDocumentosAutoevaluacion/{evaluacionID}")
	public List<AutoevaluacionDocumento> listarDocumentosIndicador(@PathVariable("evaluacionID") Long evaluacionID){
		return autoevaluacionDocumentosService.listarDocumentosAutoevaluacion(evaluacionID);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{documentoAutoevaluacionID}")
	public void eliminarDocumentosIndicador(@PathVariable("documentoAutoevaluacionID") Long documentoAutoevaluacionID) throws IOException{
		autoevaluacionDocumentosService.eliminarArchivo(documentoAutoevaluacionID);
	}	
}
