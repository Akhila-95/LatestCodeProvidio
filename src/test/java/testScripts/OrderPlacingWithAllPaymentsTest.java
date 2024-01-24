package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PlaceOrderWithDifferentPayments;

public class OrderPlacingWithAllPaymentsTest extends baseClass{

	@Test(groups = {"smoke", "regression"})
    public void VerifingOrderIsPlacingWithCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithCreditCard();
    }
	
	//@Test(groups = {"smoke", "regression"})
    public void VerifingOrderIsPlacingWithPayPal() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithpayPal();
    }
    
	@Test(groups = {"smoke", "regression"})
    public void VerifingOrderIsPlacingWithGiftCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithGiftCard();
    }
	@Test(groups = {"smoke", "regression"})
    public void VerifingOrderIsPlacingWithCombinationOfGcAndCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithCombinationOfGcAndCreditCard();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifingOrderIsPlacingWithGiftCode() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithGiftCard();
    }
}
