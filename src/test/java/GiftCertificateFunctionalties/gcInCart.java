package GiftCertificateFunctionalties;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ProductsAndItsOrdersTasks;

public class gcInCart extends baseClass {

	@Test
	public static void VerifyingPlaceOrderWithCreditCardWhenOnlyGcInCart() throws Exception {
		ProductsAndItsOrdersTasks.OnlyGcInCartWithCreditCard();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithPaypalWhenOnlyGcInCart() throws Exception {
		ProductsAndItsOrdersTasks.OnlyGcInCartWithPaypal();
	}
	
	@Test
	public static void VerifyingNoVisibilityOfGiftCertificateSectionWhenGcInCart() throws Exception {
		ProductsAndItsOrdersTasks.gcInCartNoGcSectionVisible();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithCreditCard() throws Exception {
		ProductsAndItsOrdersTasks.placeOrderOfcombinationOfGcAndSimpleProductWithCreditCard();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithPaypal() throws Exception {
		ProductsAndItsOrdersTasks.placeOrderOfcombinationOfGcAndSimpleProductWithPaypal();
	}
	
}
