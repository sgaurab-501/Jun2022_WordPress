package com.qa.wordpress.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wordpress.Base.BaseTest;
import com.qa.wordpress.pages.AccountPage;
import com.qa.wordpress.utils.Constants;

public class AccountPageTest extends BaseTest{	
	
@BeforeClass	
public void accSetup() throws Exception {

accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));



}

@Test
public void accPageTitleTest() {

	String accPageTitle = accPage.getAcctPageTitle();
	Assert.assertEquals(accPageTitle, Constants.ACCOUNT_PAGE_TITLE);
	 System.out.println(accPageTitle);
}

@Test
public void accPageHeaderTest() {

	String accPageHeader = accPage.getAcctPageHeader();
	System.out.println(accPageHeader);
Assert.assertEquals(accPageHeader, Constants.ACCOUNT_PAGE_HEADER);

}

@Test
public void isProfileLinkExistsTest() {
	
	Assert.assertEquals(accPage.isProfileLinkExist(), true);
	
}



}