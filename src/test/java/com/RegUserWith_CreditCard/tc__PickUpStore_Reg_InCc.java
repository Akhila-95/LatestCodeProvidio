package com.RegUserWith_CreditCard;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.Mens_Pants_PickUpInStore;
import com.providio.pageObjects.homePage;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class  tc__PickUpStore_Reg_InCc extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {	

		if(isLoggedIn) {     
	   
	    	 List<WebElement> findAStore = driver.findElements(By.xpath("//span[@class='header-store-name']"));
	    	 if(findAStore.size()>0) {
	    	
	    		 test.info("Cybersource payment is activated so Bopis are activated");
	    		 homePage hp = new homePage(driver);
	    		 hp.findastore(driver);
	    		 test.info("Clicked on Find a store");
	    		 
	    		 hp.findStore(driver);
	    		 JavascriptExecutor js = (JavascriptExecutor) driver;
	    	     js.executeScript("window.scrollBy(0,500)", "");
	    	     
	    	     hp.clickCommerceCloud(driver);
	    	     Thread.sleep(1000);
	    	     
	    	     
	    	   //selecting mens-pants category
	    	     Mens_Pants_PickUpInStore pickUpstore = new Mens_Pants_PickUpInStore();
	    	     pickUpstore.mens_Pants_PickUpInStore(driver);
	    	     
	    	
		      //common checkoutProcess	         
				 MinicartViewCartProcess cp = new MinicartViewCartProcess();         
				 cp.checkoutprocess();
				
			  //payment process         
	            CreditCardPaymentProcess cc = new CreditCardPaymentProcess();          
	            cc.paymentByCreditCard(); 
		    		 
	    	 }else { 
	    	     //selecting mens-pants category
	    	     Mens_Pants_PickUpInStore pickUpstore = new Mens_Pants_PickUpInStore();
	    	     pickUpstore.mens_Pants_PickUpInStore(driver);
	    	     
			    // common checkoutProcess	         
				 MinicartViewCartProcess cp = new MinicartViewCartProcess();         
				 cp.checkoutprocess();
					
			  //payment process         
	            CreditCardPaymentProcess cc = new CreditCardPaymentProcess();          
	            cc.paymentByCreditCard(); 
	    	 }
		}else {
		   	 Assert.fail("User not logged in");
		   }
		}
}
