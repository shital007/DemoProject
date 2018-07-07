package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utilities.Helper;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class VerifyLoginPageWithScreenshots {
 
  WebDriver driver;
  ExtentReports report;
  ExtentTest logger;
  
  @BeforeMethod
  public void setUp() throws IOException {
	  report = new ExtentReports("./Reports/LoginPageExtentReport.html", true);
	  logger = report.startTest("Verify login page");
	  
	  driver = BrowserFactory.openBrowser("chrome");
	  driver.get(DataProviderFactory.getConfig().getUrl());
	  logger.log(LogStatus.PASS, "Application is up and running");
	  
  }
  
  @Test
  public void testLoginPage() {
	  HomePage home = PageFactory.initElements(driver, HomePage.class);
	  Assert.assertEquals(home.getApplicationTitle(), "Paisa Dukaan");
	  logger.log(LogStatus.PASS,logger.addScreenCapture(Helper.captureScreenshot(driver,"HomePageSuccess")));
	  LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	  //login.loginApplication("testerjames365@gmail.com", "test@123");
	  logger.log(LogStatus.INFO, "Login into application");
	  login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	  Assert.assertEquals(login.getApplicationTitle(), "Borrower | Paisa Dukaan");
	  logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.captureScreenshot(driver, "LoginSuccess")));
	  
	  // login.verifyLogoutLink();
  }	

  @AfterMethod
  public void tearDown(ITestResult result) {
	  
	  //ITestResult interface
	  if(result.getStatus()==ITestResult.FAILURE) {
		  
		  String path = Helper.captureScreenshot(driver,result.getName());
		  logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
		  }
	  BrowserFactory.closeBrowser();
	  report.endTest(logger);
	  report.flush();
  }

}
