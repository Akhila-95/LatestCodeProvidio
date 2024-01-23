package validations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import data.AllPayments;
import functionality.Actionsss;
import pageObjects.CheckOutPage3;
import pageObjects.PaymentPage;

public class PaymentPageValidation extends baseClass{
	
private static final PaymentPage pp = new PaymentPage(driver);	
private static final AllPayments allPay = new AllPayments();

private static CheckOutPage3 cop3= new CheckOutPage3(driver);

		public static void displayOfGiftMessageInCheckoutPage3() throws InterruptedException {
			test.info("Verifying the gift message in checkoutpage 3");
			Thread.sleep(2000);
			if(Actionsss.displayElement(cop3.getgiftMessageInCop3())) {
				test.pass("Successfully the gift message is displayed as" + Actionsss.getTextOfElement(cop3.getgiftMessageInCop3()));
				logger.info("Successfully the gift message is displayed as" + Actionsss.getTextOfElement(cop3.getgiftMessageInCop3()));
			}else {
				test.fail("Gift message is not displayed ");
				logger.info("Gift message is not displayed");
			}
		}
		public  void editEmailValidationInCOP3() {
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
				test.pass("Successfully shipping addresss is edited the previous address is " + previousAddresses+" and edited shipping address is  is "+ editedAddress);
				logger.info("Successfully shipping addresss is edited the previous address is " + previousAddresses+" and edited shipping address is  is "+ editedAddress);
			}else {
				test.fail("shipping addresss is not edited the previous address is " + previousAddresses+" and edited shipping address is  is "+ editedAddress);
				logger.info(" shipping addresss is not edited the previous address is " + previousAddresses+" and edited shipping address is  is "+ editedAddress);
			}
		}
		
		public  void updateBillingAddressValidation() {
			test.info("Verifying the update billing address");
			  logger.info(previousBillingAddress );
			  logger.info( editedBillingAddress);
			if(!(previousBillingAddress.equals(editedBillingAddress))) {
				test.pass("Successfully billing addresss is edited the previous address is " + previousBillingAddress +" and edited billing addresss  is  is "+ editedBillingAddress);
				logger.info("Successfully billing addresss  is edited the previous address is " + previousBillingAddress +" and edited billing addresss  is  is "+ editedBillingAddress);
			}else {
				test.fail("Billing addresss  is not edited the previous address is " + previousBillingAddress +" and edited billing addresss  is  is "+ editedBillingAddress);
				logger.info("Billing addresss  is not edited the previous address is " +previousBillingAddress +" and edited billing addresss  is  is "+ editedBillingAddress);
			}
		}


	 	public  static void VerifiedThatPlaceOrderClick() {
	 		test.info("Verified That placeOrder Btn click");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement miniCartPage = driver.findElement(By.xpath("//h2[@class='order-thank-you-msg']"));
	     	
	     	if (miniCartPage.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the placeOrder Btn");
	     	    test.pass("Successfully Clicked on the placeOrder Btn");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	

	public  void salesforcePaymentAllErrors() throws InterruptedException {
			
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Thread.sleep(4000);
			
			test.info("Verifying with negative validations for card number ,exp and cvv");
			if((Actionsss.displayElement(pp.getSalesforceCreditCardIncompleteError()) &&( Actionsss.displayElement(pp.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(pp.getsalesforceCreditCvvError())))) {
				test.pass("Successfully error messages are displayed for card number exp date and cvv");
				logger.info("Successfully error messages are displayed for card number exp date and cvv");
			}else {
				test.fail("No error messages are displayed for card number exp date and cvv");
				logger.info("No error messages are displayed for card number exp date and cvv");
			}
		}
		
		public  void salesforceCvvAndExpError() throws Exception {
			
			test.info("Verifying with negative validations for exp and cvv");
			allPay.salesforceCardNumber();
			Thread.sleep(3000);
			
			Actionsss.CombinedClick(pp.getSelectPlaceOrderBtn());
			Actionsss.scrollWindowsByPixel(300);
			if((Actionsss.displayElement(pp.getsalesforceCreditCardExpDateError()) && Actionsss.displayElement(pp.getsalesforceCreditCvvError()))) {
				test.pass("Successfully error messages are displayed for exp date and cvv");
				logger.info("Successfully error messages are displayed for exp date and cvv");
			}else {
				test.fail("No error messages are displayed for exp date and cvv");
				logger.info("No error messages are displayed for  exp date and cvv");
			}
		}
		
		public void  salesforceCvvError() throws Exception {
			test.info("Verifying with negative validations  cvv");
			
			allPay.salesforceCardNumber();
			
			allPay.salesforceExpDate();
			
			Thread.sleep(2000);
			Actionsss.scrollWindowsByPixel(300);
			if(Actionsss.displayElement(pp.getsalesforceCreditCvvError())){
				test.pass("Successfully error messages are displayed  cvv");
				logger.info("Successfully error messages are displayed cvv");
			}else {
				test.fail("No error messages are displayed for  cvv");
				logger.info("No error messages are displayed for cvv");		
			}
		}
		
		public void salesforceInvalidCardNumber() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']"))); 
	        Actionsss.clearText(pp.getSalesforceCardNumber());
	        test.info("Credit card number entered is " + "2132 1312 4214 1241");
	        Actionsss.sendKeys(pp.getSalesforceCardNumber(),"2132 1312 4214 1241"," invalid cardNum");
			driver.switchTo().defaultContent();
			
			if(Actionsss.displayElement(pp.getSalesforceCardInvalidError())) {
				test.pass("Error msg displayed when invalid credit card  details are entered");
				logger.info("Error msg displayed when invalid credit card details are entered");
			}else {
				test.fail("No Error msg displayed when invalid credit card details are entered");
				logger.info("No Error msg displayed when invalid credit card details are entered");
			}
		}
		
		
		public void salesforceInvalidExpYear() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			allPay.salesforceCardNumber();         	  
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
			test.info("credit card exp date entered is 1211" );
	        Actionsss.sendKeys(pp.getSalesforceExpiryDate(), "1211","invalid expDate");
			driver.switchTo().defaultContent();
			
			if(Actionsss.displayElement(pp.getSalesforceExpInvalidError())) {
				test.pass("Error msg displayed when invalid exp date details are entered");
				logger.info("Error msg displayed when invalid exp date details are entered");
			}else {
				test.fail("No Error msg displayed when invalid exp date details are entered");
				logger.info("No Error msg displayed when invalid exp date details are entered");
			}
		}
		
	
		
		
		
		
		public void brainTreeAllPaymentsError() throws Exception {
			Actionsss.scrollWindowsByPixel(1100);
			Actionsss.javascriptClick(pp.getReviewOrderBtn());
			Thread.sleep(4000);
		
			if(Actionsss.displayElement(pp.getErrorMsgInBrainTree())){
				test.pass("Error msg displayed when no mandatory details are entered");
				logger.info("Error msg displayed when no mandatory details are entered");
			}else {
				test.fail("No Error msg displayed when no mandatory details are entered");
				logger.info("No Error msg displayed when no mandatory details are entered");
			}
		}
		
		public void stripeCardInvalidCardError() throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        test.info("Credit card number entered is " + "4111 1111 1111 1154");
	        
	        Actionsss.sendKeys(pp.getStripeCardNumber(),"4111 1111 1111 1154","Invalid cardNum");
	        Thread.sleep(2000);
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(pp.getStripeCardInvalidCardError())) {
	        	test.pass("Error msg displayed when invalid card details are entered");
				logger.info("Error msg displayed when invalid card  details are entered");
			}else {
				test.fail("Error msg displayed when invalid card details are entered");
				logger.info("Error msg displayed when invalid card details are entered");
			}   
	       
		}
		
		public void stripeCardInvalidExpDate() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        test.info("Credit card number entered is " + "11 12");
	        Actionsss.clearText(pp.getStripeExpDate());
	        Actionsss.sendKeys(pp.getStripeExpDate(), "11 12 ", " invalid expDate");
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(pp.getStripeCardExpDateInvalid())) {
	        	test.pass("Error msg displayed when invalid exp year  details are entered");
				logger.info("Error msg displayed when invalid exp year details are entered");
			}else {
				test.fail("Error msg displayed when invalid exp year details are entered");
				logger.info("Error msg displayed when invalid exp year  details are entered");  
	        }
	        
		
}
		public void stripeIncompleteCardError() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.clearText(pp.getStripeCardNumber());
	        test.info("Credit card number entered is 4111 1111 1111 ");
	        Actionsss.sendKeys(pp.getStripeCardNumber(),"4111 1111 1111 ","Incomplete cardNum");
	        Actionsss.click(pp.getClickOnStripeContainer());
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(pp.getStripeCardCardNumInComplete())) {
	        	test.pass("Error msg displayed when incomplete card  details are entered");
				logger.info("Error msg displayed when incomplete card details are entered");
			}else {
				test.fail("Error msg displayed when incomplete card details are entered");
				logger.info("Error msg displayed when incomplete card  details are entered");  
	        }
	        
		}
		
		public void stripeIncompleteExpYearError() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.clearText(pp.getStripeExpDate());
	        test.info("Credit card number entered is " + "11/");
	        Actionsss.sendKeys(pp.getStripeExpDate(), "11  ", " invalid expDate");
	        Actionsss.click(pp.getClickOnStripeContainer());
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(pp.getStripeCardExpYearIncompleteError())) {
	        	test.pass("Error msg displayed when incomplete exp year   details are entered");
				logger.info("Error msg displayed when incomplete exp year details are entered");
			}else {
				test.fail("Error msg displayed when incomplete exp year details are entered");
				logger.info("Error msg displayed when incomplete exp year  details are entered");  
	        }
	        
		}
		
		public void getStripeCardSecurityCodeIncompleteError() throws Exception {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.clearText(pp.getStripeCvv());
	        test.info("Credit card number entered is 78");
			Actionsss.sendKeys(pp.getStripeCvv(), "78","Incomplete security code");
			Actionsss.click(pp.getClickOnStripeContainer());
			 driver.switchTo().defaultContent();
			if(Actionsss.displayElement(pp.getStripeCardSecurityCodeIncompleteError())) {
				test.pass("Error msg displayed when incomplete security code  details are entered");
				logger.info("Error msg displayed when incomplete security code  details are entered");
			}else {
				test.fail("Error msg displayed when incomplete security code  details are entered");
				logger.info("Error msg displayed when incomplete security code   details are entered");  
	        }
			
		}
		public void getStripeCardPostalCodeInComplete() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
	        Actionsss.clearText(pp.getPostalCodeInStripe());
	        test.info("Credit card number entered is 987");
	        Actionsss.sendKeys(pp.getPostalCodeInStripe(), "987", "incomplete postal code");
	        driver.switchTo().defaultContent();
	        if(Actionsss.displayElement(pp.getStripeCardPostalCodeInComplete())) {
	        	test.pass("Error msg displayed when incomplete postal code  details are entered");
				logger.info("Error msg displayed when incomplete postal  code  details are entered");
			}else {
				test.fail("Error msg displayed when incomplete postal code  details are entered");
				logger.info("Error msg displayed when incomplete postal code   details are entered");  
	        }	    
		 	
		}
		
		public void getallErrosInCybersource() throws InterruptedException {
			
			Actionsss.CombinedClick(pp.getReviewOrderBtn());
			Thread.sleep(3000);
			int countOfError =Actionsss.getSizeOfList(pp.getErrorMsgsInCybersource());
			System.out.println(countOfError);
			 
			if(countOfError==3 && Actionsss.displayElement(pp.getErrorMsgForSecurityCodeInCybersource())) {
			 	test.pass("Error msg are displayed when no  card details are entered");
				logger.info("Error msg are displayed when  no  card details are entered");
			}else {
				test.fail("No Error msg displayed when  no  card details are entered");
				logger.info("No Error msg displayed when  no  card detailsare entered");  
	        }
		}
		
		public void getCreditCardCvvAndExpMonthYearErrorInCybersource() throws Exception {
			
			  allPay.cyberSourceCardNumber();
		      logger.info("entered card number");
		      
		      Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(2000);
		      int countOfError =Actionsss.getSizeOfList(pp.getErrorMsgsInCybersource());
		      if((countOfError==2) &&(Actionsss.displayElement(pp.getErrorMsgForSecurityCodeInCybersource()))){
		    	  test.pass("Error msg are displayed when expiry month and year, security code details are not entered");
				  logger.info("Error msg are displayed when expiry month and year, security code details are not entered");
			  }else {
				  test.fail("No Error msg displayed when expiry month and year, security code details are not entered");
				  logger.info("No Error msg displayed when expiry month and year, security code details are not entered");  
		      }
		}
		
		public void getCreditCardCvvAndExpYearErrorInCybersource() throws Exception {
			
			  allPay.cyberSourceCardNumber();
		      logger.info("entered card number");
		      
		      allPay.cyberSourceExpMonth();
		      logger.info("entered exp month");
		      
		      Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(2000);
		      int countOfError =Actionsss.getSizeOfList(pp.getErrorMsgsInCybersource());
		      if(Actionsss.displayElement(pp.getErrorMsgInCybersource())&& Actionsss.displayElement(pp.getErrorMsgForSecurityCodeInCybersource())){
		    	  test.pass("Error msg are displayed when expiry  year, security code details are not entered");
				  logger.info("Error msg are displayed when expiry year, security code details are not entered");
			  }else {
				  test.pass(" Error msg displayed when expiry year, security code details are not entered");
				  logger.info("No Error msg displayed when expiry  year, security code details are not entered");  
		      }
		}
		
		public void getCreditCardCvvErrorInCybersource() throws Exception {
			  
			  allPay.cyberSourceCardNumber();
		      logger.info("entered card number");
		      
		      allPay.cyberSourceExpMonth();
		      logger.info("entered exp month");
		      
		      allPay.cyberSourceExpYear();
		      logger.info("entered exp year");
		      
		      Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(3000);
		      if(Actionsss.displayElement(pp.getErrorMsgForSecurityCodeInCybersource())){
		    	  test.pass("Error msg are displayed when security code details are not entered");
				  logger.info("Error msg are displayed when  security code details are not entered");
			  }else {
				  test.fail("No Error msg displayed when  security code details are not entered");
				  logger.info("No Error msg displayed when security code details are not entered");  
		      }
		}
		
		public void getcreditCardNumberInvalidErrorInCybersource() throws Exception {
			
			  test.info("Entered credit card number is  2132421421412412"  );   
			  Actionsss.sendKeys(pp.getCyberSourceCreditcard(),"2132421421412412 ","invalid cardNum");
			  
			  allPay.cyberSourceExpMonth();
		      logger.info("entered exp month");
		      
		      allPay.cyberSourceExpYear();
		      logger.info("entered exp year");
		      
		      allPay.cyberSourceSecurityCode() ;
		      
		      Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(pp.getErrorMsgForInvalidCreditCardInCybersource())) {
				  test.pass("Error msg are displayed when  invalid card details are  entered");
				  logger.info("Error msg are displayed when invalid  card details are entered");
			  }else {
				  test.fail("No Error msg displayed when invalid  card details are entered");
				  logger.info("No Error msg displayed when invalid card details are  entered");  
		      } 
		}
		
		public void getcreditCardNumberInCompleteErrorInCybersource() throws Exception {
			
			  test.info("Entered credit card number is  41111111"  );   
			  Actionsss.sendKeys(pp.getCyberSourceCreditcard(),"41111111","incomplete cardNum");
			  
			  allPay.cyberSourceExpMonth();
		      logger.info("entered exp month");
		      
		      allPay.cyberSourceExpYear();
		      logger.info("entered exp year");
		      
		      allPay.cyberSourceSecurityCode() ;
		      
		      Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(pp.getErrorMsgForInvalidCreditCardInCybersource())) {
				  test.pass("Error msg are displayed when incomplete card details are  entered");
				  logger.info("Error msg are displayed when incomplete card details are entered");
			  }else {
				  test.fail("No Error msg displayed when incomplete card details are entered");
				  logger.info("No Error msg displayed when incomplete card details are  entered");  
		      } 
		}
		
		
		public void getIncompleteSecurityCodeErrorInCybersource() throws Exception {
			  test.info("Entered security code is  23"  );  
			  
			  allPay.cyberSourceCardNumber();
		      logger.info("entered card number");
			  
			  allPay.cyberSourceExpMonth();
		      logger.info("entered exp month");
		      
		      allPay.cyberSourceExpYear();
		      logger.info("entered exp year");
			  
			  Actionsss.sendKeys(pp.getCyberSourceSceuritycode(),"23","invalid security code");
			  
			  Actionsss.CombinedClick(pp.getReviewOrderBtn());
		      Thread.sleep(3000);
			  if(Actionsss.displayElement(pp.getErrorMsgForInvalidSecurityCodeInCybersource())) {
				  test.pass("Error msg are displayed when invalid/incomplete security code  entered");
				  logger.info("Error msg are displayed when invalid/incomplete security code entered");
			  }else {
				  test.fail("No Error msg displayed when  invalid/incomplete security code entered");
				  logger.info("No Error msg displayed when invalid/incomplete security code  entered");  
		      } 
		}
		
		//adyen payemnet
		public void getallErrorsInAdyen() throws InterruptedException {
			Actionsss.CombinedClick(pp.getReviewOrderBtn());
			if(Actionsss.displayElement(pp.getAdyenExpiryDateError()) && (Actionsss.displayElement(pp.getAdyenSecurityCodeError()) && (Actionsss.displayElement(pp.getAdyenHolderNameError())))){
				test.pass("Error msg are displayed when no  card details are entered");
				logger.info("Error msg are displayed when  no  card details are entered");
			}else {
				test.fail("No Error msg displayed when  no  card details are entered");
				logger.info("No Error msg displayed when  no  card details are entered");  
			}
		}
		
		public void getCreditCardCvvAndExpErrorMessage() throws Exception {
			allPay.cardNumberInAdyenPayment();
			
			Actionsss.CombinedClick(pp.getReviewOrderBtn());
			if(Actionsss.displayElement(pp.getAdyenExpiryDateError())&& Actionsss.displayElement(pp.getAdyenSecurityCodeError()) && Actionsss.displayElement(pp.getAdyenHolderNameError())) {
				test.pass("Error msg are displayed when only valid card number details are entered and clicked on next review order button");
				logger.info("Error msg are displayed when only valid card number details are entered and clicked on next review order button");
			}else {
				test.fail("No Error msg are displayed when only valid card number details are entered and clicked on next review order button");
				logger.info("No Error msg are displayed when only valid card number details are entered and clicked on next review order button");  
			}
		}
		
		public void getCreditCardCvvErrorMessage() throws Exception {
			allPay.cardNumberInAdyenPayment();
			
			 allPay.expDateInAdyen();
			 Actionsss.CombinedClick(pp.getReviewOrderBtn());
			 Thread.sleep(1000);
			 if(Actionsss.displayElement(pp.getAdyenSecurityCodeError()) && Actionsss.displayElement(pp.getAdyenHolderNameError())) {
					test.pass("Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");
					logger.info("Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");
				}else {
					test.fail("No Error msg are displayed when valid card number and expiry date are entered and clicked on next review order button");
					logger.info("No Error msg are displayed when  valid card number and expiry date are entered and clicked on next review order button");  
				}
		
		}
		
		public void getcreditCardNumberInvalidErrorInAdyen() throws Exception {
			
				     
		     driver.switchTo().frame(pp.getAdyenCardNumIframe());
		     Actionsss.clearText(pp.getAdyenCardNumInput());
		     Actionsss.sendKeys(pp.getAdyenCardNumInput(),"2312 4242 3121 3231","invalid card Number" );
		     driver.switchTo().defaultContent();
		     
		     Actionsss.CombinedClick(pp.getReviewOrderBtn());
		     test.info("Entered invalid credit card number is 2312 4242 3121 3231"  );	
		     if(Actionsss.displayElement(pp.getAdyenInvalidCardNumError())) {
		    	 test.pass("Error msg are displayed when invalid card number is entered");
				 logger.info("Error msg are displayed when invalid card number is entered");
			 }else {
				 test.fail("No Error msg displayed when invalid card number is entered");
				 logger.info("No Error msg displayed when invalid card number is entered");  
				}
		}
		
		public void getcreditCardExpMonthInValidInAdyen() throws Exception {
			
			 driver.switchTo().frame(pp. getAdyenExpDateIframe());
		     Actionsss.clearText(pp.getAdyenExpDateInput());
		     Actionsss.sendKeys(pp.getAdyenExpDateInput(),"03 23","Invalid Expiry date");
		     driver.switchTo().defaultContent();
		     
		     Actionsss.CombinedClick(pp.getReviewOrderBtn());
		     test.info("Entered invalid expiry date is 11 23"  );
		     if(Actionsss.displayElement(pp.getAdyenInvalidExpiryDateError())) {
		    	 test.pass("Error msg are displayed when invalid expiry date is entered");
				 logger.info("Error msg are displayed when invalid expiry date is entered");
			 }else {
				 test.fail("No Error msg displayed when invalid expiry date is entered");
				 logger.info("No Error msg displayed when invalid expiry date is entered");  
				}
		}
		
		public void getCreditCardNumberInCompleteErrorInAdyen() throws Exception {
			
			 driver.switchTo().frame(pp.getAdyenCardNumIframe());
		     Actionsss.clearText(pp.getAdyenCardNumInput());
		     Actionsss.sendKeys(pp.getAdyenCardNumInput()," 3700 000000","incompelte card Number");
		     driver.switchTo().defaultContent();
		     Actionsss.CombinedClick(pp.getReviewOrderBtn());
		     test.info("Entered incomplete card number is 3700 000000 ");
		     if(Actionsss.displayElement(pp.getAdyenIncompleteCardNumberError())) {
		    	 test.pass("Error msg are displayed when incomplete card number is entered");
				 logger.info("Error msg are displayed when  incomplete card number is entered");
			 }else {
				 test.fail("No Error msg displayed when  incomplete card number is entered");
				 logger.info("No Error msg displayed when  incomplete card number is entered");  
				}		     
		}
		public void getCreditCardInCompleteExpYearError() throws Exception {
			  allPay.cardNumberInAdyenPayment();
			
				     
			  driver.switchTo().frame(pp. getAdyenExpDateIframe());
			  Actionsss.clearText(pp.getAdyenExpDateInput());
			  Actionsss.sendKeys(pp.getAdyenExpDateInput(),"03 3","Incomplete Expiry date");
			  driver.switchTo().defaultContent();
			  
			  allPay.secCodeInAdyen();
			  
			  allPay.holderNameInAdyen();
			  
			  Actionsss.CombinedClick(pp.getReviewOrderBtn());
			  test.info("Entered incomplete expiry year is 03 3"  );	
			  if(Actionsss.displayElement(pp.getAdyenIncompleteExpYearError())) {
				 test.pass("Error msg are displayed when incomplete expiry year is entered");
				 logger.info("Error msg are displayed when  incomplete expiry year  is entered");
			  }else {
				 test.fail("No Error msg displayed when  incomplete expiry year  is entered");
				 logger.info("No Error msg displayed when  incomplete expiry year  is entered");  
				}	  
		}
		public void getCreditCardInCompleteCvvError() throws Exception {
			allPay.cardNumberInAdyenPayment();
			
			allPay.expDateInAdyen();
			
			driver.switchTo().frame(pp.getAdyenSecCodeIframe());
		    Actionsss.clearText(pp.getAdyenSecCodeInput());
		    Actionsss.sendKeys(pp.getAdyenSecCodeInput(),"73","invalid Security code");
		    driver.switchTo().defaultContent();
			
			 allPay.holderNameInAdyen();
			 Actionsss.CombinedClick(pp.getReviewOrderBtn());
			 test.info("Entered incomplete cvv number is 73 "  );
			 if(Actionsss.displayElement(pp.getAdyenIncompleteSecurityCodeError())) {
				 test.pass("Error msg are displayed when incomplete security code is entered");
				 logger.info("Error msg are displayed when  incomplete security code  is entered");
			  }else {
				 test.fail("No Error msg displayed when  incomplete security code  is entered");
				 logger.info("No Error msg displayed when  incomplete security code  is entered");  
			  }
			 
		}
	}
