package com.GuestUserWith_Minicart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.Validations.QuantityValidation;
import com.providio.Validations.validationpopupMessages;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.commonfunctionality.size;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromLoginPageGuestUser extends baseClass {
	 
   @Test
	public void PaypalFromLoginPage() throws InterruptedException {
		
			driver.get(baseURL);
			test.info("Enterd into url");
			//naviagated into random menu
			navigationPage navPage= new navigationPage(driver);
			navPage.selectRandomMenu(driver);
			logger.info("Entered into menu");
		
			//plp page	
			productListingPage plp = new productListingPage(driver);
			plp.selectProductRandom(driver);
			logger.info("Entered into plp page");


	    		 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
	    		 if( pdpPage.size()>0) {
			          size s = new size();
			          
			          s.selectSize(driver);
		    		 }
	    		 
	    		//validating the product is add to the cart
	    	 	validationpopupMessages.validatingProductisAddtoCart(driver);
	    		 
		       Thread.sleep(4000);
		        List <WebElement> minicartcounts = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));	       
		      
		 	       if(minicartcounts.size()>0) {
		 		    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		 		    	   String countOfMinicarts = minicartcount1.getText();
		 		    	   int minicartCountValue1 = Integer.parseInt(countOfMinicarts);
		 		
		 		        if (minicartCountValue1 > 0) {
		 		
		 		            miniCartPage mc = new miniCartPage(driver);
		 		            
		 		            Thread.sleep(4000);
		 		               
		 		            //click on the cart button
		 		            mc.clickcartbutton(driver);
		 		            Thread.sleep(2000);
		 		            
		 		            //validate the button click 
		 		           miniCartAndCartValidation validation =new miniCartAndCartValidation();
		 		           validation.validateMiniCartClick();
		 		            
		 		            //validate quantity in minicart
		 		            QuantityValidation quaValidation= new QuantityValidation();
		 		            //quaValidation.quantityValidationInMinicart();
		 		            Thread.sleep(5000);
		 		            //click review order
		 		            mc.clickviewCartButton(driver);
		 					logger.info("clicked the view cart button in the minicart");
		 					
		 					//validate the view cart button click
		 					validation.validateViewCartClick();
		 					Thread.sleep(5000);
		 					//Validating the quanity in view cart page
		 					//quaValidation.quantityValidationInViewCart();
		 		
		 		            viewCartPage vcp = new viewCartPage(driver);
		 		            //click the checkout button
		 		            vcp.clickCheckout(driver);
		 		            Thread.sleep(5000);
		 		
		 		            //paypalcheckout from login page
		 		            
		 		           MinicartViewCartProcessByPayPal cop = new MinicartViewCartProcessByPayPal(); 
		 		           cop.paypalFromLoginPage();
		 		        }
		 	       }
	}
}
