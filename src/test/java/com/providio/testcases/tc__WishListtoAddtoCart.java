package com.providio.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.paymentProccess.MinicartViewCartProcess;

// This class represents a test case to add items from the wishlist to the cart.
public class tc__WishListtoAddtoCart extends baseClass {
    
    // Create an instance of SoftAssert to perform soft assertions.
    SoftAssert softAssert = new SoftAssert();

    // This TestNG test method is dependent on the 'loginTest' method from the 'tc__Login' class.
    // It will always run, even if the dependent test fails.
    @Test(dependsOnMethods = {"com.proviodi.eachPagetest.tc__Login.loginTest"}, alwaysRun = true)
    public void wishListtoCart() throws InterruptedException {

        // Create an instance of the 'tc__WishlistProccess' class to handle the Wishlist process.
        tc__WishlistProccess wsh = new tc__WishlistProccess();
        
        // Execute the Wishlist process, adding items to the cart.
        wsh.wishlistPage(driver);

        // Pause the execution for 5 seconds (not recommended in automated testing).
        Thread.sleep(5000);
        
        // Create an instance of the 'MinicartViewCartProcess' class to handle the checkout process.
        MinicartViewCartProcess cp = new MinicartViewCartProcess();

        // Perform the checkout process.
        cp.checkoutprocess();
        
        // Create an instance of the 'CreditCardPaymentProcess' class to handle the payment process.
        CreditCardPaymentProcess cc = new CreditCardPaymentProcess();

        // Perform the payment process using a credit card.
        cc.paymentByCreditCard(); 
    }
}
