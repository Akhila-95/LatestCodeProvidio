package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class QuickShopValidations extends baseClass{
	
	public static void VerifiyQuickShopPOpUp() {
		test.info("Verify QuickShop button click");
 		WebElement quickPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
     	if (quickPOP.isDisplayed()) {
     	    logger.info("Successfully Clicked on the QuickShop button and displayed the Modal pop up of QuickShop");
     	    test.pass("Successfully Clicked on the QuickShop button and displayed the Modal pop up of QuickShop");
     	}else {
     		test.fail("Click failed");
     	}
 	}
	
	public static void VerifiyQuickShopPOpUpClosed() {
		test.info("Verify QuickShop Close button click");
 		WebElement quickPOP = driver.findElement(By.xpath("//div[contains(@class, 'product-quickview')]"));
     	if (!quickPOP.isDisplayed()) {
     	    logger.info("Successfully Clicked on the QuickShop Close button and Closed the Modal pop up of QuickShop");
     	    test.pass("Successfully Clicked on the QuickShop Close button and Closed the Modal pop up of QuickShop");
     	}else {
     		test.fail("Click failed");
     	}
 	}
	
	//full details link
 	public static void verifyQuickshopFullDetailsLinkClick() {
 		test.info("verify Quickshop Full Details Link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked on the Quickshop Full Details Link and Navigated to the Product detail page");
     	    test.pass("Successfully clicked on the Quickshop Full Details Link and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyAttributesSelection() {
		test.info("verify attributes selection in QuickShop page");
    	WebElement Previewbutton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
    	if (Previewbutton.isEnabled()) {
    	    logger.info("Successfully Selected the attributes and QuickShop add-to-cart button is Enable");
    	    test.pass("Successfully Selected the attributes and QuickShop add-to-cart button is Enable");
    	}else {
    		test.fail("Click failed");
    	}
	}

}
