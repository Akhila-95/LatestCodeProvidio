package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.testcases.baseClass;

public class OrderDetailsPageValidation extends baseClass{
	
	public static void orderDetails() throws InterruptedException {
		
		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {

	     // Order number and order date
			 ordernumberandOrderdat();
			 Thread.sleep(5000);
			}
	}
	
	public static void validatePlacetheOrderPage() throws InterruptedException {
		   
	    List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//h2[@class ='order-thank-you-msg']"));
			 if(orderConfirmationPage.size()>0) {
			    	test.info("verify that order is placed");
					
					//validate the orderstatus
			    	Thread.sleep(3000);
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
			 }
    }
	
	//validate the order number and date of order
		public static void ordernumberandOrderdat() throws InterruptedException {
			
		      List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//h2[@class ='order-thank-you-msg']"));
					 if(orderConfirmationPage.size()>0) {
						//displayordernumberandplaceddate
					    
					    WebElement orderNumeber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
					    String Ordernumber = orderNumeber.getText();
				        test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
				        logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
					    
					    //order date
					    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
				        String Orderdate = OrderDate.getText();
				        test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
				        
				        //paymnet details
					    WebElement paymentDetailsElement = driver.findElement(By.xpath("//div[@class='payment-details']"));
				        String paymentDetails = paymentDetailsElement.getText();
				        test.pass("Successfully Order is Placed and payment is "+ paymentDetails);
				        logger.info("Successfully Order is Placed and the Order number is "+  paymentDetails);
				        Thread.sleep(5000);
					 }
		}
		

}
