package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__simpleProductAndGc_Reg_InVC_Paypal extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {

			//simple proudct
			SimpleProductAndGc spGc = new SimpleProductAndGc();
			spGc.simpleProductAndGc();
			
		  //paypal checkout form view cart page
          MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
          paypal.checkoutprocessFromViewCart();   
	} else {
        Assert.fail("User not logged in");
    }
 }
	
}
