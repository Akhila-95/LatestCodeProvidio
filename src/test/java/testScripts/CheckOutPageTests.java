package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CheckOutPageTasks;

public class CheckOutPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingThatGuestLoginFuncitonalityInCheckOutPage() throws Exception {
		CheckOutPageTasks.GuestMailCheckOut();
    }


}
