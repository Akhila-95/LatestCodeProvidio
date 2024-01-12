package com.GuestUserWith_CreditCard;

import com.providio.commonfunctionality.selectAProduct;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__GuestUser_InCc extends baseClass {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void guestlogin() throws InterruptedException {

        // Select a random product and add it to the cart
        selectAProduct.AddingAProductToCart();

        // Checkout process
        MinicartViewCartProcess cp = new MinicartViewCartProcess();
        cp.checkoutprocess();

        // Payment process using a credit card
        CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
        cc.paymentByCreditCard();
    }
}
