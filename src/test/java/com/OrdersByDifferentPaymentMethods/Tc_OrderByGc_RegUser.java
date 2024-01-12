package com.OrdersByDifferentPaymentMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.PaymentProccess.Tc_PaymentProccessByGC;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.Tc_ReviewOrderPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__CheckOutProcess;

public class Tc_OrderByGc_RegUser extends baseClass{
@Test(dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"})	
	public void orderByGc_RegUser() throws InterruptedException {
	
		if(isLoggedIn) {
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
				 //checkoutProcess
		        
				  tc__CheckOutProcess cp = new tc__CheckOutProcess();						     
				  cp.checkoutprocess();
				  
				//payment by GC 
			     
			     Tc_PaymentProccessByGC paymentByGc= new Tc_PaymentProccessByGC();			     
			     paymentByGc.paymentByGC();
       
			     //review order page
			     Tc_ReviewOrderPage reviewOrderPage = new Tc_ReviewOrderPage();			     
			     reviewOrderPage.reviewOrderPage(driver);
		}
	}

}
