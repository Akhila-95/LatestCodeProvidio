package com.RegUserWith_Checkout_Paypal;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForRegUser_InPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.login.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 

			if(isLoggedIn) {      
				
				//simple product
			    SimpleProduct sp = new SimpleProduct();
			    sp.simpleProdcut();
			    
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

