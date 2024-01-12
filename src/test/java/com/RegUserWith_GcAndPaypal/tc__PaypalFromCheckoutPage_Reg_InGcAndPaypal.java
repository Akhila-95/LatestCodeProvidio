package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__PaypalFromCheckoutPage_Reg_InGcAndPaypal extends baseClass {
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {
	
		if(isLoggedIn) {      

		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	        
		  // common checkoutProcess	         
			 MinicartViewCartProcess cp = new MinicartViewCartProcess();         
			 cp.checkoutprocess();
	         
			//gc and paypal
			  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
			  gcAndPaypal.paymentProccessByGCandPaypal();
     
	    }else {
	   	 Assert.fail("User not logged in");
	   }
	}
}
