package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductAndGc_Reg_InMC_Paypal extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {      

			//simple proudct
			SimpleProductAndGc spGc = new SimpleProductAndGc();
			spGc.simpleProductAndGc();
			
	        //checkout from mini cart by paypal	        
	        MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
	        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
	
}
