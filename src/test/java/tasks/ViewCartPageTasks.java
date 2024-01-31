package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public static void viewCartpage() throws Exception {
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	List<WebElement> viewCartPage = driver.findElements(By.xpath("//div[contains(@class, 'cart-page')]"));
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info')]"));
     	logger.info(viewCartPage.size());
     	if (viewCartPage.size()>0 && viewCartPageproducts.size()>0) {
     	    logger.info("View cart page is already loaded");
     	}else {
     		HomePageTasks.miniCartBtnClick();
    		Actionsss.click(MCP.getSelectviewCartBtn());
    		MiniCartValidation.VerifiedThatViewcartBtnClick();
 
     	}
	}
	
	

}
