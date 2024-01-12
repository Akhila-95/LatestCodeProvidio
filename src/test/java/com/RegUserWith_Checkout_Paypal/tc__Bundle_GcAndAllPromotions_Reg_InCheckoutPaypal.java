package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Reg_InCheckoutPaypal extends baseClass{
	 
	//@Test(dependsOnMethods = {"com.proviodi.eachPagetest.tc__Login.loginTest"})
	@Test(dependsOnMethods = {"com.proviodi.login.tc__LoginSc.verifySuccessfulLogin"})
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		if(isLoggedIn) {   
		 
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		 
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	    //paypal process from checkout page
		 MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
		}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}
