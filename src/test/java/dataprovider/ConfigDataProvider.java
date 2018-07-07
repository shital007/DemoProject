package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider() throws IOException{
		
		File src = new File("./ConfigData/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getChromePath() {
		
		return prop.getProperty("ChromePath");
		
	}
		
	public String getUrl() {
			
			return prop.getProperty("Url");
			
		}
	
		
	}


