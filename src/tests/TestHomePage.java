package tests;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.HomePageConst;
import objects.Constants;
import objects.HomePage;

public class TestHomePage {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_91\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testAboutUs() {
		Constants.getHomePage(driver);
		try {
			HomePage.exitAnnouncment(driver);
			HomePage.clickAbouttUs(driver);
		} catch (NoSuchElementException e) {
			HomePage.clickAbouttUs(driver);
		}
		Constants.takeScreenShot(driver);

	}

	@Test(priority = 2)
	public void testLogIn() {

		Constants.getHomePage(driver);
		Constants.LogIn(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String actual = driver.getTitle().toString();
		String expected = "Dashboard - Dashboard - Humanity";

		Assert.assertEquals(actual, expected);
		driver.close();
	}

}
