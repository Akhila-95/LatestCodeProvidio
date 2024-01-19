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
		logger.info("Entered card name for brain tree payment");
		 allPay.brainTreeCardNumber();
		logger.info("Entered card number for brain tree payment ");
		 allPay.brainTreeCvv();
		logger.info("Entered cvv for brain tree payment");
		 allPay.brainTreeExpDate();
		logger.info("Entered exp for brain tree payment");
		
	}

	//payment of cyber source  of guest user
	public void cyberSource() throws Exception {
        allPay.cyberSourceCardNumber();
        logger.info("Entered card number for cybersource payment");
        allPay.cyberSourceExpMonth();
        logger.info("Entered exp month for cybersource payment");
        allPay.cyberSourceExpYear();
        logger.info("Entered exp year for cybersource payment");
        allPay.cyberSourceSecurityCode() ;
        logger.info("Entered scecode for cybersource paymentS");
		
	}

	//salesforce payment method
	public void salesforcePayment() throws Exception {
		allPay.salesforceCardNumber();
    	logger.info("Entered card number for salesforce payment");
    	allPay.salesforceExpDate();
    	logger.info("Entered cvv for salesforce payment");
    	allPay.salesforceCvv();
    	logger.info("Entered exp for salesforce payment");
	}
	

 
     //stripe payment method
     public void stripePayment() throws InterruptedException {
 		
    	allPay.stripeCardNumber();
 		test.info("Entered card number for stripe payment");
 		allPay.stripeExpDate();
 		test.info("Entered exp date for stripe payment");		
 		allPay.stripeCvv();
 		test.info("Entered cvv for stripe payment");
 		allPay.stripePostalCode();
 		test.info("Entered postal code for stripe payment");
 		
 	}
     
     //adyen paymnet
     public void adyenPayment() throws Exception {
    	 allPay.cardNumberInAdyenPayment();
    	 test.info("Entered card number for adyen payment");
    	 allPay.expDateInAdyen();
    	 test.info("Entered exp date for adyen payment");	
    	 allPay.secCodeInAdyen();
    	 test.info("Entered cvv for adyen payment");
    	 allPay.holderNameInAdyen();
    	 test.info("Entered holder name for adyen payment");
    	 
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
