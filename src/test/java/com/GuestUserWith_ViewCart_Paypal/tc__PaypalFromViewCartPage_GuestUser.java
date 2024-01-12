package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.selectAProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromViewCartPage_GuestUser extends baseClass {
	 
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		  
		//select a product form the pdp
		selectAProduct.AddingAProductToCart(); 
	     
       //paypal checkout form view cart page
       MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
       paypal.checkoutprocessFromViewCart();
   }

}
