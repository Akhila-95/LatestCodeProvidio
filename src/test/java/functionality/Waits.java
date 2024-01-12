package functionality;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;


public class Waits extends baseClass{
	
	public static Wait<WebDriver> createFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(org.openqa.selenium.NoSuchElementException.class);
     
}
	
	
	public static void WaitForClickableElement(WebElement e){	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(e));
		
	}
	public static void waitAndVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
}