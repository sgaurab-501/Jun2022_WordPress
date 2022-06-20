package com.qa.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	private WebDriver driver;
	
// 1. private By locators: OR
	
private By login = By.xpath("//ul/li/a[contains(text(),'Log In')]");	
private By username = By.name("usernameOrEmail");
private By password = By.xpath("//div[@class='form-password-input']/input[@type='password']");
private By contButton = By.xpath("//div/button[@type='submit']");
private By loginButton = By.xpath("//div[@class='form-password-input']/input[@type='password']");
private By forgotPwdLink = By.xpath("//div[@class='wp-login__links']/a[contains(text(),'Lost')]");
private By createAccLink = By.xpath("//div[@class='wp-login__links']/a[contains(text(),'Lost')]");
private By profileLink = By.xpath("//span[@class='masterbar__item-content']/img");
private By logoutButton = By.xpath("//div[@class='sidebar__me-signout']/button");
private By logoutMessage = By.xpath("//div[@class='inner']/h1");

// 2. public page class constructor

public LoginPage(WebDriver driver) {
	this.driver=driver;
	
}

// 3. public page actions
// using the private data members - encapsulation

public String getLoginPageTitle() {
	String title = driver.getTitle();
	System.out.println("Login page title: "+title);
return title;

}

public String getLoginPageUrl() {
	String url = driver.getCurrentUrl();
	System.out.println("Login page url is: "+url);
return url;
}

public boolean isForgotPwdLinkExists() {
	return driver.findElement(forgotPwdLink).isDisplayed();
}

public boolean isCreateAccLinkExists() {
	
	return driver.findElement(createAccLink).isDisplayed();
	
}

public AccountPage doLogin(String uname, String pwd) throws Exception {
	driver.findElement(username).sendKeys("gaurabk098@gmail.com");
	driver.findElement(contButton).click();
	
	waitForTime();
	
	driver.findElement(password).sendKeys("Login$123");
	
	return new AccountPage(driver);
		
}

public void doLogout() throws Exception {

	driver.findElement(profileLink).click();
	waitForTime();
	driver.findElement(logoutButton).click();
}

public String getLogoutMessage() {
	
	String logoutMsg = driver.findElement(logoutMessage).getText();
return logoutMsg;

}

public void waitForTime() throws Exception {
	
	Thread.sleep(2000);
	
	
}
}
