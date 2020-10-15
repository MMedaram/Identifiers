package com.excel.identifiers.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ReadExcelProp {
	
	private Properties prop = new Properties();

	public void initiate(String propertyFile) {
		try{
			InputStream input =ReadExcelProp.class.getResourceAsStream("/resources/" +propertyFile);
			if (input == null) {
				input=ReadExcelProp.class.getClassLoader().getResourceAsStream(propertyFile) ;
			}
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	
	public String getProperty(String propertyKey) {
		initiate("excel.properties");
		return prop.getProperty(propertyKey);
	}


}
