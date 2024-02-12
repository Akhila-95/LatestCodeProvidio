package validations;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import CreditCardPayment.AdyenPayment;
import CreditCardPayment.CyberSourcePayment;
import CreditCardPayment.SalesforcePayment;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ShippingPageObject;
import tasks.PaymentPageTasks;

public class PaymentPageValidation extends baseClass{
	
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final ShippingPageObject shippingPage = new ShippingPageObject(driver);

		public static void bactToCartValidationInPaymentPage() {
			test.info("Verifying the back to cart  display in payment page");
			 if(Actionsss.displayElement(paymentPage.getBackToCart())) {
				 logger.info("Back to cart is displayed in paymentpage");
				 test.pass("Back to cart is displayed in payment page");
			 }else {
				 logger.info("No Back to cart  is displayed in payment page");
				 test.pass("No Back to cart  is displayed in payment page");
			 }
		}

		public static void customerInfoValidationInPaymentPage() {
			 test.info("Verifying the customer information is displayed in payment page ");
			 if(Actionsss.displayElement(paymentPage.getCustomerInfo())) {
				 logger.info("Customer information is displayed in payment page");
				 test.pass("Customer information is displayed in payment page");
			 }else {
				 logger.info("No Customer information is displayed in payment page");
				 test.pass("No Customer information is displayed in payment page");
			 }
		}
		
		public static void shippingDetailValidationInPaymentPage() {
			test.info("Verifying the shipping details form  is displayed in payment page ");
			 if(Actionsss.displayElement(paymentPage.getshippingInfo())) {
				 logger.info("shipping details form  is displayed in payment page");
				 test.pass("shipping details form is displayed in payment page");
			 }else {
				 logger.info("No shipping details form is displayed in payment page");
				 test.pass("No shipping details form is displayed in payment page");
			 }
		}
		
		public static void orderSummaryValidationInPaymentPage() {
			test.info("Verifying the orderSummary display in payment page ");
			 if(Actionsss.displayElement(paymentPage.getOrderSummaryDiv())) {
				 logger.info("orderSummary  is displayed in payment page");
				 test.pass("orderSummary  is displayed in payment page");
			 }else {
				 logger.info("No orderSummary  is displayed in payment page");
				 test.pass("No orderSummary  is displayed in payment page");
			 }
		}
		
