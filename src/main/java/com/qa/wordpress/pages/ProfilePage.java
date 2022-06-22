package com.qa.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

WebDriver driver;


private By logoutButton = By.xpath("//div[@class='sidebar__me-signout']/button");
private By logoutMessage = By.xpath("//div[@class='inner']/h1");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isLogoutLinkExist() {
		return driver.findElement(logoutButton).isDisplayed();
		
	}
	
	public void doLogout() {
		if(isLogoutLinkExist()) {
			driver.findElement(logoutButton).click();
		}
	
}
	public String getLogoutMessage() {
		
		String logoutMsg = driver.findElement(logoutMessage).getText();
	return logoutMsg;

	}
	
}