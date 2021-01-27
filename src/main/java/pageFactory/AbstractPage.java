package pageFactory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private Select select;
	private WebElement element;
//	private List<WebElement> elements;
	private Actions action;
	
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public void refreshCurrentPage(WebDriver driver) {
		 driver.navigate().refresh();
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void canceltAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	public void waitAlertPresent(WebDriver driver, String value) {
		WebDriverWait explicitWait = new WebDriverWait(driver , 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String curentPageTitle = driver.getTitle();
			if (curentPageTitle.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	public By getByXpath(String locator ) {
		 return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver,String locator ) {
		 return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver,String locator ) {
		 return driver.findElements(getByXpath(locator));
	}
	public void clickToElement(WebDriver driver,WebElement element ) {
		if(driver.toString().toLowerCase().contains("edge")){
			sleepInMiLiSecond(500);
		}
		element.click();
	}
	public void sendkeyToElement(WebDriver driver,WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public void selectItemInDropdown(WebDriver driver, WebElement element , String itemValue) {
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	public String getFirstSelectTextInDropdown(WebDriver driver,WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMutiple(WebDriver driver,String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}
	

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
			getElement(driver, parentLocator).click();
			sleepInSecond(1);

			// 2 - Chờ cho tất cả các item con được load ra
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

			// Đưa tất cả các item trong dropdown vào 1 list để kiểm tra
			List<WebElement> allItems = getElements(driver, childItemLocator);

			// 3 - Chạy qua tất cả các giá trị đang có trong list
			for (WebElement item : allItems) {
				// 4 - Kiểm tra xem text của các giá trị có item nào bằng vs text mong muốn ko
				if (item.getText().equals(expectedItem)) {
					// 5 - Scroll xuống đến đúng item này
					jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepInSecond(1);

					// 6 - Click vào cái item này
					item.click();
					sleepInSecond(1);
					break;
				}
			}
		}
	  
	  public String getElementAttibute(WebDriver driver,WebElement element , String atiiributeName) {
			return element.getAttribute(atiiributeName);
	  }
	  public String getElementText(WebDriver driver,WebElement element ) {
		  return element.getText();
	  }
	  public int countElementSize(WebDriver driver,String locator ) {
		  return getElements(driver, locator).size();
	  }
	  public void checkToCheckbox(WebDriver driver,String locator ) {
		  element = getElement(driver, locator);	  
		  if(!element.isSelected()) {
			  element.click();
		  }
	  }
	  public void uncheckToCheckbox(WebDriver driver,String locator ) {
		  element = getElement(driver, locator);	  
		  if(element.isSelected()) {
			  element.click();
		  }
	  }
	  public boolean  isElementDisplayed(WebDriver driver,WebElement element ) {
		  return element.isDisplayed();
	  }
	  public boolean  isElementEnabled(WebDriver driver,String locator ) {
		  return getElement(driver, locator).isEnabled();
	  }
	  public boolean  isElementSelected(WebDriver driver,WebElement element ) {
		  return element.isSelected();
	  }
	  public void  switchToFrame(WebDriver driver,String locator ) {
		  driver.switchTo().frame(getElement(driver, locator));
	  }
	  public void switchToDefaultContent(WebDriver driver) {
		  driver.switchTo().defaultContent();
	  }
	  public void doubleClickToElement(WebDriver driver,String locator) {
		  action = new Actions(driver);
		  action.doubleClick(getElement(driver, locator)).perform();
	  }
	  public void rightClickToElement(WebDriver driver,String locator) {
		  action = new Actions(driver);
		  action.contextClick(getElement(driver, locator)).perform();
	  }
	  public void hoverMouseToElement(WebDriver driver,String locator) {
		  action = new Actions(driver);
		  action.moveToElement(getElement(driver, locator)).perform();
	  }
	  public void clickAndHoldToElement(WebDriver driver,String locator) {
		  action = new Actions(driver);
		  action.clickAndHold(getElement(driver, locator)).perform();
	  }
	  public void dragAnDropdToElement(WebDriver driver,String sourceLocator, String targerLocator) {
		  action = new Actions(driver);
		  action.dragAndDrop(getElement(driver, sourceLocator),getElement(driver, targerLocator)).perform();
	  }
	  public void sendKeysBoardToElement(WebDriver driver,String lorcator, Keys key) {
		  action = new Actions(driver);
		  action.sendKeys(getElement(driver, lorcator),key).perform()  ;
	  }
		public Object executeForBrowser(WebDriver driver, String javaScript) {
			jsExecutor = (JavascriptExecutor) driver;
			return jsExecutor.executeScript(javaScript);
		}
	
		public String getInnerText(WebDriver driver) {
			jsExecutor = (JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
		}
		
		public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
			jsExecutor = (JavascriptExecutor) driver;
			String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
			return textActual.equals(textExpected);
		}
	
		public void scrollToBottomPage(WebDriver driver) {
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
	
		public void navigateToUrlByJS(WebDriver driver, String url) {
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.location = '" + url + "'");
		}
	
		public void highlightElement(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			String originalStyle = element.getAttribute("style");
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
			sleepInSecond(1);
			jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
		}
	
		public void clickToElementByJS(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].click();", element);
		}
	
		public void scrollToElement(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	
		public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		}
	
		public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		}
		public boolean isImageLoade(WebDriver driver, String locator) {
			jsExecutor = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",element);
			if(ImagePresent) {
				return true;
			}
			return false; 
		}
		public void waitToElementVisible(WebDriver driver, WebElement element) {
			explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.visibilityOf(element));
		}
		public void waitToElementInVisible(WebDriver driver,String locator) {
			explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		}
		public void waitToElementClickable(WebDriver driver,WebElement element) {
			explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			jsExecutor = (JavascriptExecutor) driver;
	
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					try {
						return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
					} catch (Exception e) {
						return true;
					}
				}
			};
	
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
				}
			};
	
			return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		}
	
		public void sleepInSecond(long time) {
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public void sleepInMiLiSecond(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
