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

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_SoftAssert'), [('username') : findTestData('TestDataLogin').getValue(
            'Username', 1), ('password') : findTestData('TestDataLogin').getValue('Password', 1)], FailureHandling.STOP_ON_FAILURE)

dashboard_link = WebUI.getUrl()

WebUI.verifyMatch(dashboard_link, findTestData('TestDataLogin').getValue('url', 2), false)

WebUI.delay(3)

WebUI.takeFullPageScreenshot()

WebUI.delay(3)

WebUI.click(findTestObject('Menu PIM/click_menu_PIM'))

WebUI.delay(3)

String strEmpId = '0367'
WebUI.click(findTestObject('Menu PIM/EmpId_Object', [('EmpId'):strEmpId]))

WebUI.delay(5)

WebUI.takeFullPageScreenshot()

WebUI.delay(3)

WebUI.closeBrowser()