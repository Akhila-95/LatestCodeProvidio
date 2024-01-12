package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.footerDetails;

public class footerNavigation extends baseClass {

	public void footer(WebDriver driver) {
		
		
		//navigating from footer links 
		footerDetails footer = new footerDetails(driver);
		//navigating to womens category from footer links 
		//footer.mainDiv.clickOnWomensFooter();
			
		
	}
}
