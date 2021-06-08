package constants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsConst {// Settings Page

	public static final String Settings_URL = "https://testuseritb.humanity.com/app/admin/settings/";
	public static final String SettingsBtn_id = "sn_admin";

	public static final String ChangeNameDrop_xpath = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String SaveSettingsBtn_xpath = "//*[@id=\"act_primary\"]";

	public static final String chatPopup_xpath = "//*[@id=\"intercom-container\"]/div/div/div/div/div/div[1]/button";
	public static final String NotifEmail_id = "pref_pref_email";
	public static final String NotifSMS_id = "pref_pref_sms";
	public static final String NotifMobilePush_id = "pref_pref_mobile_push";
	public static final String SaveSettings_id = "_save_settings_button";
	
	public static final String clickOnProfileIcon_id = "tr_avatar";
	public static final String Profile_xpath = "//*[@id=\"userm\"]/div/a[1]";
	public static final String Settings_xpath = "//*[@id=\"userm\"]/div/a[2]";
	
	public static final String izvestaju_xpath= "//*[@id=\"sn_reports\"]";
	
	public static void clickSettings(WebDriver driver) {
		driver.navigate().to(Settings_URL);
		try {
			driver.findElement(By.xpath(chatPopup_xpath)).click();
		} catch (NoSuchElementException e) {
			driver.navigate().to(Settings_URL);
		}

	}

	public static void skrollDownPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	
	public static void clickSaveSettings(WebDriver driver) {
		driver.findElement(By.id(SaveSettings_id)).click();
	}
	
}
