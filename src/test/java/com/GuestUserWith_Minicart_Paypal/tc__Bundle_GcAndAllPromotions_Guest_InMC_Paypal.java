package com.GuestUserWith_Minicart_Paypal;

import org.testng.annotations.Test;
import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InMC_Paypal extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		
	  //checkout from mini cart by paypal	        
      MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
      checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	
		 
	}
}
