package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	WebDriver driver; 
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		
		//public interface TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		//Interface OutputType
		File src = ts.getScreenshotAs(OutputType.FILE);
		/*String destination = "C:\\Users\\s\\eclipse-workspace\\paisadukandemo\\Screenshots\\"
								+screenshotName+ System.currentTimeMillis() +".png";*/
		String destination = "./Screenshots/"+screenshotName+ System.currentTimeMillis() +".png";
		try {
			FileUtils.copyFile(src, new File(destination));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture a screenshot " + e.getMessage());
		}
		
		return destination;
	}

}
