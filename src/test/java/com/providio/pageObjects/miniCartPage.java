package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class miniCartPage extends baseClass{

    WebDriver lDriver;

    // Constructor for the miniCartPage class
    public miniCartPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Element for Cart Button
    @FindBy(xpath = "//a[contains(@class,'minicart-link')]")
    WebElement CartButton;

    // Method to click on the Cart Button
    public void clickcartbutton(WebDriver driver) throws InterruptedException {
        CartButton.click();
        Thread.sleep(2000);

        try {
            // Use JavaScript to click on the Cart Button (fallback)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", CartButton);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception or perform an alternative action if necessary
            CartButton.click();
        }
    }

    // Element for Cart Button (JavaScript click)
    @FindBy(xpath = "//a[@class='minicart-link']")
    WebElement CartButtonjs;

    // Method to click on the Cart Button using JavaScript
    public void clickcartbuttonjs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", CartButton);
    }

    // Element for View Cart Button
    @FindBy(xpath = "//a[contains(@class,'btn  btn-block ')]")
    WebElement viewCartButton;

    // Method to click on the View Cart Button
    public void clickviewCartButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        viewCartButton.click();
        Thread.sleep(2000);
    }

    // Element for Checkout Button
    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn')]")
    WebElement Checkout;

    // Method to click on the Checkout Button
    public void clickCheckout() throws InterruptedException {
        Checkout.click();
        Thread.sleep(5000);
    }

    // Element for PayPal Button (Braintree Payment Integration)
    @FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
    WebElement brainTreePaypalButton;

    // Method to click on the PayPal Button (Braintree Payment Integration)
    public void clickBrainTreePaypalButton() throws InterruptedException {
        brainTreePaypalButton.click();
        Thread.sleep(5000);
    }

    // Element for PayPal Button (Salesforce Integration)
    @FindBy(xpath = "//div[contains(@class,'salesforce')]")
    WebElement salesforcePaypalButton;

    // Method to click on the PayPal Button (Salesforce Integration)
    public void clickSalesforcePaypalButton() {
        salesforcePaypalButton.click();
    }

    // Element for Google Pay Button (Salesforce)
    @FindBy(xpath = "//iframe[@title='Secure payment button frame']")
    WebElement googlePayButton;

    // Method to click on the Google Pay Button (Salesforce)
    public void clickOnGooglePayButton() {
        googlePayButton.click();
    }
    
    
    public void removeformMiniCart() throws InterruptedException {
    	List<WebElement> RemoveBtnsInMiniCart = driver.findElements(By.xpath("//div[@class='card-body']//button[contains(@class,'remove-btn')]"));
    	test.info("Validate remove the product form the mini cart");
    	for(int i =1;i<=RemoveBtnsInMiniCart.size();i++) {
    		
    		if(RemoveBtnsInMiniCart.size()==1) {
        		WebElement RemoveBtnInMiniCart = driver.findElement(By.xpath("(//div[@class='card-body']//button[contains(@class,'remove-btn')])["+i+"]"));
        		Thread.sleep(2000);
        		RemoveBtnInMiniCart.click();
        		test.pass("product is removed from the cart");
        		logger.info("product is removed from the cart");
        	}
        	else {
        		test.fail("product is removed not from the cart");
        		logger.info("product is removed not from the cart");
        	}
    	}
    	
    	
    }
}

