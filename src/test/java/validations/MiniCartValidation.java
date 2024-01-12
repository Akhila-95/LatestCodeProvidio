package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class MiniCartValidation extends baseClass{
	
	//Home page banner and clp validation
 	public static void VerifiedThatMinicartBtnClick() {
 		test.info("Verified That Mini-Cart click");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//h1[contains(text(), 'Your shopping cart')]"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the MiniCart");
     	    test.pass("Successfully Clicked on the MiniCart");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	//View cart btn in mini cart
 	public static void VerifiedThatViewcartBtnClick() {
 		test.info("Verified That View-Cart click");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='col-sm-7 col-md-8']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the ViewCart");
     	    test.pass("Successfully Clicked on the ViewCart");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	//View cart btn in mini cart
 	public static void VerifiedThatCheckOutBtnClick() {
 		test.info("Verified That CheckOut Btn click");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='col-sm-7']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the CheckOut Btn");
     	    test.pass("Successfully Clicked on the CheckOut Btn");
     	}else {
     		test.fail("Click failed");
     	}
 	}

}
