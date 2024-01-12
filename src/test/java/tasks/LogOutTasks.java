package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.homepage;

public class LogOutTasks extends baseClass {
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static homepage homePage = new homepage(driver);

	public static void verifyLogout() throws InterruptedException {
		Actionsss.click(homePage.clickOnLogo());
		Thread.sleep(2000);
		Actionsss.hover(lop.getHoverMyAccount());
    	Actionsss.click(lop.getLogOut()); 
    	isLogOut=false;
	}
}
