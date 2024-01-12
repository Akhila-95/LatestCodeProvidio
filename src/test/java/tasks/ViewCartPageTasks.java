package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;

public class ViewCartPageTasks extends baseClass{
	
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void checkOutBtnClickinViewCart() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(homePage.clickOnLogo());
	}


}
