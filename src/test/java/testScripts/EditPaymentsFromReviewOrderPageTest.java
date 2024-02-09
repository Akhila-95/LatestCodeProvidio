package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.EditPaymentsFromReviewOrderPageTasks;

public class EditPaymentsFromReviewOrderPageTest extends baseClass {

	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCreditCardToGiftCertificate() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCreditToGiftCertificate();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCreditCardToPaypal() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCreditCardToPaypal();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromGiftCertificateToCreditCard() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editGiftCertificateToCredit();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromGiftCertificateToPaypal() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editGiftCertificateToPaypal();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromPaypalToGiftCertificate() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editPaypalToGiftCertificate();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromPaypalToCreditCard() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editPaypalToCreditCard();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCombinationOfGiftCertificateAndCreditCardToGiftCertificate() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCombinationOfGiftCertificateAndCreditCardToGiftCertificate();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCombinationOfGiftCertificateAndCreditCardToCreditCard() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCombinationOfGiftCertificateAndCreditCardToCreditCard();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCombinationOfGiftCertificateAndPaypalToPaypal() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCombinationOfGiftCertificateAndPaypalToPaypal();
	}
	
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCombinationOfGiftCertificateAndPaypalToGiftCertificate() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCombinationOfGiftCertificateAndPaypalToGiftCertificate();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromPaypalToGiftCertificateAndPaypal() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editPaypalToCombinationOfGiftCertificateAndPaypal();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromPaypalToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editPaypalToCombinationOfGiftCertificateAndCreditCard();
	}
	
	@Test
	public static void verifyingTheEditInPaymentInReviewOrderPageFromCreditCardToCombinationOfGiftCertificateAndPaypal() throws Exception {
		EditPaymentsFromReviewOrderPageTasks.editCreditCardToCombinationOfGiftCertificateAndPaypal();
	}
}
