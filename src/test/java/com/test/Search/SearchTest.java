package com.test.Search;

import static org.junit.Assert.*;

import org.junit.Test;
import com.test.baseTests.TestBase;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Main page")
@Stories("Search a product")
@Title("[Main page] Search a product")
public class SearchTest extends TestBase{
	
	final private String  number 				  = "5000299223017";
	final private Integer expextedResultOfComment = 49;
	final private Integer expextedResultOfRaiting = 5;
	final private float   currentCourseOfDollar   = (float)26.5;
	    
					
	@Severity(SeverityLevel.NORMAL)
	@Description("Search a product ")
	@Title("Search a product")
	@Test
	public void SerachProduct(){
		SerachProductTest();
	}

	private void SerachProductTest() {
		
		Integer counterOfComments;
		Integer ratingOfProduct;
		float   priсeOfProduct;
		
		app.getUserHelper().typeNumber(number);
		
		app.getUserHelper().clickSearchButton();
		
		boolean ifGoToProductPagePass = app.getPageOfProductHelper().ifGoToProductPagePass(number);
						
		assertTrue(ifGoToProductPagePass);
		
		counterOfComments = app.getPageOfProductHelper().getCounterOfComments();
		ratingOfProduct   = app.getPageOfProductHelper().getRaitingOfProduct();
		priсeOfProduct    = app.getPageOfProductHelper().getPriceOfProduct(currentCourseOfDollar);
		
		System.out.println("Current prise in dollars: " + priсeOfProduct);
				
		assertTrue((expextedResultOfComment == counterOfComments) && (expextedResultOfRaiting == ratingOfProduct));
	}
	
	
		
}
