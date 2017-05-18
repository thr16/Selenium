package com.test.helpers;

import org.openqa.selenium.WebDriver;

import com.test.app.ApplicationManager;
import com.test.app.DriverBasedHelper;

public class NavigationHelper extends DriverBasedHelper{
	
	private String    baseUrl;
	private WebDriver driver;
	
	public NavigationHelper(ApplicationManager manager){
		 super(manager.getWebDriver());
		 this.driver  = manager.getWebDriver();
		 this.baseUrl = manager.getBaseUrl();
	}
		
	public void openMainPage(){
		driver.get(baseUrl);
	}

	
		
}