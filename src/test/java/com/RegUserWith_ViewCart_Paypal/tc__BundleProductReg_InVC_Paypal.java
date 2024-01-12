package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__BundleProductReg_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	  
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void bundleProduct() throws InterruptedException {
		
	if(isLoggedIn) {
		 //searching the bundle product from excel sheet
	    BundleProduct bp = new BundleProduct();
	    bp.bundleproduct();
	    	
    	 //paypal checkout form view cart page
 	          MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();   
	 } else {
	        Assert.fail("User not logged in");
	    }
	 }
}

