package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ProductListingPageTasks;
import tasks.QuickShopPageTasks;

public class ProductListingPageTest extends baseClass{
	
	// Test method to verify sortby
    @Test(groups = {"regression"})
    public void VerifingSortByFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.selectSortBy();
    }
    
    @Test(groups = {"regression"})
    public void VerifingFiltersFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.selectFilters();
    } 
//    
    @Test(groups = {"regression"})
    public void VerifingResetFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.clickOnReSetBtn();
    }
//    
    @Test(groups = {"regression"})
    public void VerifingaddToWishListFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.addToWishList();
    }
    
    @Test(groups = {"regression"})
    public void VerifingQuickshopBtnFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.quickShop();
    }
    
    @Test(groups = {"regression"})
    public void VerifingViewFullDetailsInQuickshopModalInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	QuickShopPageTasks.loadPDP();
    }
    
    @Test(groups = {"regression"})
    public void VerifingCloseBtnInQuickshopModalInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	QuickShopPageTasks.popUpClose();
    }
    
    @Test(groups = {"regression"})
    public void VerifingAttributesInQuickshopModalInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	QuickShopPageTasks.selectAttributesQuickshop();
    }
    
    @Test(groups = {"regression"})
    public void VerifingCustomInputQuantityInQuickshopModalInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	QuickShopPageTasks.CustomInputQuickshop();
    }
    
    @Test(groups = {"regression"})
    public void VerifingAddtoCartInQuickshopModalInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	QuickShopPageTasks.addtoCart();
    }
    
    @Test(groups = {"regression"})
    public void VerifingProductLinkFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	logger.info("coming here");
    	ProductListingPageTasks.productclick();
    }
    
    @Test(groups = {"regression"})
    public void VerifingBreadCrumbsFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	//ProductListingPageTasks.breadCrumbs();
    }
    @Test(groups = {"regression"})
    public void VerifingAddtoBagFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	//ProductListingPageTasks.productaddtoBag();
    }


}
