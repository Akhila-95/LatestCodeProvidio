package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForReg_InGcAndPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void productSet() throws InterruptedException {

		 if(isLoggedIn) {     
				//product set
				ProductSet ps = new ProductSet();
				ps.productSet();
				 	
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

