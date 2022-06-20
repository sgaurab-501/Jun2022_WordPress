package com.qa.wordpress;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	WebDriver driver;

	private By header = By.xpath("//header/h1");
	private By actSectionHeader = By.xpath("//h3[contains(text(),'Give your')]");
	private By searchLink = By.id("search-component-5e0d7b24-ffc1-4cde-8ac9-c4eee04bb4ed");
	
	public AccountPage(WebDriver driver)	{
	
	this.driver = driver;
}

	public String getAcctPageTitle() {
		
		return driver.getTitle();
	}

public String getAcctPageUrl() {
	return driver.getCurrentUrl();
}

public String getAcctPageHeader() {
	
	return driver.findElement(header).getText();
}
public List<String> getAcctSectionList() {
	List<WebElement> acctSecList = driver.findElements(actSectionHeader);
	List<String> acctSecValList = new ArrayList<String>();
	for(WebElement e: acctSecList) {
		
	String text = e.getText();	
		
	acctSecValList.add(text);	
	}
	return acctSecValList;
}

}
