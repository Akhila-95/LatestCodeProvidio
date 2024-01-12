//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.testcases;

import com.providio.PaymentProccess.Tc_PaymentProcessByPayPal;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__PdpPage extends baseClass {

	SoftAssert softAssert = new SoftAssert();

    @Test(
        dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"}
    )
    public void PDPpage() throws InterruptedException {
    	
    	//validate login
        if (isLoggedIn) {
        	
            navigationPage navMenu = new navigationPage(driver);
            navMenu.clicknewarrivalssMenu(driver);
            logger.info("hovered on new arrival menu");
             
            navMenu.ClicknewarrivalofWomens();
            logger.info("clicked on womens category");
            
            productListingPage plp = new productListingPage(driver);
            
            plp.selectProductRandom(driver);
            logger.info("clciked on product");
            
            productDescriptionPage pdp = new productDescriptionPage(driver);
//            pdp.clickOnProduct1();
//            logger.info("clciked on product");
            
            pdp.clickOnSize(driver);
            logger.info("clicked on size");
            
            pdp.clickOnLeftCarousel(driver);
            logger.info("clciked on left carousel");
            
            pdp.clickOnRightCarousel(driver);
            logger.info("clciked on right carousel");
            
            pdp.clickOnWriteAReviewAtTop();
            logger.info("clciked on write a review");
            
            pdp.clickOnRating(driver);
            logger.info("clciked on rating");
            
            pdp.clickOnReviewHeadline(driver, headline);
            logger.info("entered review");
            
            pdp.clickOnComments(comment);
            logger.info("given comment");
            
            pdp.clickOnYes();
            logger.info("clciked on yes");
            
            pdp.clicknickName(nickName);
            logger.info("given nickaname");
            
            pdp.clickOnLoc(location);
            logger.info("entered the location");
            
            pdp.clickOnSubmitReview(driver);
            logger.info("clciked on write a review");
            
            pdp.clickOnSize(driver);
            logger.info("clicked on size");
            
//            pdp.clickInIncreaseQuantity();
//            logger.info("increased  qunatity");
            
//            pdp.clickOndecreaseTheQunatity();
//            logger.info("decreased  qunatity");
//            logger.info("clciked on wishlist");
            
//            pdp.clickOnStore(driver);
//            logger.info("clicked on find a store");
            
//            pdp.clickOnZipCode(this.zipcodeStore);
//            logger.info(" entered zipcode in store");
//            
//            pdp.clickOnRadius();
//            
//            pdp.clickOnFindStores();
//            
//            pdp.clickOnCloseFindStore(driver);
//            
//            pdp.clickOnPinterest();
//            logger.info("clicked on pinteerst");
            
//            Set<String> handles = driver.getWindowHandles();
//            Iterator<String> iterator = handles.iterator();
//            String oldTab = (String)iterator.next();
//            driver.switchTo().window(oldTab);
//            pdp.clickOnFacebook();
//            
//            logger.info("clicked on facebook");
//            Set<String> handles1 = driver.getWindowHandles();
//            Iterator<String> iterator1 = handles1.iterator();
//            String oldTab1 = (String)iterator1.next();
//            driver.switchTo().window(oldTab1);
//            pdp.clickOntwitter();
            
            logger.info("clicked on twitter");
            Set<String> handles2 = driver.getWindowHandles();
            
            Iterator<String> iterator2 = handles2.iterator();
            String oldTab2 = (String)iterator2.next();
            driver.switchTo().window(oldTab2);
            
            productDescriptionPage productDescriptionPage = new productDescriptionPage(driver);
            productDescriptionPage.clickcartbutton(driver);
            logger.info("clicked on add tocart button");
            
            Thread.sleep(5000);
            
            //checkoutproecss
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
            Assert.fail("User is not logged in");
        }

        // Assert all the soft assertions
        softAssert.assertAll();
    }
}