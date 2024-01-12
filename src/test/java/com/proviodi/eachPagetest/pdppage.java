package com.proviodi.eachPagetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/mens-classic-deer-gloves/TG508M.html?lang=en_US");
	   Thread.sleep(5000);
	   
	   List<WebElement> AccSizeBoxpresent = driver.findElements(By.xpath("//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  ']"));
		if(AccSizeBoxpresent.size()>0) {
			//total memory sizes
			List<WebElement> AccSizeBoxs= driver.findElements(By.xpath("//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  ']"));
			int randomIndexofwidth = random.nextInt(AccSizeBoxs.size())+1;
			if(randomIndexofwidth>0) {
				WebElement AccSizeBtn = driver.findElement(By.xpath("(//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  '])[" + randomIndexofwidth + "]"));
				AccSizeBtn.click();
				Thread.sleep(5000);
			}
		}
	   
	}

}
