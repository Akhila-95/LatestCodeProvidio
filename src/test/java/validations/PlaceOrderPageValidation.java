package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PlaceOrderPage;

public class PlaceOrderPageValidation extends baseClass {
	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	
	public  static void VerifyingReviewOrderBtn() throws InterruptedException {
 		test.info("Verifying the review order Btn click");
 
 		if(Actionsss.elementSize(placeOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
     	    logger.info("Successfully Clicked on the review order button");
     	    test.pass("Successfully Clicked on the review order button");
			}
     	}else {
     		test.fail("Click failed");
     	}
 	}
}
