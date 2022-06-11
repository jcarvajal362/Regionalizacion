package com.regionalizacion.app.controller.excel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regionalizacion.app.dao.service.IDocenteService;
import com.regionalizacion.app.entity.Docente;


@RestController
@RequestMapping("/exceldo")
public class ExcelDocenteController {
	
	@Autowired 
	private IDocenteService docenteService;

	//CONTROLADOR PARA EL EXCEL DEL CONSOLIDADO
		@RequestMapping(value = "/export")
		public void downloadAllClassmate(HttpServletResponse response) throws IOException {

			@SuppressWarnings("resource")
			
			//Crear un nuevo Excel
			HSSFWorkbook workbook = new HSSFWorkbook();
			
			//Crear una hoja con el nombre para volcar la informacion
			HSSFSheet sheet = workbook.createSheet("Listado Docente");
		        
			//Modificando el Ancho de las celdas
	        sheet.setColumnWidth(1, 256*25);
	        sheet.setColumnWidth(2, 256*25);
	        sheet.setColumnWidth(3, 256*25);
	        sheet.setColumnWidth(4, 256*25);
	        sheet.setColumnWidth(5, 256*60);
	        sheet.setColumnWidth(6, 256*25);
	        sheet.setColumnWidth(7, 256*60);
	        sheet.setColumnWidth(8, 256*60);
	        sheet.setColumnWidth(9, 256*25);
	        sheet.setColumnWidth(10, 256*60);
	        sheet.setColumnWidth(11, 256*25);
	        sheet.setColumnWidth(12, 256*25);
	        sheet.setColumnWidth(13, 256*25);
	        sheet.setColumnWidth(14, 256*60);
	        sheet.setZoom(100);
		        
	        //Creando la primera columna para el titulo
			HSSFRow filaTitulo = sheet.createRow(1);
			
			//Creando la celda y asignando el titulo en la celda
			HSSFCell celda = filaTitulo.createCell(1);
			
			celda.setCellValue("LISTADO DOCENTE");
			
			//sheet.addMergedRegion(CellRangeAddress.valueOf("$B$2:$D$2"));
			CellRangeAddress region =  CellRangeAddress.valueOf("$B$2:$O$2");
			sheet.addMergedRegion(region);
			
			CellStyle cellStyle = celda.getCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			
			RegionUtil.setBorderBottom(BorderStyle.THIN,region, sheet);
			RegionUtil.setBorderTop(BorderStyle.THIN, region, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN,region, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, region, sheet );
			
			RegionUtil.setBottomBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
			RegionUtil.setTopBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
			RegionUtil.setLeftBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
			RegionUtil.setRightBorderColor(IndexedColors.BLACK.getIndex(), region, sheet);
			
			//Listado Docente
			List<Docente> docente = docenteService.findAll();
			
			LocalDate fecha = LocalDate.now();
			
			
			//Nombre del documento
			String fileName = "Listado_Docente_" +fecha+ ".xls";
			
			int rowNum = 3;

			String[] encabezados = { " ", "CEDULA", "NOMBRE", "APELLIDOS", "TELEFONO", "PREGRADO","POSGRADO","INFORMACION POSGRADO", "PROGRAMA ACADEMICO", "MODALIDAD", "FACULTAD", "REGIONAL", "TIPO CONTRATO", "CATEGORIA", "OBSERVACIONES"};

			HSSFRow row = sheet.createRow(2);
			
			
			
			CellStyle style = workbook.createCellStyle();
			
			style.setAlignment(HorizontalAlignment.CENTER);
			
			style.setBorderBottom(BorderStyle.THIN);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			
			
			style.setBorderLeft(BorderStyle.THIN);
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

			style.setBorderRight(BorderStyle.THIN);
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());

			style.setBorderTop(BorderStyle.THIN);
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			

			for (int i = 0; i < encabezados.length; i++) {
				HSSFCell cell = row.createCell(i);
				HSSFRichTextString text = new HSSFRichTextString(encabezados[i]);
				cell.setCellValue(text);
				
				if (i > 0) {
					cell.setCellStyle(style);
					sheet.setAutoFilter(new CellRangeAddress(2,2,1,13));
				}
			}
			Long cedula;
			String nombre = null;
			String apellido = null;
			Long telefono;
			String pregrado = null;
			Boolean posgrado;
			String infoposgrado = null;
			String programa = null;
			String modalidad = null;
			String facultad = null;
			String regional = null;
			String tipocontrato = null;
			String categoria = null;
			String observaciones = null;
			
