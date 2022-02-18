package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class VerifyEbayCameraTotalByCategory extends Base {

	@Test
	public void test_VerifyEbayCameraTotalByCategory() {

		navigateURL(configProp.getProperty("url"));

		// option[text()= 'Cameras & Photo']
		click(By.xpath(locatorProp.getProperty("select_all_category")));
		click(By.xpath(locatorProp.getProperty("select_camera")));
		click(By.xpath(locatorProp.getProperty("click_search_button")));
		click(By.xpath(locatorProp.getProperty("shop_by_item_dslr")));

		List<WebElement> cameras = driver.findElements(By.xpath(locatorProp.getProperty("list_of_camera_per_page")));
		
		int result = cameras.size();
		System.out.println("Length: " + result);

		Assert.assertEquals(result, 46);

		
	}

}
