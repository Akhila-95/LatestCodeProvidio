package tasks;

import com.providio.testcases.baseClass;

import data.PaymentDetails;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.PlaceOrderPage;
import validations.PaymentPageValidation;

public class PlaceOrderPageTask extends baseClass{

	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	private static final 	PaymentPage pp = new PaymentPage(driver);
	
	public static void placeOrderPage() throws Exception {
		if(Actionsss.elementSize(placeOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
				logger.info("Placing order page is loaded");;
			}
		}else {
			PaymentPageTasks.creditCardWithValidDetails();
		}
	}
	
	public static void clickPlaceOrderButton() throws Exception {
		placeOrderPage();
		
		Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
		Thread.sleep(5000);
		PaymentPageValidation.VerifiedThatPlaceOrderClick();
		Thread.sleep(1000);
	}
}
