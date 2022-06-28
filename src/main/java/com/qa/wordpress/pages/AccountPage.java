package com.qa.wordpress.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.wordpress.utils.Constants;
import com.qa.wordpress.utils.ElementUtil;

public class AccountPage {
	
	WebDriver driver;
    ElementUtil eleUtil;
	
	private By header = By.xpath("//header/h1");
	private By actSectionHeader = By.xpath("//h3[contains(text(),'Give your')]");
	private By searchBar = By.id("search-component-5e0d7b24-ffc1-4cde-8ac9-c4eee04bb4ed");
	private By topicLink = By.xpath("//div[@class='inline-help__results-cell']");
	private By profileLink = By.xpath("//div[@class='masterbar__section masterbar__section--right']/a[1]");
	
	
	public AccountPage(WebDriver driver)	{
	
	this.driver = driver;
	eleUtil = new ElementUtil(driver);
	
}

	public String getAcctPageTitle() {
		
		return eleUtil.waitForTitleContains(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT);
	}

public String getAcctPageUrl() {
	return eleUtil.waitForUrlContains(Constants.ACCOUNT_ACCOUNT_PAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);
}

public String getAcctPageHeader() {
	
	return eleUtil.waitForElementVisible(actSectionHeader, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).getText();
	
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
	
	return eleUtil.waitForElementVisible(searchBar, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();
	
}

public boolean isProfileLinkExist() {

return eleUtil.waitForElementVisible(profileLink, Constants.DEFAULT_ELEMENT_WAIT_TIMEOUT).isDisplayed();	

}

//@DataProvider
//public void object[][] getProductName() {
//	return new object[][] {
//		
//		
//		
//		
//	}
//}


public ProfilePage clickOnProfile() {
	
eleUtil.waitForElementsVisible(profileLink, 30);
eleUtil.doClick(profileLink);

	return new ProfilePage(driver);
	
}
 
}

