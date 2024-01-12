package com.providio.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.GiftCardCodes;
import com.providio.testcases.baseClass;

public class Tc_PaymentProccessByGCandPaypal extends baseClass{

public void paymentProcessByGcandPaypal(WebDriver driver) throws InterruptedException {
		
		//fetching element of count of products
		WebElement parentDiv= driver.findElement(By.xpath("//div[@class='product-summary-block']"));
		List<WebElement>  countOfProducts = parentDiv.findElements(By.xpath("//div[@class='product-line-item']"));
		
		System.out.println("Product count");
		if(countOfProducts.size()>0) {
			
				GiftCardCodes code= new GiftCardCodes();				
				code.paymentBySemiGC();	
				//code.performRandomOperations(driver);
				logger.info("applied gift card code ");
				
			 
			    Tc_PaymentProcessByPayPal paypal= new Tc_PaymentProcessByPayPal();				  
			    paypal.paymentByPaypal();				  
			    Thread.sleep(5000);
			
		}else {
			test.fail("No products in cart");
			logger.info("No products in cart");
		}
			
      }
}
