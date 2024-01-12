package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import com.providio.PaymentProccess.tc__CreditCardPaymentProcess;
import com.providio.pageObjects.BundleProductFromExcel;
import com.providio.pageObjects.bundleProductAddAllToCart;


public class Tc__BundleProductRegUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"} )
	public void bundleProduct() throws InterruptedException {
		 
	if(isLoggedIn) {
		//searching the bundle product from excel sheet
			 BundleProductFromExcel bundleProduct = new  BundleProductFromExcel();		 
			 bundleProduct.performRandomOperations(driver);

		
		//product add to cart		 
			 bundleProductAddAllToCart allToCart= new bundleProductAddAllToCart();		 
			 allToCart.addAllToCart(driver);		 
			 logger.info("Bundle Product added to cart");
		 
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
	 } else {
	        Assert.fail("User not logged in");
	    }
	 }
}

