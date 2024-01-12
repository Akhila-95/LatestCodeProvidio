package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ProductListingPageTasks;

public class ProductListingPageTest extends baseClass{
	
	// Test method to verify sortby
    @Test(groups = {"regression"})
    public void VerifedThatSortByFunctionalityInPLP() throws InterruptedException {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.selectSortBy();
    }
    
    @Test(groups = {"regression"})
    public void VerifedThatFiltersFunctionalityInPLP() throws InterruptedException {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.selectFilters();
    } 
//    
    @Test(groups = {"regression"})
    public void VerifedThatResetFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.clickOnReSetBtn();
    }
//    
    @Test(groups = {"regression"})
    public void VerifedThataddToWishListFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.addToWishList();
    }
    
    @Test(groups = {"regression"})
    public void VerifedThatQuickshopBtnFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductListingPageTasks.quickShop();
    }
//    
    @Test(groups = {"regression"})
    public void VerifedThatProductLinkFunctionalityInPLP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	logger.info("coming here");
    	ProductListingPageTasks.productclick();
    }


}
