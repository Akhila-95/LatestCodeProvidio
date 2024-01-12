package com.providio.testcases;

import org.testng.annotations.Test;

import com.providio.pageObjects.productDescriptionPage;

public class practice extends baseClass{

	@Test
	public void practice() throws InterruptedException{
		
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/striped-silk-tie/793775362380M.html?lang=en_US");
		
		productDescriptionPage pdp = new productDescriptionPage(driver);
		pdp.yoptpoReviews();
		
	}
}
