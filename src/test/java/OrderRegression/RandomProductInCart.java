package OrderRegression;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PlaceOrderWithDifferentPayments;
public class RandomProductInCart {

		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithCreditCard() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
	    }
		
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithGiftCard() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithGiftCard();
	    }
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithCombinationOfGcAndCreditCard() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithCombinationOfGcAndCreditCard();
	    }

		
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithPaypalFromCheckoutPage() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithPaypalFromCheckoutPage();
	    }
		
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithCombinationOfGcAndPaypal() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithCombinationOfGcAndPaypal();
	    }
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithMiniCartPaypal() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithMiniCartPaypal();
	    }
		
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithCartPagePaypal() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithCartPagePaypal();
	    }
		
		@Test(groups = {"smoke", "regression"})
	    public void verifyingOrderIsPlacingWithPaypalBuyNowInPdpPage() throws Exception {
			PlaceOrderWithDifferentPayments.orderPlacingWithPaypalInPdpPage();
	    }
	}

