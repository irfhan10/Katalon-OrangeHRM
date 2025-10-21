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
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.delay(10)

try {
	// Hard Assertion Halaman Login
	WebUI.verifyElementText(findTestObject('Login/textlogin_h5'), findTestData('TestDataLogin').getValue('Lable', 1))

	WebUI.verifyElementText(findTestObject('Login/username_label'), findTestData('TestDataLogin').getValue('Lable', 2))

	WebUI.verifyElementText(findTestObject('Login/password_label'), findTestData('TestDataLogin').getValue('Lable', 3))
	
	WebUI.verifyElementAttributeValue(findTestObject('Login/input_Password'), 'type', 'password', 3)

	WebUI.verifyElementText(findTestObject('Login/button_Login'), findTestData('TestDataLogin').getValue('Lable', 1))

	WebUI.verifyElementText(findTestObject('Login/forgotpass_link'), findTestData('TestDataLogin').getValue('Lable', 4))

	WebUI.verifyElementVisible(findTestObject('Login/input_Username'))

	WebUI.verifyElementVisible(findTestObject('Login/input_Password'))
	
	WebUI.verifyElementVisible(findTestObject('Login/button_Login'))

	WebUI.verifyElementVisible(findTestObject('Login/forgotpass_link'))
	
	WebUI.verifyElementVisible(findTestObject('Login/icon_Linkedin'))
	
	WebUI.verifyElementVisible(findTestObject('Login/icon_Facebook'))
	
	WebUI.verifyElementVisible(findTestObject('Login/icon_Twitter'))
	
	WebUI.verifyElementVisible(findTestObject('Login/icon_Youtube'))

} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat verifikasi halaman login: " + e.message)
}

//Username
username = findTestData('TestDataLogin').getValue('Username', 1)

WebUI.click(findTestObject('Login/input_Username'))

WebUI.setText(findTestObject('Login/input_Username'), username)

// Password
encryptedPassword = findTestData('TestDataLogin').getValue('Password', 1)

WebUI.click(findTestObject('Login/input_Password'))

WebUI.setEncryptedText(findTestObject('Login/input_Password'), encryptedPassword)

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(3)

// Verifikasi URL
String dashboard_link = WebUI.getUrl()

WebUI.verifyMatch(dashboard_link, 'https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index', false)

WebUI.delay(3)