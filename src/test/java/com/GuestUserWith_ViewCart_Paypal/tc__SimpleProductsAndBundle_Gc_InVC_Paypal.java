package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_InVC_Paypal extends baseClass {
	 
	@Test
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
          
		 //adding simple product into cart
          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
          
         //paypal checkout form view cart page
 	      MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
 	      paypal.checkoutprocessFromViewCart();

	   
  }
}
