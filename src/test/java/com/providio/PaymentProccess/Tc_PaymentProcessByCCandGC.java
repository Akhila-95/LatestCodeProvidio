package com.providio.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.GiftCardCodes;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__CheckOutProcess;

public class Tc_PaymentProcessByCCandGC extends baseClass {

	public void paymentProcessByCCandGC(WebDriver driver) throws InterruptedException {
		
		//fetching element of count of products
		WebElement parentDiv= driver.findElement(By.xpath("//div[@class='product-summary-block']"));
		List<WebElement>  countOfProducts = parentDiv.findElements(By.xpath("//div[@class='product-line-item']"));
		
		System.out.println("Product count");
		if(countOfProducts.size()>0) {
			
				GiftCardCodes code= new GiftCardCodes();				
				code.paymentBySemiGC();				
				logger.info("applied gift card code ");
				
				Tc_PaymentProcessByCreditCard paymentByCC = new Tc_PaymentProcessByCreditCard();				
				paymentByCC.paymentByCreditCard();				
				logger.info("Selected credit cards");
				
		}else {
			test.fail("No products in cart");
			logger.info("No products in cart");
		}
			
      }
}
