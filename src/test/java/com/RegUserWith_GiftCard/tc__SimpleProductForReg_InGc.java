package com.RegUserWith_GiftCard;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.SimpleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForReg_InGc extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 

		if(isLoggedIn) {      

			//simple product
		    SimpleProduct sp = new SimpleProduct();
		    sp.simpleProdcut();
					
	        //checkoutProcess	        
	        MinicartViewCartProcess cp = new MinicartViewCartProcess();	        
	        cp.checkoutprocess();
           
	        //gc payment 
		     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
		     gc.paymentByGiftCard();

			 }else {
			   	 Assert.fail("User not logged in");
			   }
	        } 
}

