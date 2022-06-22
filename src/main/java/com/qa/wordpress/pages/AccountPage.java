package com.qa.wordpress.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	WebDriver driver;

	private By header = By.xpath("//header/h1");
	private By actSectionHeader = By.xpath("//h3[contains(text(),'Give your')]");
	private By searchBar = By.id("search-component-5e0d7b24-ffc1-4cde-8ac9-c4eee04bb4ed");
	private By topicLink = By.xpath("//div[@class='inline-help__results-cell']");
	private By profileLink = By.xpath("//div[@class='masterbar__section masterbar__section--right']");
	
	
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
public List<String> getSearchTopicList() {
	List<WebElement> topicList = driver.findElements(topicLink);
	List<String> topicValList = new ArrayList<String>();
	for(WebElement e: topicList) {
		
	String text = e.getText();	
		
	topicValList.add(text);	
	}
	return topicValList;
}


public boolean isSearchBarExist() {
	
	return driver.findElement(searchBar).isDisplayed();
}

public boolean isProfileLinkExist() {
	
return driver.findElement(profileLink).isDisplayed();	
}
}

