package com.providio.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.PaymentPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;

public class Tc_PaypalCheckout_MiniCart extends baseClass {
	
@Test
	public void paypalCheckout_MiniCart() throws InterruptedException {
		
		    driver.get(this.baseURL);
	        logger.info("enterd into url");
	       
	        navigationPage navMenu = new navigationPage(driver);
	        navMenu.clickwoMensMenubaritems(driver);
	        logger.info("hovered on Womens");
	        
	        navMenu.ClickwoMensofBraceletss(driver);
	        logger.info("clicked on Braceletss  sub menu");
	        
	        //validate the Television
	        WebElement earings = driver.findElement(By.xpath("//h1[@class ='page-title']"));
	        String ActualTitleofTelevisions = earings.getText();
	        String ExpectedTitleofTelevisions = "EARRINGS ";
	        logger.info(earings.getText());
	        if (ActualTitleofTelevisions.equals(ExpectedTitleofTelevisions)) {
	            test.pass( "Successfully clicked on the womens of  " + ActualTitleofTelevisions + " ");
	            logger.info("Successfully clicked on the womens of  " + ActualTitleofTelevisions + " ");
	        } else {
	            test.fail( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
	            logger.info( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
	        }

	        productListingPage plp = new productListingPage(driver);
	        plp.clickOnProduct(driver);
	       // plp.selectProductRandom(driver);
	        logger.info("clicked on earings product");
	        
	        productDescriptionPage pdp = new productDescriptionPage(driver);
	        pdp.clickcartbutton(driver);
	        logger.info("click on the add to cart button");
	        
	        //validate the productname
	        String actualProductName = driver.getTitle();
	        String expectedProductName = driver.getTitle();
	        if (actualProductName.equals(expectedProductName)) {
	            test.pass( "Successfully clicked on the electronics of  " + actualProductName + " ");
	            logger.info("click Success Womens of Dresses");
	        } else {
	            test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
	            logger.info("Click failed");
	        }
	        
	      //checkout from mini cart by paypal
	        
	        miniCartPage miniCart = new miniCartPage(driver);
       
	        miniCart.clickcartbutton(driver);
	        
	        logger.info("Clicked on minicart button");
	        
	        miniCart.clickOnPaypalCheckout_Minicart(driver);
	        
	        logger.info("clicked on minicart");
	        
	        PaymentPage pp = new PaymentPage(driver);
	        
	        pp.paypalPopup(driver);
	        
	        logger.info(" Entered paypal account credientials");
	        
	        
	        
	        
	        
	        
	}
	
	
	
}
