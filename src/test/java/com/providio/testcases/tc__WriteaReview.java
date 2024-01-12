package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.ReviewProduct;
import com.providio.Scenarios.SelectProductFormPdp;

public class tc__WriteaReview extends baseClass {

    // This test method depends on the "loginTest" method from "tc__Login" class and will always run.
    @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void writeReview() throws InterruptedException {
        
        // Check if the user is logged in
        if (isLoggedIn) {
            test.info("Test case for the Navigation menu of New Arrival Page");

            // Select a product from the Product Listing Page (PLP)
            SelectProductFormPdp.productformPDP();
            
            // Find all the review buttons on the current page
            List<WebElement> reviewOrder = driver.findElements(By.xpath("//button[contains(@class,'write-review-button')]"));
            ReviewProduct rp = new ReviewProduct();
            if (reviewOrder.size() > 0) {
                // If there are review buttons, perform some action (e.g., reviewYepto())
            	ReviewProduct.reviewYepto();
            } else {
                // If there are no review buttons, write a review for the product
                rp.writeReviewForProduct();
            }

        } else {
            // If the user is not logged in, fail the test
            Assert.fail("User not logged in");
        }
    }
}
