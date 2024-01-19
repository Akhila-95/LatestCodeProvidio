package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.homepage;

public class LogOutTasks extends baseClass {
	private static final  LogoutPage lop = new LogoutPage(driver);


	public static void verifyLogout() throws InterruptedException {
		
		Thread.sleep(2000);
		Actionsss.hover(lop.getHoverMyAccount());
    	Actionsss.click(lop.getLogOut()); 
    	
	}
}
