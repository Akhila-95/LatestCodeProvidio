package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.VariationProduct;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	  
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {
			
			//searched for variation product
			VariationProduct vp = new VariationProduct();
			vp.variationProduct();
					
            //checkoutProcess	        
            MinicartViewCartProcess cp = new MinicartViewCartProcess();          
            cp.checkoutprocess();
            
            //payment process         
		    CreditCardPaymentProcess cc = new CreditCardPaymentProcess();		     
		    cc.paymentByCreditCard();

		 }
		 
		  else {
		        Assert.fail("User not logged in");
		    }
	 }
}

