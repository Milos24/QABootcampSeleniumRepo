package tests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTestProject extends BaseTestsProject {

		
	@BeforeMethod 
		public void beforeEachTest() throws InterruptedException {
			driver.navigate().to(homeURL);
			driver.manage().window().maximize();
		
		}
	
	@Test (priority = 0) 
	public void editPersonalInformation () throws InterruptedException  {
		logInForm();	
	    myAccountPage.MyPersonaLInfoClick();
	    myPersonalInfoPage.ChooseSocialTitle();
	    myPersonalInfoPage.getFirstName().clear();
	    myPersonalInfoPage.InputFirstName(readFromExcel.getStringData("MY PERSONAL INFO", 7, 2));
	    myPersonalInfoPage.getLastName().clear();
	    myPersonalInfoPage.InputLastName(readFromExcel.getStringData("MY PERSONAL INFO", 8, 2));
	    Thread.sleep(2000);
	    myPersonalInfoPage.SelectDayFromDropDownMenu(String.valueOf(readFromExcel.getIntegerData("MY PERSONAL INFO", 9, 2)));
	    Thread.sleep(2000);
	    //myPersonalInfoPage.SelectMonthFromDropDownMenu(readFromExcel.getStringData("MY PERSONAL INFO", 10, 2));
	    myPersonalInfoPage.SelectMonthFromDropDownMenu("1");
	    Thread.sleep(2000);
	    myPersonalInfoPage.SelectYearFromDropDownMenu(String.valueOf(readFromExcel.getIntegerData("MY PERSONAL INFO", 11, 2)));
	    Thread.sleep(2000);
	    myPersonalInfoPage.InputCurrentPassword(readFromExcel.getStringData("MY PERSONAL INFO", 12, 2));
	    
	    myPersonalInfoPage.SavePersonalInfo();
	    
	    String textForAssertion = readFromExcel.getStringData("MY PERSONAL INFO", 15, 3);
	    
	    String actualText = myPersonalInfoPage.UpdatedPersonalInfoMessageText();
	    assertEquals(actualText, textForAssertion);	
		
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
