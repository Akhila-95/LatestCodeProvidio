package CreditCardPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;
import tasks.PaymentPageTasks;
import validations.ReviewOrderPageValidation;

public class CreditCardDetails extends baseClass{
	
	private static final 	PaymentPage pp = new PaymentPage(driver);
	
	public static void creditCardDetails() throws InterruptedException, Exception {

		if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {		
			test.info("Verifying by entering the valid credit card details");	
			
			if(Actionsss.elementSize(pp.getBrainTree())) {			
				BrainTreePayment.brainTreeMethod();				 
			}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
				Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
				SalesforcePayment.salesForce();				
			}else if (Actionsss.elementSize(pp.getStripePayment())) {				
				Actionsss.click(pp.getStripeCreditCard());
				StripePayment.stripe();				 
			}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {			
				CyberSourcePayment.cyberSource();				
			}else if(Actionsss.elementSize(pp.getAdyenPayment())) {				
				AdyenPayment.adyen();
			}			
			
		    if(Actionsss.elementSize(pp.getBrainTree())) {
		    	PaymentPageTasks.brainTreeReviewOrderButton();	
		    	ReviewOrderPageValidation.VerifyingReviewOrderBtn();
	    	}else {
	    		PaymentPageTasks.clickReviewOrderButton();
	    	}
			
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
				SalesforcePayment.addNewCardThoughExistingCardsInSalesforce() ;				
			}else if (Actionsss.elementSize(pp.getStripePayment())) {				
				StripePayment.addNewCardThoughExistingCardsInStripe();
				StripePayment.useSaveCardInStripe();				 
			}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {				
				CyberSourcePayment.addNewCardThoughExistingCardsInCyberSource();
			}else {
				test.pass("No add new payment is configured in adyen payment");
			}
		}else {
			test.info("User is guest check-in ");
			test.pass("No User will have saved cards ");
		}
	}
}


