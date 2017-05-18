package com.test.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.supercsv.cellprocessor.Trim;

import com.test.basePages.Page;
import com.test.basePages.PageManager;

import ru.yandex.qatools.allure.annotations.Step;

public class PageOfProduct extends Page{

	
	
	private String main = "//div[@data-location = 'ProductPage']";
	
	@FindBy(id = "price_label")
	WebElement price;

	public PageOfProduct(PageManager pages) {
		super(pages);
	}
	
	public PageOfProduct ensurePageLoaded() {
	      super.ensurePageLoaded();
	      wait.until(presenceOfElementLocated(By.xpath(main)));
	      return this;
	}

	@Step
	public Integer getCounterOfComments() {

		String path = "//*[@name = 'comments']//span";

		return Integer.parseInt(driver.findElement(By.xpath(path)).getText());
	}

	@Step
	public Integer getRaitingOfProduct() {
		
		String raiting = "";
		
		String path =  main + "//span[@class='g-rating-stars-i-medium']";
			
		raiting = driver.findElement(By.xpath(path)).getAttribute("style");
						
		raiting = raiting.substring(raiting.lastIndexOf(":") + 1, raiting.lastIndexOf("%")); 

		return Integer.parseInt(raiting.trim()) / 20;
	}


	@Step
	public float getPriceOfProduct(float currentCourseOfDollar) {
									
		return Float.parseFloat(price.getText()) / currentCourseOfDollar;
	}

	
}
