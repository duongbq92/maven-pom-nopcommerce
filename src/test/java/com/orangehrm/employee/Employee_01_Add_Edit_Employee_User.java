package com.orangehrm.employee;

import commons.AbstractTest;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeDetailPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGeneratorManager;
import pageObjects.orangeHRM.UserDetailPageObject;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Employee_01_Add_Edit_Employee_User extends AbstractTest {

	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeeDetailPage;
	UserDetailPageObject userDetailPage;
	EmployeeListPageObject employeeListPage;
	String userName, passWord, firstName, middleName, lastName, employeeID, editFirstName, editMiddleName;
	String editLastName, editSSN, editGender, editMaritalStatus, editNationality, editDatOfBirth;
	String payGrade, salaryComponent, payFrequency, currency, amount, components;
	String jobTitle, employmentStatus, jobCaterogy, joinedDate, subUnit, location, startDate, endDate;
	String supervisorName, reporttingMethod;
	String fileName = "Hana1.jpg";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {
		userName = "Admin";
		passWord = "admin123";
		firstName = "Bui";
		middleName = "Nhat";
		lastName = "Ha" + getRamdomNumber();
		editFirstName = "Hana";
		editMiddleName = "Nhat";
		editLastName = "Ha" + getRamdomNumber();
		editSSN = "837-96-6611";
		editGender = "Male";
		editMaritalStatus = "Single";
		editNationality = "Vietnamese";
		editDatOfBirth = "1992-05-05";

		payGrade = "Grade 1";
		salaryComponent = editFirstName + "-Annual Basic Payment";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amount = "50000";
		components = "Salary per month";

		jobTitle = "QA Engineer";
		employmentStatus = "Full-Time Permanent";
		jobCaterogy = "Technicians";
		joinedDate = "2019-05-05";
		subUnit = "  Quality Assurance";
		location = "Texas R&D";
		startDate = "2019-07-05";
		endDate = "2020-05-05";
		
		supervisorName = "David Morris";
		reporttingMethod = "Direct";
		driver = getBrowserDriver(browser, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Precondition step 01: Input Username textbox with " + userName);
		loginPage.enterToUserName(userName);

		log.info("Precondition step 02: Input Password textbox with " + passWord);
		loginPage.enterToPasswordTextbox(passWord);

		log.info("Precondition step 03: Click to Login button");
		dashboardPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Employee_01_Add_Employee() {
		log.info("Add Employee - Step 01: Open Page PIM");
		dashboardPage.openMenuWithPageName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add Employee - Step 02: Click to add btn");
		employeeDetailPage = employeeListPage.clickToAddButton();

		log.info("Add Employee - Step 03: Input to FirstName with " + firstName);
		employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstName);

		log.info("Add Employee - Step 04:Input to MiddleName with " + middleName);
		employeeDetailPage.enterToMiddleNameTextboxAtAddEmployeeForm(middleName);

		log.info("Add Employee - Step 05: Input to LastName with " + lastName);
		employeeDetailPage.enterToLastNameTextboxAtAddEmployeeForm(lastName);

		log.info("Add Employee - Step 06: Get employee Id");
		employeeID = employeeDetailPage.getEmpoyeeIDAtAddEmployeeForm();

		log.info("Add Employee - Step 07: Upload avatar");
		employeeDetailPage.uploadMutilFileInOrangeHRM(driver, fileName);

		log.info("Add Employee - Step 08: Click to save btn");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Employee", "Save");

		log.info("Add Employee - Step 09: Verify fullname header");
		verifyTrue(employeeDetailPage.isFullNameDisplayAtHeader(firstName + " " + middleName + " " + lastName));

		log.info("Add Employee - Step 10: Verify FirstName" + firstName);
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), firstName);

		log.info("Add Employee - Step 11: Verify MiddleName" + middleName);
		verifyEquals(employeeDetailPage.getMiddleNameValueAtPersonalDetailForm(), middleName);

		log.info("Add Employee - Step 12: Verify LastName" + lastName);
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), lastName);

		log.info("Add Employee - Step 13: Verify EmployeeID" + employeeID);
		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);

	}

