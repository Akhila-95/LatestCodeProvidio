package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import validations.OrderPageValidation;


public class OrderDetailPageTasks extends baseClass{
	

	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	
	public static void OrderConfimrationPage() throws Exception {
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())){
			logger.info("Order confirmation page is loaded");
		}else {
			PlaceOrderPageTask.clickPlaceOrderButton();
		}
	}

	public static void getOrderConfirmationPage() throws Exception {
		OrderConfimrationPage();
		Actionsss.scrollWindowsByPixel(400);
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();
	}
}
