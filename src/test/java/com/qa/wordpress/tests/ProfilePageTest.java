package com.qa.wordpress.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.wordpress.Base.BaseTest;
import com.qa.wordpress.utils.Constants;

public class ProfilePageTest extends BaseTest {

	
@BeforeClass
public void profilesetup() throws Exception {
	
	accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	proPage = accPage.clickOnProfile();
}
	

@Test	
public void isUserLoggedOUtTest() {

	lp = proPage.doLogout();
	Assert.assertEquals(lp.getLogoutMsg(), Constants.USER_LOGOUT_MESSAGE);
	
	
	
}
}
