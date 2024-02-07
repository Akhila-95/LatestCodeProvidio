package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PlaceOrderWithDifferentPayments;

public class OrderPlacingWithAllPaymentsTest extends baseClass{

	@Test
    public void verifyingOrderIsPlacingWithCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithGiftCard() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithGiftCard();
    }
	@Test
    public void verifyingOrderIsPlacingWithCombinationOfGcAndCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithCombinationOfGcAndCreditCard();
    }

	
	@Test
    public void verifyingOrderIsPlacingWithPaypalFromCheckoutPage() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithPaypalFromCheckoutPage();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithCombinationOfGcAndPaypal();
    }
	@Test
    public void verifyingOrderIsPlacingWithMiniCartPaypal() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithMiniCartPaypal();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithCartPagePaypal() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithCartPagePaypal();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithPaypalBuyNowInPdpPage() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithPaypalInPdpPage();
    }
}
