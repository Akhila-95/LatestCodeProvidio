package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__SimpleProductReg_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 
		 
	if(isLoggedIn) {
	
		//simple product
	    SimpleProduct sp = new SimpleProduct();
	    sp.simpleProdcut();

		//paypal checkout form view cart page
         MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
         paypal.checkoutprocessFromViewCart();   
             
	        }

	  else {
	        Assert.fail("User not logged in");
	    }
	 }
}

