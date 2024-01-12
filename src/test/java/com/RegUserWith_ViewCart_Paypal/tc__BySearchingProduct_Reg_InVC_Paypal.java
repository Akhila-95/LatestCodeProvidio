

package com.RegUserWith_ViewCart_Paypal;

import com.providio.Scenarios.SearchingProduct;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_Reg_InVC_Paypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		if(isLoggedIn) {
			//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
			
    	   //paypal checkout form view cart page
          MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
          paypal.checkoutprocessFromViewCart(); 
	}  else {
        Assert.fail("User not logged in");
    }
 }
}