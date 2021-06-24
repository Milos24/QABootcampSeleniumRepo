package tests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestProject extends BaseTestsProject {

	@BeforeMethod 
	public void beforeEachTest() throws InterruptedException {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	
	}
	
	@Test (priority = 0)
	public void signinWIthValidCredentials () {
		String email = readFromExcel.getStringData("LOG IN", 7, 2);
		String password = readFromExcel.getStringData("LOG IN", 8, 2);

		logInForm(email, password);
		
		String textForAssertion = readFromExcel.getStringData("LOG IN", 10, 3);
		
		String actualText = myAccountPage.textSignOutButton();
		assertEquals(actualText, textForAssertion);
    
	}
		@Test (priority = 5)
	public void signinWithInvalidEmail () {
		String email = readFromExcel.getStringData("LOG IN", 13, 2);
		String password = readFromExcel.getStringData("LOG IN", 14, 2);

		logInForm(email, password);
		
		String textForAssertion = readFromExcel.getStringData("LOG IN", 16, 3);
		
		String actualText = signinPage.EmailErrorMessageText();
		assertEquals(actualText, textForAssertion);
	
	}
	@Test (priority = 10)
	public void signInWithInvalidPassword () {
		String email = readFromExcel.getStringData("LOG IN", 19, 2);
		String password = String.valueOf(readFromExcel.getIntegerData("LOG IN", 20, 2));
		
		logInForm(email, password);
		
		String textForAssertion = readFromExcel.getStringData("LOG IN", 22, 3);
		
		String actualText = signinPage.EmailErrorMessageText();
		assertEquals(actualText, textForAssertion);	
		
	}
	@Test (priority = 15)
	public void signInWithEmptyCredentials () {
		String textForAssertion = readFromExcel.getStringData("LOG IN", 28, 3);
		
		logInForm(" ", " ");
		
		String actualText = signinPage.EmptyFieldsErrorMessageText();
		assertEquals(actualText, textForAssertion);
	
	}
	@Test (priority = 20)
	public void SignOut () {
		signinWIthValidCredentials();
		myAccountPage.SignOutButtonClick();
		
        String textForAssertion = readFromExcel.getStringData("LOG IN", 35, 3);
		
		String actualText = firstPage.SignInButtonText();
		assertEquals(actualText, textForAssertion);
	}
	
	
		
	public void logInForm(String email, String password) {
		firstPage.EnterSigninPage();
		signinPage.InputEmailAddress(email);
		signinPage.InputPassword(password);
		signinPage.Signin();
		
	}
	
	
	
	
	@AfterMethod 
	public void afterEachTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
}
