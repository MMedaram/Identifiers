package com.excel.identifiers.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetData {
	
	public Map<String, Map<String, String>> setMapData() throws IOException {
		
		ReadExcelProp rEP=new ReadExcelProp();
		String path=rEP.getProperty("filePath");
		String sheetName=rEP.getProperty("sheetName");
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
		Map<String, String> dataMap = new HashMap<String, String>();
		DataFormatter formatter = new DataFormatter();

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			// 1st Cell as Value
			String valueCell = formatter.formatCellValue(row.getCell(1));
			// 0th Cell as Key
			String keyCell = formatter.formatCellValue(row.getCell(0));
			String value = valueCell.trim();
			String key = keyCell.trim();
			// Putting key & value in dataMap
			dataMap.put(key, value);
			// Putting dataMap to excelFileMap
			excelFileMap.put("DataSheet", dataMap);
		}
		workbook.close();
		// Returning excelFileMap
		return excelFileMap;
	}

	// Method to retrieve value
	public String getMapData(String key) throws IOException {
		Map<String, String> m = setMapData().get("DataSheet");
		String value = m.get(key);
		return value;
	}

}
