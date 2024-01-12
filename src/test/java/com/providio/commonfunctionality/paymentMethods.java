package com.providio.commonfunctionality;

import com.providio.pageObjects.paymentpPage;
import com.providio.testcases.baseClass;

public class paymentMethods extends baseClass{
	
	paymentpPage pp = new paymentpPage(driver);
	
	   //brain tree payment method of guest user
		public  void braintree() throws InterruptedException {
			pp.setcardholdername();
			logger.info("entered card name");
			pp.setcardnumber();
			logger.info("entered card number");
			pp.setcardcvv();
			logger.info("entered cvv");
			pp.setcardexp();
			logger.info("entered exp");
			
		}
		
		//register user and select the new card and save the card
		public void brainTreeReguser() throws InterruptedException {

	    	pp.selectnewcardindropdown();  
			logger.info("Selectd the new card");
			braintree();
			
		}
		
		//payment of cyber source  of guest user
		public void cyberSourceNewcard() throws InterruptedException {
	        pp.latestcardnumber();
	        logger.info("entered card number");
	        pp.latestExpDate();
	        logger.info("entered exp month");
	        pp.latestExpYear();
	        logger.info("entered exp year");
	        pp.latestSceuritycode();
	        logger.info("entered scecode");
			
		}
		
		//payment reg user
		public void cybersourceReguser() throws InterruptedException {
			
			pp.cyberAddpaymentBtn();
			logger.info("clicked on the add payment button");
			//cybersource method
			cyberSourceNewcard();
			
		}
		
		//salesforce payment method
		public void salesforcePayment() throws InterruptedException {
			pp.cardNumber();
	    	logger.info("entered card number");
	    	pp.expiryDate();
	    	logger.info("entered cvv");
	    	pp.cvc();
	    	logger.info("entered exp");
		}
		
		//Reg salesfoce payment
	     public void salesforcePaymentReg() throws InterruptedException {
	    	 
	    	    pp.creditCard();
	    	    //salesforce payment
	    	    salesforcePayment();
				
				
			}
     
	     //stripe payment method
	     public void stripePayment() {
	 		
	 		pp.cardNum();
	 		test.info("entered card number");
	 		pp. expDate();
	 		test.info("entered exp date");		
	 		pp.cvv();
	 		test.info("entered cvv");
	 		pp.postalCode();
	 		test.info("entered postal code");
	 	}
	     
	     //stripe payment method
	     public void stripePaymentReguser() throws InterruptedException {
	    	Thread.sleep(2000); 
	 		pp.newCardbtn();
	 		Thread.sleep(2000); 
	 		pp.cardNum();
	 		test.info("entered card number");
	 		pp. expDate();
	 		test.info("entered exp date");		
	 		pp.cvv();
	 		test.info("entered cvv");
	 		pp.postalCode();
	 		test.info("entered postal code");
	 		Thread.sleep(2000); 
	 		pp.stripeSaveCreditCard();
	 	}
		

}
