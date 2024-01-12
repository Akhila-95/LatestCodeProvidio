package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.HomePageTasks;

public class FindAStoreTest extends baseClass {

	@Test
	public static void verifyFindAStore() throws Exception {
		HomePageTasks.getFindAtore();
	}
}
