package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;


public class tc__ProductSetRegUser_InGcAndCC extends baseClass{
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
		        
		      //semi gc and cc 
				Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				gCandCC.paymentProccessByGCandCC(driver);
		        

	    
		 }else {
		        Assert.fail("User not logged in");
		    }
		}
}

