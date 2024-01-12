package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CheckOutPageTasks;

public class CheckOutPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifedThatGuestLoginFuncitonalityInCheckOutPage() throws Exception {
		CheckOutPageTasks.GuestMailCheckOut();
    }


}
