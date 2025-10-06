import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen'), [('username') : findTestData('TestDataLogin').getValue(
            'Username', 1), ('password') : findTestData('TestDataLogin').getValue('Password', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/menu_Admin'))

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/button_Add'))

WebUI.delay(3)

// Pilih role
WebUI.click(findTestObject('Menu Admin/div_UserRole'))

String role = 'Admin'

TestObject optionrole = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//div[@role=\'option\']//span[normalize-space(text())=\'' + 
    role) + '\']')

WebUI.waitForElementVisible(optionrole, 5)

WebUI.click(optionrole)

WebUI.delay(1)

// Pilih status
WebUI.click(findTestObject('Menu Admin/div_Status'))

String status = 'Enabled'

TestObject optionstatus = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//div[@role=\'option\']//span[normalize-space(text())=\'' + 
    status) + '\']')

WebUI.waitForElementVisible(optionstatus, 5)

WebUI.click(optionstatus)

WebUI.delay(1)

WebUI.setText(findTestObject('Page_OrangeHRM/input_EmployeeName'), 'Amelia')

// Tunggu sampai suggestion muncul
TestObject suggestion = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//div[@role='listbox']//span[contains(text(),'Amelia')]")

WebUI.waitForElementVisible(suggestion, 5)

// Klik langsung pada hasil suggestion
WebUI.click(suggestion)

WebUI.delay(1)

WebUI.setText(findTestObject('Page_OrangeHRM/input_Username'), 'TestingHRM')

