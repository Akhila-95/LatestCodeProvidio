package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Reg_InGcAndPaypal extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		if(isLoggedIn) {   

		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
			
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	   //gc and paypal
		  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
		  gcAndPaypal.paymentProccessByGCandPaypal();
		}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}
