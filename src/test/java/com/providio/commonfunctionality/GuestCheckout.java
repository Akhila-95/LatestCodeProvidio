package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.guestUserLoginPage;
import com.providio.testcases.baseClass;

public class GuestCheckout extends baseClass{
	
	public void clickContinueAsGuest() throws InterruptedException {
		
        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
        logger.info(continueasAGuest.size());

        if (continueasAGuest.size() > 0) {
            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
            guestLoginPage.clickOnGuestCheckOut();
            logger.info("Guest checkout");
            guestLoginPage.clickOnEmail(reEnterMail);
            logger.info("Guest mail again");
            guestLoginPage.clickOnContinueAsGuest();
            logger.info("Guest continue as guest");
            Thread.sleep(5000L);
          
        }
  
    }

}
