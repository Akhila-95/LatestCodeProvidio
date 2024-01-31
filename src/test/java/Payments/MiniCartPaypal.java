package Payments;

import com.providio.testcases.baseClass;

import Paypal.PaypalMethod;
import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPage;
import tasks.HomePageTasks;
import tasks.OrderDetailPageTasks;
import tasks.PlaceOrderPageTask;
import validations.PlaceOrderPageValidation;

public class MiniCartPaypal extends baseClass {

	private static MiniCartPage miniCart = new MiniCartPage(driver);
	private static final 	PaymentPage pp = new PaymentPage(driver);
	
	public static void miniCartPaypal() throws InterruptedException, Exception {
		
			HomePageTasks.miniCartBtnClick();
			Thread.sleep(2000);
			test.info("Verifying payment with Mini cart paypal");
			if(Actionsss.elementSize(miniCart.getSalesforcePaypalInMiniCartList())) {
				logger.info("Salesforce paypal integration activated");
				Actionsss.click(miniCart.getSalesforcePaypalInMiniCart());
				Thread.sleep(3000);
				 PaypalMethod.paypalPopup();
				logger.info("Entered into paypal window and entered the paypal details");
				//paypal window
				//PlaceOrderPageTask.clickPlaceOrderButton();
				
			}else if(Actionsss.elementSize(miniCart.getBrainTreePaypalInMiniCartList())){
				logger.info("Brain tree activated");
				Actionsss.click(miniCart.getBrainTreePaypalInMiniCart());
			
				logger.info("Clicked on  brain tree paypal button");			
				Thread.sleep(2000);
				//checkout.validatePaypalClick();
				 PaypalMethod.paypalPopup(); 
			}else {
				test.info("CYBERSOURCE payment OR STRIPE payment OR ADYEN integration  is activated so, No paypal for cybersouce and stripe");
            	test.pass("No paypal integration for CYBERSOURCE payment OR STRIPE payment OR ADYEN integration, choose another integration to do the payment with paypal");
			}	
			PlaceOrderPageTask.placeOrder();
			OrderDetailPageTasks.getOrderConfirmationPage();
	}
}


