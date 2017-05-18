package com.test.helpers;

import org.openqa.selenium.By;

import com.test.app.ApplicationManager;
import com.test.app.DriverBasedHelper;

import ru.yandex.qatools.allure.annotations.Step;

public class PageOfProductHelper extends DriverBasedHelper{

	public PageOfProductHelper(ApplicationManager manager){
		super(manager.getWebDriver());		
	}

	public Integer getCounterOfComments() {		
		return pages.pageOfProduct.ensurePageLoaded()
				                  .getCounterOfComments();
	}

	public Integer getRaitingOfProduct() {
		return pages.pageOfProduct.ensurePageLoaded()
							      .getRaitingOfProduct();
	}

	public float getPriceOfProduct(float currentCourseOfDollar) {
		return pages.pageOfProduct.ensurePageLoaded()
								  .getPriceOfProduct(currentCourseOfDollar);
	}

	@Step
	public boolean ifGoToProductPagePass(String number) {
		
		String path = "//h1[contains(text(),'"+ number +"')]";
		String url  = "";
				
		url = driver.getCurrentUrl();
				
		makeScreenshot();
		return driver.findElements(By.xpath(path)).size() == 1 && url.contains(number);
	}
	
	
}
