package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import CreditCardPayment.AllValidationErrorMessagesOfCreditCard;
import CreditCardPayment.CreditCardDetails;
import GifCertificatePayment.GiftCertificateForGc;
import GifCertificatePayment.GiftCertificateInCombination;
import PaypalPayment.CheckOutPaypal;
import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.PaymentPageObjects;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingPageObject;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation;
import validations.ShippingPageValidation;

public class PaymentPageTasks extends baseClass {


	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final ShippingPageObject shippingPage = new ShippingPageObject(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void paymentPageView() throws Exception {
		if((Actionsss.elementSize(paymentPage.getpaymentPageList()))&& (Actionsss.elementSize(paymentPage.getNextReviewOrderBtnList()) || Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList()))) {
			if((Actionsss.displayElement(paymentPage.getpaymentPage())) ){
				logger.info("Paymnet page is loaded");
			}
		}else {
			ShippingPageTasks.enterValidAddress();
		}
		
		Thread.sleep(2000);
	}
	
	public static void getBackToCart() throws Exception {	
		 paymentPageView();
		 PaymentPageValidation.bactToCartValidationInPaymentPage();
		 Actionsss.click(paymentPage.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		 ShippingPageTasks.enterValidAddress();
		 PaymentPageValidation.bactToCartValidationInPaymentPage();
	
	}
	public static void getCutomerInfoInPaymentPage() throws Exception {	
		paymentPageView();
		PaymentPageValidation.customerInfoValidationInPaymentPage();
	}
	
	public void  getshippingInfo() throws Exception {
		paymentPageView();
		PaymentPageValidation.shippingDetailValidationInPaymentPage();		
	}
	
	public static void getOrderSummary() throws Exception {
		paymentPageView();
		PaymentPageValidation.orderSummaryValidationInPaymentPage();		
	}
	
	public static void getPaymentForm() throws Exception {
		paymentPageView();
		PaymentPageValidation.paymentFormInPaymentPage();		
	}
	
	public static void paginationOfProductsInPaymentPage() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.randomElementFromList(paymentPage.getproductsInCheckoutPage2());
		PaymentPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		ShippingPageTasks.enterValidAddress();
	}

	public static void getEtgLogo() throws Exception {
		paymentPageView();
		PaymentPageValidation.etgLogoValidationInPaymentPage();
	
	}
	public static void getReviewOrder() throws Exception {
		paymentPageView();
		PaymentPageValidation.reviewOrderButtonInPaymentPage();
	
	}
	
