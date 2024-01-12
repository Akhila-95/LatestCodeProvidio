package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductAndGc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductAndGc_Reg_InGcAndPaypal extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {      
	
			//simple proudct
			SimpleProductAndGc spGc = new SimpleProductAndGc();
			spGc.simpleProductAndGc();
		 
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
