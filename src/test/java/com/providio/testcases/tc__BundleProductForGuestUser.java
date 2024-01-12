package com.providio.testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.BundleProductFromExcel;
import com.providio.pageObjects.bundleProductAddAllToCart;

public class tc__BundleProductForGuestUser  extends baseClass{
	
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {

			 driver.get(baseURL);
			 logger.info("Entered into url");
			 logger.info("Placing the order as guest user");
			 
			 //searching the bundle product from excel sheet
			 BundleProductFromExcel bundleProduct = new  BundleProductFromExcel();
			 bundleProduct.performRandomOperations(driver);
			 logger.info("Searched a product");
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			//product add to cart 
			 //bundleProductAddAllToCart addToCart= new bundleProductAddAllToCart();
			 //addToCart.addAllToCart(driver);
			 
			 WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));				
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
				if(!addAllToCartElement.isEnabled()) {
					test.pass("Product is out of stock");
					System.out.println("out of stock");
					
					
				}else {	
					Thread.sleep(5000);
					js.executeScript("arguments[0].click();", addAllToCartElement);
					System.out.println("All products added to cart");
					Thread.sleep(5000);	       	
	 	           	System.out.println("Product is availble");
	 	           	test.pass("Product is in stock ");
				
			 
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
