package com.GuestUserWith_Checkout_Paypal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.MiniCartChekoutButton;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InCheckoutPaypal  extends baseClass{
	
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
			  MiniCartChekoutButton cp = new MiniCartChekoutButton();	         
              cp.checkoutprocess();
              
              
      		//paypal process from checkout page
  		   MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
  		   cpp.checkoutprocessFromCheckout();
      		   
		}	 
}
