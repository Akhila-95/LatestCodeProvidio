package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;

public class CheckOutPageTasks extends baseClass{
	
	private static final String Email = "GuestEmail";
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static homepage homePage = new homepage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	
	public static void GuestMailCheckOut() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);
		Thread.sleep(1000);
		Actionsss.click(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
		Thread.sleep(2000);
		Actionsss.click(homePage.clickOnLogo());
		Thread.sleep(2000);
	}

}
