package CreditCardPayment;

import java.util.Random;

import com.providio.testcases.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;

public class BrainTreePayment extends baseClass {

	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final  Random rand = new Random();	
	
	private static final String cardHolderName = "Test123";
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	private static final String  braintreeexpDate = "12/30";
	

	
	public static void brainTreeMethod() throws Exception {
	 	Actionsss.scrollWindowsByPixel(500);
	 	Thread.sleep(1000);
	 	
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			BrainTreePayment.braintree();			
		}else {
			if(Actionsss.elementSize(paymentPage.getSavedCardsBrainTree())) {				
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
		 test.info("Entering card name for brain tree payment");
		 brainTreeCardHolderName();
		 test.info("Entering card number for brain tree payment ");
		 brainTreeCardNumber();
		 test.info("Entering cvv for brain tree payment");
		 brainTreeCvv();
		 test.info("Entering exp for brain tree payment");
		 brainTreeExpDate();	
	}
	
	public static  void brainTreeCardHolderName() throws InterruptedException {
		driver.switchTo().frame("braintree-hosted-field-cardholderName");
		Actionsss.sendKeys(paymentPage.getBrainTreeHoldername(),"Test123",cardHolderName +"is Test123 ");	
		driver.switchTo().defaultContent();	
	}
	
	public static void brainTreeCardNumber() throws InterruptedException {				
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
		Actionsss.sendKeys(paymentPage.getBrainTreeCardNum(),cardNumbers[randomIndex],cardNum + cardNumbers[randomIndex]);
		 // Extract the last four digits
        String lastFourDigits = cardNum.substring(cardNum.length() - 4);
		creditCardNumber=lastFourDigits;	
		driver.switchTo().defaultContent();
	}
	
	public static void brainTreeCvv() throws InterruptedException {			
		driver.switchTo().frame("braintree-hosted-field-cvv");
		Actionsss.sendKeys(paymentPage.getBrainTreeCvv(), "3455",creditCardCvv  +" is 3455");	
		driver.switchTo().defaultContent();
	}
	
	public static void brainTreeExpDate() throws InterruptedException {	
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		Actionsss.sendKeys(paymentPage.getBrainTreeExp(),  braintreeexpDate ,expDate +  braintreeexpDate  );	
		driver.switchTo().defaultContent();
	}
	
	//register user and select the new card and save the card
	public static void savedCardsBrainTree() throws InterruptedException {
		Actionsss.click(paymentPage.getBrainTreeNewCardDropdown());		
		Actionsss.randomElementFromList(paymentPage.getSavedCardsBrainTree()); 	
		//logger.info("Selectd the new card");
		//pm.braintree();		
	}
	
	public static void brainTreeReguser() throws InterruptedException {
		Actionsss.selectValue(paymentPage.getBrainTreeNewCardDropdown());
		Thread.sleep(3000);
	}

}


