package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AssertionClass;
import utils.BaseTest;

public class SignUpFormPage extends BaseTest {

	public SignUpFormPage(WebDriver driver) {
		BaseTest.driver = driver;
	}

	AssertionClass asc = new AssertionClass(BaseTest.driver);

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	public WebElement enterAccInfoText;
	@FindBy(id = "id_gender1")
	public WebElement maleRdBtn;
	@FindBy(id = "id_gender2")
	public WebElement femaleRdBtn;
	@FindBy(name = "name")
	public WebElement nameForm;
	@FindBy(id = "password")
	public WebElement password;
	// Date of birth
	@FindBy(id = "days")
	public WebElement day;
	@FindBy(id = "months")
	public WebElement month;
	@FindBy(id = "years")
	public WebElement year;
	@FindBy(id = "newsletter")
	public WebElement newsletterCheckbox;
	@FindBy(id = "optin")
	public WebElement offersCheckbox;

	// Address Information
	@FindBy(xpath = "//b[text()='Address Information']")
	public WebElement addInfo;
	@FindBy(id = "first_name")
	public WebElement fname;
	@FindBy(id = "last_name")
	public WebElement lname;
	@FindBy(id = "company")
	public WebElement company;
	@FindBy(id = "address1")
	public WebElement address;
	@FindBy(id = "address2")
	public WebElement address2;
	@FindBy(id = "country")
	public WebElement country;
	@FindBy(id = "state")
	public WebElement state;
	@FindBy(id = "city")
	public WebElement city;
	@FindBy(id = "zipcode")
	public WebElement zipcode;
	@FindBy(id = "mobile_number")
	public WebElement mobile_number;
	@FindBy(xpath = "//button[text()='Create Account']")
	public WebElement createAccBtn;
	@FindBy(xpath = "//b[text()='Account Created!']")
	public WebElement accCreatedSuccess;
	@FindBy(xpath = "//a[text()='Continue']")
	public WebElement continueBtn;

	// Frame
	@FindBy(id = "aswift_0")
	public WebElement frameId0;
	@FindBy(id = "aswift_1")
	public WebElement frameId1;
	@FindBy(id = "aswift_2")
	public WebElement frameId2;
	@FindBy(id = "aswift_3")
	public WebElement frameId3;
	@FindBy(id = "aswift_4")
	public WebElement frameId4;
	@FindBy(id = "aswift_5")
	public WebElement frameId5;
	@FindBy(id = "aswift_6")
	public WebElement frameId6;
	@FindBy(id = "aswift_7")
	public WebElement frameId7;

	// Add Close button
	@FindBy(css = "path[d='M3.25,3.25l8.5,8.5M11.75,3.25l-8.5,8.5']")
	public WebElement addCloseBtn;
	@FindBy(id = "report_text")
	public WebElement stopSeeingAdd;
	@FindBy(xpath = "//span[text()='Not interested in this ad']")
	public WebElement notInterestedAdd;

	// Close add after continue button
	@FindBy(xpath = "//iframe[@id='ad_iframe' and @title='Advertisement']")
	public WebElement googleAddIframe;
	@FindBy(css = "path[d='M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z']")
	public WebElement googleAddClose;
	@FindBy(xpath = "//div[@id='dismiss-button']/div/span")
	public WebElement googleAddDismiss;
	@FindBy(xpath = "//span[text()='Close']")
	public WebElement gAddClose;
	@FindBy(id = "google_esf")
	public WebElement googleEsfAdd;

	public void closeAdd() {
		try {
			if (googleEsfAdd.isDisplayed()) {
				switchToFrame(googleEsfAdd);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId0.isDisplayed()) {
				switchToFrame(frameId0);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId1.isDisplayed()) {
				switchToFrame(frameId1);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId2.isDisplayed()) {
				switchToFrame(frameId2);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId3.isDisplayed()) {
				switchToFrame(frameId3);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId4.isDisplayed()) {
				switchToFrame(frameId4);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId5.isDisplayed()) {
				switchToFrame(frameId5);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			if (frameId6.isDisplayed()) {
				switchToFrame(frameId6);
				elementClick(addCloseBtn);
				elementClick(stopSeeingAdd);
				elementClick(notInterestedAdd);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}

	}

	public void closeGoogleAdd() {
		try {
			switchToFrame(googleAddIframe);
			elementClick(googleAddClose);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(googleEsfAdd);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId0);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId1);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId2);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId3);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId4);
			elementClick(googleAddClose);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId5);
			elementClick(googleAddClose);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId6);
			elementClick(googleAddClose);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
	}

	public void closeGoogleAddDismissBtn() {
		try {
			switchToFrame(googleAddIframe);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(googleEsfAdd);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId0);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId1);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId2);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId3);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId4);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId5);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
		try {
			switchToFrame(frameId6);
			elementClick(googleAddDismiss);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
	}

	// Validate home page

	public void submitSignUpForm() {
		String enterAccTitle = "ENTER ACCOUNT INFORMATION";
		asc.innerTextEquals(enterAccInfoText, enterAccTitle);

		// Submit form
		elementClick(femaleRdBtn);
		nameForm.clear();
		sendData(nameForm, readDataFromExcel(9, 2, filePath, sheetNameTest));
		sendData(password, readDataFromExcel(9, 3, filePath, sheetNameTest));

		// Close Add
		closeAdd();

		selectElement(day, readDataFromExcel(9, 4, filePath, sheetNameTest));
		selectByText(month, readDataFromExcel(9, 5, filePath, sheetNameTest));
		selectElement(year, readDataFromExcel(9, 6, filePath, sheetNameTest));

		// Close Add
		closeAdd();

		elementClick(newsletterCheckbox);
		elementClick(offersCheckbox);

		// Fill address details and create account

		sendData(fname, readDataFromExcel(15, 2, filePath, sheetNameTest));
		sendData(lname, readDataFromExcel(15, 3, filePath, sheetNameTest));
		sendData(company, readDataFromExcel(15, 4, filePath, sheetNameTest));
		sendData(address, readDataFromExcel(15, 5, filePath, sheetNameTest));
		sendData(address2, readDataFromExcel(15, 6, filePath, sheetNameTest));

		selectElement(country, readDataFromExcel(15, 7, filePath, sheetNameTest));
		sendData(state, readDataFromExcel(15, 8, filePath, sheetNameTest));
		sendData(city, readDataFromExcel(15, 9, filePath, sheetNameTest));
		sendData(zipcode, readDataFromExcel(15, 10, filePath, sheetNameTest));
		sendData(mobile_number, readDataFromExcel(15, 11, filePath, sheetNameTest));
		elementClick(createAccBtn);

		String expectedAccCreatedText = "ACCOUNT CREATED!";
		asc.innerTextEquals(accCreatedSuccess, expectedAccCreatedText);

		elementClick(continueBtn);
		String addexpectedUrl = "https://automationexercise.com/account_created#google_vignette";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.urlToBe(addexpectedUrl));
			wait.until(ExpectedConditions.visibilityOf(googleAddIframe));
			switchToFrame(googleAddIframe);
			wait.until(ExpectedConditions.elementToBeClickable(googleAddClose)).click();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			switchToDefaultContent();
		}
	}

	// Click continue button
	public void clickContinueBtn() {
		try {
			elementClick(continueBtn);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
