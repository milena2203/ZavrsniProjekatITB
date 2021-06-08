package objects;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.HomePageConst;

public class HomePage {

	public static void getHomePage(WebDriver driver) {
		driver.get(HomePageConst.HomePage_URL);
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}             //obrisati odavde

	public static void clickAbouttUs(WebDriver driver) {

		driver.findElement(By.xpath(HomePageConst.AboutUs_XPath)).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.partialLinkText(HomePageConst.AboutUs_Partial)).click();

	}

	public static void exitAnnouncment(WebDriver driver) {
		WebElement announcement = driver.findElement(By.xpath(HomePageConst.PopUp_XPATH));
		announcement.click();
	}

	public static void clickLogIn(WebDriver driver) {
		driver.findElement(By.xpath(HomePageConst.LogInbtn_XPATH)).click();
	}

	public static void inputUserName(WebDriver driver, String username) {
		driver.findElement(By.xpath(HomePageConst.Username_XPATH)).sendKeys(username);
	}

	public static void inputEmail(WebDriver driver, String email) {
		driver.findElement(By.xpath(HomePageConst.Username_XPATH)).sendKeys(email);
	}

	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(HomePageConst.Password_XPATH)).sendKeys(password);
	}

	public static void submit(WebDriver driver) {
		// driver.findElement(By.xpath(SubmitLogIn_XPATH)).click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement recaptcha = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")));

			driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath(HomePageConst.SubmitLogIn_XPATH)).click();
		} catch (TimeoutException a) {
			driver.findElement(By.xpath(HomePageConst.SubmitLogIn_XPATH)).click();
		}

	}

}