//	@Test
	public void Employee_02_Edit_Employee_By_Personal() {
		log.info("Edit Employee[Personal] - Step 01: Click to 'Edit' button at 'Personal Details' form ");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Personal Details", "Edit");

		log.info("Edit Employee[Personal] - Step 02: Enter new info to 'First Name' textbox with value : "
				+ editFirstName);
		employeeDetailPage.enterToFirstTxtNameAtPersonalDetail(editFirstName);

		log.info("Edit Employee[Personal] - Step 03: Enter new info to 'Middle Name' textbox with value : "
				+ editMiddleName);
		employeeDetailPage.enterToMiddleTxtNameAtPersonalDetail(editMiddleName);

		log.info("Edit Employee[Personal] - Step 04: Enter new info to 'Last Name' textbox with value : "
				+ editLastName);
		employeeDetailPage.enterToLastTxtNameAtPersonalDetail(editLastName);

		log.info("Edit Employee[Personal] - Step 05: Enter new info to 'SSN Number' textbox  with value : " + editSSN);
		employeeDetailPage.enterSSNNumberTxtNameAtPersonalDetail(editSSN);

		log.info("Edit Employee[Personal] - Step 06: Click to 'Gender' radio with " + editGender + "");
		employeeDetailPage.clickToGenderRdoAtPersonalDetail(editGender);

		log.info("Edit Employee[Personal] - Step 07: Select to 'Marital Status' dropdown with '" + editMaritalStatus
				+ " ");
		employeeDetailPage.selMaritalStatusDropdownAtPersonalDetail(editMaritalStatus);

		log.info("Edit Employee[Personal] - Step 08: Select to 'Nationality' dropdown with " + editNationality + " ");
		employeeDetailPage.selNationalityDropdownAtPersonalDetail(editNationality);

		log.info("Edit Employee[Personal] - Step 09: Enter new info to 'Date of birth' textbox with value : "
				+ editDatOfBirth + "");
		employeeDetailPage.enterDateOfBirthTxtNameAtPersonalDetail(editDatOfBirth);

		log.info("Edit Employee[Personal] - Step 10: Click to 'Save' button at 'Personal Detail' form ");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Personal Details", "Save");

		log.info("Edit Employee[Personal] - Step 11: Verify success message display with value 'Successfully Saved' ");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetail(), "Successfully Saved");

		log.info("Edit Employee[Personal] - Step 012: Verify 'First Name' textbox edit successfully");
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), editFirstName);

		log.info("Edit Employee[Personal] - Step 013: Verify 'Midele Name' textbox edit successfully ");
		verifyEquals(employeeDetailPage.getMiddleNameValueAtPersonalDetailForm(), editMiddleName);

		log.info("Edit Employee[Personal] - Step 014: Verify 'Last Name' textbox edit successfully ");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), editLastName);

		log.info("Edit Employee[Personal] - Step 015: Verify 'SSN Number' textbox edit successfully ");
		verifyEquals(employeeDetailPage.getSSNNumberValueAtPersonalDetail(), editSSN);

		log.info("Edit Employee[Personal] - Step 016: Verify 'Gender' textbox edit successfully ");
		verifyTrue(employeeDetailPage.isGenderRdoBtnSelAtPersonalDetail(editGender));

		log.info("Edit Employee[Personal] - Step 017: Verify 'Marital Status' dropdown edit successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfMaritalStatusDroAtPersonalDetail(), editMaritalStatus);

		log.info("Edit Employee[Personal] - Step 018: Verify 'Nationality ' dropdown edit successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfNationalityDroAtPersonalDetail(), editNationality);

		log.info("Edit Employee[Personal] - Step 020: Verify 'Date of birth ' dropdown edit successfully ");
		verifyEquals(employeeDetailPage.getDateOfBirtValueAtPersonalDetail(), editDatOfBirth);

	}

//	@Test
	public void Employee_03_Edit_By_Salary() {
		log.info("Edit Employee[Salary] - Step 01: Open 'Salary' tag ");
		employeeDetailPage.openSideBarTabByName("Salary");

		log.info("Edit Employee[Salary] - Step 02: Click to 'Add' button at 'Salary'  ");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Assigned Salary Components", "Add");

		log.info("Edit Employee[Salary] - Step 03: Select to 'Pay Grade' dropdown with value : " + payGrade);
		employeeDetailPage.selPayGradeDroAtSalary(payGrade);

		log.info("Edit Employee[Salary] - Step 04: Enter to 'Salary Component' textbox with value " + salaryComponent);
		employeeDetailPage.enterSalaryCommentTxtAtSalary(salaryComponent);

		log.info("Edit Employee[Salary] - Step 05: Select to 'Pay Frequency' dropdown with value" + payFrequency);
		employeeDetailPage.selPayFrequencyDroAtSalary(payFrequency);

		log.info("Edit Employee[Salary] - Step 06: Select to 'Currency ' dropdown with value " + currency);
		employeeDetailPage.selCurrencyDroAtSalary(currency);

		log.info("Edit Employee[Salary] - Step 07: Enter to 'Amount ' textbox with value  " + amount);
		employeeDetailPage.enterAmountTxtAtSalary(amount);

		log.info("Edit Employee[Salary] - Step 08: Enter to 'Comments' textbox with value " + components);
		employeeDetailPage.enterCommentsTxtAtSalary(components);

		log.info("Edit Employee[Salary] - Step 09: Click to 'Save' button at 'Salary' form ");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Salary Component", "Save");

		log.info("Edit Employee[Salary] - Step 09: Verify Salary table are display successfully ");
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "tblSalary", "Salary Component",
				"1", salaryComponent));
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "tblSalary", "Pay Frequency",
				"1", payFrequency));
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "tblSalary", "Currency", "1",
				currency));
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "tblSalary", "Amount", "1",
				amount));
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "tblSalary", "Comments", "1",
				components));
	}

