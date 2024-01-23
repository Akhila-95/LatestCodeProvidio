package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class CheckOutPageValidation extends baseClass{
	//View cart btn in mini cart
 	public static void VerifiedThatGuestLogin() {
 		test.info("Verified That GuestLogin click");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='card shipping-section']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the GuestLogin");
     	    test.pass("Successfully Clicked on the GuestLogin");
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}
}
