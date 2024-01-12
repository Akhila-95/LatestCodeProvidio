package com.GuestUserWith_CreditCard;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForGuestUser_InCC extends baseClass{
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
        
         //payment process           
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();		     
	     cc.paymentByCreditCard();

	        }
	        
	  
}

