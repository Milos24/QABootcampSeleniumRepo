package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddressesTestProject extends BaseTestsProject {

	@BeforeMethod 
	public void beforeEachTest() throws InterruptedException {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	
	}
	
	@Test (priority = 0) 
	public void updateMyAddress ()  {
		logInForm();
		myAccountPage.MyAddressClick();
		
		myAddressesPage.UpdateAddressClick();
		myAddressesPage.getAddressInputField().clear();
		myAddressesPage.InputUpdatedAddress(readFromExcel.getStringData("MY ADDRESSES", 10, 2));
		myAddressesPage.getAddressTitleInputField().clear();
		myAddressesPage.InputUpdatedAddressTitle(readFromExcel.getStringData("MY ADDRESSES", 11, 2));
		myAddressesPage.SaveAddress();
		
		String text = readFromExcel.getStringData("MY ADDRESSES", 13, 3);
		String actualText = myAddressesPage.MyAddressShow(); 
		assertEquals(actualText, text);
		
		String text1 = readFromExcel.getStringData("MY ADDRESSES", 14, 3);
		String actualText1 = myAddressesPage.MyAddressTitleShow(); 
		assertEquals(actualText1, text1);
		
	} 
		
	@Test (priority = 1)
	public void addAddress () {
		logInForm();
		myAccountPage.MyAddressClick();
		
		myAddressesPage.AddAddress();
		myAddressesPage.getAddressInputField().clear();
		myAddressesPage.InputUpdatedAddress(readFromExcel.getStringData("MY ADDRESSES", 18, 2));
		myAddressesPage.InputCity(readFromExcel.getStringData("MY ADDRESSES", 19, 2));
		myAddressesPage.SelectState(readFromExcel.getStringData("MY ADDRESSES", 20, 2));
		myAddressesPage.InputPostalCode(String.valueOf(readFromExcel.getIntegerData("MY ADDRESSES", 21, 2)));
		myAddressesPage.SelectCountry(readFromExcel.getStringData("MY ADDRESSES", 22, 2));
		myAddressesPage.EnterMobilePhone(readFromExcel.getStringData("MY ADDRESSES", 23, 2));
		myAddressesPage.getAddressTitleInputField().clear();
		myAddressesPage.InputUpdatedAddressTitle(readFromExcel.getStringData("MY ADDRESSES", 24, 2));
		myAddressesPage.SaveAddress();
		
		
		boolean text = myAddressesPage.getMyAddedAddressBox().isDisplayed();
		assertEquals(text, true);
	} 
	
	@Test (priority = 2)
	public void deleteAddress () {
		logInForm();
		myAccountPage.MyAddressClick();
		myAddressesPage.DeleteAddress();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		List<WebElement> listOfMyAddresses = myAddressesPage.getAddressBoxes();
		int actualNumberOfMyAddresses = listOfMyAddresses.size();
		assertEquals(actualNumberOfMyAddresses, 1);

		
		
	} 
	
	
	public void logInForm() {
		firstPage.EnterSigninPage();
		signinPage.InputEmailAddress(readFromExcel.getStringData("LOG IN", 7, 2));
		signinPage.InputPassword(readFromExcel.getStringData("LOG IN", 8, 2));
		signinPage.Signin();
		
	}
	
	
	@AfterMethod 
	public void afterEachTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
