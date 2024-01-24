package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PlaceOrderPageTask;

public class PlaceOrderTest extends baseClass{
	@Test
	public static void  verifyingPlaceOrderButton() throws Exception {
		PlaceOrderPageTask.clickPlaceOrderButton();
	}
}
