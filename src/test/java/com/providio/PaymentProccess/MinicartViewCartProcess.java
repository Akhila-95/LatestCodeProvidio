package com.providio.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.commonfunctionality.GuestCheckout;
import com.providio.commonfunctionality.allAddress;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class MinicartViewCartProcess extends baseClass {

    public void checkoutprocess() throws InterruptedException {
        // Check if the minicart is displayed
        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
        if (minicartdisplayedcount.size() > 0) {

            // Get the number of products in the cart
            WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
            String countOfMinicart = productCountInCart.getText();
            int minicartProductCountValue = Integer.parseInt(countOfMinicart);

            // If products are in the minicart, proceed
            if (minicartProductCountValue > 0) {

                miniCartPage mc = new miniCartPage(driver);
                Thread.sleep(5000);

                // Click on the cart button in the minicart
                mc.clickcartbutton(driver);
                Thread.sleep(1000);
                //mc.removeformMiniCart();

                // Validate the minicart after clicking
                miniCartAndCartValidation.validateMiniCartClick();

                // Click on the "View Cart" button in the mini cart page
                mc.clickviewCartButton(driver);
                logger.info("Clicked the view cart button in the minicart");

                // Validate the view cart page after clicking
                miniCartAndCartValidation.validateViewCartClick();

                // Initialize the view cart page
                viewCartPage vcp = new viewCartPage(driver);

                // Click the "Checkout" button in the view cart page
                vcp.clickCheckout(driver);
                Thread.sleep(1000);

                // Check if the user is a guest user and proceed with guest checkout
                GuestCheckout guest = new GuestCheckout();
                guest.clickContinueAsGuest();

                // Handle the shipping address
                allAddress sd = new allAddress();
                sd.ShippingAddress();

                checkOutPage cp = new checkOutPage(driver);

                // Select the payment method
                cp.clickpaymentbutton(driver);
                logger.info("Clicked on the payment button");
                Thread.sleep(5000);

            } else {
                logger.info("The cart value is empty");
                test.fail("The cart value is empty");
            }
        }
    }
}
