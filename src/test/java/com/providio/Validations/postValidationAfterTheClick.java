package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class postValidationAfterTheClick extends baseClass{
	
	   //validate the payment page
		public static void validatePaymentButtonClk() {
			//validate the payment page
		    WebElement paymentPage = driver.findElement(By.xpath("//label[contains(text(), 'Payment Method')]"));
		    if( paymentPage.isDisplayed()) {
			    String ActualTitleofpaymentPage = paymentPage.getText();
			    String ExpectedTitlepaymentPage = "Payment Method";
			    logger.info(paymentPage.getText());
			    
			    if (ActualTitleofpaymentPage.equals(ExpectedTitlepaymentPage)) {
			    	test.info("Verify that shipping address added");
			    	 test.pass("Successfully added the shipping address");
			    	 test.info("Verify the payment button is clicked");
			        test.pass("Successfully clicked on the Payment button");
			        logger.info("Successfully clicked on the Payment button");
			    } else {
			        test.fail( "The page Title does not match expected " + ExpectedTitlepaymentPage + " " + "  but found" + " " + ActualTitleofpaymentPage + " ");
			        logger.info("Click failed");
			    }
		    }
		//  //soft assertions payment page
		//  softAssert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
		//  //Hard assertions payment page
		//  Assert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
		}
		
		public static void validateReviewProduct() {
			test.info("validate the Review of the product");
			// Find the element using XPath
			WebElement thankYouText = driver.findElement(By.xpath("//div[@class='header col-sm-12']/h1[contains(text(), 'Thank you!')]"));
			// Get the text value of the element
			String actualText = thankYouText.getText();
			// Define the expected text
			String expectedText = "Thank you!";
			// Validate if the text is displayed using a basic if condition
			if (actualText.equals(expectedText)) {
			    logger.info("The 'Thank you!' text is displayed on the page.");
			    test.pass("successfully writen the review");
			} else {
			    logger.info("The 'Thank you!' text is not displayed on the page.");
			    test.fail("Review is not done");
			}
		}
		
		public void validateproductselect() {
			//validate the product is selected
			test.info("verify that product is selected");
	        List<WebElement> pdpHeader = driver.findElements(By.xpath("//h1[@class ='product-name hidden-sm-down']"));
	        if (pdpHeader.size()>0) {
	        	WebElement pdpHeader1 = driver.findElement(By.xpath("//h1[@class ='product-name hidden-sm-down']"));
	        	System.out.println("The product name is " +pdpHeader1);
	            test.pass("Successfully clicked on the product from the product listing page");
	            logger.info("Successfully clicked on the product from the product listing page");
	        } else {
	            test.fail("Product is not selected from the product listing page");
	            logger.info("Product is not selected from the product listing page");
	        }
			 
		}
		

}
