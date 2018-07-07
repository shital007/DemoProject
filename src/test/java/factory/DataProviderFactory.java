package factory;

import java.io.IOException;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig() throws IOException {
		
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel() {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}

}
