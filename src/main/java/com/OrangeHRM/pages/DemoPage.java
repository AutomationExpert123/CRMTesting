package com.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;

public class DemoPage {
	WebDriver driver;
	
	public DemoPage(WebDriver driver) {
		driver = this.driver;
		System.out.println("Cnstructor added to demopage-DealsBranch");
	}
	
	public void demo() {
		System.out.println("New Page added");
	} 

}
