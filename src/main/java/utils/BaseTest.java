package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends BaseDriver{	
	
	public static WebDriver driver = getDriverInstance();

	// Creating constant global variables
	public static String path = System.getProperty("user.dir");
	public static final String filePath = path + "/src/test/java/testdata/AutomationProjectTestData.xlsx";
	public static final String sheetName = "Generic";
	public static final String sheetNameTest = "UserSignup";
	

	// Method to launch application
	public void launchApp() {
		Reporter.log("=====Browser Session Started=====", true);		

		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().deleteAllCookies();
	}

	// Method to close the browser instance
	public void closeApp() {
		driver.close();
		Reporter.log("=====Browser Session End=====", true);
	}

	// Method to close alert
	public void closeAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// Random email generator
	public String getRandomEmail() {
		String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder s2 = new StringBuilder();
		Random rnd = new Random();
		while (s2.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * s1.length());
			s2.append(s1.charAt(index));
		}
		String emailStr = s2.toString();
		return emailStr;
	}

	// Method to Import Select class to handle drop down
	public void selectElement(WebElement el, String val) {
		Select sel = new Select(el);
		sel.selectByValue(val);
	}

	public void selectByText(WebElement el, String val) {
		Select sel = new Select(el);
		sel.selectByVisibleText(val);
	}
	
	public void elementClick(WebElement el) {
		el.click();
	}
	
	public void sendData(WebElement el, String text) {
		el.sendKeys(text);
	}
	
	public void switchToFrame(WebElement el) {
		driver.switchTo().frame(el);
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	// Take screenshot
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File file = new File(path + "//reports//" +testcasename+ ".png");
		
		Files.copy(f, file);
		return path + "//reports//" +testcasename+ ".png";
		
	}

	// Import workbook to get the data from the excel
	public String readDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname) {
		String data = null;
		try {
			FileInputStream input = new FileInputStream(filepath);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowcount);
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(row.getCell(columncount));
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
}
