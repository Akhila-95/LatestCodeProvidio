package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.GiftCard;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InGcAndCC extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
			//adding GC into cart
		    GiftCard gc = new GiftCard();
		    gc.giftCards();
		   //check out process	
		   MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	       cp.checkoutprocess();
	       //semi gc and cc 
		   Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		   gCandCC.paymentProccessByGCandCC(driver);
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
