package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.pageObjects.SizeSelectionForProductSet;


public class tc__ProductSetForGuestUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test
	public void productSet() throws InterruptedException {

		 	driver.get(baseURL);
		 	logger.info("Entered into url");
		
		 	//searching the product set from excel sheet
			ProductSetFromExcel fromExcel= new ProductSetFromExcel();
			fromExcel.performRandomOperations(driver);	
			logger.info("Searched for a productset");
			
			
			//selecting size for product
			SizeSelectionForProductSet set =new SizeSelectionForProductSet();
			set.sizeSelection(driver);
			logger.info("Selected size and added to cart");
			
			
			//validation for product add to cart			
			test.info("Verifying the product is added to cart or not ");			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));		
	        WebElement productAddToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']"))); 
	        String messageText = productAddToCartMsg.getText();
	        System.out.println(messageText);
				if( productAddToCartMsg.isDisplayed()) {
					test.pass("Product added to cart");
					logger.info("Product is  added to cart");
				}else {
					test.fail("Product is not added to cart");
					logger.info("Product is not added to cart");
				}

				
		    //checkoutProcess		        
	        tc__CheckOutProcess cp = new tc__CheckOutProcess();	         
	        cp.checkoutprocess();
	        
	        
	        //paypal payment process
			Tc_PaymentProcessByPayPal paypal= new Tc_PaymentProcessByPayPal();			  
			paypal.paymentByPaypal();
			   		
			Tc_ReviewOrderPage reviewOrder= new Tc_ReviewOrderPage();
			reviewOrder.reviewOrderPage(driver);
    
			//validation of paypal window is working or not			  
	    	WebElement ActualPaypalElement= driver.findElement(By.xpath("//div[@class='bt-credit-paypal']"));
	    	String expectedPaypalWindow = "PayPal Credit";  		
		    		if(ActualPaypalElement.getText().equals(expectedPaypalWindow)) {
		    			test.pass("Paypal payment is proccessed");
		    			logger.info("Paypal payment is proccessed");
		    		}else {
		    			test.fail("Paypal payment is stopped to   procces");
		    			logger.info("Paypal payment is stopped to   procces");
		    		}
	        } 
}

