package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_Reg_InGcAndCC extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		if(isLoggedIn) {
			
			 //adding simple product into cart
	          SimpleProductsAndBundle_Gc.simpleProductsAndBundle_Gc();
		
		 //checkoutProcess				        
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	   //semi gc and cc 
		 Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		 gCandCC.paymentProccessByGCandCC(driver);
			
		 } else {
		        Assert.fail("User not logged in");
		    }
}
}
