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

	
 public static void brainTreeMethod() throws InterruptedException {

		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			pm.braintree();
			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsBrainTree())) {
				
				//if user is registered and have saved cards then  this if will execute
				test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
				allPay.savedCardsBrainTree();
				
			}else {
				
				//new user without saved cards in account 
				test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
				pm.braintree();
				
			}
		}
	}
 
	//cyberSource
	public static void cyberSource() throws Exception {

		if(!Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			pm.cyberSource();
			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsCyberSource())) {
				
				//if user is registered and have saved cards then  this if will execute
				test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
				allPay.savedCardsCyberSource();
			}else {
				//if user want to add new card  into account without having the saved cards
				test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
				allPay.withoutSavedCardsCyberReg();

			}
		}
	}
	
	//salesforce
		public static void salesForce() throws Exception {
	
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
											
				//guest user payment	
				test.info("User is in guest-check in so entering a random credit card details");
				pm.salesforcePayment();
		
			}else {

				if(Actionsss.elementSize(pp.getSavedCardsSalesforce())) {
					//if user is registered and have saved cards then  this if will execute
					test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
					allPay.savedCardsSalesforce();
				}else {
					//new user without saved cards and user saves the new card to account
					test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
					allPay.withoutSavedCardSalesforceReg();
				}
			}
		}

		  //stripe payment method
	  	public static void stripe() throws Exception {

	  		Actionsss.scrollWindowsByPixel(300);
	  		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
	  		  //guest user payment
	  			test.info("User is in guest-check in so entering a random credit card details");
	  			pm.stripePayment();
	  		}else {
	  				//if user is registered and have saved cards then  this if will execute
	  				if(Actionsss.elementSize(pp.getStripeSavedCards())) {
	  					test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
	  					allPay.savedCardsStripe();
	  				}else {
	  					//new user without saved cards and user saves the new card to account
	  					test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
	  					allPay.withoutSavedCardStripeReg();
	  			}
	  		}
	  	}
		
	  	
	  	//adyen payment
	  	public static void adyen() throws Exception {
	  		Actionsss.scrollWindowsByPixel(700);
	  		Thread.sleep(3000);
	  		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
		  		  //guest user payment
		  			test.info("User is checked in as guest  so entering a random credit card details");
		  			pm.adyenPayment();
	  		}else {
	  			test.info("User is checked in as register and saving the card to account is not configured in providio adyen payment  ");
	  			pm.adyenPayment();
	  		}
	  	}
		
		public static void allErrorsInCreditCard() throws Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			Actionsss.scrollWindowsByPixel(300);
			
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				test.info("Verifying all the error messages without entering any credit card details in required fileds when user is guest");
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					ppv.salesforcePaymentAllErrors();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					// pop up in stripe unable to inpect that pop up   video :https://muskuakhila-gmial.tinytake.com/msc/OTE3MjI4OV8yMjY5NDU4Mw
					test.pass("Unable click the ok in pop up in stripe by automation to test without entering any of the details");
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					ppv.getallErrosInCybersource();
				}else {
					//adyen payment
					ppv.getallErrorsInAdyen();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		

		public static void creditcardNumberInValidError() throws InterruptedException, Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying the invalid card number error by entering invalid  credit card details ");
			
			Actionsss.scrollWindowsByPixel(400);
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceInvalidCardNumber();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					Actionsss.click(pp.getStripeCreditCard());
					Thread.sleep(1000);
					ppv.stripeCardInvalidCardError();
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource -- have to check this bug issue 
					 ppv.getcreditCardNumberInvalidErrorInCybersource();
				}else {
					ppv.getcreditCardNumberInvalidErrorInAdyen();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		
		public static void creditCardExpMonthInValid() throws Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying the invalid expiry month/year error by entering the invalid month/year in credit card ");
			
			Actionsss.scrollWindowsByPixel(300);
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceInvalidExpYear();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					Actionsss.click(pp.getStripeCreditCard());
					ppv.stripeCardInvalidExpDate();
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					test.pass("No validation for invalid expiry year/month for cybersource ");
				}else {
					ppv.getcreditCardExpMonthInValidInAdyen();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		

		public static void creditCardNumberInCompleteError() throws Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying the incomplete card number error by entering  incomplete card number in credit card ");
			Actionsss.scrollWindowsByPixel(300);
			
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceCvvAndExpError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe
					Actionsss.click(pp.getStripeCreditCard());
					ppv.stripeIncompleteCardError();
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					ppv.getcreditCardNumberInCompleteErrorInCybersource();
				}else {
					//adyen
					ppv.getCreditCardNumberInCompleteErrorInAdyen();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		
		public static void creditCardNumberInCompleteExpYearError() throws Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying the incomplete expiry year error by entering the incomplete expiry year in credit card");
			
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceCvvAndExpError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					Actionsss.click(pp.getStripeCreditCard());
					ppv.stripeIncompleteExpYearError();
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					test.pass("No validation for incomplete expiry year/month for cybersource ");
				}else {
					//adyen 
					
				}
			}else{
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		
		public static void creditCardInCompleteCvvError() throws Exception {
			
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {

			test.info("Verifying the incomplete Cvv error by entering the incomplete cvv in credit card");
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceCvvAndExpError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					Actionsss.click(pp.getStripeCreditCard());
					ppv.getStripeCardSecurityCodeIncompleteError();
					//ppv.getStripeCardPostalCodeInComplete();
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					ppv.getIncompleteSecurityCodeErrorInCybersource();
				}else {
					ppv.getCreditCardInCompleteCvvError();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
		}else {
			logger.info("Gift code was redemeed already");
			test.info("Gift code was redemeed already");
			test.pass("Gift code was redemeed already");
		}	
	}
		
		public static void creditCardCvvAndExpError() throws Exception {
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying the  cvv and expiry year error without entering the cvv and expiry year by entering credit card number ");
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceCvvAndExpError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					//pop up
					// pop up in stripe unable to inpect that pop up   video :https://muskuakhila-gmial.tinytake.com/msc/OTE3MjMwNl8yMjY5NDYwMA
					test.pass("Unable click the ok in pop up in stripe by automation to test without entering  year,cvc and zip code details");
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					//ppv.getCreditCardCvvAndExpMonthYearErrorInCybersource();
					ppv.getCreditCardCvvAndExpYearErrorInCybersource();
				}else {
					ppv.getCreditCardCvvAndExpErrorMessage();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}
		
		public static void creditCvvError() throws Exception {
		
			if(Actionsss.elementSize(pp.getPaymentPagecreditCardDivList())) {
			test.info("Verifying with cvv error without entering cvv by entering the card number, expiry m in credit card");
			
			if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
				
				if(Actionsss.elementSize(pp.getBrainTree())) {
					//brain tree negative 
					ppv.brainTreeAllPaymentsError();
					
				}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
					//salesforce negative
					Actionsss.javascriptClick(pp.getSalesforceCreditcardRadioBtn());
					ppv.salesforceCvvError();
					
				}else if (Actionsss.elementSize(pp.getStripePayment())) {
					//stripe 
					// pop up in stripe unable to inpect that pop up   video :https://muskuakhila-gmial.tinytake.com/msc/OTE3MjMyMV8yMjY5NDYxNQ
					test.pass("Unable click the ok in pop up in stripe by automation to test  without entering  cvc and zip code details");
					
				}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
					//cybersource 
					ppv.getCreditCardCvvErrorInCybersource();
				}else {
					ppv.getCreditCardCvvErrorMessage();
				}
			}else {
				test.info("User is checked-in as Registered");
				test.pass("Doing the  error validation when user is checked-in  as guest");
			}
			}else {
				logger.info("Gift code was redemeed already");
				test.info("Gift code was redemeed already");
				test.pass("Gift code was redemeed already");
			}
		}

		public static void brainTreeReguser() throws InterruptedException {
			PaymentPage pp = new PaymentPage(driver);
			Actionsss.selectValue(pp.getBrainTreeNewCardDropdown());
			Thread.sleep(3000);
		}


		//new cards
	    public static void addNewCardThoughExistingCardsInStripe() throws Exception {
	    	//clicks on credit card label			
			// Actionsss.javascriptClick(pp.getStripeCreditCard());
			
			 Actionsss.javascriptClick(pp.getAddNewCardStripe());
			 //enters paymnet details 
			 pm.stripePayment();
			
			 //clicking on save button 
			 Actionsss.javascriptClick(pp.getStripeSaveCardsButtons());
			 Thread.sleep(2000);
     }  
	    
		public static void addNewCardThoughExistingCardsInCybersource() throws Exception {

			if(!Actionsss.elementSize(pp.getContinueAsAGuest())) {
		
					//clicks on add paymnet		 
					 Actionsss.javascriptClick(pp.getAddPaymentCybersource());
					 //credit card details
					 pm.cyberSource();
					Actionsss.sendKeys(pp.getEmailInRegInCybersource(),"akhila.m@etg.digital", "Email id ");
				
			}
		}
	    public static void useSaveCardInStripe() throws Exception {
	    	Actionsss.javascriptClick(pp.getswitchToSavedCardsStripe());
	    	Actionsss.randomElementFromList(pp.getCountOfSavedCards());
	    }
	    
	    // salesforce
	    public static void addNewCardThoughExistingCardsInSalesforce() throws Exception {
	    	Actionsss.javascriptClick(pp.getSalesforceCreditCard());
	    	pm.salesforcePayment();
	    	
	    	Actionsss.CombinedClick(pp.getSaveToaccountInSalesforce());
	    }
}
