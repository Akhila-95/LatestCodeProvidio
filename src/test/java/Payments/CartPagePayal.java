package Payments;

import com.providio.testcases.baseClass;

import Paypal.PaypalMethod;
import functionality.Actionsss;
import pageObjects.ViewCartPage;
import tasks.OrderDetailPageTasks;
import tasks.PlaceOrderPageTask;
import tasks.ViewCartPageTasks;

public class CartPagePayal extends baseClass{

	private static final ViewCartPage viewCart= new ViewCartPage(driver);
	public static void cartPagePaypal() throws Exception {
		//Thread.sleep(7000);
		ViewCartPageTasks.viewCartpage();    
        test.info("Verifying payment with cart paypal");
        if(Actionsss.elementSize(viewCart.getBrainTreePaypalInCartList())){
        	test.info("Braintree payment integration is activated");       	
        	Actionsss.scrollWindowsByPixel(200);
        	Thread.sleep(3000);
        	Actionsss.click(viewCart.getBrainTreePaypalInCartPage());      
        	Thread.sleep(4000);
			PaypalMethod.paypalPopup();
			logger.info("Entered into paypal window and entered the paypal details");	
			Thread.sleep(5000);
        }else if(Actionsss.elementSize(viewCart.getSalesforcePaypalInCartPageList())){
        	test.info("Salesforce payment integration is activated");
        	Actionsss.click(viewCart.getSalesforcePaypalInCartPage());      	
			PaypalMethod.paypalPopup();
			logger.info("Entered into paypal window and entered the paypal details");
        }else {
        	test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
        }
	  	Actionsss.scrollWindowsByPixel(-300);
        PlaceOrderPageTask.placeOrder();
        Thread.sleep(2000);
        OrderDetailPageTasks.getOrderConfirmationPage();	
	}
}
