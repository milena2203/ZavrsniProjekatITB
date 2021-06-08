package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.HumanityMenuConst;
import objects.Constants;
import objects.HomePage;
import objects.HumanityMenuPage;

public class TestMenuBar {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", Constants.DriverLocation);
		driver = new ChromeDriver();
		Constants.getHomePage(driver);
		Constants.LogIn(driver);
	}

	@Test
	public void TestMenu() {
		// HumanityMenuPage.LogIn(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		List<String> ids = new ArrayList<String>();

		ids.add(HumanityMenuConst.Dashboard_id);
		ids.add(HumanityMenuConst.ShiftPlan_id);
		ids.add(HumanityMenuConst.TimeClock_id);
		ids.add(HumanityMenuConst.Leave_id);
		ids.add(HumanityMenuConst.Training_id);
		ids.add(HumanityMenuConst.Staff_id);
		ids.add(HumanityMenuConst.Payroll_id);
		ids.add(HumanityMenuConst.Reports_id);
		ids.add(HumanityMenuConst.Availability_id);

		List<String> expected = new ArrayList<String>();

		expected.add(HumanityMenuConst.Dashboard_URL);
		expected.add(HumanityMenuConst.ShiftPlan_URL);
		expected.add(HumanityMenuConst.TimeClock_URL);
		expected.add(HumanityMenuConst.Leave_URL);
		expected.add(HumanityMenuConst.Training_URL);
		expected.add(HumanityMenuConst.Staff_URL);
		expected.add(HumanityMenuConst.Payroll_URL);
		expected.add(HumanityMenuConst.Reports_URL);
		expected.add(HumanityMenuConst.Availability_URL);
		SoftAssert sa = new SoftAssert();

		for (int i = 0; i < expected.size(); i++) {

			driver.findElement(By.id(ids.get(i).toString())).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			String actual = driver.getCurrentUrl().toString();
			String exp = expected.get(i).toString();
			sa.assertTrue(actual.contains(exp));

		}
		sa.assertAll();
		driver.close();
	}

}
