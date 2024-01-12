package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InCheckoutPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
			if(isLoggedIn) {      
			
				//searched for variation product
				VariationProduct vp = new VariationProduct();
				vp.variationProduct();
					
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

