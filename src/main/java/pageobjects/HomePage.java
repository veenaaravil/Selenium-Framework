package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.api.logs.Logger;
import utils.AssertionClass;
import utils.BaseTest;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver) {
		BaseTest.driver = driver;
//		PageFactory.initElements(driver, this);

	}

	AssertionClass asc = new AssertionClass(BaseTest.driver);
	SignUpFormPage signuppage = PageFactory.initElements(BaseTest.driver, SignUpFormPage.class);
	ContactUsPage contactuspage = PageFactory.initElements(BaseTest.driver, ContactUsPage.class);


	@FindBy(css = "i[class='fa fa-home']")
	public WebElement homeIcon;
	@FindBy(css = "a[href='/products']")
	public WebElement productLink;
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart']/ancestor::a[@href='/view_cart']")
	public WebElement cartLink;
	@FindBy(css = "a[href='/contact_us']")
	public WebElement contactUsLink;
	@FindBy(xpath = "//i[@class='fa fa-list']/ancestor::a[@href='/test_cases']")
	public WebElement testcaseLink;
	@FindBy(css = "a[href='/login']")
	public WebElement loginLink;
	@FindBy(css = "a[href='/api_list']")
	public WebElement apiLink;
	@FindBy(css = "a[href='https://www.youtube.com/c/AutomationExercise']")
	public WebElement videoLink;
	// Images
	@FindBy(css = "img[src='/static/images/home/logo.png']")
	public WebElement homePageLogo;
	@FindBy(xpath = "//img[@src='/static/images/home/girl2.jpg']/ancestor::div[@class='col-sm-6']/preceding-sibling::div//h2")
	public WebElement fullFledgeText;
	@FindBy(css = "img[src='/static/images/home/girl1.jpg']")
	public WebElement girl1Img;
	@FindBy(css = "img[src='/static/images/home/girl2.jpg']")
	public WebElement girl2Img;
	@FindBy(css = "img[src='/static/images/home/girl3.jpg']")
	public WebElement girl3Img;
	@FindBy(css = "ul[class='nav navbar-nav'] > li > a")
	public List<WebElement> headerElements;
	// Scroll arrow
	@FindBy(xpath = "//a[@href='#slider-carousel']/i[@class='fa fa-angle-left']")
	public WebElement leftScroll;
	@FindBy(xpath = "//a[@href='#slider-carousel']/i[@class='fa fa-angle-right']")
	public WebElement rightScroll;
	@FindBy(css = "a[id='scrollUp'] i")
	public WebElement scrollUpIcon;
	@FindBy(css = "div[class='left-sidebar'] > h2")
	public WebElement category;
	@FindBy(css = "div[class='features_items'] > h2")
	public WebElement featured_items;
	@FindBy(css = "div[class='left-sidebar'] > div[class='brands_products'] > h2")
	public WebElement brands;
	@FindBy(css = "div[class='brands-name'] > ul > li > a ")
	public List<WebElement> brandnames;
	@FindBy(id = "susbscribe_email")
	public WebElement subscribe_email_textbox;
	@FindBy(id = "subscribe")
	public WebElement subscribe_btn;
	@FindBy(xpath = "//h2[text()='Subscription']")
	public WebElement subscription_text;
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	public WebElement subscriptionAlert;
	@FindBy(css = "div[id='dismiss-button'] > div > svg")
	public WebElement googleAddDismissBtn;

	// Header elements

	@FindBy(xpath = "//a[@href='/logout']")
	public WebElement logoutBtn;
	@FindBy(xpath = "//a[@href='/delete_account']")
	public WebElement deleteAccBtn;
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	public WebElement deleteAccSuccess;
	@FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
	public WebElement loggedinAsUser;

	public void validateHeaderElements() {
		System.out.println(driver.getTitle());

		for (WebElement header : headerElements) {

			if (header.getText().equals("Home")) {
				asc.innerTextEquals(header, "Home");

			}
			if (header.getText().equals("Products")) {
				asc.innerTextEquals(header, "Products");

			}
			if (header.getText().equals("Cart")) {
				asc.innerTextEquals(header, "Cart");

			}
			if (header.getText().equals("Signup / Login")) {
				asc.innerTextEquals(header, "Signup / Login");

			}
			if (header.getText().equals("Test Cases")) {
				asc.innerTextEquals(header, "Test Cases");

			}
			if (header.getText().equals("API Testing")) {
				asc.innerTextEquals(header, "API Testing");

			}
			if (header.getText().equals("Video Tutorials")) {
				asc.innerTextEquals(header, "Video Tutorials");

			}
			if (header.getText().equals("Contact us")) {
				asc.innerTextEquals(header, "Contact us");

			}

		}
	}

	public void validateHomePage() {
		asc.elementEnabledAndAvailable(homeIcon);
		String expectedUrl = "https://automationexercise.com/";
		asc.urlEquals(expectedUrl);

		String expectedTitle = "Automation Exercise";
		asc.titleEquals(expectedTitle);
	}

	public void validateFullyFledgeText() {
		WebElement actualfullFledgeText = fullFledgeText;
		String expectedfullFledgeText = "Full-Fledged practice website for Automation Engineers";
		asc.innerTextEquals(actualfullFledgeText, expectedfullFledgeText);
		asc.elementAvailable(fullFledgeText, true);
	}

	public void validateLeftArrow() {
		asc.elementEnabledAndAvailable(leftScroll);
	}

	public void validateRightArrow() {
		asc.elementEnabledAndAvailable(rightScroll);
	}

	public void validateGirlImages() {
		// Verify Left Arrow

		// Verify first girl image
		asc.elementEnabledAndAvailable(girl2Img);

		// Scroll to right
		elementClick(rightScroll);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Verify second girl image
		wait.until(ExpectedConditions.visibilityOf(girl1Img));
		asc.elementEnabledAndAvailable(girl1Img);

		// Scroll to right
		elementClick(rightScroll);

		// Verify third girl image
		wait.until(ExpectedConditions.visibilityOf(girl3Img));
		asc.elementEnabledAndAvailable(girl3Img);

	}

	public void validateSubscription() {

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Verify text "Subscription"
		WebElement actualSubscriptionText = subscription_text;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);

	}

	public void validateSrollUpArrow() {

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		asc.elementEnabledAndAvailable(scrollUpIcon);
		js.executeScript("window.scroll(0, -1000)");
	}

	// Logged in as user validation
	public void loggedInAsUser() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(loggedinAsUser));
		String expectedloggedinAsUserText = "Logged in as Veena";
		asc.innerTextEquals(loggedinAsUser, expectedloggedinAsUserText);
	}

	// Delete account
	public void deleteAccount() {
		// Delete account
		deleteAccBtn.click();
		String expectedDeleteAccText = "ACCOUNT DELETED!";
		asc.innerTextEquals(deleteAccSuccess, expectedDeleteAccText);
	}

	public void submitSubscription() {
		WebElement actualSubscriptionText = subscription_text;
		String expectedSubscriptionText = "SUBSCRIPTION";
		asc.innerTextEquals(actualSubscriptionText, expectedSubscriptionText);

		sendData(subscribe_email_textbox, readDataFromExcel(3, 3, filePath, sheetNameTest));
		elementClick(subscribe_btn);

		WebElement actualSubscriptionSuccess = subscriptionAlert;
		String expectedSubscriptionSuccess = "You have been successfully subscribed!";
		asc.innerTextEquals(actualSubscriptionSuccess, expectedSubscriptionSuccess);
	}
	
	public void submitContactUs() {
		
		// Click on contactus page
		elementClick(contactUsLink);
		
		// Close adds
		signuppage.closeAdd();

		// Submit contactus form
		contactuspage.submitContactUs();
		String url = driver.getCurrentUrl();
		if (url.equals("https://automationexercise.com/contact_us#google_vignette") == true) {
			signuppage.closeGoogleAdd();
			signuppage.closeGoogleAddDismissBtn();
		}
		

	}

}
