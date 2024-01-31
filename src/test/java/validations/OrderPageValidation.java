package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.OrderPageDetails;

public class OrderPageValidation extends baseClass{
	
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	
	public static void validatePlacetheOrderPage() throws InterruptedException {
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
	    	 String ActualTitleofPlacetheOrder = Actionsss.getTextOfElement(orderPage.getOrderThankMessage());
	    	 logger.info(ActualTitleofPlacetheOrder);
		     String ExpectedTitlePlacetheOrder = "Thank you for your order.";
	    	 test.info("verifying  the order is placed");
	
		    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
		        test.pass("Successfully Order is Placed and Thank you for your order message is displayed");
		        logger.info("Successfully Order is Placed and Thank you for your order message is displayed");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
		        logger.info("Click failed");
		    }		    
		}
	}    
	
	//validate the order number and date of order
		public static void orderNumberAndOrderDate() throws InterruptedException {
			if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
			   String orderNumber = Actionsss.getTextOfElement(orderPage.getOrderNumber());
			  
		        test.pass("The Order number is "+ orderNumber);
		        logger.info("The Order number is "+ orderNumber);
			    
			    //order date
			    String OrderDate = Actionsss.getTextOfElement(orderPage.getOrderDate());
		        test.pass("The Ordered date is "+  OrderDate);
		        
		        //paymnet details
			    String paymentDetails = Actionsss.getTextOfElement(orderPage.getPaymentDetailsInOrderConfirmationPage());
		      
		        test.pass("Payment is done with "+ paymentDetails);
		        logger.info("Payment is done with"+ paymentDetails);
			}
					
		}
		
}
