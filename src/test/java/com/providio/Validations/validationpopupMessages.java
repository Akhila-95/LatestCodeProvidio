package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.providio.commonfunctionality.waitForTheElement;
import com.providio.testcases.baseClass;

public class validationpopupMessages extends baseClass{
	
   public static void validatingProductisAddtoCart(WebDriver driver) {
	   test.info("Validating product is add to the cart");
	   
	   List<WebElement> Stocksize = driver.findElements(By.xpath("//div[contains(text(), 'This item is currently not available')]"));
		test.info("Verify that the product is avaliable");
	    // Check if the element is present
	    if (Stocksize.size() > 0) {
	    	logger.info("Product is  not avaliable");
	    }else {
	    	
	    	Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
	        // Wait for the success alert to be visible
	        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	        // Get the text of the alert
	        String actualAddToCart = addToCart.getText();
	        // Expected alert text
	        String expectedAddToCart = "Product added to cart";
	        if (actualAddToCart.equals(expectedAddToCart)) {
	            // Success message is displayed
	        	test.pass("Product added to cart");
	            logger.info("Product is  added to cart");
	            // Perform actions or assertions here for the success case
	        }else {
	            // Success message is not as expected
	        	test.fail("Product is not added to cart");
	            logger.info("Product is not added to cart");
	            // Perform actions or assertions here for the failure case
	         
	          }
	          
	    }
	   
	    
   }
   
   public static void validatingGiftCardAddtoCart(WebDriver driver) {
	   
	   test.info("Validating gift card is add to the cart");
	   
	    Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement gifcartAddtoCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
       // Get the text of the alert
       String actualAddToCart = gifcartAddtoCart.getText();
       // Expected alert text
       String expectedAddToCart = "Gift Certificate added to cart";
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Gift Certificate added to cart");
           logger.info("Gift Certificate added to cart");
           // Perform actions or assertions here for the success case
       }else {
           // Success message is not as expected
       	   test.fail("Gift Certificate not added to cart");
           logger.info("Gift Certificate not added to cart");
           //System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
           // Perform actions or assertions here for the failure case
        
         }
   }
   
   public static void removeproductformminicartValidation() {
	   test.info("Validate product is romoved");
	   
	   Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement removeproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger remove-to-basket-alert text-center']")));
       // Get the text of the alert
       String removeproductfromcart = removeproduct.getText();
       // Expected alert text
       String expectedAddToCart = "Product Removed from cart";
       
       if (removeproductfromcart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("product is removed from the cart");
           logger.info("product is removed from the cart");
           // Perform actions or assertions here for the success case
       }else {
           // Success message is not as expected
       	   test.fail("product is not removed from the cart");
           logger.info("product is not removed from the cart");
           //System.out.println("The product is not added to cart because it should show: " + expectedAddToCart + " but found: " + actualAddToCart);
           // Perform actions or assertions here for the failure case
        
         }
   }
   
   public static void validatingProductisAddtoWishList(WebDriver driver) {
	   test.info("Validating product is add to the cart");
	   
	    Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
        // Wait for the success alert to be visible
        WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
        // Get the text of the alert
        String actualAddToCart = addTowishList.getText();
        // Expected alert text
        String expectedAddToCart = "Product has been added to wishlist.";
        if (actualAddToCart.equals(expectedAddToCart)) {
            // Success message is displayed
        	test.pass("Product added to wishlist");
            logger.info("Product is  added to wishlist");
            // Perform actions or assertions here for the success case
        }else {
            // Success message is not as expected
        	test.fail("Product is not added to wishlist");
            logger.info("Product is not added to wishlist");
            // Perform actions or assertions here for the failure case
         
          }
          
   }

}
