package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import constants.SettingsConst;

public class SettingsPage {

	public static void ChangeLanguage(WebDriver driver) {
		driver.navigate().to(SettingsConst.Settings_URL);
		driver.findElement(By.id(SettingsConst.SettingsBtn_id)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.name("language")).click();
		Select select = new Select(driver.findElement(By.name("language")));
		select.selectByVisibleText("Croatian (machine)");
		driver.findElement(By.name("language")).submit();

		driver.findElement(By.xpath(SettingsConst.SaveSettingsBtn_xpath)).click();
		driver.navigate().refresh();
	}

	public static void DefaultLanguage(WebDriver driver) {
		SettingsConst.clickSettings(driver);
		// driver.findElement(By.id(SettingsConst.SettingsBtn_id)).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.name("language")).click();
		Select select = new Select(driver.findElement(By.name("language")));
		select.selectByVisibleText("American English");
		driver.findElement(By.name("language")).submit();

		driver.findElement(By.xpath(SettingsConst.SaveSettingsBtn_xpath)).click();
		driver.navigate().refresh();
	}

	public static void changeNotifEmail(WebDriver driver) {
		WebElement checkbox = driver.findElement(By.id(SettingsConst.NotifEmail_id));
		checkbox.click();
	}

	public static void changeNotifMobilePush(WebDriver driver) {
		WebElement checkbox = driver.findElement(By.id(SettingsConst.NotifMobilePush_id));
		checkbox.click();
	}

	public static void changeNotifSMS(WebDriver driver) {
		WebElement checkbox = driver.findElement(By.id(SettingsConst.NotifSMS_id));
		checkbox.click();
	}

	public static void checkCheckbox(WebDriver driver) {
		SettingsConst.clickSettings(driver);
		SettingsConst.skrollDownPage(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		SoftAssert sa = new SoftAssert();

		Assert.assertFalse(driver.findElement(By.id(SettingsConst.NotifEmail_id)).isSelected());
		Assert.assertFalse(driver.findElement(By.id(SettingsConst.NotifSMS_id)).isSelected());
		Assert.assertFalse(driver.findElement(By.id(SettingsConst.NotifMobilePush_id)).isSelected());
		sa.assertAll();
	}
	
	public static void changeProfileSettings (WebDriver driver) {
		SettingsConst.clickSettings(driver);
		driver.findElement(By.id(SettingsConst.clickOnProfileIcon_id)).click();
		driver.findElement(By.xpath(SettingsConst.Settings_xpath)).click();
		
	}

}
