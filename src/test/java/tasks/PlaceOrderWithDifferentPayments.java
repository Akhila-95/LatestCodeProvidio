 package tasks;

import com.providio.testcases.baseClass;

import PaypalPayment.CartPagePayal;
import PaypalPayment.MiniCartPaypal;
import PaypalPayment.PdpPagePaypalBuyNow;
import functionality.Actionsss;
import pageObjects.homepage;
import validations.OrderPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	

	private static homepage homePage = new homepage(driver);
	
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
		OrderPageValidation.paymentInOrderConfirmationPage();
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
	}
	
	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
	}
	
	public static void orderPlacingWithMiniCartPaypal() throws InterruptedException, Exception {
		Actionsss.javascriptClick(homePage.clickOnLogo());
		MiniCartPaypal.miniCartPaypal();
				
	}
	
	public static void orderPlacingWithCartPagePaypal() throws InterruptedException, Exception {
		Thread.sleep(1000);
		Actionsss.click(homePage.clickOnLogo());
		Actionsss.scrollUp();
		CartPagePayal.cartPagePaypal();
	
	}
	
	public static void orderPlacingWithPaypalInPdpPage() throws InterruptedException, Exception {
		Actionsss.click(homePage.clickOnLogo());
		PdpPagePaypalBuyNow.pdpPagePaypal();			
	}
		
}
