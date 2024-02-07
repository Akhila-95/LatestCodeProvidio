package CreditCardPayment;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;

public class CyberSourcePayment extends baseClass{

	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final  Random rand = new Random();	
	
	private static final String cardNum = "cardNumber";
	private static final String  creditCardCvv= "Cvv";
	private static final String emailInPayment= "email";
	
	public static void cyberSource() throws Exception {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
			test.info("User is in guest-check in so entering a random credit card details");
			cyberSourcePayment();			
		}else {
			if(Actionsss.elementSize(paymentPage.getSavedCardsCyberSource())) {				
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
		 test.info("Entering card number for cybersource payment");
		 cyberSourceCardNumber();
		 test.info("Entering exp month for cybersource payment");
         cyberSourceExpMonth();
         test.info("Entering exp year for cybersource payment");
         cyberSourceExpYear();
         test.info("Entering scecode for cybersource paymentS");	
         cyberSourceSecurityCode() ;      	
	}
	
	public static void cyberSourceCardNumber() throws Exception {
		String[] cardNumbers = {
  			 	 "4111 1111 1111 1111",
		         "4242 4242 4242 4242",		      
          };
		
	     int randomIndex = rand.nextInt(cardNumbers.length);
	     Actionsss.clearText(paymentPage.getCyberSourceCreditcard());
	     Actionsss.sendKeys(paymentPage.getCyberSourceCreditcard(),cardNumbers[randomIndex],cardNum +cardNumbers[randomIndex]);
	     // Extract the last four digits
	     String lastFourDigits = cardNum.substring(cardNum.length() - 4);
	     creditCardNumber=lastFourDigits;
	     Thread.sleep(2000);
	}
	
	public static void cyberSourceExpMonth() throws InterruptedException {		
		Actionsss.selectValue(paymentPage.getCyberSourceExpmonth());
	}
	
	public static void cyberSourceExpYear() throws InterruptedException {		
		Actionsss.selectValue(paymentPage.getCyberSourceExpYear());
	}
	
	public  static void cyberSourceSecurityCode() throws Exception {
		Actionsss.clearText(paymentPage.getCyberSourceSceuritycode());
		Actionsss.sendKeys(paymentPage.getCyberSourceSceuritycode(),"2345",creditCardCvv + "is 2345");
	}
	
	
	public static void savedCardsCyberSource() throws Exception {	
		//select one and send the cvv number of that card	
			Actionsss.randomElementFromList(paymentPage.getSavedCardsCyberSource());
	        //selected saved card
	        WebElement selectedCard = driver.findElement(By.xpath("//div[@class='row saved-payment-instrument selected-payment']"));
	        String selectedCardText= selectedCard.getText();
	        logger.info("Selected card is " + selectedCardText);           
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
		Actionsss.click(paymentPage.getCyberSourceAddPaymentBtn());
	}
	
    public static void addNewCardThoughExistingCardsInCyberSource() throws Exception {    	
    	//clicks on add paymnet
    	Actionsss.javascriptClick(paymentPage.getAddPaymentCybersource());
    	cyberSource();	 
		Actionsss.sendKeys(paymentPage.getEmailInRegInCybersource(), "akhila.m@etg.digital",emailInPayment + "is akhila.m@etg.digital ");
    }
}
