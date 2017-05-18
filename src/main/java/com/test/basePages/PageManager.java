package com.test.basePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.test.pages.MainPage;
import com.test.pages.PageOfProduct;

public class PageManager {
	
	private WebDriver driver;
		
	public MainPage       mainPage;	
	public PageOfProduct  pageOfProduct;            
		
	public PageManager(WebDriver driver){ 
		this.driver = driver;
				
		mainPage 		= initElements(new MainPage(this));	
		pageOfProduct   = initElements(new PageOfProduct(this));	
	
	}
	
	private <T extends Page> T initElements(T page) {
	  
		PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);

	    return page;	    
	}
		
	public WebDriver getWebDriver() {
	    return driver;
	}

}
