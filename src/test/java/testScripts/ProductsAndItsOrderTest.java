package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ProductsAndItsOrdersTasks;

public class ProductsAndItsOrderTest  extends baseClass{

	@Test
	public static void VerifyingPlaceOrderWithCreditCardWhenOnlyGcInCart() throws Exception {
		ProductsAndItsOrdersTasks.OnlyGcInCartWithCreditCard();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithBuyNowButton() throws Exception {
		ProductsAndItsOrdersTasks.pdpPagebuyNowButton();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithBuyNowPopUp() throws Exception {
		ProductsAndItsOrdersTasks.pdpPageBuyNowPopUp();
	}
}
