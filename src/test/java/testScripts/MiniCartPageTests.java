package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.HomePageTasks;
import tasks.MiniCartPageTasks;

public class MiniCartPageTests extends baseClass{

	@Test(groups = {"smoke", "regression"})
    public void VerifedThatViewCartBtnClickInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.ViewCartbtnClick();
    }
	@Test(groups = {"smoke", "regression"})
    public void VerifedThatCheckOutBtnClickInMiniCart() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
		MiniCartPageTasks.checkOutBtnClick();
    }
}
