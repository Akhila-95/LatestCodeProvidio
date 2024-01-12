package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.providio.PaymentProccess.tc__CreditCardPaymentProcess;
import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;


public class tc__VariationProductForGuestUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test
	public void variationProduct() throws InterruptedException {
		 
			 driver.get(baseURL);
			 logger.info("Entered into url");
			 
			 //serached for variation product
			 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			 fromExcel.performRandomOperations(driver);
			 logger.info("searched for Variation product");
	
	
			 SizeSelectioForVariation ss= new SizeSelectioForVariation();
			 ss.sizeSelection(driver);
			
			 
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
				   // payment by cc
		        
		        tc__CreditCardPaymentProcess creditCard = new tc__CreditCardPaymentProcess();
		        creditCard.paymentByCreditCard();

	 }
}

