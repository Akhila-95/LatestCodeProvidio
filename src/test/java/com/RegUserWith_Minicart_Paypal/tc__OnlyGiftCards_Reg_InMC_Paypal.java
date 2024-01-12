package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.GiftCard;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InMC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
			//adding GC into cart
		    GiftCard gc = new GiftCard();
		    gc.giftCards();
			
		 //checkout from mini cart by paypal	        
	        MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
	        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
