package pageObjects.nopcommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.nopcommerce.AdminProductsPageUI;

public class AdminProductsPO extends AbstractPage{
	WebDriver driver;
	public AdminProductsPO(WebDriver driver) {
		this.driver = driver;
	}
	public void goToPageAtByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductsPageUI.PAGING_AT_TABLE_BY_INDEX	, indexPage);
		clickToElement(driver, AdminProductsPageUI.PAGING_AT_TABLE_BY_INDEX	, indexPage);
	}
	public boolean isPageActivedAtTableByIndex(String indexPage) {
		waitToElementVisible(driver, AdminProductsPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
		scrollToBottomPage(driver);
		return isElementDisplayed(driver, AdminProductsPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
	}
	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
	}
	public void uncheckToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		
	}
	public void allProductCheckboxChecked() {
		List<WebElement> allProductCheckboxs = getElements(driver, AdminProductsPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxs) {
			Assert.assertTrue(productCheckbox.isSelected());
		}
	}
	public void allunProductCheckboxChecked() {
		List<WebElement> allProductCheckboxs = getElements(driver, AdminProductsPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxs) {
			Assert.assertFalse(productCheckbox.isSelected());
		}
		
	}
	public void checkProductCheckboxByName(String producName) {
		waitToElementClickable(driver, AdminProductsPageUI.PRODUCT_CHECKBOX_BY_NAME, producName);
		checkToCheckbox(driver, AdminProductsPageUI.PRODUCT_CHECKBOX_BY_NAME, producName);
		
	}
	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String quantity,
			String productTye, String check) {
		waitToElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productTye, check);
		return isElementDisplayed(driver, AdminProductsPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity, productTye, check);
	}
	public void slectShowItemDropdown(String number) {
		waitToElementClickable(driver, AdminProductsPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductsPageUI.SHOW_NUMBER_ITEM_DROPDOWN, number);
		waitToAjaxLoadingPage(driver);
		
	}
	public boolean isInformationDisplayCollumNameAtRowNumber(String collumeName, String rownIndex, String expectedValue) {
		// index of collumn
		int columNameIndex = countElementSize(driver, AdminProductsPageUI.COLLUM_NAME_INDEX, collumeName) + 1;
		String actualValue = getElementText(driver, AdminProductsPageUI.CELL_VALUE_MIX_COLUMN_AND_ROW_INDEX, rownIndex, String.valueOf(columNameIndex));
		return actualValue.equals(expectedValue);
	}
	public boolean isPuslishStatusCollumNameAtRowNumber(String Published, String rownIndex, String publicStatus) {
		int columNameIndex = countElementSize(driver, AdminProductsPageUI.COLLUM_NAME_INDEX, Published) + 1;
		return isElementDisplayed(driver, AdminProductsPageUI.CHECK_STATUS_COLUMN_AND_ROW_INDEX, rownIndex,String.valueOf(columNameIndex), publicStatus);
	}
	public void clickToEditByName(String productName) {
		waitToElementClickable(driver, AdminProductsPageUI.EDIT_ICON_BY_NAME, productName);
		clickToElement(driver, AdminProductsPageUI.EDIT_ICON_BY_NAME, productName);
		waitToAjaxLoadingPage(driver);
		
	}
	public void inputToProductNameTextBox(String productName) {
		waitToElementVisible(driver, AdminProductsPageUI.SEARCH_PRODUCT_NAME_INPUT_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.SEARCH_PRODUCT_NAME_INPUT_TEXTBOX, productName);
	}
	public void clickToSearchButton() {
		waitToElementClickable(driver, AdminProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductsPageUI.SEARCH_BUTTON);
		waitToAjaxLoadingPage(driver);
	}
	public void scrollToPicturePanel() {
		waitToElementVisible(driver, AdminProductsPageUI.PICTURE_PANEL);
		scrollToElement(driver, AdminProductsPageUI.PICTURE_PANEL);
		
	}
	public void uploadFile(String string) {
		// TODO Auto-generated method stub
		
	}
	public void inputAltTextbox(String Alt) {
		waitToElementVisible(driver, AdminProductsPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.ALT_TEXTBOX, Alt);
	}
	public void inputTitleTextbox(String Title) {
		waitToElementVisible(driver, AdminProductsPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.TITLE_TEXTBOX, Title);
		
	}
	public void inputOrderTextbox(String UpOrDown) {
		waitToElementClickable(driver, AdminProductsPageUI.DISPLAY_UP_AND_DOWN_ORDER_BUTTON, UpOrDown);
		clickToElement(driver, AdminProductsPageUI.DISPLAY_UP_AND_DOWN_ORDER_BUTTON, UpOrDown);
		
	}
	public void clickToAddProductPictureButton() {
		waitToElementClickable(driver, AdminProductsPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductsPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		waitToAjaxLoadingPage(driver);
		
	}
	public boolean areImageDetailDisplayed(String pictureName, String pictureOrder, String pictureAlt, String pictureTitle) {
		waitToElementVisible(driver, AdminProductsPageUI.UPLOADED_PICTURE_DETAIL, pictureName, pictureOrder, pictureAlt, pictureTitle);
		return isElementDisplayed(driver,AdminProductsPageUI.UPLOADED_PICTURE_DETAIL, pictureName, pictureOrder, pictureAlt, pictureTitle);
	}
	public void clickToSave() {
	waitToElementClickable(driver, AdminProductsPageUI.SAVE_BUTTON );
	clickToElement(driver, AdminProductsPageUI.SAVE_BUTTON);
	waitToAjaxLoadingPage(driver);	// TODO Auto-generated method stub
		
	}
	public void clickToDeleteButtonByPictureTitle(String pictureTitle) {
		waitToElementClickable(driver, AdminProductsPageUI.DELETE_BUTTON_BY_TITLE, pictureTitle);
		clickToElement(driver, AdminProductsPageUI.DELETE_BUTTON_BY_TITLE, pictureTitle);
		waitAlertPresent(driver);
		acceptAlert(driver);
		waitToAjaxLoadingPage(driver);
		
	}
	public void clickToDeleteAllPicture() {
		List<WebElement> allItems = getElements(driver, AdminProductsPageUI.DELETE_ALL_IMAGE_IN_PICTURE);
		for (WebElement picture : allItems) {
			picture.click();
			waitAlertPresent(driver);
			acceptAlert(driver);
			waitToAjaxLoadingPage(driver);
		}
		
	}
	public boolean isNewPictureUploadSuceess(String fileName) {
		waitToElementInVisible(driver, AdminProductsPageUI.SPINNER_UPLOAD);
		waitToElementVisible(driver, AdminProductsPageUI.UPLOAD_FILE_NAME, fileName);
		return isElementDisplayed(driver, AdminProductsPageUI.UPLOAD_FILE_NAME, fileName);
	}
	public boolean areIProductlDisplayed(String pictureNameOrDefaultName,String pictureName, String skuID, String Price,
			String stockQuantity, String productType, String published) {
		waitToElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAIL_IN_SEARCH, pictureNameOrDefaultName.toLowerCase().replace(" ","-"), pictureName, skuID, Price, stockQuantity, productType, published);
		return isElementDisplayed(driver,AdminProductsPageUI.PRODUCT_DETAIL_IN_SEARCH, pictureNameOrDefaultName.toLowerCase().replace(" ","-"), pictureName, skuID, Price, stockQuantity, productType, published);
	}
	
}
