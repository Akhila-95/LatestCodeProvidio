package com.GuestUserWith_Minicart_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__simpleProductAndGc_InMC_Paypal extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//simple proudct
		SimpleProductAndGc spGc = new SimpleProductAndGc();
		spGc.simpleProductAndGc();

	    //checkout from mini cart by paypal	        
       MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
       checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	   
	}
	
}
