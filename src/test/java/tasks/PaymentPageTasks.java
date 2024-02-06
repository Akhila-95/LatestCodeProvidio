package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import Payments.CheckOutPaypal;
import Payments.GiftCertificateForGc;
import Payments.GiftCertificateInCombination;
import data.AddressSelection;
import data.PaymentDetails;
import data.PaymentDetailsofGuestandReg;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation;
import validations.ShippingPageValidation;

public class PaymentPageTasks extends baseClass {

	private static final CheckOutPage3 cop3 = new CheckOutPage3(driver);
	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final PaymentPageValidation cop3v = new PaymentPageValidation();
	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final 	PaymentPage pp = new PaymentPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void paymentPageView() throws Exception {
		if((Actionsss.elementSize(cop3.getpaymentPageList()))&& (Actionsss.elementSize(cop3.getNextReviewOrderBtnList()) || Actionsss.elementSize(pp.getSelectPlaceOrderBtnList()))) {
			if((Actionsss.displayElement(cop3.getpaymentPage())) ){
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
		 Actionsss.click(pp.getBackToCart());				
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
		Actionsss.randomElementFromList(pp.getproductsInCheckoutPage2());
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
		previousAddresses=Actionsss.getTextOfElement(cop3.getShippingAddress());		
		Actionsss.click(cop3.getEditShipping());
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {			
			AddressSelection.editShippingAddress();
		}else {
			AddressSelection.selectingRandomSavedShippingAddress();
			Actionsss.click(cop2.getUpdateAddressBtn());
			AddressSelection.editShippingAddress();
		}
		Thread.sleep(2000);
		Actionsss.CombinedClick(cop2.getNextPaymentButton());				
		ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
		editedAddress=Actionsss.getTextOfElement(cop3.getShippingAddress());
		PaymentPageValidation.editShippingValidationInCOP3();
		Thread.sleep(1000);
		
		PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
		
	}
	public static void editGiftMessageInCop2() throws Exception {
		paymentPageView();
		Thread.sleep(1000);
		Actionsss.CombinedClick(cop3.getEditShipping());
		Actionsss.CombinedClick(cop2.getGiftMessageCheckButton());
		String giftMessage ="Birthday gift";			
		Actionsss.sendKeys(cop2.getGiftMessagegiftMessageTextArea(), giftMessage,"gift message");
		Actionsss.CombinedClick(cop2.getNextPaymentButton());	
		Thread.sleep(2000);
		PaymentPageValidation.displayOfGiftMessageInCheckoutPage3();
	}
	
	public static void editCustomerInfoFromCop3() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {			
			Thread.sleep(1000);
			previousMail=Actionsss.getTextOfElement(cop3.getEditCustomerInfo());		
			Actionsss.click(cop3.getCustomerInfoFromCop3());		
			Faker faker = new Faker();
			String randomFirstName = faker.name().firstName(); 
		    String editedEmailInCop3 = randomFirstName + "EditedFromPaymentPage@etg.digital"; 
		    emailEditedInCop3 =editedEmailInCop3;		
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop3, "Edited email form check out page 3");			
			Actionsss.click(CP.getSelectContinueasGuesttBtn());

			//CheckOutPage2Tasks.enterValidAddress();
			Actionsss.CombinedClick(cop2.getNextPaymentButton());	
			editedEmailFromCop3= Actionsss.getTextOfElement(cop3.getEditCustomerInfo());
			 
			cop3v.editEmailValidationInCOP3();
			
			PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
		}else {			
			logger.info("User is checked in as registered so edit button");
			test.info("User is checked in as registered so edit button");
			test.pass("No edit button to edit cutomer info for registered user");
		}	
		
	}
	
	public static void updateBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(cop3.getUpdateAddressBtnForBillingAddress());		
		Thread.sleep(3000);
		//Actionsss.doubleClick(cop2.getUpdateAddressBtn());
		Actionsss.javascriptClick(cop2.getUpdateAddressBtn());
		Actionsss.click(cop2.getUpdateAddressBtn());
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		cop3v.updateBillingAddressValidation();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	public static void addNewBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(cop3.getUpdateAddressBtnForBillingAddress());
		Thread.sleep(2000);
		Actionsss.javascriptClick(cop2.getnewAddressBtn());	
		Actionsss.click(cop2.getnewAddressBtn());		
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();	
		Thread.sleep(1000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		cop3v.updateBillingAddressValidation();
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
		Actionsss.randomElementFromList(cop2.getproductsInCheckoutPage2());
		ShippingPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		AddressSelection.editShippingAddress();
		Actionsss.CombinedClick(cop2.getNextPaymentButton());	
	}
	
