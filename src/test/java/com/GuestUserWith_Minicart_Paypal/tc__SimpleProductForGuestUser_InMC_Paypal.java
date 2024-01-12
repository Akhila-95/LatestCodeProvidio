package com.GuestUserWith_Minicart_Paypal;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForGuestUser_InMC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void simpleProduct() throws InterruptedException {
		 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			 
			//simple product
		    SimpleProduct sp = new SimpleProduct();
		    sp.simpleProdcut();
		    
         //checkout from mini cart by paypal	        
	      MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
	      checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	        
	      }   
	  
}

