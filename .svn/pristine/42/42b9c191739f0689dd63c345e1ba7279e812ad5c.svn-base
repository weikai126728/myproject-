package com.abbot.schimneylife.util;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExcelUtil {

	/**
	 * 数据转换成excel
	 * @param header
	 * @param content
	 * @return
	 */
	public static HSSFWorkbook createExcel(String[] header,List<Object[]> content) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// create a new sheet
		HSSFSheet s = wb.createSheet();
		// declare a row object reference
		HSSFRow r = null;
		// declare a cell object reference
		HSSFCell c = null;
		// create 2 cell styles
		HSSFCellStyle cs = wb.createCellStyle();
		HSSFCellStyle cs1 = wb.createCellStyle();

		// create 2 fonts objects
		HSSFFont f = wb.createFont();

		// Set font 1 to 12 point type, blue and bold
		f.setFontHeightInPoints((short) 12);
		f.setColor( HSSFColor.BLACK.index);
		f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		cs.setFont(f);
		cs1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cs1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cs1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cs1.setBorderTop(HSSFCellStyle.BORDER_THIN); 
		//表头设置
		r = s.createRow(0);
		for(int cellnum = 0; cellnum < header.length; cellnum++) {
			c = r.createCell(cellnum);
			c.setCellStyle(cs);
			c.setCellValue(header[cellnum]);
		}
		// Define a few rows
		for(int rownum = 1; rownum < content.size()+1; rownum++) {
			r = s.createRow(rownum);
			for(int cellnum = 0; cellnum < content.get(rownum-1).length; cellnum ++) {
				c = r.createCell(cellnum);
				Object obj = content.get(rownum-1)[cellnum];
				if(obj instanceof String) {
					c.setCellValue((String)obj);					
				}else if(obj instanceof Double) {
					c.setCellValue((Double)obj);
				}else if(obj instanceof BigDecimal) {
					BigDecimal o = (BigDecimal)obj;
					c.setCellValue(o.doubleValue());
				}else if(obj instanceof Integer) {
					c.setCellValue((Integer)obj);
				}
			}
		}
		return wb;
	}
}
