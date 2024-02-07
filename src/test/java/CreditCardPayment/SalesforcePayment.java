package CreditCardPayment;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class SalesforcePayment extends baseClass {
	
	private static final  Random rand = new Random();	
	private static final PaymentPage pp = new PaymentPage(driver);  
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	

	public static void salesForce() throws Exception {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {											
			//guest user payment	
			test.info("User is in guest-check in so entering a random credit card details");
			salesforcePayment();	
		}else {
			if(Actionsss.elementSize(pp.getSavedCardsSalesforce())) {
				//if user is registered and have saved cards then  this if will execute
				test.info("User is checked-in as registered and have saved cards so randomly selecting a saved card");
				savedCardsSalesforce();
			}else {
				//new user without saved cards and user saves the new card to account
				test.info("User is checked-in as registered but don't have saved cards so entering the random credit card details");
				withoutSavedCardSalesforceReg();
			}
		}
	}

	
	public static void salesforcePayment() throws Exception {
		salesforceCardNumber();
    	logger.info("Entered card number for salesforce payment");
    	salesforceExpDate();
    	logger.info("Entered cvv for salesforce payment");
    	salesforceCvv();
    	logger.info("Entered exp for salesforce payment");
	}
	
	public static void salesforceCardNumber() throws Exception {	  
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
	    
        int randomIndex = rand.nextInt(cardNumbers.length);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']"))); 
        Actionsss.clearText(pp.getStripeCardNumber());
        Actionsss.sendKeys(pp.getSalesforceCardNumber(),cardNumbers[randomIndex],cardNum);
		String cardNumber = pp.getSalesforceCardNumber().getAttribute("value");
		test.info("Credit card number entered is " + cardNumber);
		String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
		creditCardNumber=lastFourDigits;		
		driver.switchTo().defaultContent();
	}
	
	public static void salesforceExpDate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
		Actionsss.sendKeys(pp.getSalesforceExpiryDate(), "1229",expDate);
		Thread.sleep(2000);
		String expDate = pp.getSalesforceExpiryDate().getAttribute("value");
		test.info("Credit card expiry date entered is " +expDate);
	    driver.switchTo().defaultContent();
	}
	
	public static void salesforceCvv() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
		Actionsss.sendKeys(pp.getSalesforceCvv(), "345",creditCardCvv);
		String cvv = pp.getSalesforceCvv().getAttribute("value");
		test.info("Credit card cvv entered is " +cvv);
		driver.switchTo().defaultContent();
	}

    public static void addNewCardThoughExistingCardsInSalesforce() throws Exception {
    	Actionsss.javascriptClick(pp.getSalesforceCreditCard());
    	salesforcePayment();    	
    	Actionsss.CombinedClick(pp.getSaveToaccountInSalesforce());
    }
    
   public static  void savedCardsSalesforce() throws InterruptedException {	    
    	Actionsss.randomElementFromList(pp.getSavedCardsSalesforce());
    	logger.info("Selected random card");
	    test.info("Selected random saved card");
    }
	
    public  static void withoutSavedCardSalesforceReg() throws Exception {
   	 test.info("User don't have saved cards as new user");
   	 salesforcePayment();
   	 Actionsss.javascriptClick(pp.getSaveToaccountInSalesforce());
   	 
   }

}
