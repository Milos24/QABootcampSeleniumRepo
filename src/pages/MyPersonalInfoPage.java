package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class MyPersonalInfoPage {
	
	WebDriver driver;
	
	WebElement socialTitleMrs;
	WebElement firstName;
	WebElement lastName;
	
	Select dayDropDownMenu;
	Select monthDropDownMenu;
	Select yearDropDownMenu;
	
	WebElement currentPassword;
	WebElement newsletterCheckBox;
	
	WebElement updatedPersonalInfoMessage;
	
	WebElement saveButton;
	

	public MyPersonalInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	

	public WebElement getSocialTitleMrs() {
		return driver.findElement(By.id("id_gender2"));
	}
	public WebElement getFirstName() {
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}
	public Select getDayDropDownMenu() {
		dayDropDownMenu = new Select (driver.findElement(By.id("days")));
		return dayDropDownMenu;
	}
	public Select getMonthDropDownMenu() {
		monthDropDownMenu = new Select (driver.findElement(By.id("months")));
	    return monthDropDownMenu;
	}
	public Select getYearDropDownMenu() {
		yearDropDownMenu = new Select (driver.findElement(By.id("years")));
		return yearDropDownMenu;
	}
	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getNewsletterCheckBox() {
		return driver.findElement(By.className("checkbox"));
	}
	public WebElement getUpdatedPersonalInfoMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}

	
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}


	
	

	public void ChooseSocialTitle () {
		getSocialTitleMrs().click();
	}
	
	public void InputFirstName (String firstname) {
		getFirstName().sendKeys(firstname);
	}
	 
	public void InputLastName (String lastname) {
		getLastName().sendKeys(lastname);
	}
	
	public void SelectDayFromDropDownMenu (String day) {
		getDayDropDownMenu().selectByValue(day);
	}
	
	public void SelectMonthFromDropDownMenu (String month) {
		getMonthDropDownMenu().selectByValue(month);
	}
	
	public void SelectYearFromDropDownMenu (String year) {
		getYearDropDownMenu().selectByValue(year);
	}
	
	public void InputCurrentPassword (String password) {
		getCurrentPassword().sendKeys(password);
	}
	
	public void SignUpForNewsletter () {
		getNewsletterCheckBox().click();
	}
	
	public String UpdatedPersonalInfoMessageText () {
		return getUpdatedPersonalInfoMessage().getText();
	}
	
	public void SavePersonalInfo () {
		getSaveButton().click();
	}
	 
   
	

}
