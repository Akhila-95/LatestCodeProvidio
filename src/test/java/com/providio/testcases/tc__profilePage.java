package com.providio.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__ProfilePage extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void profilePage() throws InterruptedException {
	    // Validate login
	    if (isLoggedIn) {

		Thread.sleep(5000);

	        } else {
	            Assert.fail("User is not logged in");
	        }
		
   }
	
}