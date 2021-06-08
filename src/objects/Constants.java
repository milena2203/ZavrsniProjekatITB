package objects;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.HomePageConst;

public class Constants {
	public static WebDriver driver;
	public static String DriverLocation = "C:\\\\chromedriver_win32_91\\\\chromedriver.exe";
	public static final String DESTPATH = "C:/Users/Milena/Desktop/ssTest.png";

	
	
	public static void getHomePage(WebDriver driver) {
		driver.get(HomePageConst.HomePage_URL);
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void LogIn(WebDriver driver) {
		HomePage.getHomePage(driver);
		try {
			HomePage.exitAnnouncment(driver);
			HomePage.clickLogIn(driver);
		} catch (NoSuchElementException e) {
			HomePage.clickLogIn(driver);
		} catch (ElementNotInteractableException a) {
			HomePage.clickLogIn(driver);
		}
		HomePage.inputEmail(driver, HomePageConst.email);
		HomePage.inputPassword(driver, HomePageConst.password);
		HomePage.submit(driver);

	}

	// methods

	public static void takeScreenShot(WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(Constants.DESTPATH));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
