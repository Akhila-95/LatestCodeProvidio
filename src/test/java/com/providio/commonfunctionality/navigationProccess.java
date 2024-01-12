package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.Validations.validationpopupMessages;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class navigationProccess extends baseClass {
	
	 
	
	public void commonNavigationProccess() throws InterruptedException {
		
		for(int i=1;i<=1; i++) {
			
	         navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);
	    	// to know the category entered 
	    	 List<WebElement> pageTitle = driver.findElements(By.cssSelector("h1.page-title"));
	    	 if(pageTitle.size()>0)
	    	 {
	    		 WebElement pageTitle1 = driver.findElement(By.cssSelector("h1.page-title"));
	    		 test.info("Entered into random menu " + pageTitle1.getText());
	    	 }
	    //selected a random product 
	    	 productListingPage plp = new productListingPage(driver);
	   	     plp.selectProductRandom(driver);	    	         
	   	     List<WebElement> productName1 = driver.findElements(By.xpath("//h1[@class='product-name hidden-sm-down']"));
	   	     if(productName1.size()>0) {
	   	    	 WebElement productName = driver.findElement(By.xpath("//h1[@class='product-name hidden-sm-down']"));
	   	    	 test.info("productName is  [" + i + "] " +productName.getText());
	   	     }	
	   	  //if selected product is bundle them
	   	     List<WebElement> bundleProduct = driver.findElements(By.cssSelector(".bundle-item"));
	   	     if(bundleProduct.size()>0){
	   	    	 //validating the product is instock and adding to the cart
	   		      validatingInstock.inStockValidation();
	   	     }    
	   	
	   	// size selection
	   		 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
	   		 if( pdpPage.size()>0) {
			          size s = new size();			        
			          s.selectSize(driver);
		    		 }
	   	 //validating the product is add to the cart
	  	    validationpopupMessages.validatingProductisAddtoCart(driver);
	    }			
	}
}
