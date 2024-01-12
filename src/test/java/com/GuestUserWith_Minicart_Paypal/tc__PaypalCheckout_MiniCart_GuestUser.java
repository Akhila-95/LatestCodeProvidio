package com.GuestUserWith_Minicart_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.selectAProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalCheckout_MiniCart_GuestUser extends baseClass {
	  
    @Test
	public void paypalCheckout_MiniCart() throws InterruptedException {
		
	//launching the browser and passing the url into it
	launchBrowsering lb = new launchBrowsering();
	lb.chromeBrowser();
	  
     //selects a random catgory and product add to cart
	 selectAProduct.AddingAProductToCart();
    
     //checkout from mini cart by paypal	        
        MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
        
	}

}
