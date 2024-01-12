package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.SizeSelectionInQuickShop;
import com.providio.pageObjects.homePage;

public class Tc_Wishlist extends baseClass{

	  @Test( dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"} )
	    public void wishListtoCart() throws InterruptedException {
	    	
		    	driver.get(baseURL);
		    	logger.info("Enter into url");
	    	
	    	    	
		   	    Tc_WishlistProccess  wishlist = new Tc_WishlistProccess();
		        wishlist.wishlistPage(driver);
	        

	        //checkoutProcess
	        
		         tc__CheckOutProcess cp = new tc__CheckOutProcess();         
		         cp.checkoutprocess();
	  	/*
	        homePage hp= new homePage(driver);   	
	    	hp.clickOnWishlist(driver); 
	    	
	    	List<WebElement> productsInWishlist = driver.findElements(By.xpath("//div[contains(@class, 'card product-info uuid-')]"));
			 int countOfProducts= productsInWishlist.size();
			 System.out.println("The total product in wishlist " + countOfProducts);
			 
			 for(int i=1;i <=countOfProducts;i++) {
				 
							 
							 if (driver.findElements(By.xpath("(//button[@class='add-to-cart btn btn-primary'])[ "+ i +" ]")).size()!=0) {
								 WebElement addToCart = driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
								 if(addToCart.isEnabled()) {
									 JavascriptExecutor js = (JavascriptExecutor)driver;
					            	 js.executeScript("arguments[0].click();",addToCart);
					                 logger.info("Product added to cart");
					                 Thread.sleep(5000);
								 }

								 else {
									 System.out.println("This item is currently not available");
					                 WebElement removeButton =driver.findElement(By.xpath(".//button[@class='remove-btn-lg remove-from-wishlist btn btn-light']"));
					                 removeButton.click();
					                 Thread.sleep(2000);
								 }
								 
							 } 
			                 else  if(driver.findElements(By.xpath("(//button[@class='select-attributes-btn btn btn-outline-primary'])[ "+ i +" ]")).size()!=0) {
								 
								 
								 WebElement selectProducts= driver.findElement(By.xpath("//button[@class='select-attributes-btn btn btn-outline-primary']"));
								 selectProducts.click();
								 System.out.println("Clicked on Select attributes");
			                     Thread.sleep(5000);
			                     
			                  // Size selection code
			                     SizeSelectionInQuickShop sizeSelection = new SizeSelectionInQuickShop();
			                     sizeSelection.sizeSelectionInQuickShop(driver);
			                     logger.info("Selected size");
	
			                     // Update
			                     Thread.sleep(1000);
			                     WebElement updateElement = driver.findElement(By.xpath(".//button[@class='btn-update-wishlist-product update-cart-product-global btn btn-primary']"));
			                     updateElement.click();
			                     logger.info("Clicked on update");
			                     Thread.sleep(3000);
							 }
						 	 
					 
					  }

			 for(int j=1;j<countOfProducts;j++) {
				 if (driver.findElements(By.xpath("(//button[@class='add-to-cart btn btn-primary'])[ "+ j +" ]")).size()!=0) {
					 WebElement addToCart = driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-primary']"));
					 if(addToCart.isEnabled()) {
						 JavascriptExecutor js = (JavascriptExecutor)driver;
		            	 js.executeScript("arguments[0].click();",addToCart);
		                 logger.info("Product added to cart");
		                 Thread.sleep(5000);
					 }
				 }
			 }*/
	  }
}
//button[@class='select-attributes-btn btn btn-outline-primary']