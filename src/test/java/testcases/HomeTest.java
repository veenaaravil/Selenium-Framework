package testcases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.AssertionClass;
import utils.BaseTest;
import pageobjects.BasePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class HomeTest extends BaseTest {
	ExtentReports extent;

	AssertionClass asc = new AssertionClass(BaseTest.driver);

//	BasePage basepage = new BasePage(BaseTest.driver);
	HomePage homepage = PageFactory.initElements(BaseTest.driver, HomePage.class);
	LoginPage loginpage = PageFactory.initElements(BaseTest.driver, LoginPage.class);

	@BeforeTest
	public void setup() {
		launchApp();
		
	}

	@Test(priority = 0, description = "TestCase#1: Validate HomePage Logo")
	public void validateHomePageLogo() {
		homepage.validateHomePage();
	}

	@Test(priority = 1, description = "TestCase#2: Validate HomePage Header Elements")
	public void validateHeaders() {
		homepage.validateHeaderElements();
	}

	@Test(priority = 2, description = "TestCase#3: Validate Fully Fledge Text")
	public void verifyFullFledgeText() {
		// Verify Home Page Logo
		homepage.validateFullyFledgeText();

	}

	@Test(priority = 3, description = "TestCase#4: Verify Left Arrow slider")

	public void verifyLeftArrow() {
		// Verify Left Arrow
		homepage.validateLeftArrow();

	}

	@Test(priority = 4, description = "TestCase#5: Verify Right Arrow slider")

	public void verifyRightArrow() {
		// Verify Left Arrow
		homepage.validateRightArrow();

	}

	@Test(priority = 5, description = "TestCase#6: Verify Girls Images")

	public void verifyGirlImages() {
		// Verify homepage girl images
		homepage.validateGirlImages();

	}

	@Test(priority = 6, description = "TestCase#7: Verify Subscription Text box")
	public void verifySubscription() {
		// Verify text "Subscription"
		homepage.validateSubscription();
	}

	@Test(priority = 7, description = "TestCase#8: Verify Scroll Up Arrow")
	public void verifySrollUpArrow() {

		// Verify scroll up Arrow	
		homepage.validateSrollUpArrow();	
	}

	@AfterTest
	public void teardown() {
		closeApp();
	}

}
