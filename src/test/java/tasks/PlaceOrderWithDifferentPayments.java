package tasks;

import com.providio.testcases.baseClass;

import Payments.GiftCertificateInCombination;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;

public class PlaceOrderWithDifferentPayments  extends baseClass{
	private static final 	PaymentPage pp = new PaymentPage(driver);
	
	public static void OrderPlacingWithCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		if(Actionsss.elementSize(pp.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(pp.getSelectPlaceOrderBtn())) {
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
				Thread.sleep(5000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);
				OrderDetailsPageValidation.orderDetails();
			}else {
				logger.info("Salesforce payent activated so no next review order button");
				OrderDetailsPageValidation.orderDetails();
			}
		}
		
	}
	public static void OrderPlacingWithpayPal() throws Exception {
		//commonForPaymentPage();
		//PaymentDetails.paymentOfPayPal();
		//Thread.sleep(10000);
		OrderDetailsPageValidation.orderDetails();
	}
	
	public static void OrderPlacingWithGiftCard() throws Exception {
		PaymentPageTasks.gcRedemption();
		if(Actionsss.elementSize(pp.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(pp.getSelectPlaceOrderBtn())) {
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
				Thread.sleep(5000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);
				OrderDetailsPageValidation.orderDetails();
			}else {
				logger.info("Salesforce payent activated so no next review order button");
				OrderDetailsPageValidation.orderDetails();
			}
		}
	}
	
	public static void OrderPlacingWithCombinationOfGcAndCreditCard() throws Exception {
		PaymentPageTasks.gcRedemptionInCombination();
		PaymentPageTasks.creditCardWithValidDetails();
		
		if(Actionsss.elementSize(pp.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(pp.getSelectPlaceOrderBtn())) {
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
				Thread.sleep(5000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);
				OrderDetailsPageValidation.orderDetails();
			}else {
				logger.info("Salesforce payent activated so no next review order button");
				OrderDetailsPageValidation.orderDetails();
			}
		}
	}
	
}
