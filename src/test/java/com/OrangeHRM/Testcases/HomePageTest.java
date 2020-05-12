package com.OrangeHRM.Testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.base.TestBase;
import com.OrangeHRM.pages.EmployeePage;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.pages.RecruitmentPage;

public class HomePageTest extends TestBase {

	

	public HomePageTest() {
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	EmployeePage employeePage;
	RecruitmentPage recruitmentPage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		employeePage= new EmployeePage();
		recruitmentPage = new RecruitmentPage();
		driver.navigate().refresh();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyTitleTest()  {
		String title = homepage.verifyTitle();
	
		
		Assert.assertEquals(title, "OrangeHRM");

	}

	@Test(priority=2)
	public void verifyWelcomeMsgTest() {
		Boolean flag = homepage.verifyWelcomeMsg();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void clickOnEmployeePageLinkTest() {
		employeePage = homepage.clickOnEmployeePageLink();
		Assert.assertTrue(HomePage.verifyemployeepg.isDisplayed());
	}
	@Test(priority=4)
	public void clickOnRecruitmentPageLink() {
		recruitmentPage = homepage.clickOnRecruitmentPageLink();
	Assert.assertTrue(HomePage.verifyrecruitmentpg.isDisplayed());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
