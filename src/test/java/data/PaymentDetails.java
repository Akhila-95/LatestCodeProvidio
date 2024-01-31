package data;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;
import tasks.PaymentPageTasks;
import validations.PaymentPageValidation;
import validations.PlaceOrderPageValidation;


public class PaymentDetails extends baseClass{
	
	private static final 	PaymentPage pp = new PaymentPage(driver);

	public static void creditCardDetails() throws InterruptedException, Exception {

		if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			
			test.info("Verifying by entering the valid credit card details");
			
			if(Actionsss.elementSize(pp.getBrainTree())) {			
				PaymentDetailsofGuestandReg.brainTreeMethod();				 
			}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
				Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
				PaymentDetailsofGuestandReg.salesForce();				
			}else if (Actionsss.elementSize(pp.getStripePayment())) {				
				Actionsss.click(pp.getStripeCreditCard());
				PaymentDetailsofGuestandReg.stripe();				 
			}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {			
				PaymentDetailsofGuestandReg.cyberSource();				
			}else if(Actionsss.elementSize(pp.getAdyenPayment())) {				
				PaymentDetailsofGuestandReg.adyen();
			}
			
			PaymentPageTasks.clickReviewOrderButton();
			
		}else {
			logger.info("Other payment details are entered");
			test.info("Other payment details are entered");
			test.pass("Other payment details are entered");
		}
	}
	
	public static void addNewCardThoughExistingCards() throws Exception {
		
		if(!Actionsss.elementSize(pp.getContinueAsAGuest())) {
			
			test.info("User is checked in as registered and also have saved card even though, adding a saved card to account to check the add payment functionality in register user.");
			
			if(Actionsss.elementSize(pp.getBrainTree())) {
				
				//PaymentDetailsofGuestandReg.brainTreeMethod();
				 
			}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
				
				PaymentDetailsofGuestandReg.addNewCardThoughExistingCardsInSalesforce() ;
				
			}else if (Actionsss.elementSize(pp.getStripePayment())) {
				
				PaymentDetailsofGuestandReg.addNewCardThoughExistingCardsInStripe();
				PaymentDetailsofGuestandReg.useSaveCardInStripe();
				 
			}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
				
				PaymentDetailsofGuestandReg.addNewCardThoughExistingCardsInCybersource();
			}else {
				test.pass("No add new payment is configured in adyen payment");
			}
		}else {
			test.info("User is guest check-in ");
			test.pass("No User will have saved cards ");
		}
	}
	}


