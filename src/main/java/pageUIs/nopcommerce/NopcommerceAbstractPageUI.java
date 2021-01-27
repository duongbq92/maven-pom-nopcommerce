package pageUIs.nopcommerce;

public class NopcommerceAbstractPageUI {
	public static final String HOME_BUTTON = "//img[@src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png']";
	public static final String SEARCH_LINK = "//a[text()='Search']";
	public static final String SHIPPING_LINK = "//a[text()='Shipping & returns']";
	public static final String SITE_LINK = "//a[text()='Sitemap']";
	public static final String FOOTER_MY_ACCOUNT_LINK = "//ul[@class='list']//a[text()='My account']";
	public static final String WISHLIST_LINK = "//ul[@class='list']//a[text()='Wishlist']";
	
	public static final String DYNAMIC_LINK = "//ul[@class='list']//a[text()='%s']";
	// admin
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String UPLOAD_FILE_TYPE = "//div[@id='product-pictures']//input[@type='file']";
	public static final String PLUS_ICON_PANEL = "//div[@id='%s']//i[contains(@class,'toggle-icon')]";
	//
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_SELECT_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_RADIDO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@id='%s-error']";
}
