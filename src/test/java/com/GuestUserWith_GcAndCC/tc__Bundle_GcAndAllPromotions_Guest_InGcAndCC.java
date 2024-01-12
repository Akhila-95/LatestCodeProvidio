package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InGcAndCC extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		  
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		 
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
    
         //semi gc and cc 
		  Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		  gCandCC.paymentProccessByGCandCC(driver);
	
		 
	}
}
