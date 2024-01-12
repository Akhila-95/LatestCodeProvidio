package com.providio.commonfunctionality;

import com.providio.Scenarios.SelectProductFormPdp;
import com.providio.Validations.validationpopupMessages;
import com.providio.Validations.preValidationCheck;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.testcases.baseClass;

import functionality.allAttributesinOneFile;

public class selectAProduct extends baseClass {
    
    // This method is used to add a product to the cart.
    public static void AddingAProductToCart() throws InterruptedException {
        
        // Launching the browser and navigating to a URL.
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();
        
        // Validation for the Home page before proceeding.
        preValidationCheck.prevalidationHome();
        
        // Invoking the method to select a product from a Product Detail Page (PDP).
        SelectProductFormPdp.productformPDP();

        // Sleep for a brief period (in milliseconds).
        Thread.sleep(3000);

        // Invoking a method to select product attributes.
        allAttributesinOneFile.allAttributes(); 
        Thread.sleep(3000);

        // Validating if the selected product is in stock.
        validatingInstock.inStockValidation();
        
        // Validating if the product has been successfully added to the cart.
        validationpopupMessages.validatingProductisAddtoCart(driver);
    }
}
