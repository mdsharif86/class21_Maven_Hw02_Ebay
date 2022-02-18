package testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

@Test
public class VerifyEbayAllCategoryOptionEnabled extends Base {
	
	public void test_VerifyEbayAllCategoryOptionEnabled() {
		
		navigateURL(configProp.getProperty("url"));

		boolean isExist = driver.findElement(By.xpath(locatorProp.getProperty("select_all_category"))).isDisplayed();

		boolean expected = true;

		Assert.assertEquals(isExist, expected);
	}

}
