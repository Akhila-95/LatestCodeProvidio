package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;

public class CheckOutPageValidation extends baseClass{
	
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	
	//View cart btn in mini cart
 	public static void VerifiedThatGuestLogin() {
 		test.info("Verified That GuestLogin click");
 	
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='card shipping-section']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the GuestLogin");
     	    test.pass("Successfully Clicked on the GuestLogin");
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}
 	
 	public static void verifyingThatGuestLoginForGc() throws InterruptedException {
 		test.info("Verified That GuestLogin click when only Gc in cart");
 	
     	
     	if(Actionsss.elementSize( paymentPage .getpaymentPageList()) ) {
     	    logger.info("Successfully Clicked on the GuestLogin");
     	    test.pass("Successfully Clicked on the GuestLogin");
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}
}
