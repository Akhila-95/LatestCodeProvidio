package OrderRegression;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import CreditCardPayment.CreditCardDetails;
import PaymentProccess.CommonProccessUptoCheckout;
import pageObjects.PaymentPage;
import tasks.GiftCertificatePageTasks;

import tasks.ReviewOrderPageTask;
import validations.OrderPageValidation;

public class OnlyGcInCart extends baseClass {

	private static final PaymentPage pp = new PaymentPage(driver);
	@Test
	public static void verifyingPlacingOrderWithCreditCardWhenOnlyGcInCart() throws Exception {
		
		GiftCertificatePageTasks.giftCertificateForm();
		
		CommonProccessUptoCheckout.commonProccess();
		
		CreditCardDetails.creditCardDetails();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
}
