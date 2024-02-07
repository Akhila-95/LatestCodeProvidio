package CreditCardPayment;

import java.util.Random;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class AdyenPayment extends baseClass{

	   private static final  Random rand = new Random();	
	   private static final PaymentPage pp = new PaymentPage(driver);  
	   private static final String cardNum = "cardNumber";
	
	   public static void adyenPayment() throws Exception {
    	 cardNumberInAdyenPayment();
    	 test.info("Entered card number for adyen payment");
    	 expDateInAdyen();
    	 test.info("Entered exp date for adyen payment");	
    	 secCodeInAdyen();
    	 test.info("Entered cvv for adyen payment");
    	 holderNameInAdyen();
    	 test.info("Entered holder name for adyen payment");	    	 
	     }
	   
	   public static void adyen() throws Exception {
	  		Actionsss.scrollWindowsByPixel(700);
	  		Thread.sleep(3000);
	  		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
	  		  //guest user payment
	  			test.info("User is checked in as guest  so entering a random credit card details");
	  			adyenPayment();
	  		}else {
	  			test.info("User is checked in as register and saving the card to account is not configured in providio adyen payment  ");
	  			adyenPayment();
	  		}
	  	}
	   
	   public static void cardNumberInAdyenPayment() throws Exception {
			String[] cardNumbers = {
	  			 	// "3700 0000 0000 002",
			         "3700 0000 0100 018",
			        // "4035 5010 0000 0008",
			       //  "4360 0000 0100 0005",			        
	          };
			
		     int randomIndex = rand.nextInt(cardNumbers.length);
		     test.info("Entered credit card number is " +cardNumbers[randomIndex] );		     
		     driver.switchTo().frame(pp.getAdyenCardNumIframe());
		     Actionsss.clearText(pp.getAdyenCardNumInput());
		     Actionsss.sendKeys(pp.getAdyenCardNumInput(),cardNumbers[randomIndex],cardNum);
		     driver.switchTo().defaultContent();
		     String lastFourDigits = cardNum.substring(cardNum.length() - 4);
			 creditCardNumber=lastFourDigits;
	    }
	    
		public static void expDateInAdyen() throws Exception {
		     test.info("Entered expiry date for card number is 03 30"  );		     
		     driver.switchTo().frame(pp. getAdyenExpDateIframe());
		     Actionsss.clearText(pp.getAdyenExpDateInput());
		     Actionsss.sendKeys(pp.getAdyenExpDateInput(),"03 30","Expiry date");
		     driver.switchTo().defaultContent();
		}
		
		public static void secCodeInAdyen() throws Exception {
		     test.info("Entered security code for card number is 7373"  );		     
		     driver.switchTo().frame(pp.getAdyenSecCodeIframe());
		     Actionsss.clearText(pp.getAdyenSecCodeInput());
		     Actionsss.sendKeys(pp.getAdyenSecCodeInput(),"7373","Security code");
		     driver.switchTo().defaultContent();
		}
		
		public static void holderNameInAdyen() throws Exception {
		     test.info("Entered holder name for card number is " +fakeEmail  );		     		   
		     Actionsss.clearText(pp.getAdyenHolderNameInput());
		     Actionsss.sendKeys(pp.getAdyenHolderNameInput(),fakeEmail,"holder name");		    
		}
}
