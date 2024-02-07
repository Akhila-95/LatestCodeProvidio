package CreditCardPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import tasks.PaymentPageTasks;
import validations.ReviewOrderPageValidation;

public class CreditCardDetails extends baseClass{
	
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	
	public static void creditCardDetails() throws InterruptedException, Exception {

		if(Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {		
			test.info("Verifying by entering the valid credit card details");	
			
			if(Actionsss.elementSize(paymentPage.getBrainTree())) {			
				BrainTreePayment.brainTreeMethod();				 
			}else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
				Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
				SalesforcePayment.salesForce();				
			}else if (Actionsss.elementSize(paymentPage.getStripePayment())) {				
				Actionsss.click(paymentPage.getStripeCreditCard());
				StripePayment.stripe();				 
			}else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {			
				CyberSourcePayment.cyberSource();				
			}else if(Actionsss.elementSize(paymentPage.getAdyenPayment())) {				
				AdyenPayment.adyen();
			}			
			
			PaymentPageTasks.clickReviewOrderButton();
			
		}else {
			logger.info("Other payment details are entered");
			test.info("Other payment details are entered");
			test.pass("Other payment details are entered");
		}
	}
	
	public static void addNewCardThoughExistingCards() throws Exception {
		
		if(!Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {			
			test.info("User is checked in as registered and also have saved card even though, adding a saved card to account to check the add payment functionality in register user.");			
			if(Actionsss.elementSize(paymentPage.getBrainTree())) {				
				//PaymentDetailsofGuestandReg.brainTreeMethod();				 
			}else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {				
				SalesforcePayment.addNewCardThoughExistingCardsInSalesforce() ;				
			}else if (Actionsss.elementSize(paymentPage.getStripePayment())) {				
				StripePayment.addNewCardThoughExistingCardsInStripe();
				StripePayment.useSaveCardInStripe();				 
			}else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {				
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


