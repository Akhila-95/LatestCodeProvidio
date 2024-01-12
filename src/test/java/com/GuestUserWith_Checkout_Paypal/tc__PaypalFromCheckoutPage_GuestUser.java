package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.selectAProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromCheckoutPage_GuestUser extends baseClass {
	  
	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {
	
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		   
	  // selects a random catgory and product add to cart
	      //selectAProduct Product = new selectAProduct();
	      selectAProduct.AddingAProductToCart();
          
        
	  // common checkoutProcess	         
		 MinicartViewCartProcess cp = new MinicartViewCartProcess();         
		 cp.checkoutprocess();
         
	 //paypal process from checkout page
		 MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	
	}
}
