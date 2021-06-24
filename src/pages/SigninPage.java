package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {
	
	WebDriver driver;

	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement bottomSigninButton;
	WebElement emailErrorMessage;
	WebElement passwordErrorMessage;
	WebElement emptyFieldErrorMessage;
	
	
	
	public SigninPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getBottomSigninButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	public WebElement getEmailErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public WebElement getPasswordErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public WebElement getEmptyFieldErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
		
		
		
		
	}
	public void InputEmailAddress(String email) {
		getEmailInputField().sendKeys(email);
	}
	
	public void InputPassword(String password) {
		getPasswordInputField().sendKeys(password);
	}
	
	public void Signin () {
		getBottomSigninButton().click();
	}

	public String EmailErrorMessageText () {
		return getEmailErrorMessage().getText();
	}
	
	public String PasswordMessageText () {
		return getPasswordErrorMessage().getText();
	}
	
	public String EmptyFieldsErrorMessageText () {
		return getEmptyFieldErrorMessage().getText();
	}
}
