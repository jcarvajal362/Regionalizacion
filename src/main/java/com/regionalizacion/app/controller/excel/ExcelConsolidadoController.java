package com.regionalizacion.app.controller.excel;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

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

import com.regionalizacion.app.dao.Consolidado;
import com.regionalizacion.app.dao.service.IReporteService;

@RestController
@RequestMapping("/excel")
public class ExcelConsolidadoController {
	
	@Autowired 
	private IReporteService reporteService;

	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	//CONTROLADOR PARA EL EXCEL DEL CONSOLIDADO
	@RequestMapping(value = "/export")
	public void downloadAllClassmate(@RequestParam(value = "fechaInicio") String fechaInicio, @RequestParam(value = "fechaFinal") String fechaFinal, HttpServletResponse response) throws IOException {

		@SuppressWarnings("resource")
		
		//Crear un nuevo Excel
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//Crear una hoja con el nombre para volcar la informacion
		HSSFSheet sheet = workbook.createSheet("Consolidado Semanal");
	        
		//Modificando el Ancho de las celdas
        sheet.setColumnWidth(1, 256*25);
        sheet.setColumnWidth(2, 256*15);
        sheet.setColumnWidth(3, 256*25);
        sheet.setZoom(100);
	        
        //Creando la primera columna para el titulo
		HSSFRow filaTitulo = sheet.createRow(1);
		
		//Creando la celda y asignando el titulo en la celda
		HSSFCell celda = filaTitulo.createCell(1);
		
		celda.setCellValue("CONSOLIDADO SEMANAL ");
		
		//sheet.addMergedRegion(CellRangeAddress.valueOf("$B$2:$D$2"));
		CellRangeAddress region =  CellRangeAddress.valueOf("$B$2:$D$2");
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
		
		//Lista filtrada por las fechas parametro
		//List<Consolidado> report = consolidadoRepository.findFilter(fechaInicio, fechaFinal);
		List<Consolidado> report = reporteService.findFilter(fechaInicio, fechaFinal);
		//Nombre del documento
		String fileName = "Consolidado_"+ fechaFinal + ".xls";
		
		int rowNum = 3;

		String[] encabezados = { " ", "REGIONAL", "CANTIDAD", "FECHA DE REPORTE" };

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
			}
		}

		String regional = null;
		Date fecha = null;

		Long total;

		for (Consolidado consolidado : report) {

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
		
			if (consolidado.getRegional() == null) {
				regional = "";
			} else {
				regional = consolidado.getRegional();
			}
			row1.createCell(1).setCellValue(regional);
			row1.getCell(1).setCellStyle(style2);
			
			
			if (consolidado.getTotal() == null) {
				total = null;
			} else {
				total = consolidado.getTotal();
			}
			row1.createCell(2).setCellValue(total);
			row1.getCell(2).setCellStyle(style2);
		
			if (consolidado.getFechas() == null) {
				fecha = null;
			} else {
				fecha = consolidado.getFechas();
			}
			
			row1.createCell(3).setCellValue(DATE_FORMAT.format(fecha));
			row1.getCell(3).setCellStyle(style2);
			
			//cell.setCellStyle(style);
			
			
			rowNum++;

		}
		
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
		
		
		

	}

	 
}
