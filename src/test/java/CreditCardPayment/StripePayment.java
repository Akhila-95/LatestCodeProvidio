package CreditCardPayment;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class StripePayment extends baseClass{

	private static final PaymentPage pp = new PaymentPage(driver);
	
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	private static final String  postalCode= "postal code";

    public static void stripePayment() throws InterruptedException {		
    	stripeCardNumber();
		test.info("Entered card number for stripe payment");
		stripeExpDate();
		test.info("Entered exp date for stripe payment");		
		stripeCvv();
		test.info("Entered cvv for stripe payment");
		stripePostalCode();
		test.info("Entered postal code for stripe payment");		
	}
	
  	public static void stripe() throws Exception {
  		Actionsss.scrollWindowsByPixel(300);
  		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
  		  //guest user payment
  			test.info("User is in guest-check in so entering a random credit card details");
  			stripePayment();
  		}else {
  				//if user is registered and have saved cards then  this if will execute
  				if(Actionsss.elementSize(pp.getStripeSavedCards())) {
  					test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
  					savedCardsStripe();
  				}else {
  					//new user without saved cards and user saves the new card to account
  					test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
  					withoutSavedCardStripeReg();
  			}
  		}
  	}
    
		public static void stripeCardNumber() throws InterruptedException {
			Random random = new Random();
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        String[] cardNumbers = {
	 
	        		"4111 1111 1111 1111",
			        "4242 4242 4242 4242",
			        "2223 0031 2200 3222",
			        "4000 0566 5566 5556",
			        "5555 5555 5555 4444",
			        "5200 8282 8282 8210",
			        "3714 4963 539 8431"
	 
	                // Add more card numbers here
	            };
	    	// Generate a random index to select a card number
	        int randomIndex = random.nextInt(cardNumbers.length);
	        // Send the randomly selected card number
	        test.info("Credit card number entered is " + cardNumbers[randomIndex]);
	        Actionsss.sendKeys(pp.getStripeCardNumber(),cardNumbers[randomIndex],cardNum);
	        String lastFourDigits = cardNum.substring(cardNum.length() - 4);
			creditCardNumber=lastFourDigits;
		}
		
		public static void stripeExpDate() throws InterruptedException {
	        test.info("Credit card expiry date entered is " +"11 33");
	    	Actionsss.sendKeys(pp.getStripeExpDate(), "11 33 ",  expDate);
		}
		
		public static void stripeCvv() throws InterruptedException {
			test.info("Credit card expiry date entered is " + "748");
			Actionsss.sendKeys(pp.getStripeCvv(), "748",creditCardCvv);
		}
		
		public static void stripePostalCode() throws InterruptedException {	 
			test.info("Credit card expiry date entered is " + "8777890044");
		 	Actionsss.sendKeys(pp.getPostalCodeInStripe(), "98777890044", postalCode);
		 	driver.switchTo().defaultContent();
		}
		
	  public static void savedCardsStripe() throws InterruptedException {
		// to randomaize the saved cards -randomly pick any saved card 
	    	 List<WebElement> countOfSavedCards= driver.findElements(By.xpath("//input[@name='saved_card_id']"));
			 if(!countOfSavedCards.isEmpty()) {
				Actionsss.randomElementFromList(pp.getCountOfSavedCards());
		    	System.out.println("Selected random card");	    		
			    }
	     } 
	  public static void withoutSavedCardStripeReg() throws Exception {
	    	 stripePayment(); 
	    	 Actionsss.javascriptClick(pp.getStripeSaveCardsButtons());
	  	}
	   
	  public static void useSaveCardInStripe() throws Exception {
	  	Actionsss.javascriptClick(pp.getswitchToSavedCardsStripe());
	  	Actionsss.randomElementFromList(pp.getCountOfSavedCards());
	  }
	  
	  public static void addNewCardThoughExistingCardsInStripe() throws Exception {	
	 	test.info("Though user have saved cards want to add new card");
	  	PaymentPage pp = new PaymentPage(driver);
	  	//clicks on credit card label
	  	Actionsss.javascriptClick(pp.getStripeCreditCard());  	
	  	//add new card
	  	Actionsss.javascriptClick(pp.getAddNewCardStripe());	  	 
	    stripePayment(); 
		Actionsss.javascriptClick(pp.getStripeSaveCardsButtons());	
	  }
	  
	
}


