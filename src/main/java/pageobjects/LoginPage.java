package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AssertionClass;
import utils.BaseTest;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver driver) {
		BaseTest.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	AssertionClass asc = new AssertionClass(BaseTest.driver);
	HomePage homepage = PageFactory.initElements(BaseTest.driver, HomePage.class);
	SignUpFormPage signuppage = PageFactory.initElements(BaseTest.driver, SignUpFormPage.class);

	@FindBy(xpath = "//a[@href='/login']")
	public WebElement loginTab;
	@FindBy(css = "div[class='signup-form'] > h2")
	public WebElement signupFormTitle;
	@FindBy(css = "input[placeholder='Name']")
	public WebElement name;
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	public WebElement newUserSignUpText;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement signUpEmail;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	public WebElement signUpBtn;
	@FindBy(xpath = "//h2[text()='Login to your account']")
	public WebElement loginToAccountText;
	@FindBy(xpath = "//input[@data-qa='login-email']")
	public WebElement loginEmail;
	@FindBy(xpath = "//input[@data-qa='login-password']")
	public WebElement loginPwd;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	public WebElement loginBtn;
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	public WebElement incorrectEmailOrPwd;
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	public WebElement existingEmailError;

	// New user Signup
	public void signUp(String username, String email) {
		String expectedNewUserText = "New User Signup!";
		asc.innerTextEquals(newUserSignUpText, expectedNewUserText);
		sendData(name, username);
		// signUpEmail.sendKeys(getRandomEmail()+"@d3.com");
		sendData(signUpEmail, email);
		elementClick(signUpBtn);
	}

	// Login as user
	public void login(String email, String password) {
		String expectedLoginTitleText = "Login to your account";
		asc.innerTextEquals(loginToAccountText, expectedLoginTitleText);
		sendData(loginEmail, email);
		sendData(loginPwd, password);
		elementClick(loginBtn);

	}

	// Register user
	public void registerUser() {

		// Validate homepage is sucessfully loaded
		elementClick(loginTab);

		signUp(readDataFromExcel(3, 2, filePath, sheetNameTest), readDataFromExcel(3, 3, filePath, sheetNameTest));
		signuppage.submitSignUpForm();
		homepage.loggedInAsUser();

		homepage.deleteAccount();
		signuppage.clickContinueBtn();
	}
	
	public void validLogin() {

		// Go to login page
		elementClick(loginTab);

		// Login with valid email and password
		login(readDataFromExcel(3, 3, filePath, sheetNameTest), readDataFromExcel(9, 3, filePath, sheetNameTest));
		homepage.loggedInAsUser();

		// Delete account
		homepage.deleteAccount();
	}
	
	public void invalidLogin() {
		// Go to login page
		elementClick(loginTab);

		// Login with invalid email and password
		login(readDataFromExcel(20, 2, filePath, sheetNameTest),
				readDataFromExcel(20, 3, filePath, sheetNameTest));

		WebElement actualWrongEmail = incorrectEmailOrPwd;
		String expectedWrongEmailText = "Your email or password is incorrect!";
		asc.innerTextEquals(actualWrongEmail, expectedWrongEmailText);
	}
	
	public void logout() {
		// Go to login page
		elementClick(loginTab);

		// Login with valid email and password
		login(readDataFromExcel(3, 3, filePath, sheetNameTest), readDataFromExcel(9, 3, filePath, sheetNameTest));
		homepage.loggedInAsUser();

		// Logout user
		elementClick(homepage.logoutBtn);

		String loginUrl = "https://automationexercise.com/login";
		asc.urlEquals(loginUrl);
		String expectedLoginTitle = "Automation Exercise - Signup / Login";
		asc.titleEquals(expectedLoginTitle);
	}
	
	public void registerUserWithExistingAccount() {
		// Go to login page
//		elementClick(loginTab);
		signUp(readDataFromExcel(3, 2, filePath, sheetNameTest),
				readDataFromExcel(3, 3, filePath, sheetNameTest));

		WebElement actualEmailExistingError = existingEmailError;
		String expectedEmailExistingError = "Email Address already exist!";
		asc.innerTextEquals(actualEmailExistingError, expectedEmailExistingError);
	}

}
