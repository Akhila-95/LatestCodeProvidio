package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.BundleProductFromExcel;

import com.providio.pageObjects.bundleProductAddAllToCart;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.miniCartPage;

import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.simpleProductFromExcel;
import com.providio.pageObjects.viewCartPage;

public class tc_CombinationSimpleProductsBundleGC extends baseClass {

	@Test
	public void combinationSimpleProductsBundleGC() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(baseURL);
		logger.info("Entered into url");
		Thread.sleep(5000);
		
		simpleProductFromExcel  simpleProduct = new simpleProductFromExcel();	
		simpleProduct.performRandomOperations(driver);
		logger.info("Searched for  simple product");
		
		productDescriptionPage pdp =new productDescriptionPage(driver);
		pdp.clickcartbutton(driver);
	
		//validation for product add to cart
		test.info("Verifying the product is added to cart or not ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));		
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
		//bundle product
		 Thread.sleep(2000);
		 BundleProductFromExcel bundleProduct = new  BundleProductFromExcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a product");
		 
		 WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));				
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
			if(!addAllToCartElement.isEnabled()) {
				test.pass("Product is out of stock");
				System.out.println("out of stock");
				
				
			}else {	
				Thread.sleep(5000);
				js.executeScript("arguments[0].click();", addAllToCartElement);
				System.out.println("All products added to cart");
					       	
 	           	System.out.println("Product is availble");
 	           	test.pass("Product is in stock ");
 	           test.info("Verifying the product is added to cart or not ");
 	  			
 	          WebElement productAddToCartMsg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));	
		 
		 if(productAddToCartMsg1.isDisplayed()) {
				test.pass("Bundle Product added to cart");
				logger.info("Product is  added to cart");
		  }else {
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			}
		 
	
	//giftcard
		 Thread.sleep(5000);
	   Tc_GiftCard giftCard = new Tc_GiftCard();
	   giftCard.addGiftCertificateToCart() ;
	   logger.info("Gift card added to cart");
	   
	   WebElement giftcerticatePopUp= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));	
	   if(giftcerticatePopUp.isDisplayed()) {
			test.pass("Gift cetificate Product added to cart");
			logger.info("Product is  added to cart");
	    }else {
			test.fail("Product is not added to cart");
			logger.info("Product is not added to cart");
		}
	 
	   //checkoutProcess		        
        tc__CheckOutProcess cp = new tc__CheckOutProcess();	         
        cp.checkoutprocess();
       
       //paypal payment	         
         Tc_PaymentProcessByPayPal paypal= new Tc_PaymentProcessByPayPal();			  
		 paypal.paymentByPaypal();			  
		 Thread.sleep(5000);

		 //reviewOrderPage
		 Tc_ReviewOrderPage reviewOrder= new Tc_ReviewOrderPage();			  
		 reviewOrder.reviewOrderPage(driver);
			}
	  }
	}

