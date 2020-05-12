package com.OrangeHRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.base.TestBase;
import com.OrangeHRM.pages.EmployeeList;
import com.OrangeHRM.pages.EmployeePage;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.utility.TestUtil;
//import com.OrangeHRM.utility.TestUtil;

public class EmployeeListTest extends TestBase {
	
	public EmployeeListTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	EmployeePage employeePage;
	EmployeeList employeeList;
	
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		employeePage= new EmployeePage();
		employeeList= new EmployeeList();
		driver.navigate().refresh();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeePage = homepage.clickOnEmployeePageLink();
		employeeList = employeePage.clickOnEmployeelist();
		
	}
	
	@Test(priority=1)
	public void verifyemployeelistpageTest() {
		Assert.assertTrue(employeeList.verifyemployeelistpage());
	}
	
	@DataProvider(name="data-provider")
	public Object[][]getHRMTestData(){
		Object[][] data1 = TestUtil.getTestData(1);
		return data1;
	}
	
	@Test(priority=2,dataProvider="data-provider")
	public void addNewEmployeeTest(String FullName,String MiddlName,String LastName) {
		employeeList.addNewEmployee(FullName, MiddlName, LastName);
	}
	
@AfterMethod
public void tearDown() {
	driver.quit();
}

}
