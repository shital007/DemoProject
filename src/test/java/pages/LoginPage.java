package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(id="username") WebElement username;
	
	@FindBy(id="password") WebElement password;
	
	@FindBy(id="submit") WebElement loginButton;
	
	@FindBy(xpath="//*[@id='header_logOut']/a") WebElement logoutButton;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	
	}
	
	public void loginApplication(String uname, String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	public void verifyLogoutLink() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
		System.out.println(logoutButton.getText());
		//Assert.assertTrue(logoutLink.getText().contains("Logout"));
		
	}
	
	public String getApplicationTitle() {
		
		return driver.getTitle();
	}

}
