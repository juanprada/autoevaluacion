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

import co.com.poli.autoevaluacion.domain.DocumentoIndicador;
import co.com.poli.autoevaluacion.services.DocumentoIndicadorService;

@RestController
@RequestMapping("documentosIndicadores")
public class DocumentoIndicadorController {

	@Autowired
	private DocumentoIndicadorService documentoIndicadorService;
	
	@RequestMapping(method=RequestMethod.POST, value="cargarDocumento")
	public void cargarDocumento(@RequestParam("indicadorID") Long indicadorID, @RequestParam("documento") MultipartFile documento) throws Exception{
		documentoIndicadorService.cargarDocumento(indicadorID, documento);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cargarDocumentoAutoevaluacion")
	public void cargarDocumentoAutoevaluacion(@RequestParam("autoevaluacionDocumentoID") Long autoevaluacionDocumentoID, @RequestParam("documento") MultipartFile documento) throws Exception{
		documentoIndicadorService.cargarAutoevaluacionDocumento(autoevaluacionDocumentoID, documento);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listarDocumentosIndicador/{indicadorID}")
	public List<DocumentoIndicador> listarDocumentosIndicador(@PathVariable("indicadorID") Long indicadorID){
		return documentoIndicadorService.listarDocumentosPorIndicador(indicadorID);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="eliminar/{documentoIndicadorID}")
	public void eliminarDocumentosIndicador(@PathVariable("documentoIndicadorID") Long documentoIndicadorID) throws IOException{
		documentoIndicadorService.eliminarArchivo(documentoIndicadorID);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="listarDocumentosDetalleAutoevaluacion/{detalleAutoevaluacionID}")
	public List<DocumentoIndicador> listarDocumentosDetalleAutoevaluacion(@PathVariable("detalleAutoevaluacionID") Long detalleAutoevaluacionID){
		return documentoIndicadorService.listarDocumentosPorDetalleAutoevaluacion(detalleAutoevaluacionID);
	}
	
}
