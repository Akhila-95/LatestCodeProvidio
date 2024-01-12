package data;

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

public class AllPayments extends baseClass{

	private static final PaymentPage pp = new PaymentPage(driver);
	private static PaymentMethods pm = new PaymentMethods();
	
	private static final  Random rand = new Random();	
	
	private static final String cardHolderName = "Test123";
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	
	public  void brainTreeCardHolderName() throws InterruptedException {
		// card holder name
		driver.switchTo().frame("braintree-hosted-field-cardholderName");
		test.info("Entered card holder name");
		Actionsss.sendKeys(pp.getBrainTreeHoldername(),"Test123",cardHolderName );		
		driver.switchTo().defaultContent();
		
	}
	
	public void brainTreeCardNumber() throws InterruptedException {
	
			// card number
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
		   test.info("Entered card number");
		driver.switchTo().defaultContent();
	}
	
	public  void brainTreeCvv() throws InterruptedException {
		// cvv
			test.info("Entered cvv");
			driver.switchTo().frame("braintree-hosted-field-cvv");
			Actionsss.sendKeys(pp.getBrainTreeCvv(), "3455",creditCardCvv);			
			driver.switchTo().defaultContent();
	}
	
	public  void brainTreeExpDate() throws InterruptedException {
		//exp date
		test.info("entered Exp date");
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		Actionsss.sendKeys(pp.getBrainTreeExp(), "1230",expDate);	
		driver.switchTo().defaultContent();
	}
	
	public void brainTreeSavedCards() throws InterruptedException {
		
		Actionsss.click(pp.getBrainTreeNewCardDropdown());
																																																			
		Actionsss.randomElementFromList(pp.getSavedCardsBrainTree()); 
		
	}
	
	public  void salesforceCardNumber() throws InterruptedException {
		PaymentPage pp = new PaymentPage(driver);    

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
	    
	        int randomIndex = rand.nextInt(cardNumbers.length);

	        // Send the randomly selected card number
	      //  Actionss.waitForIframe(5,pp.getcardNumberIframe());
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']"))); 
			Actionsss.sendKeys(pp.getSalesforceCardNumber(),cardNumbers[randomIndex],cardNum);
			String cardNumber = pp.getSalesforceCardNumber().getAttribute("value");
			test.info("Credit card number entered is " + cardNumber);
			driver.switchTo().defaultContent();
	}
	public  void salesforceExpDate() throws InterruptedException {
		 //SalesForce Exp Date
		PaymentPage pp = new PaymentPage(driver);
		//Actionss.waitForIframe(5,pp.getSalesforceExpiryDate());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
		Actionsss.sendKeys(pp.getSalesforceExpiryDate(), "1229",expDate);
		Thread.sleep(2000);
		String expDate = pp.getSalesforceExpiryDate().getAttribute("value");
		test.info("Credit card expiry date entered is " +expDate);
	    driver.switchTo().defaultContent();
	}
	public  void salesforceCvv() throws InterruptedException {
		PaymentPage pp = new PaymentPage(driver); 
		//Actionss.waitForIframe(5,pp.getSalesforcecvviframeIframe());
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
		Actionsss.sendKeys(pp.getSalesforceCvv(), "345",creditCardCvv);
		String cvv = pp.getSalesforceCvv().getAttribute("value");
		test.info("Credit card cvv entered is " +cvv);
		driver.switchTo().defaultContent();
	}
    
	public void stripeCardNumber() throws InterruptedException {
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
     Actionsss.sendKeys(pp.getStripeCardNumber(),cardNumbers[randomIndex],cardNum);
 	 driver.switchTo().defaultContent();
 
	}
	
