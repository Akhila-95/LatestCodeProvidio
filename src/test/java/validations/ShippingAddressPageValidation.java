package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class ShippingAddressPageValidation extends baseClass{
	//View cart btn in mini cart
	 	public static void VerifiedThatNextpaymentBtnClick() {
	 		test.info("Verified That Nextpayment Btn click");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='card payment-form']"));
	     	
	     	if (miniCartPage.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the Nextpayment Btn");
	     	    test.pass("Successfully Clicked on the Nextpayment Btn");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}

}
