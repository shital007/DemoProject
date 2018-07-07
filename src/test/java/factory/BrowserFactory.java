package factory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver openBrowser(String browser) throws IOException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			 driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 		 
		}
		
		return driver;
	}
			
		public static  void closeBrowser() {
			
			driver.close();
			
		}
		
	} 


