package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserSitePO extends AbstractPage{
	WebDriver driver;
	public UserSitePO(WebDriver driver) {
		this.driver = driver;
	}
	
}