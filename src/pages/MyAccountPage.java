package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	WebDriver driver;
	
	WebElement signOutButton;
	//WebElement orderHistoryAndDetails;
	WebElement myAddress;
	WebElement myPersonalInfo;
	WebElement myWishlist;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	public WebElement getMyAddress() {
		return driver.findElement(By.className("icon-building"));
	} 
	public WebElement getMyPersonalInfo() {
		return driver.findElement(By.className("icon-user"));
	}
	public WebElement getMyWishlist() {
		return driver.findElement(By.className("lnk_wishlist"));
	}
	
	
	
	

	public String textSignOutButton () {
		return getSignOutButton().getText();
	}

	public void MyAddressClick () {
		getMyAddress().click();
	}
	
	public void MyPersonaLInfoClick () {
		getMyPersonalInfo().click();
	}
	
	public void MyWishlistClick () {
		getMyWishlist().click();
	}
	
	public void SignOutButtonClick () {
		getSignOutButton().click();
	}
	
}
