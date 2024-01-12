package com.RegUserWith_GiftCard;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.testcases.baseClass;

public class tc__BundleProductForReg_InGc  extends baseClass{
	 
	SoftAssert softAssert = new SoftAssert();

		 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
		public void bundleProduct() throws InterruptedException {
		if(isLoggedIn) {      
			 //searching the bundle product from excel sheet
		    BundleProduct bp = new BundleProduct();
		    bp.bundleproduct();
      		 //gc payment 
		     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
		     gc.paymentByGiftCard();
		     
		 }else {
		   	 Assert.fail("User not logged in");
		   }
		}	 
}
