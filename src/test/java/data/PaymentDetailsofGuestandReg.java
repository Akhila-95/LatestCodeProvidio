package data;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;
import validations.PaymentPageValidation;


public class PaymentDetailsofGuestandReg extends baseClass{

	private static PaymentPage pp = new PaymentPage(driver);
	private static PaymentMethods pm = new PaymentMethods();
	private static PaymentPageValidation ppv = new PaymentPageValidation();
	private static AllPayments allPay = new AllPayments();
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	
	
 public static void brainTreeMethod() throws InterruptedException {

		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {

			pm.braintree();
			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsBrainTree())) {
				
				//if user is registered and have saved cards then  this if will execute
				 pm.savedCardsBrainTree();
				
			}else {
				
				//new user without saved cards in account 
				test.info("User don't have saved cards");
				pm.braintree();
				
			}
		}
	}
 
	//cyberSource
	public static void cyberSource() throws Exception {

		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			
			pm.cyberSource();
			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsCyberSource())) {
				
				//if user is registered and have saved cards then  this if will execute
				allPay.savedCardsCyberSource();
			}else {
				//if user want to add new card  into account without having the saved cards
				allPay.withoutSavedCardsCyberReg();

			}
		}
	}
	
	//salesforce
		public static void salesForce() throws Exception {
	
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
											
				//guest user payment				
				pm.salesforcePayment();
		
			}else {

				if(Actionsss.elementSize(pp.getSavedCardsSalesforce())) {
					//if user is registered and have saved cards then  this if will execute
					allPay.savedCardsSalesforce();
				}else {
					//new user without saved cards and user saves the new card to account
					allPay.withoutSavedCardSalesforceReg();
				}
			}
		}

		  //stripe payment method
	  	public static void stripe() throws Exception {

	  		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
	  		  //guest user payment
	  			pm.stripePayment();
	  		}else {
	  		//if user is registered and have saved cards then  this if will execute
	  			if(Actionsss.elementSize(pp.getStripeSavedCards())) {
	  				allPay.savedCardsStripe();
	  			}else {
	  				allPay.withoutSavedCardStripeReg();
	  			}
	  		}
	  	}
		
		
		public static void allErrorsInCreditCard() throws Exception {

			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					ppv.salesforcePaymentAllErrors();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
				}
			}
		}
		

		
		public static void creditCardCvvAndExpError() throws Exception {

			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					ppv.salesforceCvvAndExpError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
				}
			}
		}
		
		public static void creditCvvError() throws InterruptedException {
			
			PaymentPage pp = new PaymentPage(driver);
			
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					ppv.salesforceCvvError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
				}
			}
		}

		public static void brainTreeReguser() throws InterruptedException {
			PaymentPage pp = new PaymentPage(driver);
			Actionsss.selectValue(pp.getBrainTreeNewCardDropdown(), "0");
			Thread.sleep(3000);
		}


	    
}
