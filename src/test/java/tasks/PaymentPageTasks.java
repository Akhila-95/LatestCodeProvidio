package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import data.AddressSelection;
import data.PaymentDetails;
import data.PaymentDetailsofGuestandReg;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import pageObjects.PlaceOrderPage;
import validations.PaymentPageValidation;
import validations.ShippingPageValidation;

public class PaymentPageTasks extends baseClass {

	private static final CheckOutPage3 cop3 = new CheckOutPage3(driver);
	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final PaymentPageValidation cop3v = new PaymentPageValidation();
	private static final PlaceOrderPage placeOrder = new PlaceOrderPage(driver);
	
	public static void paymentPageView() throws Exception {

		if(Actionsss.elementSize(cop3.getpaymentPageList()) ) {
			if(Actionsss.displayElement(cop3.getpaymentPage())){
			logger.info("Paymnet page is loaded");
			}
		}else {
			CheckOutPage2Tasks.enterValidAddress();
		}
		Thread.sleep(2000);
	}
	
	public static void editShippindAddressAndUpdate() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		previousAddresses=Actionsss.getTextOfElement(cop3.getShippingAddress());
		logger.info(previousAddresses);
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
		logger.info(editedAddress);
		
		PaymentPageValidation.editShippingValidationInCOP3();
		Thread.sleep(1000);
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
			logger.info(previousMail);
			
			Actionsss.click(cop3.getCustomerInfoFromCop3());		
			Faker faker = new Faker();
			String randomFirstName = faker.name().firstName(); 
		    String editedEmailInCop3 = randomFirstName + "EditedFromCOP3@etg.digital"; 
		    emailEditedInCop3 =editedEmailInCop3;
		    logger.info(emailEditedInCop3);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop3, "Edited email form check out page 3");			
			Actionsss.click(CP.getSelectContinueasGuesttBtn());

			//CheckOutPage2Tasks.enterValidAddress();
			Actionsss.CombinedClick(cop2.getNextPaymentButton());	
			editedEmailFromCop3= Actionsss.getTextOfElement(cop3.getEditCustomerInfo());
			 
			cop3v.editEmailValidationInCOP3();
		}else {			
			logger.info("User is checked in as registered so edit button");
			test.info("User is checked in as registered so edit button");
			test.pass("No edit button to edit cutomer info for registered user");
		}	
		
	}
	
	public static void updateBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(cop3.getUpdateAddressBtnForBillingAddress());
		logger.info(previousBillingAddress);
		Thread.sleep(2000);
		Actionsss.CombinedClick(cop2.getUpdateAddressBtn());
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();
		Thread.sleep(2000);
		
		
		PaymentDetails.creditCardDetails();
		
		 editedBillingAddress=Actionsss.getTextOfElement(placeOrder.getBillingAddress());
			logger.info(editedBillingAddress);
			cop3v.updateBillingAddressValidation();
		
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
}
