package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.HumanityMenuPage;
import objects.StaffPage;

public class TestStaff {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32_91\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void TestAddStaff() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HumanityMenuPage.LogIn(driver);
		HumanityMenuPage.clickStaff(driver);

		String Fname = "Petar";
		String Lname = "drugi";
		String email = "petarprvi@email.com";
		StaffPage.AddEmployees(driver, Fname, Lname, email);

		boolean expected = true;
		boolean actual = StaffPage.CheckEmployee(driver, Fname, Lname);
		Assert.assertEquals(actual, expected);
		// driver.close();
	}

	@Test(priority = 2)
	public void TestChangeStaffName() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String Fname = "Petar";
		String Lname = "drugi";
		String newName = "dragan";
		StaffPage.ChangeEmployeeName(driver, Fname, Lname, newName);
		// StaffPage.CheckChangedName(driver, "Petar", "Peric", "Petar");

		boolean expected = true;
		boolean actual = StaffPage.CheckChangedName(driver, newName, Lname);
		Assert.assertEquals(actual, expected);
		//driver.close();
	}
	@AfterClass
	public void TestDeleteStaff () {
		StaffPage.DeleteEmployee(driver);
		driver.close();
	}
}
