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
import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.configuration.RunConfiguration

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen'), [('username') : findTestData('TestDataLogin').getValue(
            'Username', 1), ('password') : findTestData('TestDataLogin').getValue('Password', 1)], FailureHandling.STOP_ON_FAILURE)

dashboard_link = WebUI.getUrl()

WebUI.verifyMatch(dashboard_link, findTestData('TestDataLogin').getValue('url', 2), false)

WebUI.delay(3)

WebUI.takeFullPageScreenshot()

WebUI.delay(3)

WebUI.click(findTestObject('Menu PIM/click_menu_PIM'))

WebUI.delay(3)

WebUI.click(findTestObject('Menu PIM/button_Add'))

WebUI.delay(3)

// Generate username unik dengan timestamp
String randomFirstname = 'First' + System.currentTimeMillis()

String randomMiddlename = 'Middle' + System.currentTimeMillis()

String randomLastname = 'Last' + System.currentTimeMillis()

String randomEmployeeId = RandomStringUtils.randomNumeric(2)

WebUI.click(findTestObject('Menu PIM/input_Employee Full Name_firstName'))

WebUI.setText(findTestObject('Menu PIM/input_Employee Full Name_firstName'), randomFirstname)

WebUI.click(findTestObject('Menu PIM/input_Employee Full Name_middleName'))

WebUI.setText(findTestObject('Menu PIM/input_Employee Full Name_middleName'), randomMiddlename)

WebUI.click(findTestObject('Menu PIM/input_Employee Full Name_lastName'))

WebUI.setText(findTestObject('Menu PIM/input_Employee Full Name_lastName'), randomLastname)

WebUI.click(findTestObject('Menu PIM/input_Employee Id'))

WebUI.setText(findTestObject('Menu PIM/input_Employee Id'), randomEmployeeId)

WebUI.delay(3)

String filePath = RunConfiguration.getProjectDir() + '/Data Files/gambar1.jpg'

WebUI.uploadFile(findTestObject('Menu PIM/button_AddEmployeeProfile'), filePath)

WebUI.delay(3)

WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Menu PIM/button_Save'))

WebUI.delay(15)

WebUI.closeBrowser()