	public static void billingPhoneNumber() throws Exception {
		paymentPageView();
		Actionsss.clearText(cop3.getBillingPhoneNumber());
		PaymentDetails.creditCardDetails();	
		PaymentPageValidation.billingPhoneNumberErrorValidation();
	}
	
	public static void allErrorsInCreditCard() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.allErrorsInCreditCard();
	
	}
	
	public static void CreditCardCvvAndExpErrorMessage() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCardCvvAndExpError();
		
	}

	public static void CreditCardCvvErrorMessage() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCvvError();
		
	}
	public static void creditcardNumberInValidError() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditcardNumberInValidError();
		
	}
	
	public static void creditCardExpDateInValid() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCardExpMonthInValid();
		
	}
	
	public static void creditCardNumberInCompleteError() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCardNumberInCompleteError();
		
	}
	public static void creditCardInCompleteExpYearError() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCardNumberInCompleteExpYearError();
		
	}
	public static void creditCardInCompleteCvvError() throws Exception {
			paymentPageView();
			PaymentDetailsofGuestandReg.creditCardInCompleteCvvError();
		
	}
	
	public static void  creditCardWithValidDetails() throws Exception {
			paymentPageView();
			PaymentDetails.creditCardDetails();
		
	}
	public static void  addNewCreditCard() throws Exception {
			paymentPageView();
			PaymentDetails.addNewCardThoughExistingCards();	
	}
	
	
	//ENTER gc code error
	public static void getEnterGiftCodeErrorMsg() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
			 Actionsss.javascriptClick(pp.getApplyGiftCardButton());			
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
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(pp.getGiftcertificateInput(),"VODJMTWPTOAVVOZG", " VODJMTWPTOAVVOZG gift code");					         
             Actionsss.javascriptClick(pp.getApplyGiftCardButton());
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
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(pp.getGiftcertificateInput(),"GLOIWCSCSCTVGYIF", "GLOIWCSCSCTVGYIF gift code");					         
             Actionsss.javascriptClick(pp.getApplyGiftCardButton());
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
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(pp.getGiftcertificateInput(),"GLOIWCSCSCTVGYIF", "GLOIWCSCSCTVGYIF gift code");					         
            Actionsss.javascriptClick(pp.getApplyGiftCardButton());
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
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(pp.getGiftcertificateInput(),"JYKCFKIMMVAPOFDV", "JYKCFKIMMVAPOFDV gift code");					         
			 Actionsss.javascriptClick(pp.getCheckBalanceButton());
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
			 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(pp.getGiftcertificateInput(),"VODJMTWPTOAVVOZG", "VODJMTWPTOAVVOZG gift code");					         
	             Actionsss.javascriptClick(pp.getCheckBalanceButton());
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
			 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(pp.getGiftcertificateInput(),"FGMLWZFQFGVOIVZP", "FGMLWZFQFGVOIVZP gift code");					         
	             Actionsss.javascriptClick(pp.getApplyGiftCardButton());
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
			 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
				 Actionsss.sendKeys(pp.getGiftcertificateInput(),"CHVCLPRPVYSJICGW", "CHVCLPRPVYSJICGW gift code");					         
	             Actionsss.javascriptClick(pp.getApplyGiftCardButton());
	             Thread.sleep(1000);
	         /*    countOfGcApplied= Actionsss.getSizeOfList(pp.getRemoveGcList());
	 			 logger.info(countOfGcApplied);
	             Actionsss.randomElementFromList(pp.getRemoveGcList());
	             logger.info("Apply button is selected");
	             logger.info(countOfGcAppliedAfterItsRemoval);
	             Thread.sleep(1000);*/
	             Actionsss.click(pp.getRemoveGc());
	             Thread.sleep(1000);
	             PaymentPageValidation.gcRemoveValidation();
			 }else 	if(Actionsss.elementSize(pp.getsuccessGiftCodeRedemptionMsgList())) {
				 
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
	
		public static void clickReviewOrderButton() throws Exception {
			if(Actionsss.elementSize(pp.getReviewOrderBtnList())) {
				if(Actionsss.displayElement(pp.getReviewOrderBtn())) {
					Thread.sleep(1000);
					Actionsss.javascriptClick(pp.getReviewOrderBtn());
					Thread.sleep(3000);							
				}
			}
		}
		public static void brainTreeReviewOrderButton() throws InterruptedException {
			//Thread.sleep(3000);
	    	if(Actionsss.displayElement(pp.getReviewOrderBtn())) {
	    		Actionsss.scrollWindowsByPixel(100);				    		
	    	//	 Thread.sleep(1000);
	    		 Actionsss.click(pp.getReviewOrderBtn());					    		 
	    		 test.info("Clicked on review order button");
	    		 pp.getReviewOrderBtn();
	    		 ReviewOrderPageValidation.VerifyingReviewOrderBtn();
	    	}
		}
}
