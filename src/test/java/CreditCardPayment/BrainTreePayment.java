package CreditCardPayment;

import java.util.Random;

import com.providio.testcases.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPage;

public class BrainTreePayment extends baseClass {

	private static final PaymentPage pp = new PaymentPage(driver);
	private static final  Random rand = new Random();	
	
	private static final String cardHolderName = "Test123";
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	

	
	public static void brainTreeMethod() throws InterruptedException {
	 	Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			BrainTreePayment.braintree();			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsBrainTree())) {				
				//if user is registered and have saved cards then  this if will execute
				test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
				BrainTreePayment.savedCardsBrainTree();				
			}else {				
				//new user without saved cards in account 
				test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
				BrainTreePayment.braintree();				
			}
		}
	}
		
	public static void braintree() throws InterruptedException {
		 brainTreeCardHolderName();
		 logger.info("Entered card name for brain tree payment");
		 brainTreeCardNumber();
		 logger.info("Entered card number for brain tree payment ");
		 brainTreeCvv();
		 logger.info("Entered cvv for brain tree payment");
		 brainTreeExpDate();
		 logger.info("Entered exp for brain tree payment");
		
	}
	
	public static  void brainTreeCardHolderName() throws InterruptedException {
		driver.switchTo().frame("braintree-hosted-field-cardholderName");
		Actionsss.sendKeys(pp.getBrainTreeHoldername(),"Test123",cardHolderName );	
		test.pass("Entered card holder name as " +cardHolderName);
		driver.switchTo().defaultContent();
		
	}
	
	public static void brainTreeCardNumber() throws InterruptedException {				
		test.info("Entered card Number");
		driver.switchTo().frame("braintree-hosted-field-number");
		String[] cardNumbers = {
    			
	               "378282246310005",
	               "371449635398431",   	    
	     	       "5555555555554444",	        
	     	       "2223000048400011",
	    		   "4111111111111111"
	            };
		// Generate a random index to select a card number
     
        int randomIndex = rand.nextInt(cardNumbers.length);
        // Send the randomly selected card number
		Actionsss.sendKeys(pp.getBrainTreeCardNum(),cardNumbers[randomIndex],cardNum);
		 // Extract the last four digits
        String lastFourDigits = cardNum.substring(cardNum.length() - 4);
		creditCardNumber=lastFourDigits;	
		driver.switchTo().defaultContent();
		logger.info(cardNum);
		test.pass("Entered card number is " +cardNumbers[randomIndex] );
	}
	
	public static void brainTreeCvv() throws InterruptedException {			
		driver.switchTo().frame("braintree-hosted-field-cvv");
		Actionsss.sendKeys(pp.getBrainTreeCvv(), "3455",creditCardCvv);	
		test.pass("Entered cvv is 3455 ");
		driver.switchTo().defaultContent();
	}
	
	public static void brainTreeExpDate() throws InterruptedException {	
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		Actionsss.sendKeys(pp.getBrainTreeExp(), "1230",expDate);	
		test.pass("Entered Exp date is 1230 ");
		driver.switchTo().defaultContent();
	}
	
	
	//register user and select the new card and save the card
	public static void savedCardsBrainTree() throws InterruptedException {

		test.info("User already have saved cards");
		Actionsss.click(pp.getBrainTreeNewCardDropdown());
		
		Actionsss.randomElementFromList(pp.getSavedCardsBrainTree()); 
	
		//logger.info("Selectd the new card");
		//pm.braintree();
		
	}
	
	public static void brainTreeReguser() throws InterruptedException {
		Actionsss.selectValue(pp.getBrainTreeNewCardDropdown());
		Thread.sleep(3000);
	}

}
