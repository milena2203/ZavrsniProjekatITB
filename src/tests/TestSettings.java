package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.SettingsConst;
import objects.HomePage;
import objects.HumanityMenuPage;
import objects.SettingsPage;
import objects.StaffPage;

public class TestSettings {
	public static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_91\\chromedriver.exe");
		driver = new ChromeDriver();
		HomePage.getHomePage(driver);
		HumanityMenuPage.LogIn(driver);

	}

	@Test(priority = 1)
	public void TestChangeLanguage() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// HumanityMenuPage.LogIn(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		SettingsPage.ChangeLanguage(driver);
		SettingsConst.clickSaveSettings(driver);

		String a = driver.findElement(By.xpath(SettingsConst.izvestaju_xpath)).getText();
		Assert.assertEquals("Izvješća", a);
	}

	@Test(priority = 2)
	public void TestNotificationCheckbox() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		SettingsConst.clickSettings(driver);
		SettingsConst.skrollDownPage(driver);
		SettingsPage.changeNotifEmail(driver);
		SettingsPage.changeNotifSMS(driver);
		SettingsPage.changeNotifMobilePush(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		SettingsConst.clickSaveSettings(driver);
		SettingsPage.checkCheckbox(driver);
	}

	@AfterClass
	public void TestDefaultLenguage() {
		SettingsPage.DefaultLanguage(driver);
		SettingsConst.clickSaveSettings(driver);
		driver.close();
	}

}
