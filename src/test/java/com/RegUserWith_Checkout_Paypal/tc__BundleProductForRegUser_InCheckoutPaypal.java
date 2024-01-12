package com.RegUserWith_Checkout_Paypal;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__BundleProductForRegUser_InCheckoutPaypal  extends baseClass{
	 
	SoftAssert softAssert = new SoftAssert();

		//@Test(dependsOnMethods = {"com.proviodi.eachPagetest.tc__Login.loginTest"})
		@Test(dependsOnMethods = {"com.proviodi.login.tc__LoginSc.verifySuccessfulLogin"})
		public void bundleProduct() throws InterruptedException {
		if(isLoggedIn) {      

			 //searching the bundle product from excel sheet
		    BundleProduct bp = new BundleProduct();
		    bp.bundleproduct();
	      
      		//paypal process from checkout page
      		   MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
      		   cpp.checkoutprocessFromCheckout();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
		}	 
}
