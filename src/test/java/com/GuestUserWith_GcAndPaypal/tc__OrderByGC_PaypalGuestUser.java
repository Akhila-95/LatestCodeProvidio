package com.GuestUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__OrderByGC_PaypalGuestUser extends baseClass {
	 
	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {	
	
			   // enters into url
			      driver.get(baseURL);		      
		          logger.info("enterd into url");	
	          
	          //selects a random catgory and product add to cart
		          navigationProccess navProccess = new navigationProccess();
		          navProccess.commonNavigationProccess();
		           
		     //common checkoutProcess	         
				  MinicartViewCartProcess cp = new MinicartViewCartProcess();         
				  cp.checkoutprocess();
				
			//gc and paypal
				  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				  gcAndPaypal.paymentProccessByGCandPaypal();
	}
}
