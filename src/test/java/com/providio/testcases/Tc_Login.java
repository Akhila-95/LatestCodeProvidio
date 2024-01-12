

package com.providio.testcases;

import com.providio.pageObjects.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tc_Login extends baseClass {
	SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginTest() throws InterruptedException {
    	
        //test.log(LogStatus.INFO, "Test case Validation started");
    	test.info("Test case Validation started");
        driver.get(baseURL);
        logger.info("enterd into url");
        Thread.sleep(2000L);
        loginPage lp = new loginPage(driver);
        lp.clickSign();
        logger.info("clicked on sign in");
        Thread.sleep(2000L);
        lp.setEmail(name);
        logger.info("entered email");
        Thread.sleep(2000L);
        lp.setPassword(password);
        logger.info("entered password");
        Thread.sleep(2000L);
        lp.clickSubmit();
        logger.info("click on the submit button");
        Thread.sleep(5000L);
        
        WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]"));
        boolean isDisplayedinvalidcred = errorMessageInvalidCred.isDisplayed();
        logger.info(isDisplayedinvalidcred);
        WebElement errorMessageemil = driver.findElement(By.id("form-email-error"));
        boolean isDisplayedemail = errorMessageemil.isDisplayed();
        logger.info(isDisplayedemail);
        Thread.sleep(5000L);
        WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[@id= 'form-password-error'])[1]"));
        boolean isDisplayedpwd = errorMessagepwd.isDisplayed();
        logger.info(isDisplayedpwd);
        
        if (isDisplayedinvalidcred || isDisplayedemail || isDisplayedpwd) {
        	loginPage lp1 = new loginPage(driver);
            //lp1.clickSign();
            logger.info("clicked on sign in");
            Thread.sleep(2000L);
            lp1.setEmail(reemail);
            logger.info("ReEntered Email");
            Thread.sleep(2000L);
            lp1.setPassword(password);
            logger.info("Reentered password");
            Thread.sleep(2000L);
            lp1.clickSubmit();
            logger.info("click on the submit button");
            Thread.sleep(5000L);
            
            WebElement Login = driver.findElement(By.xpath(" //h1[@class ='account-page-title']"));
            String expectedTitle = "Dashboard";
            String actualTitle = Login.getText();
            
            if (actualTitle.equals(expectedTitle)) {
            	test.pass("Successfully clicked on the NewArrival of " + actualTitle);
                //test.pass( "Successfully clicked on the NewArrival of  " + actualTitle + " ");
                logger.info("click Success New arrival mens");
                isLoggedIn = true;
            } else {
            	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
                //test.log(LogStatus.FAIL, "The page Title does not match expected " + expectedTitle + " " + "  but found" + " " + actualTitle + " ");
                logger.info("Click failed");
                isLoggedIn = true;
            }
            
//          //soft assertions Login
//          
//          softAssert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value");
//          
//          //Hard assertions Login
//          
//          Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value");

            isLoggedIn = true;
            logger.info(isLoggedIn);
            Thread.sleep(5000L);
            
        } else {
        	logger.info("User logged in successfully");
        }

        
        // Assert all the soft assertions
        softAssert.assertAll();
    }
}