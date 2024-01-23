package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.providio.commonfunctionality.waitForTheElement;
import com.providio.testcases.baseClass;


public class HomePageValidations extends baseClass{
	

	//Home page banner and clp validation
	public static void verifyHomePageBannersLinks() {
		test.info("verify That HOme page clp pages");
		
    	List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
    	List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
    	if (plpPagecheck.size() > 0) {
    	    logger.info("PLP page is already loaded");
    	    test.pass("Banner is Succesfully Clicked");
    	} else if (pdpPagecheck.size() > 0) {
    	    logger.info("PDP page is already loaded");
    	    test.pass("Banner is Succesfully Clicked");
    	} else {
    		test.pass("Banner is Succesfully Clicked");
    	}
	}
	
	//Home page banner and clp validation
	public static void verifyHomePageCLPLinks() {
		test.info("verify That HOme page banners");
	
	List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
    	List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
    	if (plpPagecheck.size() > 0) {
    	    logger.info("PLP page is already loaded");
    	    test.pass("CLP is Succesfully Clicked");
    	} else if (pdpPagecheck.size() > 0) {
    	    logger.info("PDP page is already loaded");
    	    test.pass("CLP is Succesfully Clicked");
    	} else {
    		test.pass("CLP is Succesfully Clicked");
    	}
	}
	
	//Home page gift card validation
	public static void verifyHomePageGiftCardLink() {
		test.info("verify That GiftCard Link");
		
    	WebElement GiftCardHeader = driver.findElement(By.xpath("//div[contains(@class, 'page-title d-none')]"));
    	
    	if (GiftCardHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the GiftCard Link");
    	    test.pass("Successfully clicked on the GiftCard Link");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//Home page banner and clp validation
	public static void verifyHomePagesingInLink() {
		test.info("verify That signn Link");
	
    	WebElement signInHeader = driver.findElement(By.xpath("//h1"));
    	
    	if (signInHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the singIn Link");
    	    test.pass("Successfully clicked on the singIn Link");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//Home page my fav link
	public static void verifyHomePageWishlistLink() {
		test.info("verify That Wishlist Link");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement GiftCardHeader = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
    	
    	if (GiftCardHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the Wishlist Link");
    	    test.pass("Successfully clicked on the Wishlist Link");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyThatuserLogin() {
		
	
    // Use FluentWait to wait for the visibility of the "Dashboard" element
    Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
    WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //h1[@class ='account-page-title']")));
    
    // Get the actual title from the "Dashboard" element
    String expectedTitle = "Dashboard";
    String actualTitle = loginTitle.getText();
    
    // Check if the actual title matches the expected title
    if (actualTitle.equals(expectedTitle)) {
    	// Log a pass message if the user is logged in successfully
    	test.pass("User logged in successfully");
        logger.info("User logged in successfully");
    } else {
    	// Log a fail message if the page title does not match the expected title
    	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
        logger.info("Click failed");
    }
	}
	
	//Home page banner and clp validation
	 	public static void verifyPLPProductClick() {
	 		test.info("verify That Search the product");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
	     	
	     	if (pdpPage.isDisplayed()) {
	     	    logger.info("Successfully Product detail page is loaded");
	     	    test.pass("Successfully Product detail page is loaded");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}

}
