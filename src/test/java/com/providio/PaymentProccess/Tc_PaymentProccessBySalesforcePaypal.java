package com.providio.PaymentProccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tc_PaymentProccessBySalesforcePaypal {

	public void paymentProccessBySalesforcePaypal(WebDriver driver) {
		
		WebElement salesforcePaypal= driver.findElement(By.xpath("//div[@class='salesforce-paymentrequest-element salesforce-paymentrequest-element-15abf2b0babd944fa94de621c5 salesforce-paymentrequest-element-registered sfpp-payment-single-method']"));
		salesforcePaypal.click();
	}
}
