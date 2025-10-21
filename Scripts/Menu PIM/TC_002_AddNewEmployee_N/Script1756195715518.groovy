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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RC


WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_HardAssert'), [:], FailureHandling.STOP_ON_FAILURE)

dashboard_link = WebUI.getUrl()

WebUI.verifyMatch(dashboard_link, findTestData('TestDataLogin').getValue('url', 2), false)

WebUI.delay(3)

String projectDir = RC.getProjectDir()
String timestamp = new Date().format("dd-MM-yyyy_HH-mm-ss")

String screenshotPIM = projectDir + "/Screenshots/Menu PIM/TC_002_Halaman_Dashboard_" + timestamp + ".png"
WebUI.takeFullPageScreenshot(screenshotPIM)

WebUI.delay(3)

WebUI.click(findTestObject('Menu PIM/click_menu_PIM'))

WebUI.verifyTextPresent('PIM', false)

WebUI.delay(3)

WebUI.click(findTestObject('Menu PIM/button_Add'))

WebUI.verifyTextPresent('Add Employee', false)

WebUI.delay(3)

// Generate username unik dengan timestamp
// String randomFirstname = 'First' + System.currentTimeMillis()

String randomMiddlename = 'Middle' + System.currentTimeMillis()

String randomLastname = 'Last' + System.currentTimeMillis()

String randomEmployeeId = RandomStringUtils.randomNumeric(2)

WebUI.verifyElementPresent(findTestObject('Menu PIM/input_FirstName'), 3)

WebUI.click(findTestObject('Menu PIM/input_FirstName'))

WebUI.setText(findTestObject('Menu PIM/input_FirstName'), 'CancelTest')

WebUI.verifyElementPresent(findTestObject('Menu PIM/input_MiddleName'), 3)

WebUI.click(findTestObject('Menu PIM/input_MiddleName'))

WebUI.setText(findTestObject('Menu PIM/input_MiddleName'), randomMiddlename)

WebUI.verifyElementPresent(findTestObject('Menu PIM/input_LastName'), 3)

WebUI.click(findTestObject('Menu PIM/input_LastName'))

WebUI.setText(findTestObject('Menu PIM/input_LastName'), randomLastname)

WebUI.verifyElementPresent(findTestObject('Menu PIM/input_EmployeeId'), 3)

WebUI.click(findTestObject('Menu PIM/input_EmployeeId'))

WebUI.setText(findTestObject('Menu PIM/input_EmployeeId'), randomEmployeeId)

WebUI.delay(3)

String filePath = RunConfiguration.getProjectDir() + '/Test Data/gambar1.jpg'

WebUI.verifyElementPresent(findTestObject('Menu PIM/button_AddEmployeeProfile'), 3)

WebUI.uploadFile(findTestObject('Menu PIM/button_AddEmployeeProfile'), filePath)

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Menu PIM/button_Cancel'), 3)

WebUI.click(findTestObject('Menu PIM/button_Cancel'))

WebUI.delay(5)

WebUI.closeBrowser()

