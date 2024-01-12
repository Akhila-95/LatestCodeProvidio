package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void variationProduct() throws InterruptedException {
		 
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		  
		 //searched for variation product
		VariationProduct vp = new VariationProduct();
		vp.variationProduct();
   	    
      //paypal checkout form view cart page
 	    MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
 	    paypal.checkoutprocessFromViewCart();
	 }
}

