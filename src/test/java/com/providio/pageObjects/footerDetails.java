package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class footerDetails  {
		WebDriver lDriver;
		
		public footerDetails(WebDriver rDriver){
			lDriver =rDriver;
			PageFactory.initElements(rDriver, this);
	}
		//navigation to the links in footer section 

		//1. shop by category
				//1.1- Womens
		@FindBy(xpath="//a[contains(text(),'Women')]")
		WebElement womensFooter;
		
		
		public void clickOnWomensFooter(WebDriver driver) {
			//main div for footer section
			WebElement shopByCategoryInFooter= driver.findElement(By.id("div#shop-category"));
			WebElement womensInFooter= shopByCategoryInFooter.findElement(By.id("div#shop-category"));

		}
}
