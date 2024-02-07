package PaypalPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import tasks.OrderDetailPageTasks;
import tasks.ReviewOrderPageTask;
import tasks.ViewCartPageTasks;
import validations.OrderPageValidation;

public class CartPagePayal extends baseClass{

	private static final ViewCartPage viewCart= new ViewCartPage(driver);
	private static homepage homePage = new homepage(driver);
	
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
			Actionsss.scrollWindowsByPixel(-300);
	        ReviewOrderPageTask.placeOrder();
	        Thread.sleep(2000);
	        OrderPageValidation.paymentInOrderConfirmationPage();
	        OrderDetailPageTasks.getOrderConfirmationPage();
	        Actionsss.click(homePage.clickOnLogo());
        }else if(Actionsss.elementSize(viewCart.getSalesforcePaypalInCartPageList())){
        	test.info("Salesforce payment integration is activated");
        	Actionsss.click(viewCart.getSalesforcePaypalInCartPage());      	
			PaypalMethod.paypalPopup();
			logger.info("Entered into paypal window and entered the paypal details");
			Actionsss.scrollWindowsByPixel(-300);
	        ReviewOrderPageTask.placeOrder();
	        Thread.sleep(2000);
	        OrderPageValidation.paymentInOrderConfirmationPage();
	        OrderDetailPageTasks.getOrderConfirmationPage();
	        Actionsss.click(homePage.clickOnLogo());
        }else {
        	test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
        }
	  	
	}
}
