package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_InCheckout_Paypal extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		

		if(isLoggedIn) {      

			 //adding simple product into cart
	          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
		    
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
