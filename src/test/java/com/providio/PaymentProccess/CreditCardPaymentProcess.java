package com.providio.PaymentProccess;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.postValidationAfterTheClick;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.paymentmethods.allPaymentMethods;
import com.providio.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class CreditCardPaymentProcess extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		 
		// Find the quantity of items in the minicart
		List<WebElement> minicartcount = driver.findElements(By.xpath("//span[@class ='minicart-quantity ml-1']"));		
		
		// Check if the minicart is empty
		if(minicartcount.size()==0) {
			
			// Validate the payment page
			postValidationAfterTheClick.validatePaymentButtonClk();
	       
			// Detect payment methods
			// Brain Tree
			List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
		    // Credit Card Salesforce
			List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
		    // Stripe
		    List<WebElement> stripePayment = driver.findElements(By.xpath("(//div[contains(@class,'StripeElement')])[1]"));
		    // CyberSource
		    List<WebElement> cyberSourcePayment = driver.findElements(By.xpath("//li[@data-method-id='CREDIT_CARD']"));
		   
		    // Create an instance of the "allPaymentMethods" class
		    allPaymentMethods bpm = new allPaymentMethods();
		    
		    // Determine the payment method and proceed accordingly
		    if(creditcardscheck.size()>0) {
		    	bpm.BrainTreeMethod();
		    	
		    } else if(creditcardsSalesForce.size()>0) {
		    	bpm.salesFroce();
		    	
		    } else if(stripePayment.size()>0) {
		    	bpm.stripe();
		    	
		    } else if(cyberSourcePayment.size()>0){
		    	bpm.cyberSource();	
		    }		

		    // Salesforce payment integration: place the order
		    if(creditcardsSalesForce.size()>0) {
		    	logger.info("Clicking the Salesforce place the order");
		    	paymentpPage pp = new paymentpPage(driver);
		    	// Click the place order button
		    	pp.placetheOrder();
		    	
		    } else {
		    	// Review order page
	    		reviewOrderPage rop = new reviewOrderPage(driver);
	    		Thread.sleep(4000);			    		
	    		// Locate the review order button
	    		WebElement reviewOrder= driver.findElement(By.xpath("//button[contains(text(), 'Next: Review Order')]"));	
	    		
	    		if(reviewOrder.isDisplayed()) {
	    			//click on the review order button
	    			Thread.sleep(5000);
	    			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	        js.executeScript("arguments[0].click();", reviewOrder);
	    			
	    			Thread.sleep(5000);
	    			if(reviewOrder.isDisplayed()) {
		    			//click on the review order button
		    			Thread.sleep(5000);
		    			reviewOrder.click();
	    			}
		    		logger.info("Clicked on review order button");
		    		Thread.sleep(5000);
		    		
		    		//click on the place order button
		    		rop.clickonplaceorderwithJsExuter(driver);
		    		
	    		}
		    }

			Thread.sleep(5000);
			
			 // Checkout validation
    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
    			
    			 Checkout_Validation checkout= new Checkout_Validation();
    			 
    		 // Validate the final place the order page
    			 checkout.validatePlacetheOrderPage();
    		
    	     // Order number and order date
    			 checkout.ordernumberandOrderdat();
    			 Thread.sleep(5000);
    			}
			
		} else {
            logger.info("This is not a payment page");
            test.fail("This is not a payment page");
		}
	}
}
