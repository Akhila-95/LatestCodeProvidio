package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProccessBySalesforcePaypal;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;

public class Tc_OrderBysalesforcePaypal_Minicart extends baseClass {
	
	@Test
	public void paypalCheckout_MiniCart1(WebDriver driver) throws InterruptedException {
		
	    driver.get(this.baseURL);
        logger.info("enterd into url");
       
        navigationPage navMenu = new navigationPage(driver);
        navMenu.clickwoMensMenubaritems(driver);
        logger.info("hovered on Womens");
        
        navMenu.ClickwoMensofBraceletss(driver);
        logger.info("clicked on Braceletss  sub menu");
        
        //validate the Television
        WebElement braclets = driver.findElement(By.xpath("//h1[@class ='page-title']"));
        String ActualTitleofBraclets =braclets.getText();
        String ExpectedTitleofBraclets = "BRACELETS";
        logger.info(braclets .getText());
        if (ActualTitleofBraclets.equals(ExpectedTitleofBraclets)) {
            test.pass( "Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
            logger.info("Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
            logger.info( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
        }

        productListingPage plp = new productListingPage(driver);
        plp.clickOnProduct(driver);
       // plp.selectProductRandom(driver);
        logger.info("clicked on earings product");
        
        //add the  product to cart
        productDescriptionPage pdp = new productDescriptionPage(driver);
        pdp.clickcartbutton(driver);
        logger.info("click on the add to cart button");
        
      //validation for product add to cart				
		 test.info("Verifying the product is added to cart or not ");				
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));		
	     WebElement productAddToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));	 
	     String messageText = productAddToCartMsg.getText();
	     System.out.println(messageText);
			  if( productAddToCartMsg.isDisplayed()) {
					test.pass(" Successfully Product added to cart");
					logger.info("Product is  added to cart");
			  }else {
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			  }
        //validate the productname
        String actualProductName = driver.getTitle();
        String expectedProductName = driver.getTitle();
        if (actualProductName.equals(expectedProductName)) {
            test.pass( "Successfully clicked on the electronics of  " + actualProductName + " ");
            logger.info("click Success Womens of Dresses");
        } else {
            test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
            logger.info("Click failed");
        }
        
        
      //checkout from mini cart by paypal
        
        miniCartPage miniCart = new miniCartPage(driver);
   
        miniCart.clickcartbutton(driver);	        
        logger.info("Clicked on minicart button");
        
        
        //salesforce paypal
        Tc_PaymentProccessBySalesforcePaypal salesforcePaypal = new Tc_PaymentProccessBySalesforcePaypal();
        salesforcePaypal.paymentProccessBySalesforcePaypal(driver);
	}
}
