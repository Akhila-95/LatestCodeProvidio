package com.providio.testcases;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.reviewOrderPage;

public class Tc_ReviewOrderPage extends baseClass {

	
	public void reviewOrderPage(WebDriver driver) throws InterruptedException {
		//revieworderpage
		
			reviewOrderPage rop = new reviewOrderPage(driver);
			WebElement reviewOrder= driver.findElement(By.xpath("//button[contains(text(), 'Next: Review Order')]"));
			
			if(reviewOrder.isDisplayed()) {
	    		rop.clickonReviewOrder(driver);
	    		logger.info("Clicked on review order button");
	    		Thread.sleep(2000);
	    		rop.clickonplaceorderwithJsExuter(driver);		
	    		logger.info("successfully click on the place order button");
			}else {  
				Thread.sleep(5000);
	    		rop.clickonplaceorderwithJsExuter(driver);		
	    		logger.info("successfully click on the place order button");
	    		Thread.sleep(5000);
	    		}
			
			
			//validate the orderstatus
			Thread.sleep(5000);
		    WebElement PlacetheOrder = driver.findElement(By.xpath("//h2[@class ='order-thank-you-msg']"));
		    String ActualTitleofPlacetheOrder = PlacetheOrder.getText();
		    String ExpectedTitlePlacetheOrder = "Thank you for your order.";
		    logger.info(PlacetheOrder.getText());
		    
		    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
		        test.pass("Successfully Order is Placed");
		        logger.info("Successfully Order is Placed");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
		        logger.info("Click failed");
		    }
		    
		    Thread.sleep(5000);
		    
		    //displayordernumberandplaceddate
		    
		    WebElement orderNumber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
		    
		    String Ordernumber = orderNumber.getText();
		    
	        test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
	        logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
		    
		    
		    
		    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
		    
	        String Orderdate = OrderDate.getText();
		    
	        test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
	        logger.info("Successfully Order is Placed and the Ordered date is "+ Orderdate);

	   
	}
}
