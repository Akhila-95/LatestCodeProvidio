package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.GiftCard;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InVC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
			//adding GC into cart
		    GiftCard gc = new GiftCard();
		    gc.giftCards();
			    
    	 //paypal checkout form view cart page
          MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
          paypal.checkoutprocessFromViewCart();   
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
