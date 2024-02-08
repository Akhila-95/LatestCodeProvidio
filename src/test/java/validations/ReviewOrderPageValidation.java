package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ReviewOrderPage;

public class ReviewOrderPageValidation extends baseClass {
	

	private static final ReviewOrderPage reviwOrder = new ReviewOrderPage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if(!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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

		test.info("Verifying the  payment edited from review order page");
		logger.info(previousPaymentInPlaceorderPage);
		logger.info(paymentafterEditInPlaceorderPage);
		if(!previousPaymentInPlaceorderPage.equals(paymentafterEditInPlaceorderPage)) {
			test.pass("Successfully payment is edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
			logger.info("Successfully payment is edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
		}else {
			test.fail("Payment is not edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
			logger.info("Payment is not edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
		}
	}
	
	public static void editCombinationOfPaymentToSinglePaymentInReviewOrderPage() {
		test.info("Verifying the combination of is payment edited from review order page");
		logger.info(previousFirstcombinationOfPaymentInPlaceorderPage);
		logger.info(previousSecondcombinationOfPaymentInPlaceorderPage);
		logger.info(paymentafterEditInPlaceorderPage);
		if (!(previousFirstcombinationOfPaymentInPlaceorderPage.equals(paymentafterEditInPlaceorderPage) &&
			      previousSecondcombinationOfPaymentInPlaceorderPage.equals(paymentafterEditInPlaceorderPage))) {
			
			  test.pass("Succesfully the combination of payment is edited to single payment ,the combination of payment are " +			     
					previousFirstcombinationOfPaymentInPlaceorderPage +" and " +previousSecondcombinationOfPaymentInPlaceorderPage + "are edited to " +paymentafterEditInPlaceorderPage);
			  logger.info("Succesfully the combination of payment is edited to single payment ,the combination of payment are " +
			      previousFirstcombinationOfPaymentInPlaceorderPage +" and " +previousSecondcombinationOfPaymentInPlaceorderPage + "are edited to " +paymentafterEditInPlaceorderPage);
			
		}else {
			test.fail("combination of payment is not edited to single payment");
			logger.info("combination of payment is not edited to single payment");
		}
	}
	
	public static void editPaypalPaymentInReviewOrderPage() throws InterruptedException {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
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
		public static void editShippingAddressValidation() {
			logger.info(previousShippingAddressInRop);
			logger.info(editedShippingAddressInRop);
			if(!previousShippingAddressInRop.equals(editedShippingAddressInRop)) {
				test.pass("Successfully  shipping address is edited from review order page ,the previous shipping address is " +previousShippingAddressInRop + " and edited shipping address is " +editedShippingAddressInRop);
				logger.info("Successfully  shipping address is edited from review order page ,the previous shipping address is " +previousShippingAddressInRop + " and edited shipping address is " +editedShippingAddressInRop);
			}else {
				test.fail("No shipping address is edited from review order page ,the previous shipping order is " +previousShippingAddressInRop + " and edited shipping address is " +editedShippingAddressInRop);
				logger.info("No shipping address is edited from review order page ,the previous shipping order is " +previousShippingAddressInRop + " and edited shipping address is " +editedShippingAddressInRop);
			}
		}
		
		public static void editPhoneNumShippingAddressValidation() {
			logger.info( previousPhoneNumInShippingAddressInRop);
			logger.info(editedPhoneNumInShippingAddressInRop);
			if(!editedPhoneNumInShippingAddressInRop.equals( previousPhoneNumInShippingAddressInRop)) {
				test.pass("Successfully  phone number is edited from review order page ,the previous phone number is " + previousPhoneNumInShippingAddressInRop + " and edited phone number is " +editedPhoneNumInShippingAddressInRop);
				logger.info("Successfully  phone number is edited from review order page ,the previous phone number is " + previousPhoneNumInShippingAddressInRop +  " and edited phone number is " +editedPhoneNumInShippingAddressInRop);
			}else {
				test.fail("No phone number is edited from review order page ,the previous phone number is " + previousPhoneNumInShippingAddressInRop + " and edited phone number is " +editedPhoneNumInShippingAddressInRop);
				logger.info("No phone number is edited from review order page ,the previous phone number is " + previousPhoneNumInShippingAddressInRop +  " and edited phone number is " +editedPhoneNumInShippingAddressInRop);
			}
		}
		public static void editedBillingAddressValidation() {
			logger.info(previousBillingAddressInRop);
			logger.info(editedBillingAddressInRop);
			if(!previousBillingAddressInRop.equals(editedBillingAddressInRop)) {
				test.pass("Successfully  billing address is edited from review order page ,the previous  billing address  is " +previousBillingAddressInRop + " and edited  billing address  is " +editedBillingAddressInRop);
				logger.info("Successfully  billing address is edited from review order page ,the previous  billing address  is " +previousBillingAddressInRop + " and edited  billing address  is " +editedBillingAddressInRop);
			}else {
				test.fail("No billing address is edited from review order page ,the previous  billing address  is " +previousBillingAddressInRop + " and edited  billing address  is " +editedBillingAddressInRop);
				logger.info("No billing address is edited from review order page ,the previous  billing address  is " +previousBillingAddressInRop + " and edited  billing address  is " +editedBillingAddressInRop);
			}
		}
		
		public static void editPaymentsInReviewOrderPage() {
			logger.info(previousPaymentInPlaceorderPage);
			logger.info(paymentafterEditInPlaceorderPage);
			if(!previousPaymentInPlaceorderPage.equals(paymentafterEditInPlaceorderPage)) {
				test.pass("Successfully payment is edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
				logger.info("Successfully payment is edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
			}else {
				test.fail("Payment is not edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
				logger.info("Payment is not edited to " + paymentafterEditInPlaceorderPage +" from " +previousPaymentInPlaceorderPage);
			}
		}
}
