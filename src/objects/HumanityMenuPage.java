package objects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.HomePageConst;
import constants.HumanityMenuConst;

public class HumanityMenuPage {


	public static void LogIn(WebDriver driver) {
		HomePage.getHomePage(driver);
		try {//driver.findElement(By.xpath(HomePageConst.PopUp_XPATH)).click();
			HomePage.exitAnnouncment(driver);
			HomePage.clickLogIn(driver);
		} catch (NoSuchElementException e) {
			HomePage.clickLogIn(driver);
		}catch (ElementNotInteractableException a) {
			HomePage.clickLogIn(driver);
		}
		HomePage.inputEmail(driver, HomePageConst.email);
		HomePage.inputPassword(driver, HomePageConst.password);
		HomePage.submit(driver);

	}

	public static void clickDashboard(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Dashboard_id)).click();
	}

	public static void clickShiftPlanning(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.ShiftPlan_id)).click();

	}

	public static void clickTimeClock(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.TimeClock_id)).click();
	}

	public static void clickLeave(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Leave_id)).click();
	}
	public static void clickTraining(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Training_id)).click();
	}
	public static void clickStaff(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Staff_id)).click();
	}
	public static void clickAvailability(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Availability_id)).click();
	}
	public static void clickPayroll(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Payroll_id)).click();
	}
	public static void clickReports(WebDriver driver) {
		driver.findElement(By.id(HumanityMenuConst.Reports_id)).click();
	}
	
}
