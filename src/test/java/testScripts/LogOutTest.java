package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.LogOutTasks;

public class LogOutTest extends baseClass{

	@Test
	public void verifyLogout() throws InterruptedException {
		LogOutTasks.verifyLogout();
	}
}
