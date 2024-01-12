package com.GuestUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.Scenarios.Bundle_GcAndAllPromotions;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer_Guest_InCc extends baseClass{
	 
	@Test
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 
		//pramotions
		Bundle_GcAndAllPromotions bgs = new Bundle_GcAndAllPromotions();
		bgs.bundelGcandallpromotions();
		 
		   //checkoutProcess	        
         MinicartViewCartProcess cp1 = new MinicartViewCartProcess();            
         cp1.checkoutprocess();
         
         //changing the billing address
	     List<WebElement> billingAddress = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));
	     if(billingAddress.size()>0) {
	    	 WebElement addNewAddress = driver.findElement(By.xpath("(//button[contains(@class,'btn-add-new')])[3]"));
	    	 addNewAddress.click();
	    	  //MinicartViewCartProcess checkoutProcess = new MinicartViewCartProcess();
	    	  //checkOutPage cp = new checkOutPage(driver);
	          // Assuming 'cp' is an instance of the 'checkOutPage' class
	          //checkoutProcess.selectBillingAddress(cp);
	     }
       
	     //Payment process		     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	}
	
}
