package com.providio.paymentmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.commonfunctionality.paymentMethods;
import com.providio.testcases.baseClass;

public class allPaymentMethods extends baseClass {
	
	List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
	paymentMethods pm = new paymentMethods();
	//BrainTree
	public void BrainTreeMethod() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
 		   //guest user payment
			pm.braintree();

        }else {
        	//brain tree select the new card and save the card
        	pm.brainTreeReguser();
        }

	}
	
	//cyberSource
	public void cyberSource() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.cyberSourceNewcard();

	        }else {
	        	//brain tree select the new card and save the card
	        	pm.cybersourceReguser();
	        }
	}

	//cyberSource
	public void salesFroce() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.salesforcePayment();

	        }else {
	        	//brain tree select the new card and save the card
	        	pm.salesforcePaymentReg();
	        }
	}
	
	//stripe payment method
	public void stripe() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.stripePayment();

	        }else {
	        	
	        	//brain tree select the new card and save the card
	        	pm.stripePaymentReguser();
	        }
		
	}
}
