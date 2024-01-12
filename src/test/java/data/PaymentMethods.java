package data;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.paymentpPage;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class PaymentMethods extends baseClass{
	
	private static AllPayments allPay = new AllPayments();
	
	private PaymentPage pp =new PaymentPage(driver);
	//brain tree payment method of guest user
	public  void braintree() throws InterruptedException {
		 allPay.brainTreeCardHolderName();
		logger.info("entered card name");
		 allPay.brainTreeCardNumber();
		logger.info("entered card number");
		 allPay.brainTreeCvv();
		logger.info("entered cvv");
		 allPay.brainTreeExpDate();
		logger.info("entered exp");
		
	}
	
	//register user and select the new card and save the card
	public void savedCardsBrainTree() throws InterruptedException {

		test.info("User already have saved cards");
		allPay.brainTreeSavedCards();  
		logger.info("Selectd the new card");
		braintree();
		
	}
	
	
	//payment of cyber source  of guest user
	public void cyberSource() throws InterruptedException {
        allPay.cyberSourceCardNumber();
        logger.info("entered card number");
        allPay.cyberSourceExpMonth();
        logger.info("entered exp month");
        allPay.cyberSourceExpYear();
        logger.info("entered exp year");
        allPay.cyberSourceSecurityCode() ;
        logger.info("entered scecode");
		
	}

	//salesforce payment method
	public void salesforcePayment() throws InterruptedException {
		allPay.salesforceCardNumber();
    	logger.info("entered card number");
    	allPay.salesforceExpDate();
    	logger.info("entered cvv");
    	allPay.salesforceCvv();
    	logger.info("entered exp");
	}
	

 
    

 
     //stripe payment method
     public void stripePayment() throws InterruptedException {
 		
    	allPay.stripeCardNumber();
 		test.info("entered card number");
 		allPay.stripeExpDate();
 		test.info("entered exp date");		
 		allPay.stripeCvv();
 		test.info("entered cvv");
 		allPay.stripePostalCode();
 		test.info("entered postal code");
 	}
     
     //stripe payment method
 /*    public void stripePaymentReguser() throws InterruptedException {
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
		
   */
}
