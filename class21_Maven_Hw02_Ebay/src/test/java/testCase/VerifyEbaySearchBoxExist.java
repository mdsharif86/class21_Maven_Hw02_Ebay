package testCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

@Test
public class VerifyEbaySearchBoxExist extends Base {

	public void test_VerifyEbaySearchBoxExist() {

		navigateURL(configProp.getProperty("url"));

		boolean isExist = driver.findElement(By.xpath(locatorProp.getProperty("main_page_search_box"))).isDisplayed();

		boolean expected = true;

		Assert.assertEquals(isExist, expected);

	}
}
