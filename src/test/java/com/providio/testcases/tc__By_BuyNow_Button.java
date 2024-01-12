package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.size;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.paymentProccess.MinicartViewCartProcess;

public class tc__By_BuyNow_Button extends baseClass{
	@Test
	public void byNowButton() throws InterruptedException {
		
	//step2 1: site url
		driver.get(baseURL);
		
		
   //naviagated into random menu
		navigationPage navPage= new navigationPage(driver);
		navPage.selectRandomMenu(driver);
		test.info("Entered into menu");
	
		//plp page	
		productListingPage plp = new productListingPage(driver);
		plp.selectProductRandom(driver);
		logger.info("Entered into plp page");
		WebElement productName = driver.findElement(By.xpath("//h1[contains(@class,'product-name hidden-sm-down')]"));
        test.info(productName.getText());
        
		 List<WebElement> buyNowButton = driver.findElements(By.xpath("//button[@class='buy-now btn btn-primary col-12 col-sm-6 d-none']"));
    	if(buyNowButton.size()>0) {
    		size s =new size();
    	    s.clickOnBuyNow(driver);


     //checkoutProcess       
    	    MinicartViewCartProcess cp = new MinicartViewCartProcess();            
    	    cp.checkoutprocess();
        
     //payment process
        CreditCardPaymentProcess tc = new CreditCardPaymentProcess();			              
        tc.paymentByCreditCard();
    	} else {
         	test.info("No buy now button for selected product");
         	test.pass("No buy now button for selected product");
         }
        
	}
}
