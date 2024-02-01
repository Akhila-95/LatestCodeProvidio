 package tasks;

import com.providio.testcases.baseClass;

import Payments.CartPagePayal;
import Payments.GiftCertificateInCombination;
import Payments.MiniCartPaypal;
import Payments.PdpPagePaypalBuyNow;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	
	private static final PaymentPage pp = new PaymentPage(driver);
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	
	public static void orderPlacingWithCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
	/*	if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
		
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			}
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Thread.sleep(2000);
			Actionsss.javascriptClick(pp.getSelectPlaceOrderBtn());
			//Actionsss.java(pp.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			
		}*/
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
	public static void orderPlacingWithGiftCard() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
	public static void orderPlacingWithCombinationOfGcAndCreditCard() throws Exception {		
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();
		/*
		if(Actionsss.elementSize(pp.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}*/
		
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.paymentInOrderConfirmationPage();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
		PaymentPageTasks.paypal();
		Thread.sleep(1000);
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");			
			Thread.sleep(8000);		
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
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
		}else {
			test.info("Paypal is not configured in stripe,Adyen,cybersource payments");
			test.pass("Paypal is not configured in stripe,Adyen,cybersource payments");
		}
	}
	
	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");			
			Thread.sleep(8000);	
			OrderPageValidation.paymentInOrderConfirmationPage();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
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
		}else {
			test.info("Paypal is not configured in stripe,Adyen,cybersource payments");
			test.pass("Paypal is not configured in stripe,Adyen,cybersource payments");
		}
	}
	
	public static void orderPlacingWithMiniCartPaypal() throws InterruptedException, Exception {
		MiniCartPaypal.miniCartPaypal();
				
	}
	
	public static void orderPlacingWithCartPagePaypal() throws InterruptedException, Exception {
		CartPagePayal.cartPagePaypal();
	
	}
	
	public static void orderPlacingWithPaypalInPdpPage() throws InterruptedException, Exception {
		PdpPagePaypalBuyNow.pdpPagePaypal();
			
	}
}