	public void stripeExpDate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
    	Actionsss.sendKeys(pp.getStripeExpDate(), "11 33 ",  expDate);
	}
	
	public void stripeCvv() throws InterruptedException {
		 Actionsss.sendKeys(pp.getStripeCvv(), "748",creditCardCvv);
	}
	
	public void stripePostalCode() {	 
	 	 //POSTAL CODE
	 	 Actionsss.selectValue(pp.getPostalCodeInStripe(), "98777890044");
	 	 driver.switchTo().defaultContent();
	}
	
	
	   public  void savedCardsSalesforce() throws InterruptedException {
	    	 //randomize the saved cards in salesforce
	    	//if (!savedCardsSalesforce.isEmpty()) {	    
	    	Actionsss.randomElementFromList(pp.getSavedCardsSalesforce());
	    	logger.info("Selected random card");
		    test.info("Selected random saved card");
	    }
		
	    public  void withoutSavedCardSalesforceReg() throws Exception {
	   	 test.info("User don't have saved cards as new user");
	   	 //entering card details into input box
	   	 pm.salesforcePayment();

	   	 Actionsss.javascriptClick(pp.getSaveToaccountInSalesforce());
	   	 
	   }
	
	
	public  void cyberSourceCardNumber() throws InterruptedException {
	
		//card number 
		String[] cardNumbers = {
  			 	 "4111 1111 1111 1111",
		         "4242 4242 4242 4242",		      
          };
		
	     int randomIndex = rand.nextInt(cardNumbers.length);
	         
	     Actionsss.sendKeys(pp.getCyberSourceCreditcard(),cardNumbers[randomIndex],cardNum);
	     Thread.sleep(2000);
	}
	public void cyberSourceExpMonth() throws InterruptedException {
		
		Actionsss.selectValue(pp.getCyberSourceExpmonth(), "10");
	}
	public  void cyberSourceExpYear() throws InterruptedException {
		
		Actionsss.selectValue(pp.getCyberSourceExpYear(),"5" );
	}
	public  void cyberSourceSecurityCode() throws InterruptedException {
		
		Actionsss.sendKeys(pp.getCyberSourceSceuritycode(),"2345",creditCardCvv);
	}
	
	public void savedCardsCyberSource() throws Exception {
	
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
	
	public  void withoutSavedCardsCyberReg() throws InterruptedException {
		
	
		pm.cyberSource();
		
		// save card to account is already enabled
		Actionsss.click(pp.getCyberSourceAddPaymentBtn());
	}
	  public void savedCardsStripe() throws InterruptedException {
	 		// to randomaize the saved cards -randomly pick any saved card 
		    	 List<WebElement> countOfSavedCards= driver.findElements(By.xpath("//input[@name='saved_card_id']"));
	 		if (!countOfSavedCards.isEmpty()) {
	 			Actionsss.randomElementFromList(pp.getCountOfSavedCards());
	 	    	System.out.println("Selected random card");	    		
			    	}
		     } 
	     public void withoutSavedCardStripeReg() throws Exception {
	     	//enters paymnet details 
	    	 pm.stripePayment();
	  
	    	//clicking on save button 
	    	 Actionsss.javascriptClick(pp.getStripeSaveCardsButtons());
	     }
	     
	     public void addNewCardThoughExistingCardsInStripe() throws Exception {
		    	
		   	    test.info("Though user have saved cards want to add new card");
		    	PaymentPage pp = new PaymentPage(driver);
		    	//clicks on credit card label
		    	Actionsss.javascriptClick(pp.getStripeCreditCard());
		    	
		    	//add new card
		    	Actionsss.javascriptClick(pp.getAddNewCardStripe());
		    	
		    	 //enters paymnet details 
		    	pm.stripePayment();
				 
				//clicking on save button 
				 Actionsss.javascriptClick(pp.getStripeSaveCardsButtons());
		    	
		    }
		    public void addNewCardThoughExistingCardsInCyberSource() throws Exception {
		    	
		   	    test.info("Though user have saved cards want to add new card");
		    	PaymentPage pp = new PaymentPage(driver);
		    	//clicks on add paymnet
		    	Actionsss.javascriptClick(pp.getAddPaymentCybersource());
		    	
		   	   //credit card details
		    	pm.cyberSource();
				 
				 Actionsss.sendKeys(pp.getEmailInRegInCybersource(), "akhila.m@etg.digital","mail");
		    }
}
