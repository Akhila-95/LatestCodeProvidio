package functionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

public class attributesSelection extends baseClass{
	
	
    //SizeSelection
	//@FindBy(xpath ="//select[contains(@class,'select-size')]" )
	
	//WebElement Size;
	public static void sizeSelction() throws InterruptedException {
		
		//sizes in boxess
		List<WebElement> sizeBox= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]"));
		List<WebElement> sizeDropDown= driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		if(sizeBox.size()>0) {
			//total sizes
			List<WebElement> sizeBoxs= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]//span[@class='text-center']"));
			int randomIndexofsize = random.nextInt(sizeBoxs.size())+1;
			if(randomIndexofsize>0) {
				WebElement sizeBtn = driver.findElement(By.xpath("(//div[contains(@class, 'select-size')]//span[@class='text-center'])[" + randomIndexofsize + "]"));
				Actionsss.CombinedClick(sizeBtn);
				//sizeBtn.click();
			}

		}else if(sizeDropDown.size()>0) {
		List<WebElement> sizedropdown= driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
		logger.info(sizedropdown.size());
		for(int i=1; i<=sizedropdown.size();i++) {
		WebElement Size = driver.findElement(By.xpath("(//select[contains(@class, 'select-size')])[" + i + "]"));

		// sizes from drop down Create a Select object and select the first enabled size
	    Select colorElement = new Select(Size);
	    List<WebElement> options = colorElement.getOptions();
	    List<String> enabledSizes = new ArrayList<>();
	    int optionIndex = 0;
	    for (WebElement option : options) {
	    	if (optionIndex > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes.add(value);
	                //System.out.println(value);
	                option.click();
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }

	    	 optionIndex++;
	    }

	}
 }
}
	
	

