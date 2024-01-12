package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ProductDetailPageTasks;
import tasks.ProductListingPageTasks;

public class ProductDetailPageTest extends baseClass{
	
	// Test method to verify sortby
    @Test(groups = {"regression"})
    public void VerifedThatWishlistFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.wishList();
    }
    
	// Test method to verify sortby
    @Test(groups = {"regression"})
    public void VerifedThatAddtoCartFunctionalityInPDP() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	ProductDetailPageTasks.addtoCart();
    }

}
