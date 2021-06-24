package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyWishlistsPage {
	
	WebDriver driver;
	WebElement wishlistNameInputField;
	
	WebElement wishlistNameDisplayed;
	WebElement deleteButton;
	
	WebElement wishlistBox;
	
	WebElement saveButton;
	//List <WebElement> myWishLists; 

	
	
	public MyWishlistsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getWishlistNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	public WebElement getWishlistNameDisplayed() {
		return driver.findElement(By.xpath("//*[@id=\"block-history\"]/table/thead/tr/th[1]"));
	}
	public WebElement getWishlistBox() {
		return driver.findElement(By.id("block-history"));
	}
	public WebElement getDeleteButton() {
		return driver.findElement(By.className("icon-remove"));
	}
	public List<WebElement> getMyWishLists() {
		return driver.findElements(By.className("wishlist_delete"));
	}
	
	
	

	
	public void InputWishlistName (String name) {
		getWishlistNameInputField().sendKeys(name);
	}
	
	public String MyWishlistNameDisplayed () {
		return getWishlistNameDisplayed().getText();
	}
	
	public void SaveWishlist () {
		getSaveButton().click();	
	}
	 
	public void DeleteWishlist () {
		getDeleteButton().click();
	}
	
}
