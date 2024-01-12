package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class PdpValidation extends baseClass{
	
	 // Plus Quantity for all pages (e.g., multiple products on PLP)
    public static void QuantityofallpagesPlus(WebDriver driver) throws InterruptedException {
        List<WebElement> noofPlusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-plus']"));
        if (noofPlusElementsPresent.size() > 0) {
            for (int i = 1; i <= noofPlusElementsPresent.size(); i++) {
                WebElement eachPlusElement = driver.findElement(By.xpath("(//span[@class ='qty-plus'])[" + i + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
                logger.info("quantity increased");
            }
        }
    }

    // Minus Quantity for all pages (e.g., multiple products on PLP)
    public static void Quantityofallpagesminus(WebDriver driver) throws InterruptedException {
        List<WebElement> noofminusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-minus']"));
        if (noofminusElementsPresent.size() > 0) {
            for (int i = 1; i <= noofminusElementsPresent.size(); i++) {
                WebElement eachminusElement = driver.findElement(By.xpath("(//span[@class ='qty-minus'])[" + i + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", eachminusElement);
                Thread.sleep(2000);
                js.executeScript("arguments[0].click();", eachminusElement);
                Thread.sleep(2000);
                logger.info("quantity decreased");
            }
        }
    }
    
    
    public static void wishlist() {
    	
    	
    }
    
    
    public static void recommandations() {
    	List<WebElement> recommandationProductsPDP = driver.findElements(By.xpath("//a[@class='tile-img-contain']"));
    	test.info("Validating the pdp recommandations");
    	if(recommandationProductsPDP.size()>0) {
    		test.pass("Recommanded products are displayed successfully");
    		logger.info("Recommanded products are displayed successfully");
    	}
    	else {
    		test.fail("Recommanded products are not displayed");
    		logger.info("Recommanded products are not displayed");
    	}
    }
    
	 // Plus Quantity for all pages (e.g., multiple products on PLP)
    public static void QuantityofallpagesPlusinviewcart(WebDriver driver) throws InterruptedException {
        List<WebElement> noofPlusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-plus']"));
        if (noofPlusElementsPresent.size() > 0) {
     
                WebElement eachPlusElement = driver.findElement(By.xpath("(//span[@class ='qty-plus'])[" + noofPlusElementsPresent.size() + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
                logger.info("quantity increased");
   
        }
    }
    
    
    


}
