package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.HomePageTasks;

public class HomePageTests extends baseClass{
	
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatSearchFunctionality() throws InterruptedException {
    	HomePageTasks.searchAProduct();
    }
    
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatWishListLink() throws InterruptedException {
    	HomePageTasks.verifyThatWishlist();
    }

	// Test method to verify mega menu selection
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatMegaMenuSelectionInHeaderSection() throws InterruptedException {
        // Call the randommenu method from homePageTasks class
        HomePageTasks.randomMegaMenu();
    }
    @Test(groups = {"regression"})
    public void VerifedThatGiftCardLink() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.verifyThatGiftCardLink();
    }
    
    //signIn link
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatSingInLink() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
  
    	HomePageTasks.verifyThatSignInLink();
    }
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatUserLogin() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.verifyThatuserLogin();
    }
    
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatMIniCartBtnClick() throws Exception {
        // Call the verifyThatCLPLinksInHomePage method from homePageTasks class
    	HomePageTasks.miniCartBtnClick();
    }

    
    
}
