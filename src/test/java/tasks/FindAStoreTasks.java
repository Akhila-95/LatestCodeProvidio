package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FindAStorePage;

public class FindAStoreTasks extends baseClass {
	
	private static final FindAStorePage findStore = new FindAStorePage(driver);
	
	public static  void getFindAtore() throws Exception {
		
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {
			
			 test.info("Bopis will available for Salesforce ,Stripe and Cybersource payments");
			 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 
			 Thread.sleep(2000);
			 Actionsss.randomElementFromList(findStore.getAnyRandomStore());
			 
			 Thread.sleep(2000);
			 
		 String nameOfStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 logger.info("Selected store is "+ nameOfStore);
			 
			 test.pass("Selected store is "+ nameOfStore);
			 
			   
			 
		}else {
			test.info("Brain tree payment is activated  so bopis are disabled");
		}
	}
}