//	WebElement memorySize;
	public static void memorySelection() throws InterruptedException {
		List<WebElement> memoryBox = driver.findElements(By.xpath(" //div[contains(@class, 'select-memorySize')]"));
		if(memoryBox.size()>0) {
			//total memory sizes
			List<WebElement> memoryBoxs= driver.findElements(By.xpath("//div[contains(@class, 'select-memorySize')]//span[@class='text-center  ']"));
			int randomIndexofmemory = random.nextInt(memoryBoxs.size())+1;
			if(randomIndexofmemory>0) {
				WebElement memoryBtn = driver.findElement(By.xpath("(//div[contains(@class, 'select-memorySize')]//span[@class='text-center  '])[" + randomIndexofmemory + "]"));
				memoryBtn.click();
			}
		}else {
		// Create a Select object and select the first enabled size
		WebElement memorySize= driver.findElement(By.xpath("//select[contains(@class,'select-memorySize')]"));
	    Select MemoryElement = new Select(memorySize);
	    List<WebElement> options = MemoryElement.getOptions();
	    
	    List<String> enabledSizes = new ArrayList<>();				    
	    int optionIndex = 0;				    
	    System.out.println(options.size());
	    for (WebElement option : options) {
	    	if (optionIndex > 0 && option.isEnabled()) {				    		
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes.add(value);
	                //System.out.println(value);
	                option.click();
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }
	    	else {
	    		System.out.println("This memory size is not avaliable");
	    	}				    	
	    	 optionIndex++;
	       }
		}
	}
	
	
	//color Selection
	public static void colorSelection() throws InterruptedException {
		List<WebElement> colorBoxpresnet = driver.findElements(By.xpath("//button[contains(@class, 'color-attribute')]"));
		if(colorBoxpresnet.size()>0) {
			//total memory sizes
			List<WebElement> colorBoxs= driver.findElements(By.xpath("//button[contains(@class, 'color-attribute')]"));
			int randomIndexofcolor = random.nextInt(colorBoxs.size())+1;
			if(randomIndexofcolor>0) {
				WebElement colorBtn = driver.findElement(By.xpath("(//button[contains(@class, 'color-attribute')])[" + randomIndexofcolor + "]"));
				colorBtn.click();
			}
 		}else {
 		    // Create a Select object and select the first enabled size
			List<WebElement> colors= driver.findElements(By.xpath("//select[contains(@class,'select-color-swatch')]"));
			logger.info(colors.size());
			for(int i=1; i<=colors.size();i++) {
			WebElement color = driver.findElement(By.xpath("(//select[contains(@class,'select-color-swatch')])[" + i + "]"));

		    Select colorElement = new Select(color);
		    List<WebElement> options = colorElement.getOptions();
		    List<String> enabledSizes = new ArrayList<>();
		    int optionIndex = 0;
		    System.out.println(options.size());
		    for (WebElement option : options) {
		    	if (optionIndex > 0 && option.isEnabled()) {					    		
		    		String text = option.getText();
		    		  //System.out.println(text);
		            if (!text.isEmpty()) {      	
		            	String value = option.getAttribute("data-attr-value");
		                enabledSizes.add(value);
		                //System.out.println(value);
		                option.click();
		                Thread.sleep(2000);
		                break; 				                
		            }
		        }

		    	 optionIndex++;
		    }

	     }
	   
    }
}			
	
	//width Selection
 	public static void widthSelection() throws InterruptedException {
 		List<WebElement> widthBoxpresent = driver.findElements(By.xpath("//div[contains(@class, 'select-width')]//span[@class='text-center' and not(contains(@disabled, 'disabled'))]"));
		if(widthBoxpresent.size()>0) {
			//total memory sizes
			List<WebElement> widthBoxs= driver.findElements(By.xpath("//div[contains(@class, 'select-width')]//span[@class='text-center' and not(contains(@disabled, 'disabled'))]"));
			int randomIndexofwidth = random.nextInt(widthBoxs.size())+1;
			if(randomIndexofwidth>0) {
				WebElement widthBtn = driver.findElement(By.xpath("(//div[contains(@class, 'select-width')]//span[@class='text-center' and not(contains(@disabled, 'disabled'))])[" + randomIndexofwidth + "]"));
				widthBtn.click();
			}
 		}else {
 		// Create a Select object and select the first enabled size
			List<WebElement> widthdropdown= driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
			logger.info(widthdropdown.size());
			
			for(int i=1; i<=widthdropdown.size();i++) {
			WebElement width = driver.findElement(By.xpath("(//select[contains(@class,'select-width')])[" + i + "]"));

		    Select colorElement = new Select(width);
		    List<WebElement> options = colorElement.getOptions();
		    List<String> enabledSizes = new ArrayList<>();
		    int optionIndex = 0;
		    System.out.println(options.size());
		    for (WebElement option : options) {
		    	if (optionIndex > 0 && option.isEnabled()) {					    		
		    		String text = option.getText();
		    		  //System.out.println(text);
		            if (!text.isEmpty()) {      	
		            	String value = option.getAttribute("data-attr-value");
		                enabledSizes.add(value);
		                //System.out.println(value);
		                option.click();
		                Thread.sleep(2000);
		                break; 				                
		            }
		        }

		    	 optionIndex++;
		    }

	     }
	

 		}
 	
 }
 	
 	
 	//select showname
 	public static void selectShowName() throws InterruptedException {
 		List<WebElement> showNameBox= driver.findElements(By.cssSelector(".select-memorySize"));
 		if(showNameBox.size()>0) {
 		List<WebElement> showNameElements = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	    System.out.println(showNameElements.size());
 		  //show name
		  WebElement widthElement = showNameElements.get(0);
		  System.out.println("width element is present on the page.");
		  Select showNameSelect = new Select(widthElement);
		  // Get the list of available options
		  List<WebElement> availableOptionsofwidth =  showNameSelect.getOptions();
		  // Create a list to store the indices of enabled options
		  List<Integer> enabledIndixes = new ArrayList<>();
		  // Iterate through the available options and store the indices of enabled options
		  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
		      if (availableOptionsofwidth.get(a).isEnabled()) {
		      	enabledIndixes.add(a);
		      }
		  }
		  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
		  //logger.info(enabledIndixes);
		  System.out.println("total numbers of"+enabledIndixes);
		  System.out.println("only width"+enabledIndixes);
		  // Select the option at the random index
		  showNameSelect.selectByIndex(randomIndexofwidth); 
		  Thread.sleep(5000);
 		}else {
 			 // Find all show name elements
 	        List<WebElement> showNameElements = driver.findElements(By.cssSelector(".select-showName .text-center"));
 	        // Filter enabled show name options
 	        List<WebElement> enabledShowNameOptions = new ArrayList<>();
 	        for (WebElement showNameElement : showNameElements) {
 	            if (!showNameElement.getAttribute("class").contains("disabled")) {
 	                enabledShowNameOptions.add(showNameElement);
 	            }
 	        }
 	        // Select a random enabled show name
 	        if (!enabledShowNameOptions.isEmpty()) {
 	            Random random = new Random();
 	            int randomIndex = random.nextInt(enabledShowNameOptions.size());
 	            enabledShowNameOptions.get(randomIndex).click();
 	        }
 		}
 	}
 	
 	//selectionExtended warrenty
   public static void selectExtendedWarranty	() {
	 
	 // Locate the dropdown element.
       List<WebElement> dropdownElement = driver.findElements(By.className("options-select"));
       if(!dropdownElement.isEmpty()) {
	        WebElement dropdownElements = driver.findElement(By.className("options-select"));
	        // Create a Select object from the dropdown element.
	        Select select = new Select(dropdownElements);
	        // Get all available options in the dropdown.
	        List<WebElement> options = select.getOptions();
	        // Generate a random index within the range of available options.
	        int randomIndex = new Random().nextInt(options.size());
	        // Select the option at the random index.
	        select.selectByIndex(randomIndex);
       }
 }
   
   
   //AcceriessizeSelection
   public static void AccsizeSelction() {
		List<WebElement> AccSizeBoxpresent = driver.findElements(By.xpath("//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  ']"));
		if(AccSizeBoxpresent.size()>0) {
			//total memory sizes
			List<WebElement> AccSizeBoxs= driver.findElements(By.xpath("//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  ']"));
			int randomIndexofwidth = random.nextInt(AccSizeBoxs.size())+1;
			if(randomIndexofwidth>0) {
				WebElement AccSizeBtn = driver.findElement(By.xpath("(//div[contains(@class, 'select-accessorySize')]//span[@class='text-center  '])[" + randomIndexofwidth + "]"));
				AccSizeBtn.click();
			}
		}else {
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }
	
   }
	
}
