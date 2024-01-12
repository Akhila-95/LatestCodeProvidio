package com.providio.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.providio.pageObjects.PaymentPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.testcases.baseClass;

public class Tc_PaymentProcessByPayPal extends baseClass{
	
	public void paymentByPaypal() throws InterruptedException {
		
	//payment page
		
		List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));

        logger.info(" Logged in as guest :  "  +continueasAGuest.size());

		PaymentPage pp = new PaymentPage(driver);
		
		pp.clickOnPaypal(driver);
		
	//paypal button click validation
		/*
		WebElement paypalText = driver.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
		if(paypalText.isDisplayed()) {
			test.info("Verify paypal button 1");
			test.pass("Clicked on paypal button ");
			logger.info("Clicked on paypal button");
		} else {
			test.fail("Not clicked on paypal button ");
			logger.info("Clicked on paypal button");
		}*/
		
		//Brain tree paypal
		List<WebElement> savedPaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));   	
    	System.out.println(savedPaypalAcc.size());
    	
    	//salesforce paypal
    	
    	
    	if(savedPaypalAcc.size()>0) {
    		
    			logger.info("Account is already added,select it ");
    		
    	}else {
    		
		Thread.sleep(5000);
    	}
    		if(continueasAGuest.size()>0) {
    		
	    		pp.paypalCheckoutButton(driver);
	    		
	    		test.info("Verify paypal button 2");
	    		
	    		//validation for paypal button clicked or not 
	    		  WebElement parentDiv= driver.findElement(By.xpath("//div[@class='tab-pane paypal-content js_braintree_paypalContent active']"));
	    		  
	    		  if(parentDiv.isDisplayed()) {
	    			    test.pass("Clicked on paypal button ");
	    				logger.info("Clicked on paypal button");
	    			} else {
	    				test.fail("Not clicked on paypal button ");
	    				logger.info("Clicked on paypal button");
	
	    		pp.paypalPopup(driver);	    		
	    		logger.info("popped up the paypal window");
    		
    		}
    	
	}
  }
}
