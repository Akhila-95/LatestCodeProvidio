package com.GuestUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_InGcAndPaypal extends baseClass {
	 
	@Test
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
          
		 //adding simple product into cart
          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
          
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	   //gc and paypal
		  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
		  gcAndPaypal.paymentProccessByGCandPaypal();
  }
}
