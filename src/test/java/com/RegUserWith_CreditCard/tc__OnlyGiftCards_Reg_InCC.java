package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.GiftCard;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InCC extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			//adding GC into cart
		    GiftCard gc = new GiftCard();
		    gc.giftCards();
			
			 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		   //payment process             
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
