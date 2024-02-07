package PaypalPayment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.providio.testcases.baseClass;
import functionality.Actionsss;

import pageObjects.PaymentPageObjects;

public class PaypalMethod extends baseClass {
	
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	
    
    //After the paypal button click
    public static void brainTreeAfterClick() throws InterruptedException {
        WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
        WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
        if(regPaypalCheckoutText.isDisplayed()) {                	 
       	  
       	 
        }else { 
            JavascriptExecutor js = (JavascriptExecutor) driver;  
            WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
            if(paypalCheckout.isDisplayed()) {
           	   js.executeScript("arguments[0].click();", paypalCheckout);                	
               Thread.sleep(1000);
	        	if(paypalCheckout.isDisplayed()) {

	        		paypalCheckout.click();
	            }
            }	                 
         }                 
   }
    
   //SalesForce paypal payment page
    public static void salesforcePaypalCheckout() throws InterruptedException {
        WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
        Thread.sleep(4000);
        WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");      
        paypalCheckout.click();
        List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
        if(salesforcePaypalCheckout.size()>0) {
            WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
          if(salesforcePaypalCheckout1.isDisplayed()) {
        	  	 Thread.sleep(3000);
            	 salesforcePaypalCheckout1.click();
            	 System.out.println("First click");
          }if(salesforcePaypalCheckout1.isDisplayed()) {    
              js.executeScript("arguments[0].click();", salesforcePaypalCheckout1);
             
          }            	
        }
    }
	
	 public static void paypalPopup() throws Exception {
	    	
	        String mainWindowHandle = driver.getWindowHandle();
	        // Switch to the new window by iterating over all available window handles
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                popUpDisplayValidation();	    	     
	                break;
	            }
	        }
	        // test.info("Entered into paypal window");
	        
	         Thread.sleep(2000);
	         if(Actionsss.elementSize(paymentPage.getEmailLoginList())) {
	        	 test.info("Entered username");
	        	 Actionsss.sendKeys( paymentPage.getEmailLogin(),"rahulnaik@etisbew.com", "User email is rahulnaik@etisbew.com");       	 	        	
	        	 WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
	        	 getTextOfPaypalInPaymentPage=email.getAttribute("value");
	         }
	         if(Actionsss.elementSize(paymentPage.getNextButtonList())) {
	        	Actionsss.click(paymentPage.getNextButton());         
	         }
	         if(Actionsss.elementSize(paymentPage.getPasswordList())) {
	        	 test.info("Entered password");
	        	 Actionsss.sendKeys(paymentPage.getPassword(),"Etgsfcc245@", "password is Etgsfcc245@");               	          
	             Thread.sleep(1000);
	         }
	         if(Actionsss.elementSize(paymentPage.getloginbuttonList())) {
	        	 Actionsss.click(paymentPage.getloginbutton());           
	             Thread.sleep(1000);
	         }
	        
	         Thread.sleep(2000);
	         if(Actionsss.elementSize(paymentPage.getReviewOrderButtonList())) {
	        	
	         	try {
	         		Actionsss.click(paymentPage.getReviewOrderButton());      		
	 	            Thread.sleep(1000);
	 	        } catch (Exception e) {
	 	        	Actionsss.javascriptClick(paymentPage.getReviewOrderButton());
	 	            System.err.println("Exception while clicking the element: " + paymentPage.getReviewOrderButton());
	 	        }
	         	
	         	logger.info("complete order");
	         	Thread.sleep(4000);
	   	
	            	try {
	            		Actionsss.click(paymentPage.getCompletePurcharseButton());
	 	           		Thread.sleep(4000);
	            	} catch (Exception e) {
		 	        	Actionsss.javascriptClick(paymentPage.getCompletePurcharseButton());
		 	            System.err.println("Exception while clicking the element: " +paymentPage.getCompletePurcharseButton());
	            	}         	
	        	                	
	         }else {
	        	 if(Actionsss.elementSize(paymentPage.getSaveAndContinueList())) {
	        		 Actionsss.click(paymentPage.getSaveAndContinue());
	        	 }
	         }                 
	         driver.switchTo().window(mainWindowHandle);
	         Thread.sleep(1000);
	         
	      } 
	 
	 public static void popUpDisplayValidation() {
		 test.info("Verifying the display of pop up window ");
		 String actualText= Actionsss.getTextOfElement(paymentPage.getPaypalPopUpText());
		 String expectedText ="Pay with PayPal";
		 if(actualText.equals(expectedText)) {			   
			  test.pass("Successfully clicked on paypal button and pop up window is displayed");
			  logger.info("Successfully clicked on paypal button and pop up window is displayed");
		}else {
			 test.fail("Not clicked on paypal button and no  pop up window is displayed");
			  logger.info("Not clicked on paypal button and no  pop up window is displayed");
		}
		 
	 }
}
