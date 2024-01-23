package tasks;

import com.providio.testcases.baseClass;

import data.PaymentDetails;
import functionality.Actionsss;
import pageObjects.PlaceOrderPage;

public class PlaceOrderPageTask extends baseClass{

	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	public static void placeOrderPage() throws Exception {
		if(Actionsss.elementSize(placeOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
				logger.info("Placing order page is loaded");;
			}
		}else {
			 PaymentDetails.creditCardDetails();
		}
	}
	
}
