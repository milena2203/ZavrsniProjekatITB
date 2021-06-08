package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Constants;
import objects.HumanityMenuPage;
import objects.StaffPage;

public class TestAddStaffFromExcel {
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", Constants.DriverLocation);
		driver = new ChromeDriver();
		
	}
	@Test (priority=1)
	public void TestAddStaffExcel () {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HumanityMenuPage.LogIn(driver);
		HumanityMenuPage.clickStaff(driver);
		StaffPage.AddEmployeesFromList(driver);
		HumanityMenuPage.clickStaff(driver);
		StaffPage.CheckAddFromExcel(driver);
		
	}
	
	@AfterClass
	public void TestDeleteStaff () {
		StaffPage.DeleteEmployee(driver);
		driver.close();
	}
}
