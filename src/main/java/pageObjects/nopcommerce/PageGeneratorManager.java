package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
		public static UserHomePO geUsertHomePage(WebDriver driver) {
			return new UserHomePO(driver);
		}
		public static UserLoginPO getUserLoginPage(WebDriver driver) {
			return new UserLoginPO(driver);
		}
		public static UserRegisterPO getUserRigisterPage(WebDriver driver) {
			return new UserRegisterPO(driver);
		}
		public static UserCustomerInforPO getUserCustomerInfor(WebDriver driver) {
			return new UserCustomerInforPO(driver);
		}
		public static UserSearchPO getUserSearchPage(WebDriver driver) {
			return new UserSearchPO(driver);
		}
		public static UserShippingPO getUserShippingPage(WebDriver driver) {
			return new UserShippingPO(driver);
		}
		public static UserSitePO getUserStiePage(WebDriver driver) {
			return new UserSitePO(driver);
		}
		public static UserFooterMyAccountPO getUserFooterPage(WebDriver driver) {
			return new UserFooterMyAccountPO(driver);
		}
		public static UserWishlistPO getUserWishlistPage(WebDriver driver) {
			return new UserWishlistPO(driver);
		}
		public static UserDesktopPO getUserDesktopPage(WebDriver driver) {
			return new UserDesktopPO(driver);
		}
		public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
			return new AdminLoginPO(driver);
		}
		public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
			return new AdminDashboardPO(driver);
		}
		public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
			return new AdminProductsPO(driver);
		}
}
