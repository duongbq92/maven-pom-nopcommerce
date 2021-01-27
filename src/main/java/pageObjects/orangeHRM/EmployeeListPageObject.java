package pageObjects.orangeHRM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;
import pageUIs.orangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends AbstractPage {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailPageObject clickToAddButton() {
		waitToElementClickable(driver, EmployeeListPageUI.ADD_BTN);
		clickToElement(driver, EmployeeListPageUI.ADD_BTN);
		return PageGeneratorManager.getEmployeeDetailPage(driver);
	}
    public void enterEmployeeNameTxt(String fullName) {
		waitToElementClickable(driver, EmployeeListPageUI.EMPLOYEE_NAME_TXT);
		clickToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TXT);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TXT, fullName);
		sendKeysBoardToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TXT, Keys.TAB);
		sleepInSecond(5);
	}

	public void enterEmployeeIDTxt(String employeeID) {
		waitToElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TXT);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TXT, employeeID);

	}

	public void selEmploymentStatusDro(String employmentStatus) {
		waitToElementClickable(driver, EmployeeListPageUI.EMPLOYMENT_STATUS_DRO);
		selectItemInDropdown(driver,  EmployeeListPageUI.EMPLOYMENT_STATUS_DRO, employmentStatus);
		
	}

	public void selIncludeDro(String include) {
		waitToElementClickable(driver, EmployeeListPageUI.INCLUDES_DRO);
		selectItemInDropdown(driver, EmployeeListPageUI.INCLUDES_DRO, include);
		
	}

	public void enterSupervisorTxt(String supervisorName) {
		waitToElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TXT);
		sendkeyToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TXT, supervisorName);

	}

	public void selJobTitlleDro(String jobTitle) {
		waitToElementClickable(driver, EmployeeListPageUI.JOB_TITLE_DRO);
		selectItemInDropdown(driver, EmployeeListPageUI.JOB_TITLE_DRO, jobTitle);
		
	}

	public void selSubUnitDro(String subUnit) {
		waitToElementClickable(driver, EmployeeListPageUI.SUB_UNIT_DRO);
		selectItemInDropdown(driver, EmployeeListPageUI.SUB_UNIT_DRO, subUnit);
		
	}

	
}
