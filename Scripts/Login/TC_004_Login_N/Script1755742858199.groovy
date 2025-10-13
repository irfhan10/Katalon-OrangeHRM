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

//WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_SoftAssert'), [('username') : findTestData('TestDataLogin').getValue(
//            'Username', 4), ('password') : findTestData('TestDataLogin').getValue('Password', 4)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login/LoginScreen/LoginScreen_SoftAssert'), [('username') : findTestData('TestDataLogin'), ('password') : findTestData('TestDataLogin')],
	FailureHandling.STOP_ON_FAILURE)

// Input username
try {
	username = findTestData('TestDataLogin').getValue('Username', 4)
	if (username != null && username.trim() != '') {
		WebUI.click(findTestObject('Login/input_Username_username'))
		WebUI.setText(findTestObject('Login/input_Username_username'), username)
		KeywordUtil.markPassed("Berhasil input Username")
	} else {
		KeywordUtil.markFailed("Gagal input Username")
	}

} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat login: " + e.message)
}

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(3)

// Verifikasi alert required
try { 
	if (WebUI.verifyElementPresent(findTestObject('Login/span_TextRequired'), 10)) {
		KeywordUtil.markPassed("Berhasil menampilkan alert error 'Required'.")
	} else {
		KeywordUtil.markFailed("Alert error 'Required' tidak tampil.")
	}

	if (WebUI.verifyElementText(findTestObject('Login/span_TextRequired'), findTestData('TestDataLogin').getValue('MessageError', 2))) {
		KeywordUtil.markPassed("Alert error sesuai dengan test data.")
	} else {
		KeywordUtil.markFailed("Alert error tidak sesuai dengan test data.")
	}

} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat verifikasi: " + e.message)
}

WebUI.delay(3)

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()

