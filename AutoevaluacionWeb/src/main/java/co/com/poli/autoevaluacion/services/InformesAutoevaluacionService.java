package co.com.poli.autoevaluacion.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.poli.autoevaluacion.domain.Parametros;
import co.com.poli.autoevaluacion.dto.InformesDto;
import co.com.poli.autoevaluacion.repositories.AutoevaluacionDetalleRepository;
import co.com.poli.autoevaluacion.repositories.ParametrosRepository;

@Service
public class InformesAutoevaluacionService {

	private static final String MINIMO_VALOR_ALTO = "minimo_valor_alto";
	
	private static final String MINIMO_VALOR_MEDIO = "minimo_valor_medio";
	
	@Autowired
	private AutoevaluacionDetalleRepository autoevaluacionDetalleRepository;
	
	@Autowired
	private ParametrosRepository parametrosRepository;
	
	public void crearInformeFactores(Long autoevaluacionID) throws InvalidFormatException, FileNotFoundException, IOException{
		
		List<InformesDto> informeDto = autoevaluacionDetalleRepository.informeFactores(autoevaluacionID);
		
		String excelFileName = "C:\\xampp\\htdocs\\autoevaluacion\\files\\informes\\factores.xls";

		InputStream ExcelFileToRead = new FileInputStream(excelFileName);
		
		String sheetName = "Hoja1";

		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		borrarDatosAnteriores(sheet);
		
		int i = 0;
		for (InformesDto factor : informeDto) {
			i++;
			sheet.createRow(i).createCell(0).setCellValue(factor.getNombre());
			sheet.getRow(i).createCell(1).setCellValue(factor.getCalificacion());
			sheet.getRow(i).createCell(2).setCellValue(obtenerCalificacionCualitativa(factor.getCalificacion()));
		}
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	private String obtenerCalificacionCualitativa(Double calificacion){
		Parametros parametroAlto = parametrosRepository.findOneByCodigo(MINIMO_VALOR_ALTO);
		Parametros parametroMedio = parametrosRepository.findOneByCodigo(MINIMO_VALOR_MEDIO);
		if (calificacion >= Integer.parseInt(parametroAlto.getValor())){
			return "ALTO";
		}else if (calificacion >= Integer.parseInt(parametroMedio.getValor())){
			return "MEDIO";
		}else{
			return "BAJO";
		}
	}
	
	public void borrarDatosAnteriores(HSSFSheet sheet){
		Iterator rows = sheet.rowIterator();
		HSSFRow row=(HSSFRow) rows.next();
		while (rows.hasNext()){
			row=(HSSFRow) rows.next();
			if (row.getCell(0) != null){
				row.removeCell(row.getCell(0));
				row.removeCell(row.getCell(1));
				row.removeCell(row.getCell(2));
			}
		}
	}
	
	public void crearInformeCaracteristicas(Long autoevaluacionID, Long factorID) throws InvalidFormatException, FileNotFoundException, IOException{
		
		List<InformesDto> informeDto = autoevaluacionDetalleRepository.informeCaracteristicas(autoevaluacionID, factorID);
		
		String excelFileName = "C:\\xampp\\htdocs\\autoevaluacion\\files\\informes\\caracteristicas.xls";

		InputStream ExcelFileToRead = new FileInputStream(excelFileName);
		
		String sheetName = "Hoja1";

		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		borrarDatosAnteriores(sheet);
		
		int i = 0;
		for (InformesDto factor : informeDto) {
			i++;
			sheet.createRow(i).createCell(0).setCellValue(factor.getNombre());
			sheet.getRow(i).createCell(1).setCellValue(factor.getCalificacion());
			sheet.getRow(i).createCell(2).setCellValue(obtenerCalificacionCualitativa(factor.getCalificacion()));
		}
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}