		public static void etgLogoValidationInPaymentPage() {
			test.info("Verifying the  etg logo display in payment page ");
			 if(Actionsss.displayElement(paymentPage.getOrderSummaryDiv())) {
				 logger.info(" Etg logo  is displayed in payment page");
				 test.pass(" Etg logo is displayed in payment page");
			 }else {
				 logger.info("No etg logo is displayed in payment page");
				 test.pass("No etg logo is displayed in payment page");
			 }
		}
		public static void pdpPageValidation() {
			test.info("Verifying the pagination of product from payment page");
			if(Actionsss.displayElement(paymentPage.getPdpPage())) {
				 logger.info("Succesfully paginated to PDP page by clicking the product from payment page");
				 test.pass("Succesfully paginated to PDP page by clicking the product from payment page");
			 }else {
				 logger.info("Not paginated to PDP page by clicking the product from payment page");
				 test.fail(" Not paginated to PDP page by clicking the product from payment page");	 
			}
		}
		public static void reviewOrderButtonInPaymentPage() {
			test.info("Verifying the  review order button display in payment page ");
			 if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
				 logger.info("Review order button is displayed in payment page");
				 test.pass("Review order button is displayed in payment page");
			 }else {
				 logger.info("No Review order button is displayed in payment page");
				 test.pass("No Review order button is displayed in payment page");
			 }
		}
		public static void paymentFormInPaymentPage() {
			test.info("Verifying the payment info display in payment page ");
			 if(Actionsss.displayElement(paymentPage.getPaymentInfoDiv())) {
				 logger.info(" Payment info div is displayed in payment page");
				 test.pass("  Payment info div is displayed in payment page");
			 }else {
				 logger.info("No  Payment info div is displayed in payment page");
				 test.pass("No  Payment info div is displayed in payment page");
			 }
		}
		
		public static void displayOfGiftMessageInCheckoutPage3() throws InterruptedException {
			test.info("Verifying the gift message in checkoutpage 3");
			Thread.sleep(4000);
			if(Actionsss.displayElement(shippingPage.getgiftMessageInCop3())) {
				test.pass("Successfully the gift message is displayed as" + Actionsss.getTextOfElement(shippingPage.getgiftMessageInCop3()));
				logger.info("Successfully the gift message is displayed as" + Actionsss.getTextOfElement(shippingPage.getgiftMessageInCop3()));
			}else {
				test.fail("Gift message is not displayed ");
				logger.info("Gift message is not displayed");
			}
		}
		
		public  static void VerifiedThatPlaceOrderClick() {
	 		test.info("Verified That placeOrder Btn click");	 		
	     	WebElement miniCartPage = driver.findElement(By.xpath("//h2[@class='order-thank-you-msg']"));	     	
	     	if (miniCartPage.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the placeOrder Btn");
	     	    test.pass("Successfully Clicked on the placeOrder Btn");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
		public static void billingPhoneNumberErrorValidation() throws InterruptedException {
			test.info("Verifying the billing phone number when it is not entered and by entering credit card details clicks on review  orderbutton or place order button ");			
			if(Actionsss.elementSize(paymentPage.getBillingPhoneNumberError())) {
				 logger.info("Successfully billing number error message is displayed ");	
				 test.pass("Successfully billing number error message is displayed ");
			}else{
				 logger.info("No billing number error message is displayed ");	
				 test.fail("No billing number error message is displayed ");
			}	
		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
		
		
		public static void editEmailValidationInCOP3() {
			test.info("Verifying that the email ID is being edited on checkout page 3");
			  logger.info(editedEmailFromCop3);
			  logger.info(previousMail);
			  
			if(!(previousMail.equals(emailEditedInCop3))) {
				test.pass("Successfully email id is edited the previous email is " +previousMail +" and edited email is "+ emailEditedInCop3);
				logger.info("Successfully email id is edited the previous email is " +previousMail +" and edited email is "+ emailEditedInCop3);
			}else {
				test.fail("Email id is not edited the previous email is " +previousMail +" and edited email is "+ emailEditedInCop3);
				logger.info("Email id is not edited the previous email is " +previousMail +" and edited email is "+ emailEditedInCop3);
			}
		}
	
		public static  void editShippingValidationInCOP3() {
			  test.info("Verifying that the  shipping addres is being edited on checkout page 3");
			  logger.info(editedAddress);
			  logger.info( previousAddresses);
			if(!(previousAddresses.equals(editedAddress))) {
				test.pass("Successfully shipping addresss is edited the previous address is " + previousAddresses+" and edited shipping address  is "+ editedAddress);
				logger.info("Successfully shipping addresss is edited the previous address is " + previousAddresses+" and edited shipping address  is "+ editedAddress);
			}else {
				test.fail("shipping addresss is not edited the previous address is " + previousAddresses+" and edited shipping address  is "+ editedAddress);
				logger.info(" shipping addresss is not edited the previous address is " + previousAddresses+" and edited shipping address  is "+ editedAddress);
			}
		}
		
		public static void updateBillingAddressValidation() {
			  test.info("Verifying the update billing address");
			  logger.info(previousBillingAddress );
			  logger.info(editedBillingAddress);
			if(!(previousBillingAddress.equals(editedBillingAddress))) {
				test.pass("Successfully billing addresss is edited the previous address is " + previousBillingAddress +" and edited billing addresss    is "+ editedBillingAddress);
				logger.info("Successfully billing addresss  is edited the previous address is " + previousBillingAddress +" and edited billing addresss    is "+ editedBillingAddress);
			}else {
				test.fail("Billing addresss  is not edited the previous address is " + previousBillingAddress +" and edited billing addresss    is "+ editedBillingAddress);
				logger.info("Billing addresss  is not edited the previous address is " +previousBillingAddress +" and edited billing addresss   is "+ editedBillingAddress);
			}
		}

		public static void addNewBillingAddressValidation() {
			  test.info("Verifying the add new  billing address");
			  logger.info(previousBillingAddress );
			  logger.info(editedBillingAddress);
			if(!(previousBillingAddress.equals(editedBillingAddress))) {
				test.pass("Successfully new billing addresss is added the previous address is " + previousBillingAddress +" and added new billing addresss    is "+ editedBillingAddress);
				logger.info("Successfully new billing addresss is added the previous address is " + previousBillingAddress +" and added new billing addresss   is "+ editedBillingAddress);
			}else {
				test.fail("Successfully new billing addresss is added the previous address is " + previousBillingAddress +" and added new billing addresss    is "+ editedBillingAddress);
				logger.info("Successfully new billing addresss is added the previous address is " + previousBillingAddress +" and added new billing addresss    is "+ editedBillingAddress);
			}
		}
		

		public static void phoneNumberInBillingAddressValidation() {
			  test.info("Verifying the phone number in billing address");
			  logger.info(prevoiusBillingPhoneNumber );
			  logger.info(editedBillingPhoneNumber);
			if(!(prevoiusBillingPhoneNumber.equals(editedBillingPhoneNumber))) {
				test.pass("Successfully phone number in billing addresss is edited, the previous address is " + prevoiusBillingPhoneNumber +" and added new billing addresss   is "+ editedBillingPhoneNumber);
				logger.info("Successfully phone number in billing addresss is edited, the previous address is " + prevoiusBillingPhoneNumber +" and added new billing addresss   is "+ editedBillingPhoneNumber);
			}else {
				test.fail("Successfully phone number in billing addresss is edited, the previous address is " + prevoiusBillingPhoneNumber +" and added new billing addresss   is "+ editedBillingPhoneNumber);
				logger.info("Successfully phone number in billing addresss is edited, the previous address is " + prevoiusBillingPhoneNumber +" and added new billing addresss   is "+ editedBillingPhoneNumber);
			}
		}

	 	
		////////////////////////////////////////////////////////////////////////////////////////////////

	public static void salesforcePaymentAllErrors() throws InterruptedException {			
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(4000);						
			if((Actionsss.displayElement(paymentPage.getSalesforceCreditCardIncompleteError()) &&( Actionsss.displayElement(paymentPage.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(paymentPage.getsalesforceCreditCvvError())))) {
				test.pass("Successfully error messages are displayed for card number exp date and cvv");
				logger.info("Successfully error messages are displayed for card number exp date and cvv");
			}else {
				test.fail("No error messages are displayed for card number exp date and cvv");
				logger.info("No error messages are displayed for card number exp date and cvv");
			}
		}
		
		public static void salesforceCvvAndExpError() throws Exception {						
			SalesforcePayment.salesforceCardNumber();					
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Actionsss.scrollWindowsByPixel(300);
			Thread.sleep(3000);
			if((Actionsss.displayElement(paymentPage.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(paymentPage.getsalesforceCreditCvvError()))) {
				test.pass("Successfully error messages are displayed for exp date and cvv");
				logger.info("Successfully error messages are displayed for exp date and cvv");
			}else {
				test.fail("No error messages are displayed for exp date and cvv");
				logger.info("No error messages are displayed for  exp date and cvv");
			}
		}
		
		public static void  salesforceCvvError() throws Exception {			
			SalesforcePayment.salesforceCardNumber();			
			SalesforcePayment.salesforceExpDate();			
			Thread.sleep(2000);
			Actionsss.scrollWindowsByPixel(300);
			if(Actionsss.displayElement(paymentPage.getsalesforceCreditCvvError())){
				test.pass("Successfully error messages are displayed  cvv");
				logger.info("Successfully error messages are displayed cvv");
			}else {
				test.fail("No error messages are displayed for  cvv");
				logger.info("No error messages are displayed for cvv");		
			}
		}
		
		public static void salesforceInvalidCardNumber() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']"))); 
	        Actionsss.clearText(paymentPage.getSalesforceCardNumber());
	        test.info("Entered invalid Credit card number is " + "2132 1312 4214 1241");
	        Actionsss.sendKeys(paymentPage.getSalesforceCardNumber(),"2132 1312 4214 1241"," invalid cardNum");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			if(Actionsss.displayElement(paymentPage.getSalesforceCardInvalidError())) {
				test.pass("Error msg displayed when invalid credit card  details are entered");
				logger.info("Error msg displayed when invalid credit card details are entered");
			}else {
				test.fail("No Error msg displayed when invalid credit card details are entered");
				logger.info("No Error msg displayed when invalid credit card details are entered");
			}
		}
				
		public static void salesforceInvalidExpYear() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			SalesforcePayment.salesforceCardNumber();         	  
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
			test.info("Entered invalid expiry date is 1211" );
	        Actionsss.sendKeys(paymentPage.getSalesforceExpiryDate(), "1211","invalid expDate");
			driver.switchTo().defaultContent();			
			if(Actionsss.displayElement(paymentPage.getSalesforceExpInvalidError())) {
				test.pass("Error msg displayed when invalid exp date details are entered");
				logger.info("Error msg displayed when invalid exp date details are entered");
			}else {
				test.fail("No Error msg displayed when invalid exp date details are entered");
				logger.info("No Error msg displayed when invalid exp date details are entered");
			}
		}	
		
	
		
	/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		public static void brainTreeAllPaymentsError() throws Exception {
			Actionsss.scrollWindowsByPixel(800);
			PaymentPageTasks.clickReviewOrderButton();			
			if(Actionsss.displayElement(paymentPage.getErrorMsgInBrainTree())){
				test.pass("Error msg displayed when no mandatory details are entered");
				logger.info("Error msg displayed when no mandatory details are entered");
			}else {
				test.fail("No Error msg displayed when no mandatory details are entered");
				logger.info("No Error msg displayed when no mandatory details are entered");
			}
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		
		public static void stripePopUpErrorNoDetailsEntered() throws Exception {
			PaymentPageTasks.clickReviewOrderButton();
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();        
	        String alertText = alert.getText();
	        logger.info("Alert Text: " + alertText);      
	        alert.accept(); // Clicks the "OK" button
	        String expectedText ="Your card number is incomplete.";
	        if(alertText.equals(expectedText)) {	        	
	        	test.pass("Error msg displayed when no card details are entered");
				logger.info("Error msg displayed when no card  details are entered");
			}else {
				test.fail("No Error msg displayed when no card details are entered");
				logger.info("No Error msg displayed when no card details are entered");
			}   
		}
		
		public static void stripePopUpErrorCvvAndExpiryEntered() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));	        
	        Actionsss.sendKeys(paymentPage.getStripeCardNumber(),"4111 1111 1111 1111","valid card Number is 4111 1111 1111 1111");	 
	        Thread.sleep(2000);
	        driver.switchTo().defaultContent();
			PaymentPageTasks.clickReviewOrderButton();			
			Alert alert = driver.switchTo().alert();        
	        String alertText = alert.getText();
	        logger.info("Alert Text: " + alertText);  
	        String expectedText="Your card's expiration date is incomplete.";
	        alert.accept(); // Clicks the "OK" button
	        if(alertText.equals(expectedText)) {	        	
	        	test.pass("Error msg displayed when no cvv and expiry  are no entered entered");
				logger.info("Error msg displayed when no cvv and expiry  are no entered entered");
			}else {
				test.fail("No Error msg displayed when no cvv and expiry  are no entered entered");
				logger.info("No Error msg displayed when no cvv and expiry  are no entered entered");
			}   
		}
		
		public static void stripePopUpErrorNoCvvAndPostalCodeEntered() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));	        
	        Actionsss.sendKeys(paymentPage.getStripeCardNumber(),"4111 1111 1111 1111","valid card Number is 4111 1111 1111 1111 ");  	     	  
	        Actionsss.sendKeys(paymentPage.getStripeExpDate(), "11 32 ", " valid expiry date is 11/32 ");
	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
			PaymentPageTasks.clickReviewOrderButton();			
			Alert alert = driver.switchTo().alert();        
	        String alertText = alert.getText();
	        logger.info("Alert Text: " + alertText);
	        String expectedText="Your card's security code is incomplete.";
	        alert.accept(); // Clicks the "OK" button
	        if(alertText.equals(expectedText)) {	        	
	        	test.pass("Error msg displayed when cvv and postal code are not entered");
				logger.info("Error msg displayed when cvv and postal code are not entered");
			}else {
				test.fail("No Error msg displayed when cvv and postal code are not entered");
				logger.info("No Error msg displayed when cvv and postal code are not entered");
			}   
		}
		
		public static void stripePopUpErrorNoPostalCodeEntered() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));        
	        Actionsss.sendKeys(paymentPage.getStripeCardNumber(),"4111 1111 1111 1111","valid cardNumber is 4111 1111 1111 1111");	                 
	        Actionsss.sendKeys(paymentPage.getStripeExpDate(), "11 32 ", " valid expiry Date is 11/32");     	       
			Actionsss.sendKeys(paymentPage.getStripeCvv(), "748","security code is 748");
	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
			PaymentPageTasks.clickReviewOrderButton();			
			Alert alert = driver.switchTo().alert();        
	        String alertText = alert.getText();
	        logger.info("Alert Text: " + alertText);
	        String expectedText="Your postal code is incomplete.";
	        alert.accept(); // Clicks the "OK" button
	        if(alertText.equals(expectedText)) {	        	
	        	test.pass("Error msg displayed when postal code is not entered");
				logger.info("Error msg displayed when postal code is not entered");
			}else {
				test.fail("No Error msg displayed when postal codeis not entered");
				logger.info("No Error msg displayed when postal code is not entered");
			}   
		}
		
		
		
		public static void stripeCardInvalidCardError() throws Exception {			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));	        
	        Actionsss.sendKeys(paymentPage.getStripeCardNumber(),"4111 1111 1111 1154","Invalid card Number is 4111 1111 1111 1154");
	        Thread.sleep(2000);
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(paymentPage.getStripeCardInvalidCardError())) {
	        	test.pass("Error msg displayed when invalid card details are entered");
				logger.info("Error msg displayed when invalid card  details are entered");
			}else {
				test.fail("Error msg displayed when invalid card details are entered");
				logger.info("Error msg displayed when invalid card details are entered");
			}   
	       
		}
		
		public static void stripeCardInvalidExpDate() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.sendKeys(paymentPage.getStripeExpDate(), "11 12 ", " invalid expiry Date is 11/12");
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(paymentPage.getStripeCardExpDateInvalid())) {
	        	test.pass("Error msg displayed when invalid exp year  details are entered");
				logger.info("Error msg displayed when invalid exp year details are entered");
			}else {
				test.fail("Error msg displayed when invalid exp year details are entered");
				logger.info("Error msg displayed when invalid exp year  details are entered");  
	        }	        		
		}
		
		public static void stripeIncompleteCardError() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));	   
	        Actionsss.sendKeys(paymentPage.getStripeCardNumber(),"4111 1111 1111 ","Incomplete card Number is  4111 1111 1111");
	        Actionsss.click(paymentPage.getClickOnStripeContainer());
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(paymentPage.getStripeCardCardNumInComplete())) {
	        	test.pass("Error msg displayed when incomplete card  details are entered");
				logger.info("Error msg displayed when incomplete card details are entered");
			}else {
				test.fail("Error msg displayed when incomplete card details are entered");
				logger.info("Error msg displayed when incomplete card  details are entered");  
	        }	        
		}
		
		public static void stripeIncompleteExpYearError() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.sendKeys(paymentPage.getStripeExpDate(), "11  ", " incomplete expiry Date 11/");
	        Actionsss.click(paymentPage.getClickOnStripeContainer());
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(paymentPage.getStripeCardExpYearIncompleteError())) {
	        	test.pass("Error msg displayed when incomplete exp year   details are entered");
				logger.info("Error msg displayed when incomplete exp year details are entered");
			}else {
				test.fail("Error msg displayed when incomplete exp year details are entered");
				logger.info("Error msg displayed when incomplete exp year  details are entered");  
	        }
	        
		}
		
		public static void getStripeCardSecurityCodeIncompleteError() throws Exception {			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
			Actionsss.sendKeys(paymentPage.getStripeCvv(), "78","Incomplete security code is 78");
			Actionsss.click(paymentPage.getClickOnStripeContainer());
			 driver.switchTo().defaultContent();
			if(Actionsss.displayElement(paymentPage.getStripeCardSecurityCodeIncompleteError())) {
				test.pass("Error msg displayed when incomplete security code  details are entered");
				logger.info("Error msg displayed when incomplete security code  details are entered");
			}else {
				test.fail("Error msg displayed when incomplete security code  details are entered");
				logger.info("Error msg displayed when incomplete security code   details are entered");  
	        }
			
		}
		
		public static void getStripeCardPostalCodeInComplete() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.sendKeys(paymentPage.getPostalCodeInStripe(), "987", "incomplete postal code is 987");
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(paymentPage.getStripeCardPostalCodeInComplete())) {
	        	test.pass("Error msg displayed when incomplete postal code  details are entered");
				logger.info("Error msg displayed when incomplete postal  code  details are entered");
			}else {
				test.fail("Error msg displayed when incomplete postal code  details are entered");
				logger.info("Error msg displayed when incomplete postal code   details are entered");  
	        }	    
		 	
		}
	
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		
		public static void getallErrosInCybersource() throws InterruptedException {			
			Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			Thread.sleep(3000);
			int countOfError =Actionsss.getSizeOfList(paymentPage.getErrorMsgsInCybersource());
			System.out.println(countOfError);			 
			if(countOfError==3 && Actionsss.displayElement(paymentPage.getErrorMsgForSecurityCodeInCybersource())) {
			 	test.pass("Error msg are displayed when no  card details are entered");
				logger.info("Error msg are displayed when  no  card details are entered");
			}else {
				test.fail("No Error msg displayed when  no  card details are entered");
				logger.info("No Error msg displayed when  no  card detailsare entered");  
	        }
		}
		
		public static void getCreditCardCvvAndExpMonthYearErrorInCybersource() throws Exception {			
			  CyberSourcePayment.cyberSourceCardNumber();		   	      
		      Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(2000);
		      int countOfError =Actionsss.getSizeOfList(paymentPage.getErrorMsgsInCybersource());
		      if((countOfError==2) &&(Actionsss.displayElement(paymentPage.getErrorMsgForSecurityCodeInCybersource()))){
		    	  test.pass("Error msg are displayed when expiry month and year, security code details are not entered");
				  logger.info("Error msg are displayed when expiry month and year, security code details are not entered");
			  }else {
				  test.fail("No Error msg displayed when expiry month and year, security code details are not entered");
				  logger.info("No Error msg displayed when expiry month and year, security code details are not entered");  
		      }
		}
		
		public static void getCreditCardCvvAndExpYearErrorInCybersource() throws Exception {			
			  CyberSourcePayment.cyberSourceCardNumber();		          
		      CyberSourcePayment.cyberSourceExpMonth();		            
		      Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(2000);
		      if(Actionsss.displayElement(paymentPage.getErrorMsgInCybersource())&& Actionsss.displayElement(paymentPage.getErrorMsgForSecurityCodeInCybersource())){
		    	  test.pass("Error msg are displayed when expiry  year, security code details are not entered");
				  logger.info("Error msg are displayed when expiry year, security code details are not entered");
			  }else {
				  test.pass(" Error msg displayed when expiry year, security code details are not entered");
				  logger.info("No Error msg displayed when expiry  year, security code details are not entered");  
		      }
		}
		
		public static void getCreditCardCvvErrorInCybersource() throws Exception {			  
			  CyberSourcePayment.cyberSourceCardNumber();	     		      
		      CyberSourcePayment.cyberSourceExpMonth();	      
		      CyberSourcePayment.cyberSourceExpYear();	      
		      Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(3000);
		      if(Actionsss.displayElement(paymentPage.getErrorMsgForSecurityCodeInCybersource())){
		    	  test.pass("Error msg are displayed when security code details are not entered");
				  logger.info("Error msg are displayed when  security code details are not entered");
			  }else {
				  test.fail("No Error msg displayed when  security code details are not entered");
				  logger.info("No Error msg displayed when security code details are not entered");  
		      }
		}
		
		public static void getcreditCardNumberInvalidErrorInCybersource() throws Exception {			   
			  Actionsss.sendKeys(paymentPage.getCyberSourceCreditcard(),"2132421421412412 ","invalid card Number is 2132421421412412");		  
			  CyberSourcePayment.cyberSourceExpMonth();      
		      CyberSourcePayment.cyberSourceExpYear();	      
		      CyberSourcePayment.cyberSourceSecurityCode() ;		      
		      Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(paymentPage.getErrorMsgForInvalidCreditCardInCybersource())) {
				  test.pass("Error msg are displayed when  invalid card details are  entered");
				  logger.info("Error msg are displayed when invalid  card details are entered");
			  }else {
				  test.fail("No Error msg displayed when invalid  card details are entered");
				  logger.info("No Error msg displayed when invalid card details are  entered");  
		      } 
		}
		
		public static void getcreditCardNumberInCompleteErrorInCybersource() throws Exception {			
			  Actionsss.sendKeys(paymentPage.getCyberSourceCreditcard(),"41111111","incomplete card Number 41111111 ");			  
			  CyberSourcePayment.cyberSourceExpMonth();	      
		      CyberSourcePayment.cyberSourceExpYear();		      
		      CyberSourcePayment.cyberSourceSecurityCode() ;		      
		      Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(paymentPage.getErrorMsgForInvalidCreditCardInCybersource())) {
				  test.pass("Error msg are displayed when incomplete card details are  entered");
				  logger.info("Error msg are displayed when incomplete card details are entered");
			  }else {
				  test.fail("No Error msg displayed when incomplete card details are entered");
				  logger.info("No Error msg displayed when incomplete card details are  entered");  
		      } 
		}
		
		
		public static void getIncompleteSecurityCodeErrorInCybersource() throws Exception { 			  
			  CyberSourcePayment.cyberSourceCardNumber();		  
		      CyberSourcePayment.cyberSourceExpMonth();	      
		      CyberSourcePayment.cyberSourceExpYear();		  
			  Actionsss.sendKeys(paymentPage.getCyberSourceSceuritycode(),"23","invalid security code 23");			  
			  Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(paymentPage.getErrorMsgForInvalidSecurityCodeInCybersource())) {
				  test.pass("Error msg are displayed when invalid/incomplete security code  entered");
				  logger.info("Error msg are displayed when invalid/incomplete security code entered");
			  }else {
				  test.fail("No Error msg displayed when  invalid/incomplete security code entered");
				  logger.info("No Error msg displayed when invalid/incomplete security code  entered");  
		      } 
		}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		
		
		//adyen payemnet
		public static void getallErrorsInAdyen() throws InterruptedException {
			Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			if(Actionsss.displayElement(paymentPage.getAdyenExpiryDateError()) && (Actionsss.displayElement(paymentPage.getAdyenSecurityCodeError()) && (Actionsss.displayElement(paymentPage.getAdyenHolderNameError())))){
				test.pass("Error msg are displayed when no  card details are entered");
				logger.info("Error msg are displayed when  no  card details are entered");
			}else {
				test.fail("No Error msg displayed when  no  card details are entered");
				logger.info("No Error msg displayed when  no  card details are entered");  
			}
		}
		
		public static void getCreditCardCvvAndExpErrorMessage() throws Exception {
			AdyenPayment.cardNumberInAdyenPayment();			
			Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			if(Actionsss.displayElement(paymentPage.getAdyenExpiryDateError())&& Actionsss.displayElement(paymentPage.getAdyenSecurityCodeError()) && Actionsss.displayElement(paymentPage.getAdyenHolderNameError())) {
				test.pass("Error msg are displayed when only valid card number details are entered and clicked on next review order button");
				logger.info("Error msg are displayed when only valid card number details are entered and clicked on next review order button");
			}else {
				test.fail("No Error msg are displayed when only valid card number details are entered and clicked on next review order button");
				logger.info("No Error msg are displayed when only valid card number details are entered and clicked on next review order button");  
			}
		}
		
		public static void getCreditCardCvvErrorMessage() throws Exception {
			AdyenPayment.cardNumberInAdyenPayment();			
			AdyenPayment.expDateInAdyen();
			Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			Thread.sleep(1000);
			 if(Actionsss.displayElement(paymentPage.getAdyenSecurityCodeError()) && Actionsss.displayElement(paymentPage.getAdyenHolderNameError())) {
					test.pass("Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");
					logger.info("Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");
				}else {
					test.fail("No Error msg are displayed when valid card number and expiry date are entered and clicked on next review order button");
					logger.info("No Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");  
				}		
		}
		
		public static void getcreditCardNumberInvalidErrorInAdyen() throws Exception {						     
		     driver.switchTo().frame(paymentPage.getAdyenCardNumIframe());
		     Actionsss.clearText(paymentPage.getAdyenCardNumInput());
		     Actionsss.sendKeys(paymentPage.getAdyenCardNumInput(),"2312 4242 3121 3231","invalid card Number 2312 4242 3121 3231" );
		     driver.switchTo().defaultContent();		     
		     Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());		    
		     if(Actionsss.displayElement(paymentPage.getAdyenInvalidCardNumError())) {
		    	 test.pass("Error msg are displayed when invalid card number is entered");
				 logger.info("Error msg are displayed when invalid card number is entered");
			 }else {
				 test.fail("No Error msg displayed when invalid card number is entered");
				 logger.info("No Error msg displayed when invalid card number is entered");  
				}
		}
		
		public static void getcreditCardExpMonthInValidInAdyen() throws Exception {	
			 driver.switchTo().frame(paymentPage. getAdyenExpDateIframe());
		     Actionsss.clearText(paymentPage.getAdyenExpDateInput());
		     Actionsss.sendKeys(paymentPage.getAdyenExpDateInput(),"03 23","Invalid Expiry date");
		     driver.switchTo().defaultContent();		     
		     Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		     test.info("Entered invalid expiry date is 11 23"  );
		     if(Actionsss.displayElement(paymentPage.getAdyenInvalidExpiryDateError())) {
		    	 test.pass("Error msg are displayed when invalid expiry date is entered");
				 logger.info("Error msg are displayed when invalid expiry date is entered");
			 }else {
				 test.fail("No Error msg displayed when invalid expiry date is entered");
				 logger.info("No Error msg displayed when invalid expiry date is entered");  
				}
		}
		
		public static void getCreditCardNumberInCompleteErrorInAdyen() throws Exception {			
			 driver.switchTo().frame(paymentPage.getAdyenCardNumIframe());
		     Actionsss.clearText(paymentPage.getAdyenCardNumInput());
		     Actionsss.sendKeys(paymentPage.getAdyenCardNumInput()," 3700 000000","incompelte card Number is 3700 000000");
		     driver.switchTo().defaultContent();
		     Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
		     if(Actionsss.displayElement(paymentPage.getAdyenIncompleteCardNumberError())) {
		    	 test.pass("Error msg are displayed when incomplete card number is entered");
				 logger.info("Error msg are displayed when  incomplete card number is entered");
			 }else {
				 test.fail("No Error msg displayed when  incomplete card number is entered");
				 logger.info("No Error msg displayed when  incomplete card number is entered");  
				}		     
		}
		
		public static void getCreditCardInCompleteExpYearError() throws Exception {
			  AdyenPayment.cardNumberInAdyenPayment();	     
			  driver.switchTo().frame(paymentPage. getAdyenExpDateIframe());
			  Actionsss.clearText(paymentPage.getAdyenExpDateInput());
			  Actionsss.sendKeys(paymentPage.getAdyenExpDateInput(),"03 3","Incomplete Expiry date is 03/3");
			  driver.switchTo().defaultContent();			  
			  AdyenPayment.secCodeInAdyen();			  
			  AdyenPayment.holderNameInAdyen();		  
			  Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());;	
			  if(Actionsss.displayElement(paymentPage.getAdyenIncompleteExpYearError())) {
				 test.pass("Error msg are displayed when incomplete expiry year is entered");
				 logger.info("Error msg are displayed when  incomplete expiry year  is entered");
			  }else {
				 test.fail("No Error msg displayed when  incomplete expiry year  is entered");
				 logger.info("No Error msg displayed when  incomplete expiry year  is entered");  
			}	  
		}
		public static void getCreditCardInCompleteCvvError() throws Exception {
			AdyenPayment.cardNumberInAdyenPayment();			
			AdyenPayment.expDateInAdyen();		
			driver.switchTo().frame(paymentPage.getAdyenSecCodeIframe());
		    Actionsss.clearText(paymentPage.getAdyenSecCodeInput());
		    Actionsss.sendKeys(paymentPage.getAdyenSecCodeInput(),"73","invalid Security code is 73");
		    driver.switchTo().defaultContent();			
		    AdyenPayment.holderNameInAdyen();
			Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			 if(Actionsss.displayElement(paymentPage.getAdyenIncompleteSecurityCodeError())) {
				 test.pass("Error msg are displayed when incomplete security code is entered");
				 logger.info("Error msg are displayed when  incomplete security code  is entered");
			  }else {
				 test.fail("No Error msg displayed when  incomplete security code  is entered");
				 logger.info("No Error msg displayed when  incomplete security code  is entered");  
			  }			 
		}
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		
		public static void redemptionOfGcValidation() throws InterruptedException {
			if(Actionsss.elementSize(paymentPage.getRedemptionWithGcMsg())) {
				 logger.info("Your order has been paid using gift certificates message is displayed.");	
				 test.pass("Gc code got redeemed and this message is displayed as Your order has been paid using gift certificates message");
			}else{
				logger.info("No Gc code got redeemed as No balance in Gift certificate ");	
				 test.pass("No Gc code got redeemed as No balance in Gift certificate ");
			}
		}
		
		public static void partialRedemptionOfGcValidation() throws InterruptedException {
			if(Actionsss.getSizeOfList(paymentPage.getsuccessGiftCodeRedemptionMsgList())==1) {
				 logger.info("One Gc code is redeemed ");	
				 test.pass("One Gc code is redeemed ");
			}else{
				 logger.info("No Gc code is redeemed ");	
				 test.fail("No Gc code is redeemed ");
			}
		}
		
		public static void enterGiftCodeErrorMsgValidation() throws InterruptedException {
			test.info("Verifying the Please enter a gift certificate code message when no gc is entered");
			if(Actionsss.elementSize(paymentPage.getEnterGiftCodeErrorMsg())) {
				 logger.info("Please enter a gift certificate code is displayed");	
				 test.pass("Please enter a gift certificate code is displayed");
			}else{
				logger.info("No Please enter a gift certificate code is displayed");	
				 test.fail("No Please enter a gift certificate code is displayed");
			}			
		}
		
		public static void invalidGiftCodeErrorMsgValidation() throws InterruptedException {
			test.info("Verifying the Invalid Gift Certificate Code when invalid gc is entered");
			if(Actionsss.elementSize(paymentPage.getInvalidGcError())) {
				 logger.info("Invalid Gift Certificate Code is displayed.");	
				 test.pass("Invalid Gift Certificate Code is displayed.");
			}else{
				logger.info("No Invalid Gift Certificate Code is displayed.");	
				 test.fail("No Invalid Gift Certificate Code is displayed.");
			}			
		}
		
		public static void insufficientGiftCodeErrorMsgValidation() throws InterruptedException {
			test.info("Verifying the insufficient Gift Certificate Code when no balance in gc is entered");
			if(Actionsss.elementSize(paymentPage.getInsufficientGiftCodeBalError())) {
				 logger.info("Insufficient Gift Certificate balance is displayed.");	
				 test.pass("Insufficient Gift Certificate balance is displayed.");
			}else{
				logger.info("No Insufficient Gift Certificate balance is displayed.");	
				 test.fail("No Insufficient Gift Certificate balance is displayed.");
			}			
		}
		
		public static void checkBalOfValidGiftCodeValidation() throws InterruptedException {
			test.info("Verifying the check bal Gift Certificate Code when valid  gc is entered");
			if(Actionsss.elementSize(paymentPage.getGiftCardBalMsgList())) {
				 logger.info("Check the balance message in gc  is displayed, bal in gc are " +Actionsss.getTextOfElement(paymentPage.getGiftCardBalMsg()));	
				 test.pass("Check the balance message in gc  is displayed, bal in gc are " +Actionsss.getTextOfElement(paymentPage.getGiftCardBalMsg()));
			}else{
				 logger.info("No Check the balance message in gc  is displayed");	
				 test.fail("No Check the balance message in gc  is displayed.");
			}			
		}
		
		public static void checkBalOfInvalidGiftCodeValidation() throws InterruptedException {
			test.info("Verifying the error message for checking balance of invalid gc code ");
			if(Actionsss.elementSize(paymentPage.getInvalidGcError() )) {
				 logger.info("The error message for checking balance of invalid gc code is displayed");	
				 test.pass("The error message for checking balance of invalid gc code is displayed");
			}else{
				 logger.info("The error message for checking balance of invalid gc code is displayed");	
				 test.fail("The error message for checking balance of invalid gc code is displayed");
			}			
		}
		
		public static void succesMsgForValidGcAppliedValidation() throws InterruptedException {
			test.info("Verifying the success message when a valid Gc is applied ");
			if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
				 logger.info("Success message is displayed when a valid Gc is applied ");	
				 test.pass("Success message is displayed when a valid Gc is applied ");
			}else{
				 logger.info("No Success message is displayed when a valid Gc is applied ");	
				 test.fail("No Success message is displayed when a valid Gc is applied ");
			}	
		}
		
		public static void gcBelongsToDifferentCutomerErrorValidation() throws InterruptedException {
			test.info("Verifying the success message when a valid Gc is applied ");
			if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
				 logger.info("Success message is displayed when a valid Gc is applied ");	
				 test.pass("Success message is displayed when a valid Gc is applied ");
			}else{
				 logger.info("No Success message is displayed when a valid Gc is applied ");	
				 test.fail("No Success message is displayed when a valid Gc is applied ");
			}	
		}
		
		public static void gcRemoveValidation() throws InterruptedException {
			test.info("Verifying the removal of Gc when a valid Gc is applied ");
			if(!Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
				 logger.info("Successfully applied gc is removed  ");	
				 test.pass("Successfully applied gc is removed");
			}else{
				 logger.info("No Successfully applied gc is removed ");	
				 //test.fail("No Successfully applied gc is removed ");
			}
		}		
	}


