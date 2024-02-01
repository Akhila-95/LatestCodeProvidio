package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;

public class ReviewOrderPageValidation extends baseClass {
	

	private static final ReviewOrderPage reviwOrder = new ReviewOrderPage(driver);
	private static final 	PaymentPage pp = new PaymentPage(driver);
	public  static void VerifyingReviewOrderBtn() throws InterruptedException {
 		test.info("Verifying the review order Btn click");
 
 		if(Actionsss.elementSize(reviwOrder.getgsummaryOfBillingAddressList())) {
			if(Actionsss.displayElement(reviwOrder.getgsummaryOfBillingAddress())) {
     	    logger.info("Successfully Clicked on the review order button");
     	    test.pass("Successfully Clicked on the review order button");
			}
     	}else {
     		test.fail("Click failed");
     	}
 	}
	

	public static void bactToCartValidationInreviewOrderPage() throws InterruptedException{
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the back to cart  display in review order page");
			 if(Actionsss.displayElement(reviwOrder.getBackToCart())) {
				 logger.info("Back to cart is displayed in review order page");
				 test.pass("Back to cart is displayed in review order page");
			 }else {
				 logger.info("No Back to cart  is displayed in review order page");
				 test.pass("No Back to cart  is displayed in review order page");
			 }
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}

	public static void customerInfoValidationInreviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			 test.info("Verifying the customer information is displayed in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getCustomerInfo())) {
				 logger.info("Customer information is displayed in review order page");
				 test.pass("Customer information is displayed in review order page");
			 }else {
				 logger.info("No Customer information is displayed in review order page");
				 test.pass("No Customer information is displayed in review order page");
			 }
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	public static void shippingDetailInfoValidationInreviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the shipping details form  is displayed in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getshippingInfo())) {
				 logger.info("shipping details form  is displayed in review order page");
				 test.pass("shipping details form is displayed in review order page");
			 }else {
				 logger.info("No shipping details form is displayed in review order page");
				 test.pass("No shipping details form is displayed in review order page");
			 }
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	public static void orderSummaryValidationInreviewOrderPage() throws InterruptedException {
		if(!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the orderSummary display in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getOrderSummaryDiv())) {
				 logger.info("orderSummary  is displayed in review order page");
				 test.pass("orderSummary  is displayed in review order page");
			 }else {
				 logger.info("No orderSummary  is displayed in review order page");
				 test.pass("No orderSummary  is displayed in review order page");
			 }
		 }else {
				test.info("Salesforce payment is activated");
				test.info("No review order page in salesforce payment");
			}
	}
	
	public static void etgLogoValidationInreviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the  etg logo display in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getEtgLogo())) {
				 logger.info(" Etg logo  is displayed in review order page");
				 test.pass(" Etg logo is displayed in review order page");
			 }else {
				 logger.info("No etg logo is displayed in review order page");
				 test.pass("No etg logo is displayed in review order page");
			 }
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	public static void pdpPageValidation() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the pagination of product from review order page");
			if(Actionsss.displayElement(reviwOrder.getPdpPage())) {
				 logger.info("Succesfully paginated to PDP page by clicking the product from review order page");
				 test.pass("Succesfully paginated to PDP page by clicking the product from review order page");
			 }else {
				 logger.info("Not paginated to PDP page by clicking the product from review order page");
				 test.fail(" Not paginated to PDP page by clicking the product from review order page");	 
			}
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	public static void placeOrderButtonInPaymentPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the  place order button display in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getSelectPlaceOrderBtn())) {
				 logger.info("Place order button is displayed in review order page");
				 test.pass("Place order button is displayed in review order page");
			 }else {
				 logger.info("No Place order button is displayed in review order page");
				 test.pass("No Place order button is displayed in review order page");
			 }
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	public static void billingFormInreviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			test.info("Verifying the payment info display in review order page ");
			 if(Actionsss.displayElement(reviwOrder.getgsummaryOfBillingAddress())) {
				 logger.info(" Payment info div is displayed in review order page");
				 test.pass("  Payment info div is displayed in review order page");
			 }else {
				 logger.info("No  Payment info div is displayed in review order page");
				 test.pass("No  Payment info div is displayed in review order page");
			 }
		 }else {
				test.info("Salesforce payment is activated");
				test.info("No review order page in salesforce payment");
			}
	}

	public static void editPaymentInReviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
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
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	public static void editPaypalPaymentInReviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
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
			}else {
				test.info("Salesforce payment is activated");
				test.info("No review order page in salesforce payment");
			}
	}
	
	public static void editPaymentToPaypalReviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
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
	}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
}
