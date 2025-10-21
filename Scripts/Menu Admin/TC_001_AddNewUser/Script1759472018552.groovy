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

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_HardAssert'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

// Klik menu admin
WebUI.click(findTestObject('Menu Admin/menu_Admin'))

WebUI.delay(3)

WebUI.verifyTextPresent('User Management', false)

/// Klik add button
WebUI.click(findTestObject('Menu Admin/button_Add'))

WebUI.verifyTextPresent('Admin', false)

WebUI.delay(3)

// Pilih role
WebUI.verifyElementPresent(findTestObject('Menu Admin/div_UserRole'), 3)

WebUI.click(findTestObject('Menu Admin/div_UserRole'))

String role = 'Admin'

TestObject optionrole = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//div[@role=\'option\']//span[normalize-space(text())=\'' + role) + '\']')

WebUI.waitForElementVisible(optionrole, 5)

WebUI.click(optionrole)

WebUI.delay(3)

// Pilih status
WebUI.verifyElementPresent(findTestObject('Menu Admin/div_Status'), 3)

WebUI.click(findTestObject('Menu Admin/div_Status'))

String status = 'Enabled'

TestObject optionstatus = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//div[@role=\'option\']//span[normalize-space(text())=\'' + status) + '\']')

WebUI.waitForElementVisible(optionstatus, 5)

WebUI.click(optionstatus)

WebUI.delay(1)

// Employee name
WebUI.verifyElementPresent(findTestObject('Menu Admin/input_EmployeeName'), 3)

WebUI.setText(findTestObject('Menu Admin/input_EmployeeName'), 'Amelia')

// Tunggu sampai suggestion muncul
TestObject suggestion = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@role=\'listbox\']//span[contains(text(),\'Amelia\')]')

WebUI.waitForElementVisible(suggestion, 5)

// Klik langsung pada hasil suggestion
WebUI.click(suggestion)

WebUI.delay(3)

// Input username
WebUI.verifyElementPresent(findTestObject('Menu Admin/input_Username'), 3)

String randomUsername = 'UserTest' + System.currentTimeMillis()

WebUI.click(findTestObject('Menu Admin/input_Username'))

WebUI.setText(findTestObject('Menu Admin/input_Username'), randomUsername)

WebUI.delay(3)

// Input password
WebUI.verifyElementPresent(findTestObject('Menu Admin/input_Password'), 3)

WebUI.setText(findTestObject('Menu Admin/input_Password'), 'Test1234')

// Input confirm password
WebUI.verifyElementPresent(findTestObject('Menu Admin/input_Confirm_Password'), 3)

WebUI.setText(findTestObject('Menu Admin/input_Confirm_Password'), 'Test1234')

WebUI.delay(3)

// Klik button save
WebUI.verifyElementPresent(findTestObject('Menu Admin/button_Save'), 3)

WebUI.click(findTestObject('Menu Admin/button_Save'))

WebUI.closeBrowser()


