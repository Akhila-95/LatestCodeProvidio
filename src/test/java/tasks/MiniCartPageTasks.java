package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.homepage;
import validations.MiniCartValidation;


public class MiniCartPageTasks extends baseClass{
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static homepage homePage = new homepage(driver);
	public static void ViewCartbtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
	}
	
	public static void checkOutBtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(homePage.clickOnLogo());
		
	}


}
