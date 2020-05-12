package com.OrangeHRM.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.base.TestBase;
import com.OrangeHRM.pages.EmployeePage;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;

public class EmployeePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	EmployeePage employeePage;
	
	public EmployeePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		employeePage= new EmployeePage();
		driver.navigate().refresh();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeePage = homepage.clickOnEmployeePageLink();
		
		
	}
	@Test
	public void selectEmolyeeTest() throws InterruptedException {
		employeePage.selectEmolyee();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
