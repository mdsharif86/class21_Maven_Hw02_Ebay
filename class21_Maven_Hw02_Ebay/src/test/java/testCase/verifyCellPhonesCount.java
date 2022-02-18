package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class verifyCellPhonesCount extends Base {
	
	@Test
	public void test_verifyCellPhonesCount() throws InterruptedException {
		
		navigateURL(configProp.getProperty("url"));

		// option[text()= 'Cameras & Photo']
		click(By.xpath(locatorProp.getProperty("select_all_category")));
		click(By.xpath(locatorProp.getProperty("select_cellphones")));
		click(By.xpath(locatorProp.getProperty("click_search_button")));
		Thread.sleep(2000);
		click(By.xpath(locatorProp.getProperty("shop_by_item_iphone")));
		click(By.xpath(locatorProp.getProperty("shop_by_iphone12_pro")));

		Thread.sleep(2000);
		List<WebElement> cameras = driver.findElements(By.xpath(locatorProp.getProperty("list_of_iphone12_pro")));
		// String cameraList =
		// getText(By.xpath(locatorProp.getProperty("lsit_of_camera_per_page")));

		Thread.sleep(2000);
		int result = cameras.size();
		System.out.println("Length: " + result);

		Assert.assertEquals(result, 32);
	}
	

}
