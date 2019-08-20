import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/CustomerSignUp')

suiteProperties.put('name', 'CustomerSignUp')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DAPL-Asset-180\\Desktop\\project folder\\Workilo\\WorkiloAutomation(14.8.19)\\Reports\\CustomerSignUp\\20190820_162941\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/CustomerSignUp', suiteProperties, [new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/InvalidEmailIdLogin', 'Test Cases/Workilo/Sign Up/RegistrationValidation/InvalidEmailIdLogin',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/InvalidPwdLogin', 'Test Cases/Workilo/Sign Up/RegistrationValidation/InvalidPwdLogin',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpBlankValidation', 'Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpBlankValidation',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidContact', 'Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidContact',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidEmail', 'Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidEmail',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidFirstLastName', 'Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidFirstLastName',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidPWD', 'Test Cases/Workilo/Sign Up/RegistrationValidation/SignUpValidationInvalidPWD',  null), new TestCaseBinding('Test Cases/Workilo/Sign Up/CustSignUp', 'Test Cases/Workilo/Sign Up/CustSignUp',  null)])
