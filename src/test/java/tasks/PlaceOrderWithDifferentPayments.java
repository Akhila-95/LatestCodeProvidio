package tasks;

import com.providio.testcases.baseClass;

import Payments.GiftCertificateInCombination;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	
	private static final PaymentPage pp = new PaymentPage(driver);
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	
	public static void OrderPlacingWithCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
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
		}
		
	}
	
	public static void OrderPlacingWithGiftCard() throws Exception {
		PaymentPageTasks.gcRedemption();
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
		}
	}
	
	public static void OrderPlacingWithCombinationOfGcAndCreditCard() throws Exception {		
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();
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
		}
	}
	
	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
		PaymentPageTasks.paypal();
		Thread.sleep(1000);
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");
			//Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			//PaymentPageValidation.VerifiedThatPlaceOrderClick();
			//Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			}
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}
	}
	
	public static void OrderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
			logger.info("Salesforce payment activated");
			//Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			//PaymentPageValidation.VerifiedThatPlaceOrderClick();
			//Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			}
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
			Thread.sleep(1000);
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}
	}
	
	
	
}
