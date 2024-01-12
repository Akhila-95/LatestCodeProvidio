package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__simpleProductAndGc_InVC_Paypal extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//simple proudct
		SimpleProductAndGc spGc = new SimpleProductAndGc();
		spGc.simpleProductAndGc();
		
	     //paypal checkout form view cart page
	      MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
	      paypal.checkoutprocessFromViewCart();
	   
	}
	
}
