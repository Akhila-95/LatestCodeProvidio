package com.RegUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromCheckoutPage_RegUser extends baseClass {
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {
	
		if(isLoggedIn) {      

		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	        
		  // common checkoutProcess	         
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
