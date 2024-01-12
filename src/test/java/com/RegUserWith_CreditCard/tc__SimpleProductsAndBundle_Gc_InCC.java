package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_InCC extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		if(isLoggedIn) {

		 //adding simple product into cart
          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
		
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	     //credit card
		 CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
		 cc.paymentByCreditCard();
		}else {
		        Assert.fail("User not logged in");
		    }
		}
}
