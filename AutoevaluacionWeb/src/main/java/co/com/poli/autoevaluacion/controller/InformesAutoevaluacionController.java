package co.com.poli.autoevaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.poli.autoevaluacion.services.InformesAutoevaluacionService;

@RestController
@RequestMapping("informes")
public class InformesAutoevaluacionController {

	@Autowired
	private InformesAutoevaluacionService informesAutoevaluacionService;
	
	@RequestMapping(method=RequestMethod.GET, value="factores/{autoevaluacionID}")
	public void informeFactores(@PathVariable(name="autoevaluacionID") Long autoevaluacionID) throws Exception{
		informesAutoevaluacionService.crearInformeFactores(autoevaluacionID);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="caracteristicas/{autoevaluacionID}/{factorID}")
	public void informeCaracteristicas(@PathVariable(name="autoevaluacionID") Long autoevaluacionID, @PathVariable("factorID") Long factorID) throws Exception{
		informesAutoevaluacionService.crearInformeCaracteristicas(autoevaluacionID, factorID);
	}
}
