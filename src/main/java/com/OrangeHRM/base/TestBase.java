/**
 * 
 */
package com.OrangeHRM.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OrangeHRM.utility.TestUtil;

/**
 * @author Tushar
 * This class will provide all basic initializations.
 *
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
public TestBase() {
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/OrangeHRM"
				+ "/config/config.properties");
		prop.load(fis);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}
public static void intialization() {
	String browser = prop.getProperty("browser");
	if(browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium soft\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	else if(browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium soft\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.get(prop.getProperty("URL"));
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
}
}
