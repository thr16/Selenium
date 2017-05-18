package com.test.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.helpers.NavigationHelper;
import com.test.helpers.PageOfProductHelper;
import com.test.helpers.UserHelper;

public class ApplicationManager {
		
	private WebDriver            driver;
	private String               url;
			
	private UserHelper            	      userHelper;
	private NavigationHelper      	      navHelper;
	private PageOfProductHelper           pageOfProductHelper;

	
	public ApplicationManager() throws MalformedURLException{ 
	
		try {
			    String filePath = "src/test/resources/config.properties";    //
			
		    	FileInputStream fis;
		        Properties property = new Properties();
		        fis = new FileInputStream(filePath);
		        property.load(fis);

		        url     	= property.getProperty("host");
		        		      		       	        
		        fis.close();         
		        
		} catch (IOException e) {
		        System.err.println("The properties - file is not available!");
		}		
					        
		String geckoPath = "/media/thr16/cde19f28-a60c-4de3-8049-fd02ef59c407/Project/ControlPay/Alauras-a1420f8f467418491f40ca1dd33af2bf74d2cab0-a1420f8f467418491f40ca1dd33af2bf74d2cab0/src/test/resources/geckodriver";
	    System.setProperty("webdriver.firefox.marionette", geckoPath);
	        	
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
	   	   	    													
	    driver = new FirefoxDriver();		    
				
	    // setup of driver
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		 
		navHelper     		  = new NavigationHelper(this);
		userHelper    		  = new UserHelper(this);	 
		pageOfProductHelper   = new PageOfProductHelper(this);
				
		getNavHelper().openMainPage();
	}
					
	public String getBaseUrl() {	
		return url;
	}		

	public UserHelper getUserHelper() {
		return userHelper;
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}		
	
	public void stop(){		
		if(driver != null){
			driver.quit();
		}			
	}
			
	public NavigationHelper getNavHelper() {
		return navHelper;
	}

	public PageOfProductHelper getPageOfProductHelper() {
		return pageOfProductHelper;
	}
	
}
