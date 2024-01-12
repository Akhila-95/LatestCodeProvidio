package com.providio.testcases;

import org.openqa.selenium.WebDriver;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.wishListPage;

// This class represents a test case for the Wishlist process and extends the baseClass, which contains common functionality.
public class tc__WishlistProccess extends baseClass {

    // This method represents the actions for the Wishlist process.
    public void wishlistPage(WebDriver driver) throws InterruptedException {
        // Create an instance of the navigationPage class to interact with navigation elements.
        navigationPage navPage = new navigationPage(driver);

        // Select a random menu item.
        navPage.selectRandomMenu(driver);
        logger.info("Selected random menu");

        // Create an instance of the productListingPage class to interact with product listing elements.
        productListingPage plp = new productListingPage(driver);

        // Select a product to add to the wishlist.
        plp.selecttheWishlist();
        logger.info("Added product to wishlist");

        // Create an instance of the homePage class to interact with home page elements.
        homePage hp = new homePage(driver);
        Thread.sleep(3000); // Sleep for 3 seconds (not recommended in automated testing).
        
        // Click on the Wishlist link or button.
        hp.clickOnWishlist(driver);
        logger.info("Clicked on wishlist");

        // Create an instance of the wishListPage class to interact with the wishlist elements.
        wishListPage wlp = new wishListPage(driver);
        
        // Remove items from the wishlist that have null values.
        wlp.removeButtonwithProductHavingNullValue();

        // Select attributes and change the "Select Attributes" button to add products to the cart.
        wlp.selectingTheAttributesandChangetheSelectAttributesButtonToAddtoCart();

        // Add all products in the wishlist to the cart.
        wlp.allProductsAddedtoCart();
    }
}
