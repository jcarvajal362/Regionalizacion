package com.regionalizacion.app.controller.excel;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.regionalizacion.app.dao.service.IEstdocprogService;
import com.regionalizacion.app.entity.Estdocprog;

@RestController
@RequestMapping("/excelrs")
public class ExcelReporteSemestralController {
	
	//private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	@Autowired 
	private IEstdocprogService estdocprogService;
	
	//CONTROLADOR PARA EL EXCEL SEMESTRAL
		@RequestMapping(value = "/export")
		public void downloadAllClassmates(@RequestParam(value = "fechaI") String fechaI,
				@RequestParam(value = "fechaF") String fechaF, HttpServletResponse response) throws IOException {

			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Reporte Semestral");

			//Modificando el Ancho de las celdas
	        sheet.setColumnWidth(1, 256*20);
	        sheet.setColumnWidth(2, 256*45);
	        sheet.setColumnWidth(3, 256*63);
	        sheet.setColumnWidth(4, 256*18);
	        sheet.setColumnWidth(5, 256*30);
	        sheet.setColumnWidth(6, 256*30);
	        sheet.setColumnWidth(7, 256*20);
	        sheet.setZoom(100);
	        
	      //Creando la primera columna para el titulo
			HSSFRow filaTitulo = sheet.createRow(1);
			
			//Creando la celda y asignando el titulo en la celda
			HSSFCell celda = filaTitulo.createCell(1);
			
			celda.setCellValue("REPORTE SEMESTRAL");
			
			CellRangeAddress region = CellRangeAddress.valueOf("$B$2:$G$2");
			sheet.addMergedRegion(region);
			//sheet.addMergedRegion(CellRangeAddress.valueOf("$B$2:$H$2"));
			
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
			
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formato2 = new SimpleDateFormat("MM");
			SimpleDateFormat formato3 = new SimpleDateFormat("yyyy");

			
			Date fecha = null;
			Date fecha2 = null;
			
			try {
				fecha = formato.parse(fechaI);
				fecha2 = formato.parse(fechaF);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

			int valormes = Integer.parseInt(formato2.format(fecha));
			int valormes2 = Integer.parseInt(formato2.format(fecha2));
			String semestre;
			
			//Lista filtrada por las fechas parametro
			List<Estdocprog> estdocprog = estdocprogService.filterSemestral(fechaI, fechaF);
			
			if(valormes >= 01 && valormes<= 06 && valormes2>=01 && valormes2<=06) {
				semestre = "Primer Semestre ";
			}else {
				semestre = "Segundo Semestre ";
			}
			
			
			//Nombre del documento
			String fileName = "Reporte "+semestre +formato3.format(fecha)+".xls";

			int rowNum = 3;

			String[] encabezados = { " ", "NIVEL", "PROGRAMA", "FACULTAD","REGIONAL","ESTUDIANTES MATRICULADOS","DOCENTES ASIGNADOS" };

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
					sheet.setAutoFilter(new CellRangeAddress(2,2,1,6));

				}
			}
			
			String nivel = null;
			String programa = null;
			String facultad = null;
			String regional = null;
			int estudiantes;
			int docentes;


			for (Estdocprog reporteS : estdocprog) {

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
				
				if (reporteS.getPrograma().getNivel() == null) {
					nivel = "";
				} else {
					nivel = reporteS.getPrograma().getNivel();
				}
				row1.createCell(1).setCellValue(nivel);
				row1.getCell(1).setCellStyle(style2);
				
				
				if (reporteS.getPrograma().getNombre() == null) {
					programa = "";
				} else {
					programa = reporteS.getPrograma().getNombre();
				}
				row1.createCell(2).setCellValue(programa);
				row1.getCell(2).setCellStyle(style2);
				
				if (reporteS.getPrograma().getFacultad().getNombre() == null) {
					facultad = "";
				} else {
					facultad = reporteS.getPrograma().getFacultad().getNombre();
				}
				row1.createCell(3).setCellValue(facultad);
				row1.getCell(3).setCellStyle(style2);
				
				if (reporteS.getPrograma().getFacultad().getRegional().getNombre() == null) {
					regional = "";
				} else {
					regional = reporteS.getPrograma().getFacultad().getRegional().getNombre();
				}
				row1.createCell(4).setCellValue(regional);
				row1.getCell(4).setCellStyle(style2);
				
				
				if (reporteS.getEcantidad() == 0) {
					estudiantes = 0;
				} else {
					estudiantes = reporteS.getEcantidad();
				}
				row1.createCell(5).setCellValue(estudiantes);
				row1.getCell(5).setCellStyle(style2);
				

				if (reporteS.getDcantidad() == 0) {
					docentes = 0;
				} else {
					docentes = reporteS.getDcantidad();
				}
				row1.createCell(6).setCellValue(docentes);
				row1.getCell(6).setCellStyle(style2);
				
				rowNum++;
			}
			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
			response.flushBuffer();
			workbook.write(response.getOutputStream());

		}
}
