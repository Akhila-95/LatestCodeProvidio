package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.QuickShopPage;
import validations.ProductListingPageValidations;
import validations.QuickShopValidations;

public class QuickShopPageTasks extends baseClass{
	
	private static QuickShopPage QSP = new QuickShopPage(driver);
	private static final String InputQuantityinQuickShop = "Input Quantity in QuickShop pop Up";
	
	public static void modalPopUPQuickShop() throws Exception {
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'product-quickview')]"));
     
     	if (viewCartPageproducts.size()>0) {
     	    logger.info("Quick shop pop up modal is already loaded");
     	}else {
     		ProductListingPageTasks.quickShop();
     	}
	}
	
	public static void loadPDP() throws Exception {
		modalPopUPQuickShop();
		Actionsss.CombinedClick(QSP.getSelectPDPLink());
		QuickShopValidations.verifyQuickshopFullDetailsLinkClick();
	}
	
	public static void popUpClose() throws Exception {
		modalPopUPQuickShop();
		Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());
		QuickShopValidations.VerifiyQuickShopPOpUpClosed();
	}
	
	public static void selectAttributesQuickshop() throws Exception {
		modalPopUPQuickShop();
		allAttributesSelection.selectTheAttributesInQuickShop();
		QuickShopValidations.verifyAttributesSelection();
	}
	
	public static void CustomInputQuickshop() throws Exception {
		modalPopUPQuickShop();
		Actionsss.SendKeys(QSP.getSelectCustomInput(), 4, InputQuantityinQuickShop);
		Thread.sleep(2000);
	}
	
	public static void addtoCart() throws Exception {
		modalPopUPQuickShop();
		Thread.sleep(2000);
		allAttributesSelection.selectTheAttributesInQuickShop();
		Thread.sleep(1000);
		Actionsss.CombinedClick(QSP.getSelectaddToCartBtn());
		ProductListingPageValidations.validatingProductisAddtoCart();
	}


	

}
