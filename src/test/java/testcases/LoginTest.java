package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignUpFormPage;
import utils.AssertionClass;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	AssertionClass asc = new AssertionClass(BaseTest.driver);

	HomePage homepage = PageFactory.initElements(BaseTest.driver, HomePage.class);
	LoginPage loginpage = PageFactory.initElements(BaseTest.driver, LoginPage.class);
	SignUpFormPage signuppage = PageFactory.initElements(BaseTest.driver, SignUpFormPage.class);
	
	
	
	@Test(priority = 0, description = "TestCase#1: Register User")
	public void registerUsers() {

		// Validate homepage is sucessfully loaded.
		loginpage.registerUser();
	}

	@Test(priority = 1, description = "TestCase#2: Login User with correct email and password")
	public void loginUserWithValidEmail() {

		loginpage.validLogin();
	}
	
	@Test(priority = 2, description = "TestCase#3: Login User with incorrect email and password")
	public void loginUserWithInvalidEmailAndPassword() {
	
		// Login with invalid email and password
		loginpage.invalidLogin();
	
	}

	@Test(priority = 3, description = "TestCase#4: Logout User")
	public void logoutUser() {
		// Logout user
		loginpage.logout();
		
	}

	@Test(priority = 4, description = "TestCase#5: Register User with existing email")
	public void registerUserWithExistingEmail() {
		
		// Register user with existing account
		loginpage.registerUserWithExistingAccount();
		
	}

	@Test(priority = 5, description = "TestCase#6: Submit Contact Us Form")
	public void submitContactUsForm() {
		
		// Submit contactus form
		homepage.submitContactUs();
		

	}
	
	@Test(priority = 6, description = "TestCase#7: Verify Subscription in home page")
	public void verifySubscriptionInHome() {
		
		// Verify text "Subscription"
		homepage.submitSubscription();
	
	}
	

}
