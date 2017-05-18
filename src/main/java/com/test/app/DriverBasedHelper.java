package com.test.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.basePages.PageManager;

import ru.yandex.qatools.allure.annotations.Attachment;

public class DriverBasedHelper {

  protected WebDriver     driver;
  protected WebDriverWait wait;
  protected PageManager   pages;
  protected Alert         alert;
 
  public DriverBasedHelper(WebDriver driver) {
    this.driver       = driver;   
    pages       = new PageManager(driver);      
  }  

  @Attachment(type = "image/png")
  public byte[] makeScreenshot() {
	   return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
  
  public void workWithAlert(String decision){
	  try {
		  
		  alert = wait.until(ExpectedConditions.alertIsPresent()); 
		  
		  switch (decision) {
			  	case "Ok":
			  		alert.accept();
				break;
	
				case "Cancel":
					alert.dismiss();
				break;
		 }
	         
	    } catch (NoAlertPresentException e) {
	        
	    }
     }
  
  public boolean chekingPresentOfElement(By locator){
	  
	  try {
		  
		  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		  
		  return driver.findElements(locator).size() == 0;
		
	} finally {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  }
  
}