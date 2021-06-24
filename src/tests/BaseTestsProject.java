package tests;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.FirstPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInfoPage;
import pages.MyWishlistsPage;
import pages.SigninPage;

public class BaseTestsProject { 
		
	WebDriver driver;
	FirstPage firstPage;
	SigninPage signinPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	MyPersonalInfoPage myPersonalInfoPage;
	MyWishlistsPage myWishlistPage;
	
	ExcelReader readFromExcel;	
	String homeURL;
		
		@BeforeClass
		public void beforeAllTests() throws IOException {
			System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			firstPage = new FirstPage(driver);
			signinPage = new SigninPage(driver);
			myAccountPage = new MyAccountPage(driver);
			myAddressesPage = new MyAddressesPage(driver);
			myPersonalInfoPage = new MyPersonalInfoPage(driver);
			myWishlistPage = new MyWishlistsPage(driver);
			
			readFromExcel = new ExcelReader("data/QAProjekatAutomationTest.xlsx");
			homeURL = "http://automationpractice.com/";
		
		}
		
		@AfterClass
		public void afterAllTests() {
			driver.close();
		}
	}


