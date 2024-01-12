package com.providio.launchingbrowser;

import com.providio.testcases.baseClass;

public class launchBrowsering extends baseClass{
	
	public void chromeBrowser() {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
	}

}
