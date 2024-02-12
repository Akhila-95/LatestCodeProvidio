package tasks;

import com.providio.testcases.baseClass;

import CreditCardPayment.CreditCardDetails;
import PaypalPayment.CheckOutPaypal;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingPageObject;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation ;
import validations.ShippingPageValidation;

public class ReviewOrderPageTask extends baseClass{

	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final ShippingPageObject shippingPage = new ShippingPageObject(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void reviewOrderPage() throws Exception {
		if(Actionsss.elementSize(reviewOrder.getgsummaryOfBillingAddressList()) && Actionsss.elementSize(reviewOrder.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(reviewOrder.getgsummaryOfBillingAddress()) && (Actionsss.displayElement(reviewOrder.getSelectPlaceOrderBtn()))   ) {
				logger.info("Review order page is loaded");
			//	CreditCardDetails.creditCardDetails();
			}
		}else {
			PaymentPageTasks.creditCardWithValidDetails();
			//PaymentPageTasks.gcRedemption();
		}
	}
	
	public static void getBackToCart() throws Exception {	
		 reviewOrderPage();
		 ReviewOrderPageValidation.bactToCartValidationInreviewOrderPage();
		 Actionsss.click(paymentPage.getBackToCart());				
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
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Actionsss.randomElementFromList(paymentPage.getproductsInCheckoutPage2());
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
	
	
	public static void placeOrder() throws Exception {
		//reviewOrderPage();
	
		if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	
			Actionsss.scrollWindowsByPixel(700);
			logger.info("Salesforce payment activated");	
			Thread.sleep(1000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}else {
			Actionsss.scrollWindowsByPixel(700);
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Thread.sleep(5000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}
	}
		
	public static void editShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			previousShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			Actionsss.javascriptClick(reviewOrder.getEditShippingAddressInRop());
			Thread.sleep(1000);
			Actionsss.editShippingAddressFromRop(shippingPage.getShippingAddress());
			Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			Thread.sleep(1000);
			ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
			PaymentPageTasks.creditCardWithValidDetails();			
			PaymentPageTasks.clickReviewOrderButton();
			Thread.sleep(1000);
			editedShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			ReviewOrderPageValidation.editShippingAddressValidation();
			PaymentPageTasks.clickReviewOrderButton();
			placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();		 			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editPhoneNumInShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 Actionsss.click(reviewOrder.getEditShippingAddressInRop());
			 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), "8765987653","shipping phone number");
			 Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			 Thread.sleep(1000);
			 ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
			 PaymentPageTasks.creditCardWithValidDetails();		
			 Actionsss.scrollIntoCenterView(paymentPage.getReviewOrderBtn());
			 Actionsss.scrollWindowsByPixel(400);
			 Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());
			 Thread.sleep(5000);
			 editedPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 ReviewOrderPageValidation.editPhoneNumShippingAddressValidation();
			 Thread.sleep(1000);
			 placeOrder();
			 OrderPageValidation.validatePlacetheOrderPage();
			 OrderPageValidation.orderNumberAndOrderDate();		
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void editBillingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());			 
			 Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());
			 Actionsss.click(paymentPage.getUpdateBillingAddress());
			 Thread.sleep(1000);
			 Actionsss.scrollWindowsByPixel(200);
			 Actionsss.editBillingAddressFromRop(paymentPage.getBillingAddress());
			 PaymentPageTasks.creditCardWithValidDetails();		
			 Actionsss.scrollWindowsByPixel(200);
			 Actionsss.scrollIntoCenterView(paymentPage.getReviewOrderBtn());
			 Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());
			 Thread.sleep(5000);
			 editedBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());
			 ReviewOrderPageValidation.editedBillingAddressValidation();
			 placeOrder();
			 OrderPageValidation.validatePlacetheOrderPage();
			 OrderPageValidation.orderNumberAndOrderDate();
			 
			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	
	public static void editPhoneNumberInBillingAddress() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Thread.sleep(2000);				
			prevoiusBillingPhoneNumber =Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());	
			Thread.sleep(1000);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());		
			Actionsss.sendKeys(paymentPage.getBillingPhoneNumber(), "9876543567", "edited phone number  in billing address");
			PaymentPageTasks.creditCardWithValidDetails();		
			 if(Actionsss.elementSize(paymentPage.getBrainTree())) {
				 Actionsss.scrollWindowsByPixel(200);
				 Actionsss.scrollIntoCenterView(paymentPage.getReviewOrderBtn());
				 Actionsss.scrollWindowsByPixel(400);
				 Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());			    	
			    	Thread.sleep(5000);
		    	}
			
			editedBillingPhoneNumber=Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());				
			PaymentPageValidation.phoneNumberInBillingAddressValidation();	
			placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
