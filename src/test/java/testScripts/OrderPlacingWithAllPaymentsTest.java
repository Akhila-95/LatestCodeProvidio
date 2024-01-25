package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PlaceOrderWithDifferentPayments;

public class OrderPlacingWithAllPaymentsTest extends baseClass{

	@Test(groups = {"smoke", "regression"})
    public void verifingOrderIsPlacingWithCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithCreditCard();
    }
	

    
	@Test(groups = {"smoke", "regression"})
    public void verifingOrderIsPlacingWithGiftCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithGiftCard();
    }
	@Test(groups = {"smoke", "regression"})
    public void verifingOrderIsPlacingWithCombinationOfGcAndCreditCard() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithCombinationOfGcAndCreditCard();
    }

	
	@Test(groups = {"smoke", "regression"})
    public void verifingOrderIsPlacingWithPaypalFromCheckoutPage() throws Exception {
		PlaceOrderWithDifferentPayments.orderPlacingWithPaypalFromCheckoutPage();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifingOrderIsPlacingWithCombinationOfGcAndPaypal() throws Exception {
		PlaceOrderWithDifferentPayments.OrderPlacingWithCombinationOfGcAndPaypal();
    }
}
