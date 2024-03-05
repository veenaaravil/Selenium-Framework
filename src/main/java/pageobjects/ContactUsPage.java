package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AssertionClass;
import utils.BaseTest;

public class ContactUsPage extends BaseTest {
	
	
	public ContactUsPage(WebDriver driver) {
		BaseTest.driver = driver;
//		PageFactory.initElements(driver, this);
	
	}
	
	//Import other class
	AssertionClass asc = new AssertionClass(BaseTest.driver);
	SignUpFormPage signuppage = PageFactory.initElements(BaseTest.driver, SignUpFormPage.class);
	
	@FindBy (xpath = "//h2[text()='Get In Touch']")public WebElement getInTouchText;
	@FindBy (name = "name")public WebElement name;
	@FindBy (name = "email")public WebElement email;
	@FindBy (name = "subject")public WebElement subject;
	@FindBy (id = "message")public WebElement message;
	@FindBy (name = "upload_file")public WebElement uploadFileBtn;
	@FindBy (name = "submit")public WebElement submitBtn;
	@FindBy (css = "div[class='status alert alert-success']")public WebElement successMsg;
	@FindBy (css = "a[class='btn btn-success']")public WebElement homeBtn;

	public void submitContactUs() {
		
		// Verify 'GET IN TOUCH' is visible
		WebElement actualgetInTouchText = getInTouchText;
		String expectedgetInTouchText = "GET IN TOUCH";
		asc.innerTextEquals(actualgetInTouchText, expectedgetInTouchText);
		
		signuppage.closeAdd();	
		sendData(name, readDataFromExcel(27, 2,filePath, sheetNameTest));
		sendData(email, readDataFromExcel(27, 3,filePath, sheetNameTest));
		sendData(subject, readDataFromExcel(27, 4,filePath, sheetNameTest));
		sendData(message, readDataFromExcel(27, 5,filePath, sheetNameTest));
		sendData(uploadFileBtn, readDataFromExcel(27, 6,filePath, sheetNameTest));
		elementClick(submitBtn);
		
		// Close the alert popup
		closeAlert();
		
		// Verify 'GET IN TOUCH' is visible
		String expectedContactFormSuccessText = "Success! Your details have been submitted successfully.";
		asc.innerTextEquals(successMsg, expectedContactFormSuccessText);
		
		// Click on home button
		elementClick(homeBtn);
	}
	

}
