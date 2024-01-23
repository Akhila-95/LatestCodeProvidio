package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.HomePageValidations;
import validations.MiniCartValidation;

public class HomePageTasks extends baseClass{

	private static homepage homePage = new homepage(driver);
	private static loginPage lp = new loginPage(driver);	
	
	
	//Home page mega menu
    public static void randomMegaMenu() throws InterruptedException {
  	homePage.selectRandomMegaMenu(driver);
  }
    
    //wishlist
    public static void verifyThatWishlist() throws InterruptedException {
	    // Click on the "My Favorites" link
	    Actionsss.click(homePage.getWishListLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(3000);
	    // Verify the result of clicking on the "My Favorites" link
	    HomePageValidations.verifyHomePageWishlistLink();
	}
    
    //gift card
    public static void verifyThatGiftCardLink() throws Exception {
	    // Click on the "Gift Card" link
	    Actionsss.javascriptClick(homePage.getGiftCardLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(3000);
	    // Verify the result of clicking on the "Gift Card" link
	    HomePageValidations.verifyHomePageGiftCardLink();
	}
    
  //gift card
    public static void verifyThatSignInLink() throws Exception {
	    // Click on the "Gift Card" link
	    Actionsss.click(homePage.getsignInLinkLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(3000);
	    // Verify the result of clicking on the "Gift Card" link
	    HomePageValidations.verifyHomePagesingInLink();
	}
    
  //login
    public static void verifyThatuserLogin() throws Exception {
    	 String mail = " user Email";
    	 String password = " User password";
    	 
	    // Click on the "Gift Card" link
	    Actionsss.click(homePage.getsignInLinkLink());
	    // Wait for 3 seconds to allow the action to complete
	    test.info("Verify with valid credentials");

	    loginPage lp = new loginPage(driver);
        // Click the sign-in button
        Actionsss.click(lp.clickSign());
        test.pass("User clicked on sign in button");

        // Enter valid email and password
        Actionsss.sendKeys(lp.getEmail(), "akhila.m+4@etg.digital",mail);
        test.pass("user entered the " +mail);
        Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07",password);
        test.pass("User entered the " +password);

        // Click the login button
        Actionsss.click(lp.btnLogin);
        test.pass("User clicked on login button");

	    // Verify the result of clicking on the "Gift Card" link
	    HomePageValidations.verifyThatuserLogin();
	}
    
    //search fuctionality
    public static void searchAProduct() throws InterruptedException {
		
    	String searchElemnt = "Search";
		Actionsss.sendKeys(homePage.getSearchElement(), searchBar, searchElemnt );
		test.info("Searched for the product is " + searchBar);
		Thread.sleep(3000);
		
		Actionsss.click(homePage.getClickOnSearchedProduct());
		
		HomePageValidations.verifyPLPProductClick();
		
	}
    
   //mini cart btn check
    public static void miniCartBtnClick() throws Exception {
    	ProductListingPageTasks.quickShop();
    	Thread.sleep(3000);
    	Actionsss.click(homePage.getMiniCartLink());
    	MiniCartValidation.VerifiedThatMinicartBtnClick();
    	
    }
    

	

    
}
