package CreditCardPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;


public class AdyenPayment extends baseClass{
	
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	   private static String  adyenExpiryDate ="03 30";
	   
	   public static void adyenPayment() throws Exception {
		   test.info("Entering card number for adyen payment");
		   cardNumberInAdyenPayment(); 
		   test.info("Entering exp date for adyen payment");	
	       expDateInAdyen();
	       test.info("Entering cvv for adyen payment");
	       secCodeInAdyen();
	       test.info("Entering holder name for adyen payment");	  
	       holderNameInAdyen();	    	  	 
	     }
	   
	   public static void adyen() throws Exception {
	  		Actionsss.scrollWindowsByPixel(700);
	  		Thread.sleep(3000);
	  		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
	  		  //guest user payment
	  			test.info("User is checked in as guest  so entering a random credit card details");
	  			adyenPayment();
	  		}else {
	  			test.info("User is checked in as register and saving the card to account is not configured in providio adyen payment  ");
	  			adyenPayment();
	  		}
	  	}
	   
	   public static void cardNumberInAdyenPayment() throws Exception {
		     driver.switchTo().frame(paymentPage.getAdyenCardNumIframe());
		     String adyenCreditCardNumber="3700 0000 0100 018";
		     Actionsss.clearText(paymentPage.getAdyenCardNumInput());
		     Actionsss.sendKeys(paymentPage.getAdyenCardNumInput(),"3700 0000 0100 018" ,adyenCreditCardNumber);
		     driver.switchTo().defaultContent();
		     String lastFourDigits = adyenCreditCardNumber.substring(adyenCreditCardNumber.length() - 4);
			 creditCardNumber=lastFourDigits;
	    }
	    
		public static void expDateInAdyen() throws Exception {		     
		     driver.switchTo().frame(paymentPage. getAdyenExpDateIframe());
		     Actionsss.clearText(paymentPage.getAdyenExpDateInput());
		     Actionsss.sendKeys(paymentPage.getAdyenExpDateInput(),adyenExpiryDate ,"Expiry date" +adyenExpiryDate );
		     driver.switchTo().defaultContent();
		}
		
		public static void secCodeInAdyen() throws Exception {	     
		     driver.switchTo().frame(paymentPage.getAdyenSecCodeIframe());
		     Actionsss.clearText(paymentPage.getAdyenSecCodeInput());
		     Actionsss.sendKeys(paymentPage.getAdyenSecCodeInput(),"7373","Security code is 7373");
		     driver.switchTo().defaultContent();
		}
		
		public static void holderNameInAdyen() throws Exception {	     		   
		     Actionsss.clearText(paymentPage.getAdyenHolderNameInput());
		     Actionsss.sendKeys(paymentPage.getAdyenHolderNameInput(),fakeEmail,"holder name is " +fakeEmail);		    
		}
}
