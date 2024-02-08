package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.homepage;

public class EditPaymentsFromReviewOrderPageTasks extends baseClass {
	private static homepage homePage = new homepage(driver);
	
	public static void editCreditToGiftCertificate() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.editPaymentFromCreditCardToGiftCerticficate();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}

	public static void editCreditCardToPaypal() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.creditCardToPaypal();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editGiftCertificateToCredit() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.editPaymentFromGiftCertificateToCreditCard();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}

	public static void editGiftCertificateToPaypal() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.editPaymentFromGiftCertificateToPaypal();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editPaypalToGiftCertificate() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToGiftCertificate();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editPaypalToCreditCard() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToCreditCard();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editCombinationOfGiftCertificateAndCreditCardToGiftCertificate() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndCreditCardToGiftCertificate();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editCombinationOfGiftCertificateAndCreditCardToCreditCard() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndCreditCardToCreditCard();
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
}
