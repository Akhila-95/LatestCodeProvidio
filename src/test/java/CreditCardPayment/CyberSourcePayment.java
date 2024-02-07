package CreditCardPayment;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class CyberSourcePayment extends baseClass{

	private static final PaymentPage pp = new PaymentPage(driver);
	private static final  Random rand = new Random();	
	
	private static final String cardNum = "cardNumber";
	private static final String  creditCardCvv= "Cvv";
	private static final String emailInPayment= "email";
	
	public static void cyberSource() throws Exception {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			cyberSourcePayment();			
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsCyberSource())) {				
				//if user is registered and have saved cards then  this if will execute
				test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
				savedCardsCyberSource();
			}else {
				//if user want to add new card  into account without having the saved cards
				test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
				withoutSavedCardsCyberReg();
			}
		}
	}
	
	
	public static void cyberSourcePayment() throws Exception {
		cyberSourceCardNumber();
        logger.info("Entered card number for cybersource payment");
        cyberSourceExpMonth();
        logger.info("Entered exp month for cybersource payment");
        cyberSourceExpYear();
        logger.info("Entered exp year for cybersource payment");
        cyberSourceSecurityCode() ;
        logger.info("Entered scecode for cybersource paymentS");		
	}
	
	public static void cyberSourceCardNumber() throws Exception {
		String[] cardNumbers = {
  			 	 "4111 1111 1111 1111",
		         "4242 4242 4242 4242",		      
          };
		
	     int randomIndex = rand.nextInt(cardNumbers.length);
	      test.info("Entered credit card number is " +cardNumbers[randomIndex] );
	     Actionsss.clearText(pp.getCyberSourceCreditcard());
	     Actionsss.sendKeys(pp.getCyberSourceCreditcard(),cardNumbers[randomIndex],cardNum);
	     // Extract the last four digits
	     String lastFourDigits = cardNum.substring(cardNum.length() - 4);
	     creditCardNumber=lastFourDigits;
	     Thread.sleep(2000);
	}
	
	public static void cyberSourceExpMonth() throws InterruptedException {		
		Actionsss.selectValue(pp.getCyberSourceExpmonth());
	}
	
	public static void cyberSourceExpYear() throws InterruptedException {		
		Actionsss.selectValue(pp.getCyberSourceExpYear());
	}
	
	public  static void cyberSourceSecurityCode() throws Exception {
		test.info("Entered cvv is  2345");
		Actionsss.clearText(pp.getCyberSourceSceuritycode());
		Actionsss.sendKeys(pp.getCyberSourceSceuritycode(),"2345",creditCardCvv);
	}
	
	
	public static void savedCardsCyberSource() throws Exception {	
		//select one and send the cvv number of that card	
			Actionsss.randomElementFromList(pp.getSavedCardsCyberSource());
	        //selected saved card
	        WebElement selectedCard = driver.findElement(By.xpath("//div[@class='row saved-payment-instrument selected-payment']"));
	        String selectedCardText= selectedCard.getText();
	        test.info("Selected card is " + selectedCardText);           
	        //scrolling to saved card input box to enter cvv
	        WebElement securityCodeElement = selectedCard .findElement(By.id("saved-payment-security-code"));
	        Actionsss.scrollIntoViewCenter(selectedCard);            
	        //clicks to enter cvv 
	        Actionsss.javascriptClick(securityCodeElement);           
	
	        if(selectedCardText.contains("Credit Amex")) {	
	            // Locate the security code element and send the generated code		           
	            Thread.sleep(1000);		          
	            Actionsss.sendKeys(securityCodeElement, "1234",creditCardCvv);	                	
	        }else {   
	            // Locate the security code element and send the generated code		           
	            Thread.sleep(1000);	            
	            Actionsss.sendKeys(securityCodeElement, "456",creditCardCvv);	   	                 		       
	        }
	}
	
	public static void withoutSavedCardsCyberReg() throws Exception {
		cyberSource();		
		// save card to account is already enabled
		Actionsss.click(pp.getCyberSourceAddPaymentBtn());
	}
	
    public static void addNewCardThoughExistingCardsInCyberSource() throws Exception {    	
   	    test.info("Though user have saved cards want to add new card");
    	PaymentPage pp = new PaymentPage(driver);
    	//clicks on add paymnet
    	Actionsss.javascriptClick(pp.getAddPaymentCybersource());
    	cyberSource();	 
		Actionsss.sendKeys(pp.getEmailInRegInCybersource(), "akhila.m@etg.digital",emailInPayment);
    }
}
