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


suiteProperties.put('id', 'Test Suites/Bookings')

suiteProperties.put('name', 'Bookings')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DAPL-Asset-180\\Desktop\\project folder\\Workilo\\WorkiloAutomation(14.8.19)\\Reports\\Bookings\\20190819_132826\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Bookings', suiteProperties, [new TestCaseBinding('Test Cases/Workilo/Bookings/Customer/PlaceOrderBySearchTestMode', 'Test Cases/Workilo/Bookings/Customer/PlaceOrderBySearchTestMode',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/InboxAcceptOrder', 'Test Cases/Workilo/Bookings/ServiceProvider/InboxAcceptOrder',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/NewBookingOrder', 'Test Cases/Workilo/Bookings/ServiceProvider/NewBookingOrder',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/Customer/CustomerInbox', 'Test Cases/Workilo/Bookings/Customer/CustomerInbox',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/TaskCompleted', 'Test Cases/Workilo/Bookings/ServiceProvider/TaskCompleted',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/ALLorder', 'Test Cases/Workilo/Bookings/ServiceProvider/ALLorder',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/InboxVerifyMessageDetail', 'Test Cases/Workilo/Bookings/ServiceProvider/InboxVerifyMessageDetail',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/OrderCompleted', 'Test Cases/Workilo/Bookings/ServiceProvider/OrderCompleted',  null), new TestCaseBinding('Test Cases/Workilo/Bookings/ServiceProvider/InboxVerifyMessageDetail', 'Test Cases/Workilo/Bookings/ServiceProvider/InboxVerifyMessageDetail',  null)])
