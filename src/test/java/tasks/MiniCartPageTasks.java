package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.MiniCartPage;
import pageObjects.homepage;
import validations.MiniCartValidation;


public class MiniCartPageTasks extends baseClass{
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static homepage homePage = new homepage(driver);
	private static final String InputQuantity = "Input Quantity in MiniCart";

	
	public static void miniCartValue() throws Exception {
        WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
        String countOfMinicart = productCountInCart.getText();
        logger.info(countOfMinicart);
        int minicartProductCountValue = Integer.parseInt(countOfMinicart);
        if(minicartProductCountValue>0) {
        	logger.info("Products are avaliable");
        }else {
        	ProductDetailPageTasks.addtoCart();
        }
	}
	
	public static void minicartClick() throws Exception {
     List<WebElement> miniCartPage = driver.findElements(By.xpath("//h1[contains(text(), 'Your shopping cart')]"));
     	
     	if (miniCartPage.size()>0) {
     		logger.info("Mini cart is already there");
     	}else {
     		HomePageTasks.miniCartBtnClick();
     	}
		
	}
	public static void ViewCartbtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
	}
	
	public static void checkOutBtnClick() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(homePage.clickOnLogo());
	}
	/*
	//remove from the minicart
	public static void removeFromMinicart() throws Exception {
		minicartClick();
		Actionsss.randomElementFromList(MCP.getSelectRemoveBtn());
		MiniCartValidation.removeproductformminicartValidation();
	}
	
	//custom input
	public static void CustomInput() throws Exception{		
		minicartClick();
		Actionsss.clearText(MCP.getSelectCustomInput());
		Thread.sleep(2000);
		Actionsss.SendKeys(MCP.getSelectCustomInput(), 5, InputQuantity);
		Thread.sleep(2000);
	}
	
	public static void closeMiniCart() throws Exception{		
		minicartClick();
		Actionsss.CombinedClick(MCP.getSelectcloseMiniCart());
		Thread.sleep(2000);
		MiniCartValidation.VerifingCloseMinicartBtnClick();
	}
*/

}
