package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks.OrderDetailPageTasks;

public class OrderDetailsTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingOrderConfirmationPage() throws Exception {
		OrderDetailPageTasks.getOrderConfirmationPage();
    }

}
