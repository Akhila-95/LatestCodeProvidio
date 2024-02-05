 package tasks;

import com.providio.testcases.baseClass;

import Payments.CartPagePayal;
import Payments.GiftCertificateInCombination;
import Payments.MiniCartPaypal;
import Payments.PdpPagePaypalBuyNow;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPage;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	
	private static final PaymentPage pp = new PaymentPage(driver);
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void orderPlacingWithCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
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
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
		PaymentPageTasks.paypal();
	/*	Thread.sleep(1000);
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");			
			Thread.sleep(8000);		
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			}
		}
		else if(Actionsss.elementSize(pp.getSelectPlaceOrderBtnList())) {	
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
		}else {
			test.info("Paypal is not configured in stripe,Adyen,cybersource payments");
			test.pass("Paypal is not configured in stripe,Adyen,cybersource payments");
			Actionsss.click(homePage.clickOnLogo());
		}*/
	}
	
	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
	/*	if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");			
			Thread.sleep(8000);	
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			}
		}
		else if(Actionsss.elementSize(pp.getSelectPlaceOrderBtnList())) {	
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
		}else {
			test.info("Paypal is not configured in stripe,Adyen,cybersource payments");
			test.pass("Paypal is not configured in stripe,Adyen,cybersource payments");
			Actionsss.click(homePage.clickOnLogo());
		}*/
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
