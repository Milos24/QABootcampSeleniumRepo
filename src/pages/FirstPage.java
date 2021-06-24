package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FirstPage {

	WebDriver driver;
	
	WebElement signinButton;
	WebElement myAccountButton;
	

	public FirstPage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public WebElement getSigninButton() {
		return driver.findElement(By.className("login"));
	}
	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
	}

	

	public void EnterSigninPage() {
		getSigninButton().click();
	}
	
	public void EnterMyAccountPage () {
		getMyAccountButton().click();
	}
	
	public String SignInButtonText () {
		return getSigninButton().getText();
	}
}
