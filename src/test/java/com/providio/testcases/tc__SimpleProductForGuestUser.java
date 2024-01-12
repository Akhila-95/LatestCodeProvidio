package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.simpleProductFromExcel;


public class tc__SimpleProductForGuestUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test
	public void simpleProduct() throws InterruptedException {
		 
			 driver.get(baseURL);
			 logger.info("Entered into url");
		
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
					 
			
	     
	        
	        }
	        
	  
}

