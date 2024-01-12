

package com.RegUserWith_GcAndCC;

import com.providio.Scenarios.SearchingProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_RegUser_InGcAndCc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		 
		if(isLoggedIn) {
			//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
    	    
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