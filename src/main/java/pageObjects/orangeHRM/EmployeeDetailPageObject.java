package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends AbstractPage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String firstName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FROM, firstName);
		
	}

	public void enterToMiddleNameTextboxAtAddEmployeeForm(String middleName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_EMPLOYEE_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_EMPLOYEE_FROM, middleName);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_EMPLOYEE_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_EMPLOYEE_FROM, lastName);
		
	}

	public String getEmpoyeeIDAtAddEmployeeForm() {
		waitToElementVisible(driver, EmployeeDetailPageUI.EMPLOYED_ID_TEXTBOX_AT_EMPLOYEE_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.EMPLOYED_ID_TEXTBOX_AT_EMPLOYEE_FROM, "value");
	}


	public boolean isFullNameDisplayAtHeader(String fullName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, fullName);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, fullName);
	}

	public String getFirstNameValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public String getMiddleNameValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitToElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public void enterToFirstTxtNameAtPersonalDetail(String firstName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, firstName);
		
	}

	public void enterToMiddleTxtNameAtPersonalDetail(String middleName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.MIDDLE_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, middleName);
		
	}

	public void enterToLastTxtNameAtPersonalDetail(String lastName) {
		waitToElementVisible(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM, lastName);
		
	}

	public void enterSSNNumberTxtNameAtPersonalDetail(String ssnNumber) {
		waitToElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FROM, ssnNumber);
		
	}

	public void clickToGenderRdoAtPersonalDetail(String genderValue) {
		waitToElementClickable(driver, EmployeeDetailPageUI.GENDER_RDO_AT_PERSONAL_DETAIL_FROM, genderValue);
		checkToCheckbox(driver, EmployeeDetailPageUI.GENDER_RDO_AT_PERSONAL_DETAIL_FROM, genderValue);
	}

	public void selMaritalStatusDropdownAtPersonalDetail(String maritalStatusValue) {
		waitToElementClickable(driver, EmployeeDetailPageUI.MARIAL_STATUS_DRO_AT_PERSONAL_DETAIL_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.MARIAL_STATUS_DRO_AT_PERSONAL_DETAIL_FROM, maritalStatusValue);
	}

	public void selNationalityDropdownAtPersonalDetail(String nationalityValue) {
		waitToElementClickable(driver, EmployeeDetailPageUI.NATIONALITY_DRO_AT_PERSONAL_DETAIL_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.NATIONALITY_DRO_AT_PERSONAL_DETAIL_FROM, nationalityValue);
		
	}

	public void enterDateOfBirthTxtNameAtPersonalDetail(String dateOfBirth) {
		waitToElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_DRO_AT_PERSONAL_DETAIL_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_DRO_AT_PERSONAL_DETAIL_FROM, dateOfBirth);
		
	}

	public String getSuccessMessageAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FROM);
		return getElementText(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FROM).trim();
	}

	public String getSSNNumberValueAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public boolean isGenderRdoBtnSelAtPersonalDetail(String genderValue) {
		waitToElementVisible(driver, EmployeeDetailPageUI.GENDER_RDO_AT_PERSONAL_DETAIL_FROM, genderValue);
		return isElementSelected(driver, EmployeeDetailPageUI.GENDER_RDO_AT_PERSONAL_DETAIL_FROM, genderValue);
	}

	public String getSelItemOfMaritalStatusDroAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.MARIAL_STATUS_DRO_AT_PERSONAL_DETAIL_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.MARIAL_STATUS_DRO_AT_PERSONAL_DETAIL_FROM);
	}

	public String getSelItemOfNationalityDroAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DRO_AT_PERSONAL_DETAIL_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DRO_AT_PERSONAL_DETAIL_FROM);
	}

	public String getDateOfBirtValueAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_DRO_AT_PERSONAL_DETAIL_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_DRO_AT_PERSONAL_DETAIL_FROM, "value");
	}

	public void openSideBarTabByName(String tagName) {
		waitToElementClickable(driver, EmployeeDetailPageUI.SIDE_TAG_BAR_BY_NAME, tagName);	
		clickToElement(driver, EmployeeDetailPageUI.SIDE_TAG_BAR_BY_NAME, tagName);
	}

	public void selPayGradeDroAtSalary(String payGrade) {
		waitToElementClickable(driver, EmployeeDetailPageUI.PAYGRADE_DRO_AT_SALARY_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.PAYGRADE_DRO_AT_SALARY_FROM, payGrade);
	}

	public void enterSalaryCommentTxtAtSalary(String salaryComment) {
		waitToElementVisible(driver, EmployeeDetailPageUI.SALARY_COMPONENT_AT_SALARY_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SALARY_COMPONENT_AT_SALARY_FROM, salaryComment);
		
	}

	public void selPayFrequencyDroAtSalary(String payFrequency) {
		waitToElementClickable(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DRO_AT_SALARY_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.PAY_FREQUENCY_DRO_AT_SALARY_FROM, payFrequency);
		
	}

	public void selCurrencyDroAtSalary(String currency) {
		waitToElementClickable(driver, EmployeeDetailPageUI.CURRENCY_DRO_AT_SALARY_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.CURRENCY_DRO_AT_SALARY_FROM, currency);
	}

	public void enterAmountTxtAtSalary(String amount) {
		waitToElementVisible(driver, EmployeeDetailPageUI.AMOUNT_AT_SALARY_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.AMOUNT_AT_SALARY_FROM, amount);
		
	}

	public void enterCommentsTxtAtSalary(String comments) {
		waitToElementVisible(driver, EmployeeDetailPageUI.COMENTS_AT_SALARY_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.COMENTS_AT_SALARY_FROM, comments);
		
	}

	public void selJobTitlesDropdownAtJobl(String jobTitle) {
		waitToElementClickable(driver, EmployeeDetailPageUI.JOB_TITLE_DRO_AT_JOB_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.JOB_TITLE_DRO_AT_JOB_FROM, jobTitle);
		
	}

	public void selEmploymentStatusDropdownAtJob(String employmentStatus) {
		waitToElementClickable(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DRO_AT_JOB_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.EMPLOYMENT_STATUS_DRO_AT_JOB_FROM, employmentStatus);
		
	}

	public void selJobCatagoryDropdownAtJob(String jobCaterogy) {
		waitToElementClickable(driver, EmployeeDetailPageUI.JOB_CATEGORY_DRO_AT_JOB_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.JOB_CATEGORY_DRO_AT_JOB_FROM, jobCaterogy);
		
	}

	public void enterJoinedDateTxtAtJob(String joinedDate) {
		waitToElementClickable(driver, EmployeeDetailPageUI.JOINED_DATE_TXT_AT_JOB_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.JOINED_DATE_TXT_AT_JOB_FROM, joinedDate);
		
	}

	public void selSubUnitDropdownAtJob(String subUnit) {
		waitToElementClickable(driver, EmployeeDetailPageUI.SUB_IN_DRO_AT_JOB_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.SUB_IN_DRO_AT_JOB_FROM, subUnit);
		
	}

	public void selLocationsDropdownAtJob(String location) {
		waitToElementClickable(driver, EmployeeDetailPageUI.LOCATION_DRO_AT_JOB_FROM);
		selectItemInDropdown(driver,  EmployeeDetailPageUI.LOCATION_DRO_AT_JOB_FROM, location);
		
	}

	public void enterStartDateDropdownAtJob(String startDate) {
		waitToElementClickable(driver, EmployeeDetailPageUI.START_DATE_TXT_AT_JOB_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.START_DATE_TXT_AT_JOB_FROM, startDate);
		
	}

	public void enterEndDateDropdownAtJob(String endDate) {
		waitToElementClickable(driver, EmployeeDetailPageUI.END_DATE_TXT_AT_JOB_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.END_DATE_TXT_AT_JOB_FROM, endDate);
		
	}

	public String getSelItemOfJobTitleStatusDroAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.JOB_TITLE_DRO_AT_JOB_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.JOB_TITLE_DRO_AT_JOB_FROM);
	}

	public String getSelItemOfEmploymentStatusDroAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DRO_AT_JOB_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DRO_AT_JOB_FROM);
	}

	public String getSelItemOfJobCatagoryDroAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.JOB_CATEGORY_DRO_AT_JOB_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.JOB_CATEGORY_DRO_AT_JOB_FROM);
	}

	public String getJoinedDateValueAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.JOINED_DATE_TXT_AT_JOB_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.JOINED_DATE_TXT_AT_JOB_FROM, "value");
	}

	public String getSelItemOfSubUnitDroAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.SUB_IN_DRO_AT_JOB_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.SUB_IN_DRO_AT_JOB_FROM);
	}

	public String getSelItemOfLocationDroAtJob() {
		waitToElementVisible(driver, EmployeeDetailPageUI.LOCATION_DRO_AT_JOB_FROM);
		return getFirstSelectTextInDropdown(driver, EmployeeDetailPageUI.LOCATION_DRO_AT_JOB_FROM);
	}

	public String getStartDateValueAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.START_DATE_TXT_AT_JOB_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.START_DATE_TXT_AT_JOB_FROM, "value");
	}

	public String getEndDateValueAtPersonalDetail() {
		waitToElementVisible(driver, EmployeeDetailPageUI.END_DATE_TXT_AT_JOB_FROM);
		return getElementAttibute(driver, EmployeeDetailPageUI.END_DATE_TXT_AT_JOB_FROM, "value");
	}

	public void enterNameTxtAtReportTo(String nameInReport) {
		waitToElementVisible(driver, EmployeeDetailPageUI.NAME_TXT_AT_REPORT_TO_FROM);
		sendkeyToElement(driver, EmployeeDetailPageUI.NAME_TXT_AT_REPORT_TO_FROM, nameInReport);
	
	}

	public void selReporttingMethodDroAtReportTo(String reporttingMethod) {
		waitToElementClickable(driver, EmployeeDetailPageUI.REPORTTING_METHOD_AT_REPORT_TO_FROM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.REPORTTING_METHOD_AT_REPORT_TO_FROM, reporttingMethod);
	}
}