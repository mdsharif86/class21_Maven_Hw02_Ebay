package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class VerifyEbayPetSuppliesCount extends Base {
	
	@Test
	public void test_VerifyEbayPetSuppliesCount() throws InterruptedException {
		
		navigateURL(configProp.getProperty("url"));

		// option[text()= 'Cameras & Photo']
		click(By.xpath(locatorProp.getProperty("select_all_category")));
		click(By.xpath(locatorProp.getProperty("select_pet_supplies")));
		click(By.xpath(locatorProp.getProperty("click_search_button")));
		Thread.sleep(2000);
		click(By.xpath(locatorProp.getProperty("shop_by_item_fish_tank")));
		
		Thread.sleep(2000);
		List<WebElement> cameras = driver.findElements(By.xpath(locatorProp.getProperty("list_of_fish_tank")));
		
		Thread.sleep(2000);
		int result = cameras.size();
		System.out.println("Length: " + result);

		Assert.assertEquals(result, 47);
	}

}
