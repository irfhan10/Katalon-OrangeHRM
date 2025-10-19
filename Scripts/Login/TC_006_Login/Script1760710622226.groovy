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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration as RC
import java.text.SimpleDateFormat as SimpleDateFormat


WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_SoftAssert'), [('username') : findTestData('TestDataLogin')
        , ('password') : findTestData('TestDataLogin')], FailureHandling.STOP_ON_FAILURE)


WebUI.delay(5)

// Input username & password
try {
	//Username
	try {
		WebUI.click(findTestObject('Login/input_Username'))
		WebUI.setText(findTestObject('Login/input_Username'), Username)
		KeywordUtil.markPassed("Berhasil input Username")
	} catch (Exception e) {
		KeywordUtil.markFailed("Gagal input Username")
	}
	
	// Password
	try {
		WebUI.click(findTestObject('Login/input_Password'))
		WebUI.setEncryptedText(findTestObject('Login/input_Password'), Password)
		KeywordUtil.markPassed('Berhasil input Password')
	} catch (Exception e) {
		KeywordUtil.markFailed('Gagal input Password')
	}

} catch (Exception e) {
	KeywordUtil.markFailed('Terjadi error saat login: ' + e.message)
}

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(5)

// Verifikasi hasil login berdasarkan nilai ExpectedResult
switch (ExpectedResult) {
	case 'Success':
		WebUI.verifyElementText(findTestObject('Login/h6_textDashboard'), 'Dashboard')
		break
	case 'InvalidCredentials':
		WebUI.verifyElementPresent(findTestObject('Login/message_error_invalid_credentials'), 5)
		break
	case 'Required':
		WebUI.verifyElementPresent(findTestObject('Login/span_TextRequired'), 5)
		break
	default:
		KeywordUtil.markFailed("Expected Result tidak dikenali : " + ExpectedResult)
}

WebUI.delay(5)

// Screenshoot
CustomKeywords.'login.loginpage.screenshoot'()

WebUI.closeBrowser()

