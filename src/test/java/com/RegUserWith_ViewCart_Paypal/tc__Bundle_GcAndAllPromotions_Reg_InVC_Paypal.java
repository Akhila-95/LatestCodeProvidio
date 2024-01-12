package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Reg_InVC_Paypal extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		if(isLoggedIn) {   

			//pramotions
			Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
			bgs.bundelGcandallpromotions();
		    
    	    //paypal checkout form view cart page
 	          MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();  
		 } else {
		        Assert.fail("User not logged in");
		    }
		 
	}
}
