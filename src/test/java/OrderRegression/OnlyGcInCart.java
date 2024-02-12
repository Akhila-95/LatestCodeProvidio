package OrderRegression;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import CreditCardPayment.CreditCardDetails;
import PaymentProccess.CommonProccessUptoCheckout;
import tasks.GiftCertificatePageTasks;

import tasks.ReviewOrderPageTask;
import validations.OrderPageValidation;

public class OnlyGcInCart extends baseClass {


	@Test
	public static void verifyingPlacingOrderWithCreditCardWhenOnlyGcInCart() throws Exception {
		
		GiftCertificatePageTasks.giftCertificateForm();
		
		CommonProccessUptoCheckout.commonCheckoutProccess();
		
		CreditCardDetails.creditCardDetails();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
}
