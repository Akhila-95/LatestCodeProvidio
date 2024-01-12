package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.MiniCartChekoutButton;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InCheckoutPaypal extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		 
		 //checkoutProcess
        MiniCartChekoutButton cp = new MiniCartChekoutButton();         
		cp.checkoutprocess();
	     
	    //paypal process from checkout page
		 MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	
		 
	}
}
