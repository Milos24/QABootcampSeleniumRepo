package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	
	WebDriver driver;
	
	WebElement updateButton;
	WebElement deleteButton;
    WebElement addNewButton;
	
    WebElement addressInputField;
    WebElement cityInputField;
    
    WebElement stateDropDownMenu;
    WebElement zipInputField;
    WebElement countryDropDownMenu;
    WebElement mobilePhoneInputField;
    
    WebElement addressTitleInputField;
    
    WebElement myUpdatedAdressText;
	WebElement myUpdatedAdressTitleText;
	WebElement myAddedAddressBox;
    
    WebElement saveButton;
    
    
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public WebElement getMyUpdatedAdressText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[4]/span[1]"));	
	}
	public WebElement getMyUpdatedAdressTitleText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[1]/h3"));
	}
	public WebElement getMyAddedAddressBox() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]"));
	}
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}
	public WebElement getAddNewButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}	
	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}
	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}
	public WebElement getStateDropDownMenu() {
		return driver.findElement(By.id("id_state"));
	}
	public WebElement getZipInputField() {
		return driver.findElement(By.id("postcode"));
	}
	public WebElement getCountryDropDownMenu() {
		return driver.findElement(By.id("id_country"));
	}
	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}
	public WebElement getAddressTitleInputField() {
		return driver.findElement(By.id("alias"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public List<WebElement> getAddressBoxes() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[2]"));
	}
	
	

	

	public String MyAddressShow () {
		return getMyUpdatedAdressText().getText();
	}
	
	public String MyAddressTitleShow () {
		return getMyUpdatedAdressTitleText().getText();
	}
	
	
	public void UpdateAddressClick () {
		getUpdateButton().click();
	}

	
	public void InputUpdatedAddress (String address) {
		getAddressInputField().sendKeys(address);
	}
	
	public void InputCity (String city) {
		getCityInputField().sendKeys(city);
	}
	
	public void SelectState (String state) {
		getStateDropDownMenu().sendKeys(Keys.ARROW_DOWN);
		getStateDropDownMenu().sendKeys(Keys.ENTER);
	}
	
	public void InputPostalCode (String zip) {
		getZipInputField().sendKeys(zip);
	}
	
	public void SelectCountry (String country) {
		getCountryDropDownMenu().sendKeys(Keys.ARROW_DOWN);
		getCountryDropDownMenu().sendKeys(Keys.ENTER);
	}
	
	public void EnterMobilePhone (String phone) {
		getMobilePhoneInputField().sendKeys(phone);
	}
	
	public void InputUpdatedAddressTitle (String addressfield) {
		getAddressTitleInputField().sendKeys(addressfield);
	}
	
	public void AddAddress () {
		getAddNewButton().click();
	}
	
	public void DeleteAddress () {
		getDeleteButton().click();
	}
	
	public void SaveAddress () {
		getSaveButton().click();
	}
	
	
}
