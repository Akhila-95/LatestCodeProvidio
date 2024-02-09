package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;
import validations.ProductListingPageValidations;

public class ProductDetailPageTasks extends baseClass{
	
	private static ProductDetailPage PDP = new ProductDetailPage(driver);

	//wishList in pdp
	public static  void wishList() throws Exception {
		ProductListingPageTasks.productclick();
		Actionsss.CombinedClick(PDP.getSelectWishListBtn());
		ProductListingPageValidations.popUpProductisAddtoWishList();
	}
	
	//addtocart in pdp
	public static  void addtoCart() throws Exception {
		ProductListingPageTasks.productclick();
		allAttributesSelection.allAttributes();
		Thread.sleep(3000);
		Actionsss.CombinedClick(PDP.getSelectAddtoCartBtn());
		//ProductListingPageValidations.validatingProductisAddtoCart();
	}

}
