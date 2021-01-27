package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginTextbox;
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputToPassWordTextbox(String passWord) {
		waitToElementClickable(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, passWord);
		
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, loginTextbox);
		clickToElement(driver, loginTextbox);
		
	}
}
