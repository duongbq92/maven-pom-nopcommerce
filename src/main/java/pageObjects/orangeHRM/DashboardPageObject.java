package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DashboardPageObject extends AbstractPage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
