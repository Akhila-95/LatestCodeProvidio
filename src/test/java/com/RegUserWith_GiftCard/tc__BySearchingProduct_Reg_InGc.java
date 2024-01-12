

package com.RegUserWith_GiftCard;

import com.providio.Scenarios.SearchingProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_Reg_InGc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {      

			//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
			
		        //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}