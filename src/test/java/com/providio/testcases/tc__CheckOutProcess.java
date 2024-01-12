package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;

public class tc__CheckOutProcess extends baseClass{
	
	public int minicartCountValue;

	public void checkoutprocess() throws InterruptedException {
	
				//mini cart
		
				WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		
		        String countOfMinicart = minicartcount.getText();
		
		        minicartCountValue = Integer.parseInt(countOfMinicart);
		        
		        System.out.println("Minicart contains : " + minicartCountValue + " products");
		
		        if(minicartCountValue>0) {
        	
	        
				    miniCartPage mc = new miniCartPage(driver);
					
					mc.clickcartbutton(driver);
					
					logger.info("clicked the mini cart button");
					
					mc.clickviewCartButton(driver);
					
					logger.info("clicked the view cart button in the minicart");
					
					Thread.sleep(10000);
					
					
					//TaxCalculation
					
					tc__TaxCalculation tx = new tc__TaxCalculation();
					
					tx.taxCalculation();
				    
				    //check out after adding the add to cart
				    
				    viewCartPage vcp = new viewCartPage(driver);
				    
				    vcp.clickCheckout(driver);
				    
					logger.info("clicked the checkout button in  the viewcart page");
					
					
					//If Guest login means excute this one

	                List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
	
	                logger.info(" Logged in as guest :  "  +continueasAGuest.size());

	                if(continueasAGuest.size()>0) {
	
	                    guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
	
	                    guestLoginPage.clickOnGuestCheckOut();
	
	                    logger.info("guest checkout");
	
	                    guestLoginPage.clickOnEmail(reEnterMail);
	
	                    logger.info("guestmail again");
	
	                    guestLoginPage.clickOnContinueAsGuest();
	
	                    logger.info("guest continue as guest");
	
	                    Thread.sleep(5000L);
	
	                }
					
				
					//checkoutpage
					
					checkOutPage cp = new checkOutPage(driver);
					
					//shipping methods
					
				//	cp.clickOnExpress();
				//	
				//	cp.clickOnGround();
					
					WebElement existingAddress = driver.findElement(By.xpath("//select[@name = 'shipmentSelector' and @id='shipmentSelector-default']"));
				
					//Select sizeSelect = new Select(excestingAddress);
					
					 List<WebElement> options1 = existingAddress.findElements(By.xpath("./option"));
					
				   // List<WebElement> options = sizeSelect.getOptions();
				
				    
				    System.out.println(options1.size());
				    
				
				
				if(options1.size()>1) {
					
				
				    logger.info("Address already exits");
					
				}else {
					
				    cp.setFisrtName(fname);
				    logger.info("entered fname");
				    
				    cp.setLastname(lname);
				    logger.info("entered lname");
				    
				    cp.setAddress1(address,driver);
				    logger.info("entered address");
				
				    cp.setPhone(phonenumber);
				    logger.info("entered phone number");
				    Thread.sleep(10000L);
				    
				    
	                  if(continueasAGuest.size()<0) {
	
	                    cp.clickaddToMyAddress(driver);
	                    logger.info("Clicked on the add to my address");
	
	                }
				    
				
				    Thread.sleep(2000);
				
				}
				
					cp.clickpaymentbutton(driver);
					logger.info("Clicked on the payment button");
					
	              
	                	
	            	    //validate the checkoutpage
	    			    WebElement checkOut = driver.findElement(By.xpath("//h2[text()='Customer']"));
	    			    String ActualTitleofcheckOut = checkOut.getText();
	    			    String ExpectedTitlecheckOut = "Customer";
	    			    logger.info(checkOut.getText());
	    			    if (ActualTitleofcheckOut.equals(ExpectedTitlecheckOut)) {
	    			        test.pass("Successfully clicked on the electronics of  " + ActualTitleofcheckOut + " ");
	    			        logger.info("click Success Womens of Dresses");
	    			    } else {
	    			        //test.fail( "The page Title does not match expected " + ExpectedTitlecheckOut + " " + "  but found" + " " + ActualTitleofcheckOut + " ");
	    			        logger.info("Click failed");
	    			    }
    			    
		        }else {
		        	test.fail("Cart value is empty");
		        	logger.info("Cart value is empty");		        	
		        }
			
	}			
}
