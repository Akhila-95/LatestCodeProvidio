package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_Reg_InMC_Paypal extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		

		if(isLoggedIn) {      

			 //adding simple product into cart
	          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
	          
			 //checkout from mini cart by paypal	        
		     MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
		     checkOutProcessByPayPal.checkoutprocessFromMiniCart();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
  }
}
