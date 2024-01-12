package com.OrdersByDifferentPaymentMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.Tc_ReviewOrderPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__CheckOutProcess;

public class Tc_OrderByPaypal_RegUser extends baseClass {
	
	@Test(dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"} )
	public void OrderByPaypal_RegUser() throws InterruptedException {
		
		if(isLoggedIn) {
			
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
			    
			     productDescriptionPage pdp = new productDescriptionPage(driver);
			     pdp.clickcartbutton(driver);
			     logger.info("click on the add to cart button");
			    
			    //validate the productname
				   String actualProductName = driver.getTitle();
				   String expectedProductName = driver.getTitle();
				    if (actualProductName.equals(expectedProductName)) {
				        test.pass( "Successfully clicked on the braclets of  " + actualProductName + " ");
				        logger.info("clicked on the braclets ");
				    } else {
				        test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
				        logger.info("Click failed");
				    }
						    
				  //checkoutProcess					        
				   tc__CheckOutProcess cp = new tc__CheckOutProcess();					     
				   cp.checkoutprocess();
				  
				  //paypal payment process
				   Tc_PaymentProcessByPayPal paypal= new Tc_PaymentProcessByPayPal();			  
				   paypal.paymentByPaypal();
				  				
				   Tc_ReviewOrderPage reviewOrder= new Tc_ReviewOrderPage();
				   reviewOrder.reviewOrderPage(driver);
				   
				 //validation of paypal window is working or not	
				 // Scroll by 500 pixels vertically
				   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				   jsExecutor.executeScript("window.scrollBy(0, 1000);");
			    	WebElement ActualPaypalElement= driver.findElement(By.xpath("//div[@class='bt-credit-paypal']"));
			    	String expectedPaypalWindow = "PayPal Credit";  		
				    		if(ActualPaypalElement.getText().equals(expectedPaypalWindow)) {
				    			test.pass("Paypal payment is proccessed");
				    			logger.info("Paypal payment is proccessed");
				    		}else {
				    			test.fail("Paypal payment is stopped to   procces");
				    			logger.info("Paypal payment is stopped to   procces");
				    		}
			        

		} else {
	        Assert.fail("User not logged in");
	    }
		
	}
}
