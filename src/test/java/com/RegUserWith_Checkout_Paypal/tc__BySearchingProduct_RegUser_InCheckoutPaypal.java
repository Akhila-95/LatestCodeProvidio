

package com.RegUserWith_Checkout_Paypal;

import com.providio.Scenarios.SearchingProduct;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_RegUser_InCheckoutPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();
	//@Test(dependsOnMethods = {"com.proviodi.eachPagetest.tc__Login.loginTest"})
	@Test(dependsOnMethods = {"com.proviodi.login.tc__LoginSc.verifySuccessfulLogin"})
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {      
				
	        //searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();

    	    
    		//paypal process from checkout page
			 MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}