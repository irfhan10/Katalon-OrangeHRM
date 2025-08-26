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

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.verifyElementText(findTestObject('Login/textlogin_h5'), findTestData('TestDataLogin').getValue('Lable', 1))

WebUI.verifyElementText(findTestObject('Login/username_label'), findTestData('TestDataLogin').getValue('Lable', 2))

WebUI.verifyElementText(findTestObject('Login/password_label'), findTestData('TestDataLogin').getValue('Lable', 3))

WebUI.verifyElementText(findTestObject('Login/button_Login'), findTestData('TestDataLogin').getValue('Lable', 1))

WebUI.verifyElementText(findTestObject('Login/forgotpass_link'), findTestData('TestDataLogin').getValue('Lable', 4))

WebUI.verifyElementVisible(findTestObject('Login/input_Username_username'))

WebUI.verifyElementVisible(findTestObject('Login/input_Password_password'))

WebUI.verifyElementVisible(findTestObject('Login/button_Login'))

WebUI.verifyElementVisible(findTestObject('Login/forgotpass_link'))

WebUI.delay(5)

WebUI.click(findTestObject('Login/input_Username_username'))

WebUI.setText(findTestObject('Login/input_Username_username'), username)

WebUI.click(findTestObject('Login/input_Password_password'))

WebUI.setText(findTestObject('Login/input_Password_password'), password)

WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(5)

