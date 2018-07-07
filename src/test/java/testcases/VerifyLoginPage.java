package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class VerifyLoginPage {
 
  WebDriver driver;
  //ExtentReports 
  ExtentReports report;
  //public class ExtentTest extends java.lang.Object
  ExtentTest logger;
  
  @BeforeMethod
  public void setUp() throws IOException {
	 
	  report = new ExtentReports("./Reports/LoginPageExtentReport.html", true);	  
	  logger = report.startTest("login page verification");
	  
	  driver = BrowserFactory.openBrowser("chrome");
	  driver.get(DataProviderFactory.getConfig().getUrl());
	  logger.log(LogStatus.PASS, "Application is up & running");
	  
  }
  
  @Test
  public void testLoginPage() {
	  HomePage home = PageFactory.initElements(driver, HomePage.class);
	  Assert.assertEquals(home.getApplicationTitle(), "Paisa Dukaan");
	 
	  LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	  //login.loginApplication("testerjames365@gmail.com", "test@123");
	 
	  login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	  Assert.assertEquals(login.getApplicationTitle(), "Borrower | Paisa Dukaan");
	 
	 // login.verifyLogoutLink();
  }

  @AfterMethod
  public void tearDown() {
	  
	  report.endTest(logger);
	  report.flush();
	  BrowserFactory.closeBrowser();
	 
	 
  }

}
