package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.Validations.ViewCartValidation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationProcess;

public class tc__viewCartvalidation extends baseClass{
	
 @Test(dependsOnMethods = {"com.proviodi.eachPagetest.tc__Login.loginTest"}, alwaysRun = true)
    public void viewCartvalidation() throws InterruptedException {
        
        // Check if the user is logged in
        if (isLoggedIn) {
        	
        	navigationProcess np = new navigationProcess(driver);
            np.navigateeachmainmenuandselectoneproductformthesubmenu();
        	
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

                    // Validate the minicart after clicking
                   // miniCartAndCartValidation.validateMiniCartClick();

                    // Click on the "View Cart" button in the mini cart page
                    mc.clickviewCartButton(driver);
                    logger.info("Clicked the view cart button in the minicart");
          
                    //validate the view cart
                    ViewCartValidation.viewCartValidations();
                    
                }
            }
        }
     }

}
