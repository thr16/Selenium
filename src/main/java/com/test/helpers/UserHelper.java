package com.test.helpers;


import com.test.app.ApplicationManager;
import com.test.app.DriverBasedHelper;


public class UserHelper extends DriverBasedHelper {
		
	public UserHelper(ApplicationManager manager){
		super(manager.getWebDriver());		
	}

	public void typeNumber(String number) {
		pages.mainPage.ensurePageLoaded()
					  .typeNumber(number);
	}

	public void clickSearchButton() {
		pages.mainPage.ensurePageLoaded()
					  .clickSearchButton();
	}
			
	
	
}	
