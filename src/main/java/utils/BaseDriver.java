package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

	public static WebDriver driver;
	public static String path = System.getProperty("user.dir");

	public static WebDriver getDriverInstance() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");

			driver = new ChromeDriver();
			
		}
		return driver;
	}

}
