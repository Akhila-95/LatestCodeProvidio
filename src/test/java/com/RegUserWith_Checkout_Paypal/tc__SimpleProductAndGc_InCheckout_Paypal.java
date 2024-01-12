package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductAndGc_InCheckout_Paypal extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {      

		//simple proudct
		SimpleProductAndGc spGc = new SimpleProductAndGc();
		spGc.simpleProductAndGc();
		 
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
