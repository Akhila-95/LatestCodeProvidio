package com.providio.testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProcessByCreditCard;
import com.providio.PaymentProccess.tc__CreditCardPaymentProcess;
import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;

public class Tc_OrderForPreOrderGuestUser extends baseClass{
	@Test
	public void orderForPreOrder() throws InterruptedException {
		
			driver.get(baseURL);
			logger.info("Entered into url");
			
		//navigate to electronics category
			navigationPage navPage= new navigationPage(driver);
			navPage.clickelectronicsMenu(driver);
			logger.info("Navigated to electronics category");
		
		//navigate to GPS navigation category
			navPage.ClickelectronicsofGpsUnits();
			logger.info("Navigated to GPS navigation category ");
			
		//Validating the submenu page
		 	WebElement gpsCategory = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
	        String ActualTitleofGpsCategory =gpsCategory .getText();
	        String ExpectedTitleofGpsCategory = "GPS Navigation";
	        logger.info(gpsCategory  .getText());
		        if (ActualTitleofGpsCategory.equals(ExpectedTitleofGpsCategory)) {
		            test.pass( "Successfully clicked on the womens of  " + ActualTitleofGpsCategory + " ");
		            logger.info("Successfully clicked on the womens of  " + ActualTitleofGpsCategory + " ");
		        } else {
		            test.fail( "The page Title does not match expected " + ExpectedTitleofGpsCategory + " " + "  but found" + " " + ActualTitleofGpsCategory + " ");
		            logger.info( "The page Title does not match expected " + ExpectedTitleofGpsCategory + " " + "  but found" + " " + ActualTitleofGpsCategory + " ");
		        }
	        
	        productListingPage plp = new productListingPage(driver);
		    plp.clickOnProduct(driver);
		     // plp.selectProductRandom(driver);
		    logger.info("clicked on earings product");
		    
		    WebElement expectedSashOnPdp= driver.findElement(By.xpath("//div[@class='attributes px-0']"));
		    System.out.println(expectedSashOnPdp.getText());
		    String actualSaahOnPdp ="Pre-Order";
		    if(expectedSashOnPdp.getText().equals(actualSaahOnPdp)) {
		    	test.pass("Pre-order product");
		    	logger.info("Pre-order product");
		    }else {
		    	test.fail("Not a Pre-order product");
		    	logger.info(" Not a Pre-order product");
		    }
		    productDescriptionPage pdp = new productDescriptionPage(driver);
		    pdp.clickcartbutton(driver);
		    logger.info("click on the add to cart button");
		    
		    
		    //validate the productname
			String actualProductName = driver.getTitle();
			String expectedProductName = driver.getTitle();
			    if (actualProductName.equals(expectedProductName)) {
			        test.pass( "Successfully clicked on the Gps navigation of  " + actualProductName + " ");
			        logger.info("clicked on the Gps navigation ");
			    } else {
			        test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
			        logger.info("Click failed");
			    }
			    
			    // payment by cc
		        
		        tc__CreditCardPaymentProcess creditCard = new tc__CreditCardPaymentProcess();
		        creditCard.paymentByCreditCard();
	}
}
