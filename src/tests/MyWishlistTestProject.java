package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTestProject extends BaseTestsProject{

	@BeforeMethod 
	public void beforeEachTest() throws InterruptedException {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	
	}

	@Test (priority = 0)
	public void addWishlist () {
		logInForm();
		myAccountPage.MyWishlistClick();
		myWishlistPage.InputWishlistName(readFromExcel.getStringData("MY WISHLIST", 7, 2));
		myWishlistPage.SaveWishlist();
	
		//String textForAssertion = readFromExcel.getStringData("MY WISHLIST", 9, 3);
		
		//String text = myWishlistPage.MyWishlistNameDisplayed();
		//assertEquals(text, textForAssertion);
		
		boolean box = myWishlistPage.getWishlistBox().isDisplayed();
		assertEquals(box, true);
		
	} 


	@Test (priority = 1)
	public void addMultipleWishlist () {
		logInForm();
		myAccountPage.MyWishlistClick();

		int i = 12; 
			while (i < 15) {
			myWishlistPage.InputWishlistName(readFromExcel.getStringData("MY WISHLIST", i, 2));
			myWishlistPage.SaveWishlist();
			i = i + 2;	
		}
	
		List<WebElement> listOfMyWishlists = myWishlistPage.getMyWishLists();
		int actualNumberOfMyWishlists = listOfMyWishlists.size();
		assertEquals(actualNumberOfMyWishlists, 3);
	}
	
	
		
	@Test (priority = 2)
	public void deleteWishlist () {
		logInForm();
		
		List<WebElement> listOfMyWishlists = myWishlistPage.getMyWishLists();
		int numberOfMyWishlists = listOfMyWishlists.size();
		myWishlistPage.DeleteWishlist();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		int numberOfMyWishlistsAfterDeleting = listOfMyWishlists.size();
		assertEquals(numberOfMyWishlistsAfterDeleting, numberOfMyWishlists - 1);
		
	
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

