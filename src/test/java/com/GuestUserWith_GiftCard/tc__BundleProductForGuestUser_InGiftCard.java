package com.GuestUserWith_GiftCard;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InGiftCard  extends baseClass{
	 
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {
			//launching the browser and passing the url into it
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
			 
				 //searching the bundle product from excel sheet
			    BundleProduct bp = new BundleProduct();
			    bp.bundleproduct();
   	    	
	         //checkoutProcess		        
			  MinicartViewCartProcess cp = new MinicartViewCartProcess();	         
              cp.checkoutprocess();
              
             //gc payment 
			   Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			   gc.paymentByGiftCard();
			   
        }	 
}
