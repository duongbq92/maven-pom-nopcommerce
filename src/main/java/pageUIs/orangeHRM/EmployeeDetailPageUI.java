package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
	public static final String FIRST_NAME_TEXTBOX_AT_EMPLOYEE_FROM = "//input[@id='firstName']";
	public static final String MIDDLE_NAME_TEXTBOX_AT_EMPLOYEE_FROM = "//input[@id='middleName']";
	public static final String LAST_NAME_TEXTBOX_AT_EMPLOYEE_FROM = "//input[@id='lastName']";
	public static final String EMPLOYED_ID_TEXTBOX_AT_EMPLOYEE_FROM = "//input[@id='employeeId']";
	public static final String IMAGE_UPLOAD_FILE = "//input[@type='file']";
	//public static final String SAVE_BUTTON = "//input[@id='btnSave']";
	
	public static final String FULL_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//div[@id='profile-pic']//h1[text()='%s']";
	public static final String FIRST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_txtEmpFirstName']";
	public static final String MIDDLE_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_txtEmpMiddleName']";
	public static final String LAST_NAME_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_txtEmployeeId']";
	public static final String SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_txtNICNo']";
	public static final String GENDER_RDO_AT_PERSONAL_DETAIL_FROM = "//label[text()='%s']/preceding-sibling::input";
	public static final String MARIAL_STATUS_DRO_AT_PERSONAL_DETAIL_FROM = "//select[@id='personal_cmbMarital']";
	public static final String NATIONALITY_DRO_AT_PERSONAL_DETAIL_FROM = "//select[@id='personal_cmbNation']";
	public static final String DATE_OF_BIRTH_DRO_AT_PERSONAL_DETAIL_FROM = "//input[@id='personal_DOB']";
	public static final String SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FROM = "//div[contains(@class,'message success')]";
	public static final String SIDE_TAG_BAR_BY_NAME = "//ul[@id='sidenav']//a[text()='%s']";
	/*Salary*/
	public static final String PAYGRADE_DRO_AT_SALARY_FROM = "//select[@id='salary_sal_grd_code']";
	public static final String SALARY_COMPONENT_AT_SALARY_FROM = "//input[@id='salary_salary_component']";
	public static final String PAY_FREQUENCY_DRO_AT_SALARY_FROM = "//select[@id='salary_payperiod_code']";
	public static final String CURRENCY_DRO_AT_SALARY_FROM = "//select[@id='salary_currency_id']";
	public static final String AMOUNT_AT_SALARY_FROM = "//input[@id='salary_basic_salary']";
	public static final String COMENTS_AT_SALARY_FROM = "//textarea[@id='salary_comments']";
	public static final String COLLUM_NAME_INDEX = "//table[@id='%s']//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE_MIX_COLUMN_AND_ROW_INDEX = "//table[@id='%s']//tr[%s]/td[%s]";
	/*Job*/
	public static final String JOB_TITLE_DRO_AT_JOB_FROM = "//select[@id='job_job_title']";
	public static final String EMPLOYMENT_STATUS_DRO_AT_JOB_FROM = "//select[@id='job_emp_status']";
	public static final String JOB_CATEGORY_DRO_AT_JOB_FROM = "//select[@id='job_eeo_category']";
	public static final String JOINED_DATE_TXT_AT_JOB_FROM = "//input[@id='job_joined_date']";
	public static final String SUB_IN_DRO_AT_JOB_FROM = "//select[@id='job_sub_unit']";
	public static final String LOCATION_DRO_AT_JOB_FROM = "//select[@id='job_location']";
	public static final String START_DATE_TXT_AT_JOB_FROM = "//input[@id='job_contract_start_date']";
	public static final String END_DATE_TXT_AT_JOB_FROM = "//input[@id='job_contract_end_date']";
	/*Add Supervisor*/
	public static final String NAME_TXT_AT_REPORT_TO_FROM = "//input[@id='reportto_supervisorName_empName']";
	public static final String REPORTTING_METHOD_AT_REPORT_TO_FROM = "//select[@id='reportto_reportingMethodType']";




}
