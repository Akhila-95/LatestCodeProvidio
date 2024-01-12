package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ViewCartPageTasks;

public class ViewCartPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifedThatCheckOutBtnClickInViewCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		ViewCartPageTasks.checkOutBtnClickinViewCart();
    }

}
