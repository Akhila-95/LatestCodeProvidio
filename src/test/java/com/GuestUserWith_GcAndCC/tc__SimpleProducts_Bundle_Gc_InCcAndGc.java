package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProducts_Bundle_Gc_InCcAndGc extends baseClass {
	 
	@Test
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		  
        //simple all promotions
        SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
		
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	     //semi gc and cc 
		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		gCandCC.paymentProccessByGCandCC(driver);
  }
}
