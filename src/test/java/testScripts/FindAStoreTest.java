package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.FindAStoreTasks;


public class FindAStoreTest extends baseClass {

	@Test
	public static void verifyFindAStore() throws Exception {
		FindAStoreTasks.getFindAtore();
	}
}
