package constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StaffPageConst {
	public static final String Staff_URL = "https://testuseritb.humanity.com/app/staff/list/load/true/";
	public static final String AddEmployees_xpath = "//*[@id=\"act_primary\"]";
	public static final String FirstName_id = "_asf1";
	public static final String FirstName_xpath = "//*[@id=\\\"_asf1\\\"]";
	public static final String LastName_id = "_asl1";
	public static final String Email_id = "_ase1";
	public static final String SaveNewEmployee_xpath = "//*[@id=\"_as_save_multiple\"]";

	public static final String AllStaff_css = "#StaffSchedules > ul.lMenuHolder > li:nth-child(1) > a";
	public static final String AllStaff_xpath = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
	
	public static final String AllStaff_class = "mi menu dent";
	public static final String SearchByName_xpath = "//*[@id=\"EmployeeStaffFilter\"]";
	public static final String SearchByName_id = "EmployeeStaffFilter";
	public static final String Employee_linkText = "testUser ITB";
	public static final String EditDetails_xpath = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String FirstNameInput_id = "first_name";
	public static final String SaveChanges_xpath = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[42]/td/input";
	public static final String SaveChanges_css = "#NewEmployeeForm > table > tbody > tr:nth-child(46) > td > input";

	//delete employees
	//public static final String AllStaff_xpath = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
	public static final String SelectAllEmployees = "//*[@id=\"staff-list-container\"]/div[1]/div/div[1]/span/input";
	public static final String BulkEditBTN_xpath ="//*[@id=\"_topnav\"]/button[2]";
	public static final String NextStepBTN_xpath = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div/form/button";
	public static final String MenageUserAcc_xpath = "//*[@id=\"manageAccount\"]/label/input";
	public static final String ConfirmBTN_xpath ="//*[@id=\"_cd_staff\"]/div[2]/div[2]/div/div/button";
	
	
public static void goToStaffPage (WebDriver driver) {
	driver.navigate().to(Staff_URL);
}
public static void addEmployee (WebDriver driver, String Fname, String Lname, String email) {
	driver.findElement(By.xpath(AddEmployees_xpath)).click();
	driver.findElement(By.id(FirstName_id)).sendKeys(Fname);
	driver.findElement(By.id(LastName_id)).sendKeys(Lname);
	driver.findElement(By.id(Email_id)).sendKeys(email);
	driver.findElement(By.xpath(SaveNewEmployee_xpath)).click();
}






}
