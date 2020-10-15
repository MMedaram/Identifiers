package com.excel.identifiers.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.identifiers.helper.ReadExcelSheetData;

@RestController
@RequestMapping("/api")
public class ReadIdentifiers {

	@GetMapping("/identifier/{key}")
	public String getValue(@PathVariable String key) throws IOException {
		
		ReadExcelSheetData readExcelSheetData=new ReadExcelSheetData();
		return readExcelSheetData.getMapData(key);
	}
}
