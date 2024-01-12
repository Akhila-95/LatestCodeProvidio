package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer_Reg_InVC_Paypal extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		if(isLoggedIn) {     
			//pramotions
			Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
			bgs.bundelGcandallpromotions();
		}else {
		   	 Assert.fail("User not logged in");
		   }
		
	}
}
