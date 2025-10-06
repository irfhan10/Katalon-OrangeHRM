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

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen'), [('username') : findTestData('TestDataLogin').getValue(
            'Username', 1), ('password') : findTestData('TestDataLogin').getValue('Password', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/menu_Admin'))

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/input_Username'))

WebUI.setText(findTestObject('Menu Admin/input_Username'), 'Testing')

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/button_Search'))

WebUI.delay(3)

WebUI.click(findTestObject('Menu Admin/button_Edit'))

WebUI.delay(3)

notchecked = WebUI.verifyElementNotChecked(findTestObject('Menu Admin/checkbox_Yes'), 0)

if (notchecked == true) {
    WebUI.click(findTestObject('Menu Admin/checkbox_Yes'))

    WebUI.verifyElementVisible(findTestObject('Menu Admin/input_Password'))

    WebUI.verifyElementVisible(findTestObject('Menu Admin/input_Confirm Password'))

    WebUI.click(findTestObject('Menu Admin/input_Password'))

    WebUI.setText(findTestObject('Menu Admin/input_Password'), 'admin123')

    WebUI.click(findTestObject('Menu Admin/input_Confirm Password'))

    WebUI.setText(findTestObject('Menu Admin/input_Confirm Password'), 'admin123')

    WebUI.delay(3)

    WebUI.click(findTestObject('Menu Admin/button_Save'))

    WebUI.delay(5)
} else {
    WebUI.click(findTestObject('Menu Admin/button_Save'))

    WebUI.delay(3)
}

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()