			String info=null;


			for (Docente docentes : docente) {

				HSSFRow row1 = sheet.createRow(rowNum);
				
				CellStyle style2 = workbook.createCellStyle();		
				
				style2.setAlignment(HorizontalAlignment.CENTER);
				
				style2.setBorderBottom(BorderStyle.THIN);
				style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				
				
				style2.setBorderLeft(BorderStyle.THIN);
				style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());

				style2.setBorderRight(BorderStyle.THIN);
				style2.setRightBorderColor(IndexedColors.BLACK.getIndex());

				style2.setBorderTop(BorderStyle.THIN);
				style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
			
				if (docentes.getCedula() == null) {
					cedula = null;
				} else {
					cedula = docentes.getCedula();
				}
				row1.createCell(1).setCellValue(cedula);
				row1.getCell(1).setCellStyle(style2);
				
				
				if (docentes.getNombre() == null) {
					nombre = "";
				} else {
					nombre = docentes.getNombre();
				}
				row1.createCell(2).setCellValue(nombre);
				row1.getCell(2).setCellStyle(style2);
				
				
				if (docentes.getApellido() == null) {
					apellido = "";
				} else {
					apellido = docentes.getApellido();
				}
				row1.createCell(3).setCellValue(apellido);
				row1.getCell(3).setCellStyle(style2);
				
				
				if (docentes.getTelefono() == null) {
					telefono = null;
				} else {
					telefono = docentes.getTelefono();
				}
				row1.createCell(4).setCellValue(telefono);
				row1.getCell(4).setCellStyle(style2);
				
				
				if (docentes.getPregrado() == null) {
					pregrado = "";
				} else {
					pregrado = docentes.getPregrado();
				}
				row1.createCell(5).setCellValue(pregrado);
				row1.getCell(5).setCellStyle(style2);
				
				
				
				if (docentes.getPosgrado() == false) {
					posgrado = false;
				} else {
					posgrado = docentes.getPosgrado();
				}
				if(posgrado == true) {
					info = "SI";
				}else {
					info = "NO";
				}
				row1.createCell(6).setCellValue(info);
				row1.getCell(6).setCellStyle(style2);
				
				if (docentes.getInfoposgrado() == null) {
					infoposgrado = "";
				} else {
					infoposgrado = docentes.getInfoposgrado();
				}
				row1.createCell(7).setCellValue(infoposgrado);
				row1.getCell(7).setCellStyle(style2);
				
				
				if (docentes.getPrograma().getNombre() == null) {
					programa = "";
				} else {
					programa = docentes.getPrograma().getNombre();
				}
				row1.createCell(8).setCellValue(programa);
				row1.getCell(8).setCellStyle(style2);
				
				
				if (docentes.getPrograma().getModalidad() == null) {
					modalidad = "";
				} else {
					modalidad = docentes.getPrograma().getModalidad() ;
				}
				row1.createCell(9).setCellValue(modalidad);
				row1.getCell(9).setCellStyle(style2);
				
				
				if (docentes.getPrograma().getFacultad().getNombre() == null) {
					facultad = "";
				} else {
					facultad = docentes.getPrograma().getFacultad().getNombre();
				}
				row1.createCell(10).setCellValue(facultad);
				row1.getCell(10).setCellStyle(style2);
				
				if (docentes.getPrograma().getFacultad().getRegional().getNombre() == null) {
					regional = "";
				} else {
					regional = docentes.getPrograma().getFacultad().getRegional().getNombre();
				}
				row1.createCell(11).setCellValue(regional);
				row1.getCell(11).setCellStyle(style2);
				
				
				if (docentes.getContrato() == null) {
					tipocontrato = "";
				} else {
					tipocontrato = docentes.getContrato() ;
				}
				row1.createCell(12).setCellValue(tipocontrato);
				row1.getCell(12).setCellStyle(style2);
				
				
				if (docentes.getCategoria() == null) {
					categoria = "";
				} else {
					categoria = docentes.getCategoria() ;
				}
				row1.createCell(13).setCellValue(categoria);
				row1.getCell(13).setCellStyle(style2);
				
				if (docentes.getObservaciones() == null) {
					observaciones = "";
				} else {
					observaciones = docentes.getObservaciones() ;
				}
				row1.createCell(14).setCellValue(observaciones);
				row1.getCell(14).setCellStyle(style2);
				
				rowNum++;

			}
			
			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			response.flushBuffer();
			workbook.write(response.getOutputStream());
			
			
			

		}
}
