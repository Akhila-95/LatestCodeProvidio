package com.RegUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.GiftCard;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InGc extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			//adding GC into cart
		    GiftCard gc = new GiftCard();
		    gc.giftCards();
			//check our process
			 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		     //gc payment 
		     Gc__CC_Paypal gc1 = new Gc__CC_Paypal ();
		     gc1.paymentByGiftCard();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
