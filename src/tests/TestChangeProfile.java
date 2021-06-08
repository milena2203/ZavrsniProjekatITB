package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.SettingsConst;
import objects.Constants;
import objects.HomePage;
import objects.HumanityMenuPage;
import objects.SettingsPage;

public class TestChangeProfile {
	public static WebDriver driver;
	public static final String PayType_xpath = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[18]/td[2]/select";
	public static final String SaveEmployee_xpath = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[42]/td/input";

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_91\\chromedriver.exe");
		driver = new ChromeDriver();
		// HomePage.getHomePage(driver);
		// HumanityMenuPage.LogIn(driver);
		Constants.getHomePage(driver);
		Constants.LogIn(driver);

	}

	@Test
	public void TestChangeProfileSettings() {
		SettingsPage.changeProfileSettings(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String hourlyRate = "70";
		driver.findElement(By.id("wage")).clear();
		driver.findElement(By.id("wage")).sendKeys(hourlyRate);
		driver.findElement(By.id("eid")).clear();
		driver.findElement(By.id("eid")).sendKeys("777555");

		Select payType = new Select(driver.findElement(By.xpath(PayType_xpath)));

		payType.selectByIndex(1);

		driver.findElement(By.xpath(SaveEmployee_xpath)).click();
	}
}
