 package tasks;

import com.providio.testcases.baseClass;

import PaypalPayment.CartPagePayal;
import PaypalPayment.MiniCartPaypal;
import PaypalPayment.PdpPagePaypalBuyNow;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPageObjects;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	

	private static homepage homePage = new homepage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final OrderPageDetails orderPage = new OrderPageDetails(driver);
	
	public static void orderPlacingWithCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.placeOrder();
		//OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithGiftCard() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.placeOrder();
		//OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithCombinationOfGcAndCreditCard() throws Exception {		
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();		
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
		PaymentPageTasks.paypal();
			if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
				if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
				logger.info("Salesforce payment activated");			
				Thread.sleep(8000);		
				//OrderPageValidation.paymentInOrderConfirmationPage();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				
				}
			}
			else if(Actionsss.elementSize(paymentPage.getBrainPaypalAcc())) {	
				logger.info("Other paymnet activated");
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
				Thread.sleep(8000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);					
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				
			}else {
				logger.info("cybersource or stripe or adyen payments are activated.");
			}
			Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithMiniCartPaypal() throws InterruptedException, Exception {	
		MiniCartPaypal.miniCartPaypal();
		Actionsss.javascriptClick(homePage.clickOnLogo());
				
	}
	
	public static void orderPlacingWithCartPagePaypal() throws InterruptedException, Exception {		
		CartPagePayal.cartPagePaypal();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	
	}
	
	public static void orderPlacingWithPaypalInPdpPage() throws InterruptedException, Exception {		
		PdpPagePaypalBuyNow.pdpPagePaypal();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
		
}