	public static void editShippindAddressFromPaymentPage() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		previousAddresses=Actionsss.getTextOfElement(paymentPage.getShippingAddress());		
		Actionsss.click(paymentPage.getEditShipping());
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {			
			AddressSelection.editShippingAddress();
		}else {
			AddressSelection.selectingRandomSavedShippingAddress();
			Actionsss.click(shippingPage.getUpdateAddressBtn());
			AddressSelection.editShippingAddress();
		}
		Thread.sleep(2000);
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());				
		ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
		editedAddress=Actionsss.getTextOfElement(shippingPage.getShippingAddress());
		PaymentPageValidation.editShippingValidationInCOP3();
		Thread.sleep(1000);
		
		PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
		
	}
	public static void editGiftMessageInCop2() throws Exception {
		paymentPageView();
		Thread.sleep(1000);
		Actionsss.CombinedClick(paymentPage.getEditShipping());
		Actionsss.CombinedClick(shippingPage.getGiftMessageCheckButton());
		String giftMessage ="Birthday gift";			
		Actionsss.sendKeys(shippingPage.getGiftMessagegiftMessageTextArea(), giftMessage,"gift message");
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
		Thread.sleep(2000);
		PaymentPageValidation.displayOfGiftMessageInCheckoutPage3();
	}
	
	public static void editCustomerInfoFromCop3() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {			
			Thread.sleep(1000);
			previousMail=Actionsss.getTextOfElement(paymentPage.getEditCustomerInfo());		
			Actionsss.click(paymentPage.getCustomerInfoFromCop3());		
			Faker faker = new Faker();
			String randomFirstName = faker.name().firstName(); 
		    String editedEmailInCop3 = randomFirstName + "EditedFromPaymentPage@etg.digital"; 
		    emailEditedInCop3 =editedEmailInCop3;		
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop3, "Edited email form check out page 3");			
			Actionsss.click(CP.getSelectContinueasGuesttBtn());

			//CheckOutPage2Tasks.enterValidAddress();
			Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			editedEmailFromCop3= Actionsss.getTextOfElement(paymentPage.getEditCustomerInfo());
			 
			PaymentPageValidation.editEmailValidationInCOP3();
			
			PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
		}else {			
			logger.info("User is checked in as registered so edit button");
			test.info("User is checked in as registered so edit button");
			test.pass("No edit button to edit cutomer info for registered user");
		}	
		
	}
	
	public static void updateBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(paymentPage.getUpdateAddressBtnForBillingAddress());		
		Thread.sleep(3000);
		//Actionsss.doubleClick(cop2.getUpdateAddressBtn());
		Actionsss.javascriptClick(shippingPage.getUpdateAddressBtn());
		Actionsss.click(shippingPage.getUpdateAddressBtn());
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		PaymentPageValidation.updateBillingAddressValidation();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	public static void addNewBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(paymentPage.getUpdateAddressBtnForBillingAddress());
		Thread.sleep(2000);
		Actionsss.javascriptClick(shippingPage.getnewAddressBtn());	
		Actionsss.click(shippingPage.getnewAddressBtn());		
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();	
		Thread.sleep(1000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		PaymentPageValidation.updateBillingAddressValidation();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	/*	String newAddress= reviewOrder.getBillingAddress().getAttribute("value");
		editedBillingAddress=newAddress;
		cop3v.addNewBillingAddressValidation();
		
		PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();*/
	}
	
	public static void paginationOfProductsFromPaymentPage() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.randomElementFromList(shippingPage.getproductsInCheckoutPage2());
		ShippingPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		AddressSelection.editShippingAddress();
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
	}
	
	public static void billingPhoneNumber() throws Exception {
		paymentPageView();
		Actionsss.clearText(paymentPage.getBillingPhoneNumber());
		CreditCardDetails.creditCardDetails();	
		PaymentPageValidation.billingPhoneNumberErrorValidation();
	}
	
	public static void allErrorsInCreditCard() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.allErrorsInCreditCard();
	
	}
	
	public static void CreditCardCvvAndExpErrorMessage() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardCvvAndExpError();
		
	}

	public static void CreditCardCvvErrorMessage() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCvvError();
		
	}
	public static void creditcardNumberInValidError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditcardNumberInValidError();
		
	}
	
	public static void creditCardExpDateInValid() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardExpMonthInValid();
		
	}
	
	public static void creditCardNumberInCompleteError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardNumberInCompleteError();
		
	}
	public static void creditCardInCompleteExpYearError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardNumberInCompleteExpYearError();
		
	}
	public static void creditCardInCompleteCvvError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardInCompleteCvvError();
		
	}
	
	public static void  creditCardWithValidDetails() throws Exception {
			paymentPageView();
			CreditCardDetails.creditCardDetails();
		
	}
	public static void  addNewCreditCard() throws Exception {
			paymentPageView();
			CreditCardDetails.addNewCardThoughExistingCards();	
	}
	
	
	//ENTER gc code error
	public static void getEnterGiftCodeErrorMsg() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());			
			 PaymentPageValidation.enterGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }
		
	}
	
	//invalid gc
	public static void getInvalidGcCode() throws Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"VODJMTWPTOAVVOZG", " VODJMTWPTOAVVOZG gift code");					         
             Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
             logger.info("Apply button is selected");
             Thread.sleep(1000);
             PaymentPageValidation.invalidGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }		
	}
	
	//insufficient gc
	public static void getInsufficientGcCode() throws Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"GLOIWCSCSCTVGYIF", "GLOIWCSCSCTVGYIF gift code");					         
             Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
             logger.info("Apply button is selected");
             Thread.sleep(1000);
             PaymentPageValidation.insufficientGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }		
	}
	//gc belongs to different customer
	public static void getGcBelongsToDifferentCustomer() throws Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"GLOIWCSCSCTVGYIF", "GLOIWCSCSCTVGYIF gift code");					         
            Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
            logger.info("Apply button is selected");
            Thread.sleep(1000);
            PaymentPageValidation.insufficientGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }	
	}
	
	//check bal with valid gc 
	public static void getCheckBalOfValidGc() throws Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"JYKCFKIMMVAPOFDV", "JYKCFKIMMVAPOFDV gift code");					         
			 Actionsss.javascriptClick(paymentPage.getCheckBalanceButton());
             logger.info("check button is selected");
             Thread.sleep(2000);
             PaymentPageValidation.checkBalOfValidGiftCodeValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }
	}
	//check bal with invalid gc 
		public static void getCheckBalOfInvalidGc() throws Exception {
			paymentPageView();
			Actionsss.scrollWindowsByPixel(300);
			 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"VODJMTWPTOAVVOZG", "VODJMTWPTOAVVOZG gift code");					         
	             Actionsss.javascriptClick(paymentPage.getCheckBalanceButton());
	             logger.info("check button is selected");
	             Thread.sleep(1000);
	             PaymentPageValidation.checkBalOfInvalidGiftCodeValidation();
			 }else {
			    	test.info("Gift certificate is in cart");
			    	test.pass("No Gift certificate div");
			    }
		}
		//check bal with valid gc 
		public static void applyValidGc() throws Exception {
			paymentPageView();
			Actionsss.scrollWindowsByPixel(300);
			 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"FGMLWZFQFGVOIVZP", "FGMLWZFQFGVOIVZP gift code");					         
	             Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
	             logger.info("Apply button is selected");
	             Thread.sleep(2000);
	             PaymentPageValidation.succesMsgForValidGcAppliedValidation();
			 }else {
			    	test.info("Gift certificate is in cart");
			    	test.pass("No Gift certificate div");
			    }
		}
		
		
		public static void removeAppliedGc() throws Exception {
			paymentPageView();
			Actionsss.scrollWindowsByPixel(300);
			 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"CHVCLPRPVYSJICGW", "CHVCLPRPVYSJICGW gift code");					         
	             Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
	             Thread.sleep(1000);
	         /*    countOfGcApplied= Actionsss.getSizeOfList(pp.getRemoveGcList());
	 			 logger.info(countOfGcApplied);
	             Actionsss.randomElementFromList(pp.getRemoveGcList());
	             logger.info("Apply button is selected");
	             logger.info(countOfGcAppliedAfterItsRemoval);
	             Thread.sleep(1000);*/
	             Actionsss.click(paymentPage.getRemoveGc());
	             Thread.sleep(1000);
	             PaymentPageValidation.gcRemoveValidation();
			 }else 	if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
				 
			 } else {
			    	test.info("Gift certificate is in cart");
			    	test.pass("No Gift certificate div");
			    }
		}
		
		
		public static void gcRemoved() throws Exception {
			paymentPageView();
			Actionsss.scrollWindowsByPixel(300);
			 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {				
	             Actionsss.click(paymentPage.getRemoveGc());
	             Thread.sleep(1000);
	             PaymentPageValidation.gcRemoveValidation();
			 }else 	if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
				 
			 } else {
			    	test.info("Gift certificate is in cart");
			    	test.pass("No Gift certificate div");
			    }
		}
	//gift card
		public static void gcRedemption() throws Exception {
			paymentPageView();
			GiftCertificateForGc.giftCodeForGc();
		//	PaymentPageValidation.redemptionOfGcValidation();	
		}
	
	//gift card
		public static void gcRedemptionInCombinationWithCreditCard() throws Exception {
			paymentPageView();
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			PaymentPageTasks.creditCardWithValidDetails();
		}
		
		public static void paypal() throws Exception {
			paymentPageView();
			CheckOutPaypal.paypalFromCheckout();
		}
		
		public static void gcRedemptionInCombinationWithPaypal() throws Exception {
			paymentPageView();		
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			CheckOutPaypal.paypalFromCheckout();
		}
	
		
	/*	public static void clickReviewOrderButton() throws Exception {
			if(Actionsss.elementSize(paymentPage.getReviewOrderBtnList())) {
				if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
					Thread.sleep(1000);
					Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());
					Thread.sleep(3000);							
				}
			}
		}
		public static void brainTreeReviewOrderButton() throws InterruptedException {
			//Thread.sleep(3000);
	    	if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
	    		Actionsss.scrollWindowsByPixel(100);				    		
	    		Thread.sleep(3000);
	    		 Actionsss.click(paymentPage.getReviewOrderBtn());					    		 
	    		 test.info("Clicked on review order button");
	    		// paymentPage.getReviewOrderBtn();
	    		 ReviewOrderPageValidation.VerifyingReviewOrderBtn();
	    	}
		}*/
		
		public static void clickReviewOrderButton() throws Exception {
		   if(Actionsss.elementSize(paymentPage.getBrainTree())) {
			   Thread.sleep(3000);
				 if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
			    		Actionsss.scrollWindowsByPixel(100);	
			    		Thread.sleep(3000);
			    		Actionsss.click(paymentPage.getReviewOrderBtn());					    		 	    		
			    		paymentPage.getReviewOrderBtn();
			    		ReviewOrderPageValidation.VerifyingReviewOrderBtn();
			    	}
	    	}else {
	    		Actionsss.scrollWindowsByPixel(200);
	    		Thread.sleep(1000);
	    		if(Actionsss.elementSize(paymentPage.getReviewOrderBtnList())) {
					if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
						Thread.sleep(1000);
						Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());
						Thread.sleep(3000);							
					}
				}
	    	}
		}
}
