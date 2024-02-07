package PaypalPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPageObjects;
import pageObjects.homepage;
import tasks.HomePageTasks;
import tasks.OrderDetailPageTasks;
import tasks.ReviewOrderPageTask;
import validations.OrderPageValidation;
public class MiniCartPaypal extends baseClass {

	private static MiniCartPage miniCart = new MiniCartPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void miniCartPaypal() throws InterruptedException, Exception {
		
			HomePageTasks.miniCartBtnClick();
			Thread.sleep(2000);
			
			test.info("Verifying payment with Mini cart paypal");
			if(Actionsss.elementSize(miniCart.getSalesforcePaypalInMiniCartList())) {
				logger.info("Salesforce paypal integration activated");
				Actionsss.CombinedClick(miniCart.getSalesforcePaypalInMiniCart());
				Thread.sleep(3000);
				 PaypalMethod.paypalPopup();
				logger.info("Entered into paypal window and entered the paypal details");
				ReviewOrderPageTask.placeOrder();
				OrderPageValidation.paymentInOrderConfirmationPage();
				OrderDetailPageTasks.getOrderConfirmationPage();
				Actionsss.click(homePage.clickOnLogo());
				
			}else if(Actionsss.elementSize(miniCart.getBrainTreePaypalInMiniCartList())){
				logger.info("Brain tree activated");
				Actionsss.click(miniCart.getBrainTreePaypalInMiniCart());
			
				logger.info("Clicked on  brain tree paypal button");			
				Thread.sleep(2000);
				//checkout.validatePaypalClick();
				 PaypalMethod.paypalPopup(); 
				 ReviewOrderPageTask.placeOrder();
				 OrderPageValidation.paymentInOrderConfirmationPage();
				 OrderDetailPageTasks.getOrderConfirmationPage();
				 Actionsss.click(homePage.clickOnLogo());
			}else {
				test.info("CYBERSOURCE payment OR STRIPE payment OR ADYEN integration  is activated so, No paypal for cybersouce and stripe");
            	test.pass("No paypal integration for CYBERSOURCE payment OR STRIPE payment OR ADYEN integration, choose another integration to do the payment with paypal");
			}	
		
	}
}


