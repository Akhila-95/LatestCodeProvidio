package CreditCardPayment;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;

public class SalesforcePayment extends baseClass {
	
	private static final  Random rand = new Random();	
	private static final String cardNum = "cardNumber";
	private static final String  expDate = "Expired date";
	private static final String  creditCardCvv= "Cvv";
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final String  salesforceExpiryDate= "1245";
	

	public static void salesForce() throws Exception {
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {											
			//guest user payment	
			test.info("User is in guest-check in so entering a random credit card details");
			salesforcePayment();	
		}else {
			if(Actionsss.elementSize(paymentPage.getSavedCardsSalesforce())) {
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
		test.info("Entering card number for salesforce payment");
		salesforceCardNumber();
		test.info("Entering cvv for salesforce payment");
    	salesforceExpDate();
    	test.info("Entering exp for salesforce payment");
    	salesforceCvv();  	
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
        Actionsss.clearText(paymentPage.getStripeCardNumber());
        Actionsss.sendKeys(paymentPage.getSalesforceCardNumber(),cardNumbers[randomIndex],cardNum);
		String cardNumber = paymentPage.getSalesforceCardNumber().getAttribute("value");
		String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
		creditCardNumber=lastFourDigits;		
		driver.switchTo().defaultContent();
	}
	
	public static void salesforceExpDate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
		Actionsss.sendKeys(paymentPage.getSalesforceExpiryDate(), salesforceExpiryDate ,expDate + "is " +salesforceExpiryDate);
	    driver.switchTo().defaultContent();
	}
	
	public static void salesforceCvv() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
		Actionsss.sendKeys(paymentPage.getSalesforceCvv(), "345",creditCardCvv +"is 345");
		driver.switchTo().defaultContent();
	}

    public static void addNewCardThoughExistingCardsInSalesforce() throws Exception {
    	Actionsss.javascriptClick(paymentPage.getSalesforceCreditCard());
    	salesforcePayment();    	
    	Actionsss.CombinedClick(paymentPage.getSaveToaccountInSalesforce());
    }
    
   public static  void savedCardsSalesforce() throws InterruptedException {	    
    	Actionsss.randomElementFromList(paymentPage.getSavedCardsSalesforce());
    	logger.info("Selected random card");
    }
	
    public  static void withoutSavedCardSalesforceReg() throws Exception {
   	   	salesforcePayment();
   	   	Actionsss.javascriptClick(paymentPage.getSaveToaccountInSalesforce());   	 
   }

}