//	@Test
	public void Employee_04_Edit_By_Job() {
		log.info("Edit Employee[Job] - Step 01: Open 'Job' tag ");
		employeeDetailPage.openSideBarTabByName("Job");

		log.info("Edit Employee[Job] - Step 02: Click to Edit button at Job");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Job", "Edit");

		log.info("Edit Employee[Job] - Step 03: Select 'Job Title' with :"+jobTitle);
		employeeDetailPage.selJobTitlesDropdownAtJobl(jobTitle);
		
		log.info("Edit Employee[Job] - Step 04: Select 'Employment Status' with :"+employmentStatus);
		employeeDetailPage.selEmploymentStatusDropdownAtJob(employmentStatus);
		
		log.info("Edit Employee[Job] - Step 05: Select 'Job Catagory' with :"+jobCaterogy);
		employeeDetailPage.selJobCatagoryDropdownAtJob(jobCaterogy);

		log.info("Edit Employee[Job] - Step 06: Input 'Joined Date' with :"+joinedDate);
		employeeDetailPage.enterJoinedDateTxtAtJob(joinedDate);

		log.info("Edit Employee[Job] - Step 07: Select 'Sub Unit' with :"+subUnit);
		employeeDetailPage.selSubUnitDropdownAtJob(subUnit);

		log.info("Edit Employee[Job] - Step 08: Select 'Location' with :"+location);
		employeeDetailPage.selLocationsDropdownAtJob(location);

		log.info("Edit Employee[Job] - Step 09: Input 'Start Date' with :"+startDate);
		employeeDetailPage.enterStartDateDropdownAtJob(startDate);

		log.info("Edit Employee[Job] - Step 10: Input 'End Date' with :"+endDate);
		employeeDetailPage.enterEndDateDropdownAtJob(endDate);

		log.info("Edit Employee[Job] - Step 11: Click to Save button at Job");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Job", "Save");

		log.info("Edit Employee[Job] - Step 012: Verify 'Job Title' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfJobTitleStatusDroAtJob(), jobTitle);
		
		log.info("Edit Employee[Job] - Step 013: Verify 'Employment Status' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfEmploymentStatusDroAtJob(), employmentStatus);
		
		log.info("Edit Employee[Job] - Step 014: Verify 'Job Catagory' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfJobCatagoryDroAtJob(), jobCaterogy);
		
		log.info("Edit Employee[Job] - Step 015: Verify 'Joined Date' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getJoinedDateValueAtJob(), joinedDate);
		
		log.info("Edit Employee[Job] - Step 016: Verify 'Sub Unit' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfSubUnitDroAtJob(), subUnit);
		
		log.info("Edit Employee[Job] - Step 017: Verify 'Location' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getSelItemOfLocationDroAtJob(), location);
		
		log.info("Edit Employee[Job] - Step 018: Verify 'Start Date' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getStartDateValueAtPersonalDetail(), startDate);
		
		log.info("Edit Employee[Job] - Step 019: Verify 'End Date' dropdown edited successfully ");
		verifyEquals(employeeDetailPage.getEndDateValueAtPersonalDetail(), endDate);
		

	}

//	@Test
	public void Employee_05_Edit_Report() {
		log.info("Edit Employee[Report-to]] - Step 01: Open 'Report-to' tag ");
		employeeDetailPage.openSideBarTabByName("Report-to");
		
		log.info("Edit Employee[Report-to] - Step 02: Click to Add button at Report-to");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Assigned Supervisors", "Add");
		
		log.info("Edit Employee[Report-to] - Step 03: Enter Name at Add Supervior with value : "+supervisorName);
		employeeDetailPage.enterNameTxtAtReportTo(supervisorName);
		
		log.info("Edit Employee[Report-to] - Step 04: Select Reporting Method at 'Add Supervior' with value : "+reporttingMethod);
		employeeDetailPage.selReporttingMethodDroAtReportTo(reporttingMethod);
		
		log.info("Edit Employee[Report-to] - Step 05: Click to Save button at 'Add Supervisor'");
		employeeDetailPage.clickToButtonByNameAtFromHeader(driver, "Add Supervisor", "Save");
		
		log.info("Edit Employee[Report-to] - Step 06: Verify at 'Add Supervisor'");
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "sup_list", "Name","1", supervisorName));
		verifyTrue(employeeDetailPage.isInformationDisplayCollumNameAtRowNumber(driver, "sup_list", "Reporting Method","1", reporttingMethod));
	}

//	@Test
	public void Employee_06_Search_Employee() {
		log.info("Search Employee - Step 01: Open Page PIM page menu");
		employeeDetailPage.openMenuWithPageName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		
		log.info("Search Employee - Step 02: Enter to 'Employee Name' textbox with value : "+editFirstName+" "+editMiddleName+" "+editLastName);
		employeeListPage.enterEmployeeNameTxt(editFirstName + " " + editMiddleName + " " + editLastName);
		
		log.info("Search Employee - Step 03: Enter to 'Id' textbox with value : "+employeeID);
		employeeListPage.enterEmployeeIDTxt(employeeID);
		
		log.info("Search Employee - Step 04: Select to 'Employment Status' dropdown with value : "+employmentStatus);
		employeeListPage.selEmploymentStatusDro(employmentStatus);
		
		log.info("Search Employee - Step 05: Enter to 'Include' dropdown with value : ");
		employeeListPage.selIncludeDro("Current Employees Only");
		
		log.info("Search Employee - Step 06: Enter to 'Supervisor  Name' textbox with value : "+supervisorName);
		employeeListPage.enterSupervisorTxt(supervisorName);
		
		log.info("Search Employee - Step 07: Select to 'Job Title' dropdown with value : "+jobTitle);
		employeeListPage.selJobTitlleDro(jobTitle);
		
		log.info("Search Employee - Step 08: Select to 'Sub Unit' dropdown with value : "+subUnit);
		employeeListPage.selSubUnitDro(subUnit);
		
		log.info("Search Employee - Step 09: Click to 'Search' button at Employee Inpformation");
		employeeListPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Search");

//		log.info("Search Employee - Step 10: Click to 'Reset' button at Employee Inpformation");
//		employeeListPage.clickToButtonByNameAtFromHeader(driver, "Employee Information", "Reset");

	}

	@Test
	public void Employee_07_Search_User() {

	}

	@Test
	public void Employee_08_Delete_User() {

	}

	@Test
	public void Employee_09_Delete_User() {

	}

	@Test
	public void Employee_10_Search_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
