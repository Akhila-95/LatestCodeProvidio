package OrderRegression;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import PaymentProccess.CommonProccessUptoCheckout;
import data.PaymentDetails;
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
		
		PaymentDetails.creditCardDetails();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
	
}
