package com.qa.wordpress.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wordpress.utils.Constants;
import com.qa.wordpress.utils.ElementUtil;

public class LoginPage {

	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
// 1. private By locators: OR
	
private By login = By.xpath("//ul/li/a[contains(text(),'Log In')]");	
private By emailField = By.name("usernameOrEmail");
private By pwdField = By.xpath("//div[@class='form-password-input']/input[@type='password']");
private By contButton = By.xpath("//div/button[@type='submit']");
private By logintButton = By.xpath("//div[@class='login__form-action']/button");
private By forgotPwdLink = By.xpath("//div[@class='wp-login__links']/a[contains(text(),'Lost')]");
private By createAccLink = By.xpath("//div[@class='wp-login__links']/a[contains(text(),'Lost')]");
private By accLogoutMsg = By.xpath("//div[@class='inner']/h1[contains(text(),'On your way')]");


// 2. public page class constructor

public LoginPage(WebDriver driver) {
	this.driver=driver;
	eleUtil = new ElementUtil(driver);
}

// 3. public page actions
// using the private data members - encapsulation

public String getLoginPageTitle() {
	String title = eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	System.out.println("Login page title: "+title);
return title;

}

public String getLoginPageUrl() {
	String url = eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);
	System.out.println("Login page url is: "+url);
return url;
}

public boolean isForgotPwdLinkExists() {
	return eleUtil.waitForElementVisible(forgotPwdLink, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();
}

public boolean isCreateAccLinkExists() {
	
	return eleUtil.waitForElementVisible(createAccLink, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();
	
}

public AccountPage doLogin(String uname, String pwd) throws Exception {
	
	eleUtil.getElement(emailField).sendKeys(uname);
	
	eleUtil.getElement(contButton).click();
	
	
	eleUtil.waitForElementVisible(pwdField, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).sendKeys(pwd);
	
	
	eleUtil.getElement(logintButton).click();	
	
    
	return new AccountPage(driver);
		
}

public String getLogoutMsg() {
	
	String logoutMsg = eleUtil.waitForElementVisible(accLogoutMsg, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).getText();
	
	System.out.println("Logout Successful message: "+logoutMsg);
	return logoutMsg;
	
}

public void waitForTime(int seconds) throws Exception {
	
	Thread.sleep(2000);
		
}
}