/*	
	public static void editPaymentToPaypal() throws Exception {
		reviewOrderPage();
		if(Actionsss.elementSize(reviewOrder.getStripePaymentInReviewOrderPageList())) {
			logger.info("stripe activated");
			if(Actionsss.elementSize(reviewOrder.getGcStripePaymentInReviewOrderPageList())) {
				logger.info("gc");
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcCodeInstripePaymentInReviewOrderPage());
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			} {
				
			}
			
			
		}else if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {
			logger.info("brain tree activated");
			if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
				logger.info("credit card");
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
				logger.info(previousPaymentInPlaceorderPage);
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else if(Actionsss.elementSize(reviewOrder.getpaypalPaymentBeforeEditList())) {
				logger.info("paypal");
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				logger.info(previousPaymentInPlaceorderPage);
				}
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList())){
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
							
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
					logger.info("brain tree activated");
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					logger.info(paymentafterEditInPlaceorderPage);
					logger.info("If payment is brain tree then clicked on edit and check the edited payment");
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					WebElement paypal= driver.findElement(By.xpath("//option[@id='braintreePaypalAccount']"));
					getTextOfPaypalInPaymentPage= paypal.getAttribute("value");
					logger.info(getTextOfPaypalInPaymentPage);
					
					PaymentPageTasks.clickReviewOrderButton();
					ReviewOrderPageValidation.editPaymentToPaypalReviewOrderPage();
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
	
	public static void cybersource() throws InterruptedException, Exception {
		logger.info("cybersource activated");			
		if(Actionsss.elementSize(reviewOrder.getcybersourceCardDetailsInReviewOrderPageList())) {
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.gcRedemption();
			if(Actionsss.elementSize(paymentPage.getNextReviewOrderBtnList())) {
				if(Actionsss.displayElement(paymentPage.getNextReviewOrderBtn())) {
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
				}
			}
			if(Actionsss.elementSize(reviewOrder.getcybersourceGcDetailsInReviewOrderPageList())) {
				paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
				ReviewOrderPageValidation.editPaymentInReviewOrderPage();			
			}else if(Actionsss.elementSize(reviewOrder.getcybersourceGiftCertificateInReviewOrderPageList())&& Actionsss.elementSize(reviewOrder.getcybersourceVisaInReviewOrderPageList())) {
				paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				combinationPaymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
				ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			}							
	}else {
		previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
		Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
	}
  }
	*/
	
	
	public static void editPaymentFromCreditCardToGiftCerticficate() throws Exception {
		
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from credit card to gift certificate from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree activated");				
				if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					logger.info("credit card details entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					
				}			
			}else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
				 logger.info("Cybersource payment activated");
				 	if(Actionsss.elementSize(reviewOrder.getcybersourceCardDetailsInReviewOrderPageList())) {
				 		logger.info("credit card details entered");
				 		Actionsss.scrollWindowsByPixel(100);
				 		previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				 		Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				 		PaymentPageTasks.gcRedemption();
				 		paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
				 	}				 
			}
			ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());			
		}
	}
	
	public static void creditCardToPaypal() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from Credit card to Paypal from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree activated");				
				if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
					logger.info("credit card details entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					if( Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
						CheckOutPaypal.paypalFromCheckout();
					}
					Thread.sleep(1000);
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments");
			}
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
		}
	}
	
	
	
	public static void editPaymentFromGiftCertificateToCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from Gift certificate to Credit card from review order page");
			
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList())){
					logger.info("gc entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();				
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());			
				}
				
			}else  if(Actionsss.elementSize(reviewOrder.getcybersourceGcDetailsInReviewOrderPageList())) {				
					logger.info("cybersource activated");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
					PaymentPageTasks.gcRemoved();				
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
			}
			
				ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				ReviewOrderPageTask.placeOrder();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());	
		}
	}
	
	public static void editPaymentFromGiftCertificateToPaypal() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {			
			test.info("Verifying the payment change from Gift certificate to Paypal from review order page");
			
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList())){
					logger.info("gc entered");
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();
					Thread.sleep(2000);
					if( Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
						CheckOutPaypal.paypalFromCheckout();
					}
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				}else {
					test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments");
					logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments");
				}
				ReviewOrderPageTask.placeOrder();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());
			}
		}
	}
	
	public static void editPaymentFromPaypalToGiftCertificate() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal to Gift certificate from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("brain tree");
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {					
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments");
			}						
			ReviewOrderPageValidation.editPaymentInReviewOrderPage();	
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	}
	
	public static void editPaymentFromPaypalToCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal to Credit Card from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {	
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					Actionsss.javascriptClick(paymentPage.getBrainTreeCreditCardTab());
					CreditCardDetails.creditCardDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());					
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments");
			}
			ReviewOrderPageValidation.editPaymentInReviewOrderPage();	
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
		}
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndCreditCardToGiftCertificate() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());					
				}				
			}else if(Actionsss.elementSize(reviewOrder.getcybersourceVisaInReviewOrderPageList())&& Actionsss.elementSize(reviewOrder.getcybersourceGiftCertificateInReviewOrderPageList())){
				logger.info("cybersource activated");
				previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
			}
			ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());			
		}		
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndCreditCardToCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("Brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
		}
		
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndPaypalToPaypal() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("Brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();
					Thread.sleep(2000);
					//CheckOutPaypal.paypalFromCheckout();
					PaymentPageTasks.clickReviewOrderButton();
					Thread.sleep(1000);
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	
	public static void editPaymentFromCombinationOfGiftCertificateAndPaypalToGiftCertificate() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	
	

	public static void editPaymentFromPaypalToCombinationOfGiftCertificateAndPaypal() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
					Thread.sleep(2000);
					firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	
	
	public static void editPaymentFromPaypalToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					Actionsss.javascriptClick(paymentPage.getBrainTreeCreditCardTab());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
					firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	
	
	public static void editPaymentFromCreditCardToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
					firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	
	public static void editPaymentFromCreditCardToCombinationOfGiftCertificateAndPaypal() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
					firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				}
			}else {
				logger.info("other payment");
			}
			ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
			Actionsss.click(homePage.clickOnLogo());
			
		}
	  }
	public static void brainTree() throws InterruptedException, Exception {
		
	/*	
		else if (Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {
			logger.info("Paypal details entered");
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());		
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			PaymentPageTasks.creditCardWithValidDetails();
		
		}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())) {
			logger.info("gc entered");
			if( Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
				CheckOutPaypal.paypalFromCheckout();
			}else {
				PaymentPageTasks.creditCardWithValidDetails();
			}
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
						
			if(Actionsss.elementSize(paymentPage.getBrainTree())) {	
				logger.info("If payment is brain tree then clicked on edit and check the edited payment");
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else {
				placeOrder();
				ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			}
		}*/
	}
}
