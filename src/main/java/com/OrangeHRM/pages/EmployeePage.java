package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.OrangeHRM.base.TestBase;

public class EmployeePage extends TestBase {
	@FindBy(css="input[id='ohrmList_chkSelectRecord_6']")
	WebElement selectEmployee1;
	
	@FindBy(css="input[id='ohrmList_chkSelectRecord_4']")
	WebElement selectEmployee2;
	
	@FindBy(css =".selected>a")
	WebElement employeelist;
	
	public EmployeePage() {
		PageFactory.initElements(driver, this);
	}
	

	public void selectEmolyee() {
		selectEmployee1.click();
		selectEmployee2.click();
		
	}
	public EmployeeList clickOnEmployeelist() {
		employeelist.click();
		return new EmployeeList();
	}
	

}
