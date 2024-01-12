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
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.simpleProductFromExcel;


public class tc__SimpleProductRegUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test( dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"} )
	public void simpleProduct() throws InterruptedException {
		 
		 
	if(isLoggedIn) {
		
		
		simpleProductFromExcel  simpleProduct = new simpleProductFromExcel ();			
		simpleProduct.performRandomOperations(driver);
		
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
        
        //checkoutProcess
        
        tc__CheckOutProcess cp = new tc__CheckOutProcess();       
        cp.checkoutprocess();

	    // payment by cc
        
        tc__CreditCardPaymentProcess creditCard = new tc__CreditCardPaymentProcess();
        creditCard.paymentByCreditCard();
	    
	
	 
	        }

	  else {
	        Assert.fail("User not logged in");
	    }
	 }
}

