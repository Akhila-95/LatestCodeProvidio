package com.GuestUserWith_Minicart_Paypal;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.Mens_Pants_PickUpInStore;
import com.providio.pageObjects.homePage;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class  tc__PickUpStore_Guest_InMC_Paypal extends baseClass {
	 
	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {	

				driver.get(baseURL);
				test.info("Entered into Browser");
	   
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
	    	     
	    	   //checkout from mini cart by paypal	        
			      MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
			      checkOutProcessByPayPal. checkoutprocessFromMiniCart();
				  
	    	 }else {

	    		  //selecting mens-pants category
	    	     Mens_Pants_PickUpInStore pickUpstore = new Mens_Pants_PickUpInStore();
	    	     pickUpstore.mens_Pants_PickUpInStore(driver);
	    	     
	    	
	    	   //checkout from mini cart by paypal	        
			      MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
			      checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	    	 }
		}
}