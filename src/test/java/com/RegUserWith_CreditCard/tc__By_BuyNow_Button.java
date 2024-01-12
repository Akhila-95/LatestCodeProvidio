package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Validations.Checkout_Validation;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.size;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__By_BuyNow_Button extends baseClass{
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void byNowButton() throws InterruptedException {
		if(isLoggedIn) {   
		//step2 1: site url
			driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/striped-shirt/701642854784M.html?lang=en_US");
			Thread.sleep(3000);
		/*	
		
	   //AS we have configured to a product we are naviagating the  
			navigationPage navPage= new navigationPage(driver);
			//hover on electronics
			navPage.clickelectronicsMenu(driver);
			//click ongps navigation 
			navPage.ClickelectronicsofGpsUnits();
			test.info("Entered into womens menu");
		
			//select the product from plp page	 
			productListingPage plp = new productListingPage(driver);
			plp.selectProductRandom(driver);
			logger.info("Entered into plp page");
			
			WebElement productName = driver.findElement(By.xpath("//h1[contains(@class,'product-name hidden-sm-down')]"));
	        test.info(productName.getText());
	      */
			 List<WebElement> buyNowButton = driver.findElements(By.xpath("//button[contains(@class,'buy-now btn btn-primary')]"));
	    	if(buyNowButton.size()>0) {
	    		size s =new size();
	    	    s.clickOnBuyNow(driver);
	    	    
	    	    Thread.sleep(5000);
				 //Checkout_Validation checkout= new Checkout_Validation();
	    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
	    			
	    			 Checkout_Validation checkout= new Checkout_Validation();
	    		 //validate the final place the order page
	    			 checkout.validatePlacetheOrderPage();
	    		
	    	     //ordernumberandOrderdate
	    			 checkout.ordernumberandOrderdate();
	    			 //Thread.sleep(5000);
	    			}
	    	}
    	}else {
		   	 Assert.fail("User not logged in");
		   }
		 
	}
}
