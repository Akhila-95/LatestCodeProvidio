package com.OrdersByDifferentPaymentMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProcessByCCandGC;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.Tc_ReviewOrderPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__CheckOutProcess;

public class Tc_OrderByGCandCC_InGuestUser extends baseClass {
	
	@Test
	public void orderByCCandGC_GuestUser() throws InterruptedException {
		
		driver.get(baseURL);
		logger.info("Entered in url ");
		
		navigationPage navMenu = new navigationPage(driver);
	    navMenu.clickwoMensMenubaritems(driver);
	    logger.info("hovered on Womens");
	    
	    navMenu.ClickwoMensofBraceletss(driver);
	    logger.info("clicked on Braceletss  sub menu");
	    
	    //validate the Television
		    WebElement earings = driver.findElement(By.xpath("//h1[@class ='page-title']"));
		    String ActualTitleofTelevisions = earings.getText();
		    String ExpectedTitleofTelevisions = "BRACELETS";
		    logger.info(earings.getText());
		    if (ActualTitleofTelevisions.equals(ExpectedTitleofTelevisions)) {
		        test.pass( "Successfully clicked on the womens of  " + ActualTitleofTelevisions + " ");
		        logger.info("Successfully clicked on the womens of  " + ActualTitleofTelevisions + " ");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
		        logger.info( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
		    }
	
		    productListingPage plp = new productListingPage(driver);
		    plp.clickOnProduct(driver);
		   // plp.selectProductRandom(driver);
		    logger.info("clicked on earings product");
		    
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
							test.pass(" Succesfully Product  is added to cart");
							logger.info("Product is  added to cart");
					  }else {
						test.fail("Product is not added to cart");
						logger.info("Product is not added to cart");
					  }

		    //checkoutProcess
	        
			  tc__CheckOutProcess cp = new tc__CheckOutProcess();					     
			  cp.checkoutprocess();
			  
			  Tc_PaymentProcessByCCandGC paymentByGCandCC = new Tc_PaymentProcessByCCandGC();			  
			  paymentByGCandCC.paymentProcessByCCandGC(driver);
			  
			  Tc_ReviewOrderPage reviewOrderPage = new Tc_ReviewOrderPage();			  
			  reviewOrderPage.reviewOrderPage(driver);

	}

}
