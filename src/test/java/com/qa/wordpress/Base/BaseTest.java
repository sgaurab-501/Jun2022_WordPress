package com.qa.wordpress.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.wordpress.factory.DriverFactory;
import com.qa.wordpress.pages.AccountPage;
import com.qa.wordpress.pages.LoginPage;
import com.qa.wordpress.pages.ProfilePage;

public class BaseTest {

	DriverFactory df;
	
 protected Properties prop;
public WebDriver driver;

protected LoginPage lp;
protected AccountPage accPage;
protected ProfilePage proPage;


@BeforeTest
public void setup() {
	
	df = new DriverFactory();
   prop = df.init_prop(driver);
	driver = df.init_driver(prop);
    
	lp = new LoginPage(driver);
}

	
	public WebDriver getDriver() {
	return driver;
}




	@AfterTest
	public void tearDown() throws Exception {
Thread.sleep(1500);	
//  driver.quit();
	}
	
	
}
