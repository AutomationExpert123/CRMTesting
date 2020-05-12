package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.OrangeHRM.base.TestBase;

public class EmployeeList extends TestBase  {
	
@FindBy(css ="#firstName")
WebElement frstName;
@FindBy(css ="#middleName")
WebElement mdlename;
@FindBy(css ="#lastName")
WebElement lstName;
@FindBy(css ="#btnSave")
WebElement savebtn;
@FindBy(css =".selected>a")
WebElement employeelist;




public EmployeeList() {
	PageFactory.initElements(driver, this);
}



public boolean verifyemployeelistpage() {
	return employeelist.isDisplayed();
}


public  void addNewEmployee(String FullName,String MiddlName,String LastName){
	
	frstName.sendKeys(FullName);
	mdlename.sendKeys(MiddlName);
	lstName.sendKeys(LastName);
	savebtn.click();
	
	}
}
