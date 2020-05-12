package com.OrangeHRM.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(how= How.CSS,using ="input[id='txtUsername']")
	WebElement username;
	@FindBy(how = How.CSS,using="input[id='txtPassword']")
	WebElement password;
	@FindBy(xpath = "//div[@id='divLoginButton']/input")
	WebElement loginbtn;
	@FindBy(how = How.CSS,using="div[id='divLogo']>img")
	WebElement OrangeHRMimg;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public boolean validatelogo() {
		return OrangeHRMimg.isDisplayed();
	}
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public  HomePage login(String uname, String pswd) {
		
		username.sendKeys(uname);
		password.sendKeys(pswd);
		loginbtn.click();
		
		
		
		return new HomePage();
		
		
	}
	
	
}
