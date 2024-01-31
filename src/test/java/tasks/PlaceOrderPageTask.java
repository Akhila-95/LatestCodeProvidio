package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import data.PaymentDetails;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.PlaceOrderPage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.PlaceOrderPageValidation;

public class PlaceOrderPageTask extends baseClass{

	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	private static final PaymentPage pp = new PaymentPage(driver);
	
	public static void placeOrderPage() throws Exception {
		if(Actionsss.elementSize(placeOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
				logger.info("Placing order page is loaded");
				PaymentDetails.creditCardDetails();
			}
		}else {
			//PaymentPageTasks.creditCardWithValidDetails();
			PaymentPageTasks.gcRedemption();
		}
	}
	
	public static void getBackToCart() throws Exception {	
		 placeOrderPage();
		 PlaceOrderPageValidation.bactToCartValidationInPlaceOrderPage();
		 Actionsss.click(pp.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		 ShippingPageTasks.enterValidAddress();
		 PaymentPageTasks.creditCardWithValidDetails();
		 PlaceOrderPageValidation.bactToCartValidationInPlaceOrderPage();
	
	}
	
	public static void getCutomerInfoInPaymentPage() throws Exception {	
		placeOrderPage();
		PlaceOrderPageValidation.customerInfoValidationInPlaceOrderPage();
	}
	
	public void  getshippingInfo() throws Exception {
		placeOrderPage();
		PlaceOrderPageValidation.shippingDetailInfoValidationInPlaceOrderPage();		
	}
	
	public static void getOrderSummary() throws Exception {
		placeOrderPage();
		PlaceOrderPageValidation.orderSummaryValidationInPlaceOrderPage();		
	}
	
	public static void getPaymentInfo() throws Exception {
		placeOrderPage();
		PlaceOrderPageValidation.billingFormInPlaceOrderPage();		
	}
	
	
	public static void paginationOfProductsInPaymentPage() throws InterruptedException, Exception {
		placeOrderPage();
		Actionsss.randomElementFromList(pp.getproductsInCheckoutPage2());
		PlaceOrderPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		ShippingPageTasks.enterValidAddress();
		PaymentPageTasks.creditCardWithValidDetails();
	}

	public static void getEtgLogo() throws Exception {
		placeOrderPage();
		PlaceOrderPageValidation.etgLogoValidationInPlaceOrderPage();
	
	}
	public static void getPlaceOrder() throws Exception {
		placeOrderPage();
		PlaceOrderPageValidation.placeOrderButtonInPaymentPage();	
	}
	
	public static void clickPlaceOrderButton() throws Exception {
		placeOrderPage();			
		placeOrder();
	}
	
	public static void placeOrder() throws InterruptedException {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(pp.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");			
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
		placeOrderPage();
	
		if(Actionsss.elementSize(placeOrder.getCreditCardPaymentBeforeEditList())) {
			logger.info("credit card");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getCreditCardPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(placeOrder.getpaypalPaymentBeforeEditList())) {
			logger.info("paypal");
		//	previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getpaypalPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(placeOrder.getGcPaymentBeforeEditList())){
			logger.info("gc");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getGcPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.removeAppliedGc();
			logger.info("edit credit card");
			PaymentPageTasks.creditCardWithValidDetails();
			logger.info("Entered credit card num is " +creditCardNumber);
			paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getGcPaymentBeforeEdit());
			logger.info(paymentafterEditInPlaceorderPage);
						
			if(Actionsss.elementSize(pp.getBrainTree())) {	
				logger.info("If payment is brain tree then clicked on edit and check the edited payment");
				Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
			}else {
				placeOrder();
				PlaceOrderPageValidation.editPaymentInReviewOrderPage();
			}
		}	
	}
	
	public static void editPaymentToPaypal() throws Exception {
		placeOrderPage();
	
		if(Actionsss.elementSize(placeOrder.getCreditCardPaymentBeforeEditList())) {
			logger.info("credit card");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getCreditCardPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(placeOrder.getpaypalPaymentBeforeEditList())) {
			logger.info("paypal");
			if(Actionsss.elementSize(placeOrder.getBrainTreeDisplay())) {
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getBrainPaypalPaymentInReviewOrderPage());
			logger.info(previousPaymentInPlaceorderPage);
			}
			Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
		}else if(Actionsss.elementSize(placeOrder.getGcPaymentBeforeEditList())){
			logger.info("gc");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getGcPaymentBeforeEdit());
			logger.info(previousPaymentInPlaceorderPage);
			Actionsss.javascriptClick(placeOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.removeAppliedGc();
			PaymentPageTasks.paypal();
			logger.info("edit paypal");			
			
			Thread.sleep(2000);
			//paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getBrainPaypalPaymentBeforeEdit());
			//logger.info(paymentafterEditInPlaceorderPage);
						
			if(Actionsss.elementSize(placeOrder.getBrainTreeDisplay())) {
				logger.info("brain tree activated");
				paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getBrainPaypalPaymentInReviewOrderPage());
				logger.info(paymentafterEditInPlaceorderPage);
				logger.info("If payment is brain tree then clicked on edit and check the edited payment");
				Actionsss.click(placeOrder.getEditPaymentInPlaceOrderPage());
				WebElement paypal= driver.findElement(By.xpath("//option[@id='braintreePaypalAccount']"));
				getTextOfPaypalInPaymentPage= paypal.getAttribute("value");
				logger.info(getTextOfPaypalInPaymentPage);
				
				PaymentPageTasks.clickReviewOrderButton();
				PlaceOrderPageValidation.editPaymentToPaypalReviewOrderPage();
				placeOrder();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
			}else {
				logger.info("");
				placeOrder();
				PlaceOrderPageValidation.editPaymentInReviewOrderPage();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				
			}
		}
	}
}
