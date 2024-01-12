package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer_InCheckoutPaypal extends baseClass{
	 
	@Test
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		 
	}
}
