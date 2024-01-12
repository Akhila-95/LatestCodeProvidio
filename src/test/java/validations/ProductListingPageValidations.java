package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.providio.commonfunctionality.waitForTheElement;
import com.providio.testcases.baseClass;

import functionality.Waits;



public class ProductListingPageValidations extends baseClass{
	//Home page banner and clp validation
	public static void verifyPLPResetBtn() {
		test.info("verify That reset btn in plp");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement resetBtn = driver.findElement(By.xpath("//button[@class = 'reset btn p-0']"));
    	
    	if (!resetBtn.isDisplayed()) {
    	    logger.info("Successfully clicked in the reset btn in plp");
    	    test.pass("Successfully clicked in the reset btn in plp");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//validation pop up add ot wishlist
   public static void popUpProductisAddtoWishList() {
	   test.info("Validating product is added to the wishlist");
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() ='The product has been added to your wishlist.']")));
       // Get the text of the alert   
       String actualAddToCart = addTowishList.getText();
       logger.info(actualAddToCart);
       // Expected alert text
       String expectedAddToCart = "The product has been added to your wishlist.";
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to wishlist");
           logger.info("Product is added to wishlist");
           // Perform actions or assertions here for the success case
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to wishlist");
           logger.info("Product is not added to wishlist");
       }
   }
   
 //validation pop up add to cart
   public static void popUpProductisAddtoCart() {
	   test.info("Validating product is added to the wishlist");
	   // Create a FluentWait for dynamic element wait
	   Wait<WebDriver> wait = Waits.createFluentWait(driver);
       // Wait for the success alert to be visible
       WebElement addTowishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() ='Successfully added to your cart.']")));
       // Get the text of the alert   
       String actualAddToCart = addTowishList.getText();
       logger.info(actualAddToCart);
       // Expected alert text
       String expectedAddToCart = "Successfully added to your cart.";
       // Check if the actual alert text matches the expected text
       if (actualAddToCart.equals(expectedAddToCart)) {
           // Success message is displayed
       	   test.pass("Product added to Cart");
           logger.info("Product is added to wishlist");
           // Perform actions or assertions here for the success case
       } else {
           // Success message is not as expected
       	   test.fail("Product is not added to wishlist");
           logger.info("Product is not added to wishlist");
       }
   }
   
 //Home page banner and clp validation
 	public static void verifyPLPProductClick() {
 		test.info("verify That Plp product link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked in the Product link in plp");
     	    test.pass("Successfully clicked in the Product link in plp");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	//Home page banner and clp validation
 	 	public static void verifyPLPQuickshopClick() {
 	 		test.info("verify That Plp Quickshop link");
 	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 	     	WebElement Quickshop = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
 	     	
 	     	if (Quickshop.isDisplayed()) {
 	     	    logger.info("Successfully clicked in the Quickshop link in plp");
 	     	    test.pass("Successfully clicked in the Quickshop link in plp");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 	// add to cart validation in quick shop
 	 	public static void validatingProductisAddtoCart() {
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
	
	
}
