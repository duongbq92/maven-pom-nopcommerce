package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends AbstractPage{
	//bien toan cuc - global
	WebDriver driver;
	// ham constructor-khoi tao
	// khi new class nay len homepageobject thi no se chay dau tien
	// khong co kieu tra ve
	// cung ten voi class
	// map = gan gia tri cho driver
	
	public HomePageObject(WebDriver driver) { // local
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
//	public static final String REGISTER_LINK = "//a[@class='ico-register']";
//	public static final String LOGIN_LINK = "//a[@class='ico-login']";
//	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";
//	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public void clickToRegisterLink() {
		// button , link , radio, checkbox
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		//erro messgse, 
		waitToElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, logoutLink);
		return isElementDisplayed(driver, logoutLink);
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
		
	}

}
