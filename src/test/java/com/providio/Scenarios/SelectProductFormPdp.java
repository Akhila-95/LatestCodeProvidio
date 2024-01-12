package com.providio.Scenarios;

import com.providio.pageObjects.navigationProcess;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.testcases.baseClass;

public class SelectProductFormPdp extends baseClass{
	
	public static void productformPDP() throws InterruptedException {
		
		//selecting a random menu form the menus and loading a plp page form the menus
		navigationProcess np = new navigationProcess(driver);
		np.selectRandomMenu(driver);

		
		//select a product and validate with the breadcramps
		productDescriptionPage pdp = new productDescriptionPage(driver);
		pdp.validateBreadCrumbs();
		
        //select a product form the products loaded on the product listing page
//		productListingPage plp = new productListingPage(driver);
//		plp.selectProductRandom(driver);
	}

}

