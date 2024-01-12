package com.providio.pageObjects;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.providio.Validations.PdpValidation;
import com.providio.Validations.validationpopupMessages;
import com.providio.testcases.baseClass;

import functionality.allAttributesinOneFile;

public class viewCartPage extends baseClass{
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//edit button on the view cart page
	public void editBtn() throws InterruptedException {
		List<WebElement> editBtns = driver.findElements(By.xpath("//div[contains(@class,'card product')]//a[@title='Edit']"));
		 // Get the total count of top-level menu elements.
        int count = editBtns.size();
        // Create a random number generator.
        Random random = new Random();
        // Generate a random index to select a top-level menu item.
        int randomeditBtn = random.nextInt(count) + 1;
        logger.info(randomeditBtn);
        WebElement editBtn = driver.findElement(By.xpath("(//div[contains(@class,'card product')]//a[@title='Edit'])[" + randomeditBtn + "]"));
		Thread.sleep(2000);
		editBtn.click();
		//selecting size for product
		allAttributesinOneFile.allAttributes();
		
		PdpValidation.QuantityofallpagesPlusinviewcart(driver);
		Thread.sleep(3000);
		WebElement updateElement = driver.findElement(By.xpath("//button[contains(@class,'update-cart')]"));
        
        // Check if the 'Update' button is enabled
        boolean isEnabled = updateElement.isEnabled();
        if (isEnabled) {
            // If the 'Update' button is enabled, click it
            System.out.println("Button is enabled");
            
            updateElement.click();
            logger.info("Clicked on 'Update'");
            test.pass("Product is changed from 'Select Attributes' to 'Add To Cart'");
        } else {
            // If the 'Update' button is disabled, handle this case as needed
            System.out.println("Button is disabled");
            // You may want to log and handle this scenario accordingly
        }
        
	}
	
	
	   //move to wishlist link on the view cart page
		public void moveToWishListBtn() throws InterruptedException {
			List<WebElement> wishListLink = driver.findElements(By.xpath("//a[@class='move' and @title='Move to Wishlist']"));
			 // Get the total count of top-level menu elements.
	        int count = wishListLink.size();
	        // Create a random number generator.
	        Random random = new Random();
	        // Generate a random index to select a top-level menu item.
	        int randomeditlink = random.nextInt(count) + 1;
	        logger.info(randomeditlink);
	        WebElement movetoWishListLink = driver.findElement(By.xpath("(//a[@class='move' and @title='Move to Wishlist'])[" + randomeditlink + "]"));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", movetoWishListLink);		
			//movetoWishListLink.click();
			
			//validationpopupMessages.validatingProductisAddtoWishList(driver);
			
	        
		}
		
		//move to wishlist link on the view cart page
		public void removeBtn() throws InterruptedException {
			List<WebElement> removeBtns = driver.findElements(By.xpath("//div[contains(@class,'custom-delete')]//button"));
			 // Get the total count of top-level menu elements.
	        int count = removeBtns.size();
	        // Create a random number generator.
	        Random random = new Random();
	        // Generate a random index to select a top-level menu item.
	        int randomRemoveBtn = random.nextInt(count) + 1;
	        logger.info(randomRemoveBtn);
	        WebElement removeformviewcart = driver.findElement(By.xpath("(//div[contains(@class,'custom-delete')]//button)[" + randomRemoveBtn + "]"));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", removeformviewcart);		
			//removeformviewcart.click();
			//popup validations
			//validationpopupMessages.removeproductformminicartValidation();
	        
		}
		
		//select shipping method
		public void selectPaymentMethod() {
			// Find the select element
			WebElement selectElement = driver.findElement(By.id("shippingMethods"));
			Select select = new Select(selectElement);
			// Get all the available shipping options
			List<WebElement> options = select.getOptions();
			// Exclude the "Store Pickup" option (class="d-none")
			List<WebElement> validOptions = options.stream()
			    .filter(option -> option.getAttribute("class").isEmpty())
			    .toList();
			// Select a random shipping method from the valid options
			int randomIndex = new Random().nextInt(validOptions.size());
			select.selectByIndex(randomIndex);
		}
		
		//continue shopting
		@FindBy(xpath="//a[@title='Continue Shopping']")
		WebElement continueShoping;	
		public void clickcontinueShiping(WebDriver driver) throws InterruptedException{		
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", continueShoping);		
	        Thread.sleep(5000);
		}
		
	
	//Checkout :- 
	@FindBy(xpath="//a[@class ='btn btn-primary btn-block checkout-btn ']")
	WebElement Checkout;	
	public void clickCheckout(WebDriver driver) throws InterruptedException{		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", Checkout);		
        Thread.sleep(5000);
	}
	
	//Removeitem	
	@FindBy(xpath="(//button[@class ='remove-btn-lg cart-delete-confirmation-btn btn btn-light'])[1]")
	WebElement CancelItem;
	public void clickCancelItem(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", CancelItem);
        Thread.sleep(5000);
	}
		
	
   //brain tree paypal button

		public void braintreePayPalButton(WebDriver driver) {
			
		    // Find the element using its xpath
		    WebElement payPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
	
		    // Perform the click action
		    payPalButton.click();
		}
//salesforce paypalbutton
		public void salesforcePayPalButton(WebDriver driver) {
				
			    // Find the element using its xpath
			    WebElement payPalButton = driver.findElement(By.xpath("(//div[contains(@class,'salesforce-paymentrequest-element')])[1]"));
		
			    // Perform the click action
			    payPalButton.click();
			}
	
	

	/*public void clickPayPalButton(WebDriver driver) throws InterruptedException {
	    // Locate the parent div containing the PayPal button
	    WebElement parentPaypal = driver.findElement(By.xpath("//div[@class='paypal-button paypal-button-number-0 paypal-button-layout-horizontal paypal-button-shape-rect paypal-button-number-single paypal-button-env-sandbox paypal-button-color-gold paypal-button-text-color-black paypal-logo-color-blue']"));

	    // Find the child div with class 'paypal-button-label-container'
	    WebElement payPalButton = parentPaypal.findElement(By.xpath(".//div[@class='paypal-button-label-container']"));

	    // Click the PayPal button using JavaScript
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", payPalButton);

	    // Wait for a short while (adjust the time if needed)
	    Thread.sleep(5000);
	}*/


	
		 

}
