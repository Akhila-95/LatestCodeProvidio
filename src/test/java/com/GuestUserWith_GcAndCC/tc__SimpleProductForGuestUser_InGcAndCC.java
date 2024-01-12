package com.GuestUserWith_GcAndCC;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForGuestUser_InGcAndCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void simpleProduct() throws InterruptedException {
		 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			 
			//simple product
		    SimpleProduct sp = new SimpleProduct();
		    sp.simpleProdcut();
		    
	        //checkoutProcess	        
	        MinicartViewCartProcess cp = new MinicartViewCartProcess();	        
	        cp.checkoutprocess();
            
	      //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			gCandCC.paymentProccessByGCandCC(driver);

	        
	        }
	        
	  
}

