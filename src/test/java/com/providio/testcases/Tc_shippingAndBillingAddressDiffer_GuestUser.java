package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProcessByCreditCard;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.simpleProductFromExcel;

public class Tc_shippingAndBillingAddressDiffer_GuestUser extends baseClass {
	@Test
	public void shippingAndBillingAddressDiffer_GuestUser() throws InterruptedException {

			driver.get(baseURL);
			logger.info("Entered into url");
			Thread.sleep(5000);
			
			//simple product
			simpleProductFromExcel  simpleProduct = new simpleProductFromExcel();	
			simpleProduct.performRandomOperations(driver);
			logger.info("Searched for  simple product");
			
			productDescriptionPage pdp =new productDescriptionPage(driver);
			pdp.clickcartbutton(driver);
		
			//validation for product add to cart
			test.info("Verifying the product is added to cart or not ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));		
	        WebElement productAddToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	
	        // Get the text from the productAddToCartMsg element
	        	String messageText = productAddToCartMsg.getText();
	        	System.out.println(messageText);
			if( productAddToCartMsg.isDisplayed()) {
				test.pass("Product added to cart");
				logger.info("Product is  added to cart");
			}else {
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			}
				
			tc__CheckOutProcess cp = new tc__CheckOutProcess();        
	        cp.checkoutprocess();

	        // CC payment
			  Tc_PaymentProcessByCreditCard paymenyByCC = new Tc_PaymentProcessByCreditCard();
			  paymenyByCC.paymentByCreditCard();
			  logger.info("Selected CC payment integration");
			  
			  
			  //review order page
			  Tc_ReviewOrderPage rop = new Tc_ReviewOrderPage();
			  rop.reviewOrderPage(driver);
			  logger.info("order got placed");
			  
	}
	
}
