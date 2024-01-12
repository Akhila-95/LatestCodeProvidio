package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import data.AllPayments;
import functionality.Actionsss;
import pageObjects.PaymentPage;

public class PaymentPageValidation extends baseClass{
	
private static final PaymentPage pp = new PaymentPage(driver);	
private static final AllPayments allPay = new AllPayments();


	 	public  static void VerifiedThatPlaceOrderClick() {
	 		test.info("Verified That placeOrder Btn click");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement miniCartPage = driver.findElement(By.xpath("//h2[@class='order-thank-you-msg']"));
	     	
	     	if (miniCartPage.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the placeOrder Btn");
	     	    test.pass("Successfully Clicked on the placeOrder Btn");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}

	public  void salesforcePaymentAllErrors() throws InterruptedException {
			
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(4000);
			
			test.info("Verifying with negative validations for card number ,exp and cvv");
			if((Actionsss.displayElement(pp.getSalesforceCreditCardIncompleteError()) &&( Actionsss.displayElement(pp.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(pp.getsalesforceCreditCvvError())))) {
				test.pass("Successfully error messages are displayed for card number exp date and cvv");
				logger.info("Successfully error messages are displayed for card number exp date and cvv");
			}else {
				test.fail("No error messages are displayed for card number exp date and cvv");
				logger.info("No error messages are displayed for card number exp date and cvv");
			}
		}
		
		public  void salesforceCvvAndExpError() throws InterruptedException {
			
			test.info("Verifying with negative validations for exp and cvv");
			allPay.salesforceCardNumber();
			Thread.sleep(3000);
			
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Actionsss.scrollWindowsByPixel(300);
			if((Actionsss.displayElement(pp.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(pp.getsalesforceCreditCvvError()))) {
				test.pass("Successfully error messages are displayed for exp date and cvv");
				logger.info("Successfully error messages are displayed for exp date and cvv");
			}else {
				test.fail("No error messages are displayed for exp date and cvv");
				logger.info("No error messages are displayed for  exp date and cvv");
			}
		}
		
		public void  salesforceCvvError() throws InterruptedException {
			test.info("Verifying with negative validations  cvv");
			
			allPay.salesforceCardNumber();
			
			allPay.salesforceExpDate();
			
			Thread.sleep(2000);
			Actionsss.scrollWindowsByPixel(300);
			if(Actionsss.displayElement(pp.getsalesforceCreditCvvError())){
				test.pass("Successfully error messages are displayed  cvv");
				logger.info("Successfully error messages are displayed cvv");
			}else {
				test.fail("No error messages are displayed for  cvv");
				logger.info("No error messages are displayed for cvv");		
			}
		}
		
		public void brainTreeAllPaymentsError() throws Exception {
			
			Actionsss.javascriptClick(pp.getReviewOrderBtn());
			Actionsss.scrollUp(driver);
			
			if(Actionsss.displayElement(pp.getErrorMsgInBrainTree())){
				test.pass("Error msg displayed when no mandatory details are entered");
				logger.info("Error msg displayed when no mandatory details are entered");
			}else {
				test.fail("No Error msg displayed when no mandatory details are entered");
				logger.info("No Error msg displayed when no mandatory details are entered");
			}
		}
}
