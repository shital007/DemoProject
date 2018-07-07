package testcases;

import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifyHomePage {
	
	WebDriver driver;
	

  @BeforeMethod
  public void setUp() throws IOException {
	  driver = BrowserFactory.openBrowser("chrome");
	  driver.get(DataProviderFactory.getConfig().getUrl());
	  
  }
  
  @Test
  public void testHomePage() {
	  
	  HomePage home = PageFactory.initElements(driver, HomePage.class);
	  Assert.assertTrue(home.getApplicationTitle().equals("Paisa Dukaan"));
	  	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	 BrowserFactory.closeBrowser();
	  
  }

}
