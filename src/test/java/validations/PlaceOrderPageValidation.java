package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PlaceOrderPage;

public class PlaceOrderPageValidation extends baseClass {
	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	
	public  static void VerifyingReviewOrderBtn() throws InterruptedException {
 		test.info("Verifying the review order Btn click");
 
 		if(Actionsss.elementSize(placeOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
     	    logger.info("Successfully Clicked on the review order button");
     	    test.pass("Successfully Clicked on the review order button");
			}
     	}else {
     		test.fail("Click failed");
     	}
 	}
	

	public static void bactToCartValidationInPlaceOrderPage() {
		test.info("Verifying the back to cart  display in  place order page");
		 if(Actionsss.displayElement(placeOrder.getBackToCart())) {
			 logger.info("Back to cart is displayed in place order page");
			 test.pass("Back to cart is displayed in place order page");
		 }else {
			 logger.info("No Back to cart  is displayed in  place order page");
			 test.pass("No Back to cart  is displayed in  place order page");
		 }
	}

	public static void customerInfoValidationInPlaceOrderPage() {
		 test.info("Verifying the customer information is displayed in  place order page ");
		 if(Actionsss.displayElement(placeOrder.getCustomerInfo())) {
			 logger.info("Customer information is displayed in  place order page");
			 test.pass("Customer information is displayed in  place order page");
		 }else {
			 logger.info("No Customer information is displayed in  place order page");
			 test.pass("No Customer information is displayed in  place order page");
		 }
	}
	
	public static void shippingDetailInfoValidationInPlaceOrderPage() {
		test.info("Verifying the shipping details form  is displayed in  place order page ");
		 if(Actionsss.displayElement(placeOrder.getshippingInfo())) {
			 logger.info("shipping details form  is displayed in  place order page");
			 test.pass("shipping details form is displayed in  place order page");
		 }else {
			 logger.info("No shipping details form is displayed in  place order page");
			 test.pass("No shipping details form is displayed in  place order page");
		 }
	}
	
	public static void orderSummaryValidationInPlaceOrderPage() {
		test.info("Verifying the orderSummary display in  place order page ");
		 if(Actionsss.displayElement(placeOrder .getOrderSummaryDiv())) {
			 logger.info("orderSummary  is displayed in  place order page");
			 test.pass("orderSummary  is displayed in  place order page");
		 }else {
			 logger.info("No orderSummary  is displayed in  place order page");
			 test.pass("No orderSummary  is displayed in  place order page");
		 }
	}
	
	public static void etgLogoValidationInPlaceOrderPage() {
		test.info("Verifying the  etg logo display in  place order page ");
		 if(Actionsss.displayElement(placeOrder.getEtgLogo())) {
			 logger.info(" Etg logo  is displayed in  place order page");
			 test.pass(" Etg logo is displayed in  place order page");
		 }else {
			 logger.info("No etg logo is displayed in  place order page");
			 test.pass("No etg logo is displayed in  place order page");
		 }
	}
	public static void pdpPageValidation() {
		test.info("Verifying the pagination of product from  place order page");
		if(Actionsss.displayElement(placeOrder.getPdpPage())) {
			 logger.info("Succesfully paginated to PDP page by clicking the product from  place order page");
			 test.pass("Succesfully paginated to PDP page by clicking the product from  place order page");
		 }else {
			 logger.info("Not paginated to PDP page by clicking the product from  place order page");
			 test.fail(" Not paginated to PDP page by clicking the product from  place order page");	 
		}
	}
	public static void placeOrderButtonInPaymentPage() {
		test.info("Verifying the  review order button display in  place order page ");
		 if(Actionsss.displayElement(placeOrder.getSelectPlaceOrderBtn())) {
			 logger.info("Place order button is displayed in  place order page");
			 test.pass("Place order button is displayed in  place order page");
		 }else {
			 logger.info("No Place order button is displayed in  place order page");
			 test.pass("No Place order button is displayed in  place order page");
		 }
	}
	public static void billingFormInPlaceOrderPage() {
		test.info("Verifying the payment info display in  place order page ");
		 if(Actionsss.displayElement(placeOrder.getgsummaryOfBillingAddress())) {
			 logger.info(" Payment info div is displayed in  place order page");
			 test.pass("  Payment info div is displayed in  place order page");
		 }else {
			 logger.info("No  Payment info div is displayed in  place order page");
			 test.pass("No  Payment info div is displayed in  place order page");
		 }
	}

	public static void editPaymentInReviewOrderPage() {
		test.info("Verifying the gift certificate payment edited with credit card from review order page");
		logger.info(previousPaymentInPlaceorderPage);
		logger.info(paymentafterEditInPlaceorderPage);
		logger.info(creditCardNumber);
		if((!previousPaymentInPlaceorderPage.equals(paymentafterEditInPlaceorderPage)) && (creditCardNumber.equals(paymentafterEditInPlaceorderPage))){
			test.pass("Successfully  gift certificate payment is  edited with credit card from review order page");
			logger.info("Successfully  gift certificate payment is  edited with credit card from review order page");
		}else {
			test.fail("No  gift certificate payment is  edited with credit card from review order page");
			logger.info("NO gift certificate payment is  edited with credit card from review order page");
		}
	}
	
	public static void editPaypalPaymentInReviewOrderPage() {
		test.info("Verifying the display of paypal once edited payment edited is edited with paypal in review order page");
		logger.info(getTextOfPaypalInPaymentPage);
		logger.info(paymentafterEditInPlaceorderPage);
		//logger.info(creditCardNumber);
		if(getTextOfPaypalInPaymentPage.equals(paymentafterEditInPlaceorderPage)){
			test.pass("Successfully  paypal is displayed after updating the Gc with paypal and clicks on edit it shows paypal,and also after review order button click same paypal is dispalyed in review order page");
			logger.info("Successfully  gift certificate payment is  edited with credit card from review order page");
		}else {
			test.fail("No  gift certificate payment is  edited with credit card from review order page");
			logger.info("NO gift certificate payment is  edited with credit card from review order page");
		}
	}
	
	public static void editPaymentToPaypalReviewOrderPage() {
		test.info("Verifying the display of paypal in review order page");
		logger.info(getTextOfPaypalInPaymentPage);
		logger.info(paymentafterEditInPlaceorderPage);
		//logger.info(creditCardNumber);
		if(getTextOfPaypalInPaymentPage.equals(paymentafterEditInPlaceorderPage)){
			test.pass("Successfully  paypal is displayed after updating the Gc with paypal and clicks on edit it shows paypal,and also after review order button click same paypal is dispalyed in review order page");
			logger.info("Successfully  paypal is displayed after updating the Gc with paypal and clicks on edit it shows paypal,and also after review order button click same paypal is dispalyed in review order page");
		}else {
			test.fail("No paypal is displayed after updating the Gc with paypal and clicks on edit it shows paypal,and also after review order button click same paypal is dispalyed in review order page");
			logger.info("No  paypal is displayed after updating the Gc with paypal and clicks on edit it shows paypal,and also after review order button click same paypal is dispalyed in review order page");
		}
	}
}
