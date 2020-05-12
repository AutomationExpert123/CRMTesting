package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.OrangeHRM.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(how = How.XPATH,using = "//a[text()='Welcome Admin']")
	WebElement signInmsg;
	@FindBy(how = How.XPATH,using="//a[@id='menu_pim_viewPimModule']")
	WebElement employeepg;
	@FindBy(how = How.XPATH,using="//a[@id='menu_recruitment_viewRecruitmentModule']")
	WebElement recruitmentpg;
	@FindBy(how = How.XPATH, using = "//a[@id='menu_pim_viewEmployeeList']")
	public static WebElement verifyemployeepg;
	@FindBy(how = How.XPATH, using = "//a[@id='menu_recruitment_viewCandidates']")
	public static WebElement verifyrecruitmentpg;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyTitle() {
		 return driver.getTitle();
		
		
		}
	public Boolean verifyWelcomeMsg() {
		
		return signInmsg.isDisplayed();
		
	}
	public EmployeePage clickOnEmployeePageLink() {
		
		employeepg.click();
		return new EmployeePage();
	}

	public RecruitmentPage clickOnRecruitmentPageLink() {
		
		recruitmentpg.click();
		return new RecruitmentPage();
	}

}
