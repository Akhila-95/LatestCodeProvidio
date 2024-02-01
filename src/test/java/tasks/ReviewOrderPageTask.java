package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import data.PaymentDetails;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation ;

public class ReviewOrderPageTask extends baseClass{

	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPage pp = new PaymentPage(driver);
	
	public static void reviewOrderPage() throws Exception {
		if(Actionsss.elementSize(reviewOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(reviewOrder.getgsummaryOfBillingAddress())) {
				logger.info("Placing order page is loaded");
				PaymentDetails.creditCardDetails();
			}
		}else {
			//PaymentPageTasks.creditCardWithValidDetails();
			PaymentPageTasks.gcRedemption();
		}
	}
	
	public static void getBackToCart() throws Exception {	
		 reviewOrderPage();
		 ReviewOrderPageValidation.bactToCartValidationInreviewOrderPage();
		 Actionsss.click(pp.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		 ShippingPageTasks.enterValidAddress();
		 PaymentPageTasks.creditCardWithValidDetails();
		 ReviewOrderPageValidation .bactToCartValidationInreviewOrderPage();
	
	}
	
	public static void getCutomerInfoInReviewOrderPage() throws Exception {	
		reviewOrderPage();
		ReviewOrderPageValidation.customerInfoValidationInreviewOrderPage();
	}
	
	public void  getshippingInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.shippingDetailInfoValidationInreviewOrderPage();		
	}
	
	public static void getOrderSummary() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.orderSummaryValidationInreviewOrderPage();		
	}
	
	public static void getPaymentInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.billingFormInreviewOrderPage();		
	}
	
	
	public static void paginationOfProductsInReviewOrderPage() throws InterruptedException, Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			Actionsss.randomElementFromList(pp.getproductsInCheckoutPage2());
			ReviewOrderPageValidation.pdpPageValidation();
			ViewCartPageTasks.viewCartpage();
			CheckOutPageTasks.GuestMailCheckOut();
			ShippingPageTasks.enterValidAddress();
			PaymentPageTasks.creditCardWithValidDetails();
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}

	public static void getEtgLogo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.etgLogoValidationInreviewOrderPage();
	
	}
	public static void getPlaceOrder() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.placeOrderButtonInPaymentPage();	
	}
	
	public static void clickPlaceOrderButton() throws Exception {
		reviewOrderPage();			
		placeOrder();
	}
	
	public static void placeOrder() throws InterruptedException {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(pp.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");	
			Thread.sleep(1000);
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Thread.sleep(2000);
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}
	}
	
	public static void editPaymentToCreditCard() throws Exception {
		reviewOrderPage();
	
		if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBeforeEditList())) {
			logger.info("credit card");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(reviewOrder.getpaypalPaymentBeforeEditList())) {
			logger.info("paypal");
		//	previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getpaypalPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())){
			logger.info("gc");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.removeAppliedGc();
			logger.info("edit credit card");
			PaymentPageTasks.creditCardWithValidDetails();
			logger.info("Entered credit card num is " +creditCardNumber);
			paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
			logger.info(paymentafterEditInPlaceorderPage);
						
			if(Actionsss.elementSize(pp.getBrainTree())) {	
				logger.info("If payment is brain tree then clicked on edit and check the edited payment");
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else {
				placeOrder();
				ReviewOrderPageValidation .editPaymentInReviewOrderPage();
			}
		}	
	}
	
	public static void editPaymentToPaypal() throws Exception {
		reviewOrderPage();

		if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBeforeEditList())) {
			logger.info("credit card");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(reviewOrder.getpaypalPaymentBeforeEditList())) {
			logger.info("paypal");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplay())) {
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
			logger.info(previousPaymentInPlaceorderPage);
			}
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())){
			logger.info("gc");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.javascriptClick(reviewOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.removeAppliedGc();
			PaymentPageTasks.paypal();
			logger.info("edit paypal");			
			
			Thread.sleep(2000);
			//paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getBrainPaypalPaymentBeforeEdit());
			//logger.info(paymentafterEditInPlaceorderPage);
						
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplay())) {
				logger.info("brain tree activated");
				paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				logger.info(paymentafterEditInPlaceorderPage);
				logger.info("If payment is brain tree then clicked on edit and check the edited payment");
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				WebElement paypal= driver.findElement(By.xpath("//option[@id='braintreePaypalAccount']"));
				getTextOfPaypalInPaymentPage= paypal.getAttribute("value");
				logger.info(getTextOfPaypalInPaymentPage);
				
				PaymentPageTasks.clickReviewOrderButton();
				ReviewOrderPageValidation .editPaymentToPaypalReviewOrderPage();
				placeOrder();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
			}else {
				logger.info("");
				placeOrder();
				ReviewOrderPageValidation .editPaymentInReviewOrderPage();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				
			}
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
}
