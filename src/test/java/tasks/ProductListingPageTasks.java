package tasks;


import com.providio.testcases.baseClass;

import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductListingPage;
import pageObjects.homepage;
import validations.ProductListingPageValidations;


public class ProductListingPageTasks extends baseClass{
	
	private static homepage homePage = new homepage(driver);
	private static ProductListingPage PLP = new ProductListingPage(driver);
	
	
	//sort by
	public static void selectSortBy() throws InterruptedException{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectRandomMegaMenu(driver);
		PLP.selecttheSortBy();
	}  
	
	//filters
	public static void selectFilters() throws InterruptedException{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectRandomMegaMenu(driver);
		PLP.selectaFilterFormPLP();
	}
	
	//filters
	public static void clickOnReSetBtn() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectRandomMegaMenu(driver);
		PLP.selectaFilterFormPLP();
		Thread.sleep(4000);
		Actionsss.scrollUp(driver);
		Thread.sleep(2000);
		Actionsss.click(PLP.getSelecttheResetButton());
		ProductListingPageValidations.verifyPLPResetBtn();
	}
	
	//addToMyFav
	public static void addToWishList() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectRandomMegaMenu(driver);
		Thread.sleep(4000);
		PLP.selecttheWishlist();
		ProductListingPageValidations.popUpProductisAddtoWishList();
	}

	//addTocartsBtns
	public static void addTocart() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectRandomMegaMenu(driver);
		Thread.sleep(8000);
		//PLP.addToCartBtn();
	//	ProductListingPageValidations.popUpProductisAddtoCart();
		Thread.sleep(2000);
	}
	
	//quick shop
		public static void quickShop() throws Exception{		
			//Actionsss.click(homePage.getCookies_Yes_Btn());
			homePage.selectRandomMegaMenu(driver);
			Thread.sleep(4000);
			PLP.selectthequickshope();
			ProductListingPageValidations.verifyPLPQuickshopClick();
			allAttributesSelection.selectTheAttributesInQuickShop();
			Thread.sleep(2000);
			Actionsss.click(PLP.getSelectaddToCartBtn());
			//PLP.incTheQunatityAndClickUpdateBtn();
		//	ProductListingPageValidations.validatingProductisAddtoCart();
		}
		
	//addTocartsBtns
		public static void productclick() throws Exception{		
			//Actionsss.click(homePage.getCookies_Yes_Btn());
			homePage.selectRandomMegaMenu(driver);
			Thread.sleep(4000);
			PLP.selectRandomProduct();
			ProductListingPageValidations.verifyPLPProductClick();
		}
		
		//addTocartsBtns
		public static void gpsProducts() throws Exception{		
			//Actionsss.click(homePage.getCookies_Yes_Btn());
			homePage.selectGpsNavigation();
			Thread.sleep(4000);
			PLP.selectRandomProduct();
			ProductListingPageValidations.verifyPLPProductClick();
		}
}
