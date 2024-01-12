package com.GuestUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__simpleProductAndGc_InGcAndPaypal extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//simple proudct
		SimpleProductAndGc spGc = new SimpleProductAndGc();
		spGc.simpleProductAndGc();
		 
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	   //gc and paypal
		  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
		  gcAndPaypal.paymentProccessByGCandPaypal();
	}
	
}
