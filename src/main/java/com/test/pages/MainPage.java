package com.test.pages;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.basePages.Page;
import com.test.basePages.PageManager;

import ru.yandex.qatools.allure.annotations.Step;


public class MainPage extends Page {

	public MainPage(PageManager pages) {
		super(pages);		
	}
		
	@FindBy(name = "text")
	private WebElement txtSearchField;
	
	@FindBy(name = "rz-search-button")
	private WebElement btnSearch;
		
	
	public MainPage ensurePageLoaded() {
	      super.ensurePageLoaded();
	      wait.until(presenceOfElementLocated(By.id("fat_menu_btn")));
	      return this;
	}

	@Step
	public void typeNumber(String number) {
		txtSearchField.clear();
		txtSearchField.sendKeys(number);
	}

	public void clickSearchButton() {
		btnSearch.click();
	}
		
}
