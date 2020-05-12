package com.OrangeHRM.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.base.TestBase;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
	}

	@Test(priority=1)
	public void validateTitleTest() {
		String title = loginpage.validateTitle();
		Boolean flag = title.contains("Orange");
		Assert.assertTrue(flag);
	}

	@Test(priority=2)
	public void validatelogoTest() {

		Boolean flag = loginpage.validatelogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()  {
		driver.navigate().refresh();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
