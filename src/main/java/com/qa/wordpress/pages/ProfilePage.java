package com.qa.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.wordpress.utils.Constants;
import com.qa.wordpress.utils.ElementUtil;

public class ProfilePage {

WebDriver driver;
ElementUtil eleUtil;

private By logoutButton = By.xpath("//li[@class='sidebar__region']/div/button");
private By logoutMessage = By.xpath("//div[@class='inner']/h1");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	eleUtil = new ElementUtil(driver);
	
	}
	public boolean isLogoutLinkExist() {
return	eleUtil.waitForElementVisible(logoutButton, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();
		
		
	}
	
	public LoginPage doLogout() {
		if(isLogoutLinkExist()) {
			
			eleUtil.waitForElementVisible(logoutButton, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT);
			eleUtil.doClick(logoutButton);
			
		  return new LoginPage(driver);
		
		}
		return null;
	
}
	public String getLogoutMessage() {
		
		String logoutMsg = driver.findElement(logoutMessage).getText();
		System.out.println("Logout Successful message: "+logoutMsg);
	return logoutMsg;

	}
	
}