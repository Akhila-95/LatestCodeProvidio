

package com.providio.testcases;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();

    @Test(dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"})
    public void bySearchingProduct() throws InterruptedException {
    	
    	//validate the user login or not 
    	
        if (isLoggedIn) {
        	
        	//Home page 
            homePage homepage = new homePage(driver);
            homepage.clickOnSearchBar(this.searchBar);
            logger.info("searched a product " + this.searchBar);
            
            homepage.clickOnSearchedProduct();
            logger.info("clicked on searched product");
            
            //plp page
            productDescriptionPage productDescriptionPage = new productDescriptionPage(driver);
            productDescriptionPage.clickcartbutton(driver);

	        
            //checkoutProcess		        
	         tc__CheckOutProcess cp = new tc__CheckOutProcess();	         
	         cp.checkoutprocess();
	         
	         //paypal payment	         
	         Tc_PaymentProcessByPayPal paypal= new Tc_PaymentProcessByPayPal();			  
			 paypal.paymentByPaypal();			  
			 Thread.sleep(5000);
	
			 //reviewOrderPage
			 Tc_ReviewOrderPage reviewOrder= new Tc_ReviewOrderPage();			  
			 reviewOrder.reviewOrderPage(driver);
            
      
            Thread.sleep(10000L);
        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }
}