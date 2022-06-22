package com.qa.wordpress.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wordpress.AccountPage;
import com.qa.wordpress.Base.BaseTest;
import com.qa.wordpress.utils.Constants;

public class AccountPageTest extends BaseTest{	
	
	
@BeforeClass	
public void accSetup() {
	
	AccountPage accPage = new AccountPage(driver);

}

@Test
public void accPageTitleTest() {

	Assert.assertEquals(accPage.getAcctPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	 
}

@Test
public void accPageHeaderTest() {

	String accPageHeader = accPage.getAcctPageHeader();
	System.out.println(accPageHeader);
Assert.assertEquals(accPageHeader, Constants.ACCOUNT_PAGE_HEADER);

}

}