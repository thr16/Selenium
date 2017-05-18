package com.test.basePages;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.basePages.Page;

public class Page {
	
 	 protected WebDriver driver;
     protected FluentWait<WebDriver> wait;
	 protected PageManager pages;
	 
	 public Page(PageManager pages){
		 this.pages = pages;
		 driver = pages.getWebDriver();
		 wait = new WebDriverWait(driver, 10);
	 }
	 
	 public WebDriver getWebDriver() {
		return driver;
	 }

	 public String getTitle() {
		return driver.getTitle();
	 }

		public Page ensurePageLoaded() {
		  return this;
		}

	  public boolean waitPageLoaded() {
	    try {
	      ensurePageLoaded();
	      return true;
	    } catch (TimeoutException to) {
	      return false;
	    }
	  }
	  
	  public boolean ensureElementLoaded(By locator) {
	    
		  wait.until(presenceOfElementLocated(locator));
	      try{
			 driver.findElement(locator);
			 return true;
		  }catch(NoSuchElementException e){
				return false;
		  }	
	}	
	  
}
