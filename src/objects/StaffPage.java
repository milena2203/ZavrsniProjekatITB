package objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import constants.StaffPageConst;

public class StaffPage {

	

	public static void AddEmployees(WebDriver driver, String Fname, String Lname, String email) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		StaffPageConst.goToStaffPage(driver);
		StaffPageConst.addEmployee(driver,Fname,Lname,email);		
	}

	public static void AddEmployeesFromList(WebDriver driver) {

		String FirstName_id = "_asf";
		String LastName_id = "_asl";
		String Email_id = "_ase";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(StaffPageConst.Staff_URL);
		driver.findElement(By.xpath(StaffPageConst.AddEmployees_xpath)).click();

		File f = new File("C:\\Users\\Milena\\Desktop\\zavrsniProjekatZaposleni.xlsx");
		try {
			InputStream is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			driver.navigate().to(StaffPageConst.Staff_URL);
			driver.findElement(By.xpath(StaffPageConst.AddEmployees_xpath)).click();
			for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
				Row row = sheet.getRow(i); // dohvatanje redova
				// for (int a = 0; a <sheet.getLastRowNum(); a++) {
				Cell cellName = row.getCell(0);
				String firstName = cellName.toString();
				driver.findElement(By.id((FirstName_id + (i + 1)).toString())).sendKeys(firstName);

				Cell cellLastName = row.getCell(1);
				String lastName = cellLastName.toString();
				driver.findElement(By.id((LastName_id + (i + 1)).toString())).sendKeys(lastName);

				Cell cellEmail = row.getCell(2);
				String email = cellEmail.toString();
				driver.findElement(By.id((Email_id + (i + 1)).toString())).sendKeys(email);
				// }
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			driver.findElement(By.xpath(StaffPageConst.SaveNewEmployee_xpath)).click();

		} catch (IOException e) {
			System.out.println("Odgovarajuci fajl nije pronadjen");
			e.printStackTrace();
		}
	}

	public static void CheckAddFromExcel(WebDriver driver) {
		
		driver.navigate().to(StaffPageConst.Staff_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(StaffPageConst.AllStaff_css)).click();
		File f = new File("C:\\Users\\Milena\\Desktop\\zavrsniProjekatZaposleni.xlsx");
		InputStream is;
		try {
			is = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			SoftAssert sa = new SoftAssert();
			for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {

				Row row = sheet.getRow(i);
				Cell cellEmail = row.getCell(2);
				String email = cellEmail.toString();
				sa.assertTrue(driver.getPageSource().contains(email));
				//Assert.assertTrue(driver.getPageSource().contains(email));
			}
			
			sa.assertAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void DeleteEmployee(WebDriver driver) {
		StaffPageConst.goToStaffPage(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.navigate().to(StaffPageConst.Staff_URL);
		driver.findElement(By.xpath(StaffPageConst.SelectAllEmployees)).click();
		driver.findElement(By.xpath(StaffPageConst.BulkEditBTN_xpath)).click();
		driver.findElement(By.xpath(StaffPageConst.MenageUserAcc_xpath)).click();
		driver.findElement(By.xpath(StaffPageConst.NextStepBTN_xpath)).click();
		driver.findElement(By.xpath(StaffPageConst.ConfirmBTN_xpath)).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		 Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); //press enter key
		  robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
		
	}

	public static boolean CheckEmployee(WebDriver driver, String Fname, String Lname) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(StaffPageConst.AllStaff_css)).click(); // all staff
		driver.findElement(By.xpath(StaffPageConst.SearchByName_xpath)).sendKeys(Fname);
		// driver.findElement(By.xpath("//*[@id=\"EmployeeStaffFilter\"]")).sendKeys(Keys.ENTER);
		StringBuilder str = new StringBuilder(Fname);
		str.append(" ");
		str.append(Lname);
		String string = str.toString();
		boolean a = driver.findElement(By.linkText(string)).isDisplayed();
		return a;
	}

	public static void ChangeEmployeeName(WebDriver driver, String FirstName, String LastName, String NewName) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(StaffPageConst.Staff_URL);
		driver.findElement(By.xpath(StaffPageConst.SearchByName_xpath)).sendKeys(FirstName);
		StringBuilder str = new StringBuilder(FirstName);
		str.append(" ");
		str.append(LastName);
		String stringemployee = str.toString();
		driver.findElement(By.linkText(stringemployee)).click();
		driver.findElement(By.xpath(StaffPageConst.EditDetails_xpath)).click();
		driver.findElement(By.id(StaffPageConst.FirstNameInput_id)).clear();
		driver.findElement(By.id(StaffPageConst.FirstNameInput_id)).sendKeys(NewName);
		driver.findElement(By.id(StaffPageConst.FirstNameInput_id)).sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath(SaveChanges_xpath)).click();
		// driver.findElement(By.cssSelector(SaveChanges_css)).click();
	}

	public static boolean CheckChangedName(WebDriver driver, String NewName, String LastName) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(StaffPageConst.AllStaff_css)).click(); // all staff
		driver.findElement(By.xpath(StaffPageConst.SearchByName_xpath)).sendKeys(NewName);
		StringBuilder str = new StringBuilder(NewName);
		str.append(" ");
		str.append(LastName);
		String string = str.toString();
		boolean a = driver.findElement(By.linkText(string)).isDisplayed();
		return a;
	}
	
	

}
