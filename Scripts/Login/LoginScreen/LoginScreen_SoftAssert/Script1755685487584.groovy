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
	// Soft Assertion Halaman Login
	if (WebUI.verifyElementText(findTestObject('Login/textlogin_h5'), findTestData('TestDataLogin').getValue('Lable', 1), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Login H5'")
	} else {
		KeywordUtil.markFailed("Teks 'Login H5' tidak ditemukan")
	}

	if (WebUI.verifyElementText(findTestObject('Login/username_label'), findTestData('TestDataLogin').getValue('Lable', 2), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Username'")
	} else {
		KeywordUtil.markFailed("Teks 'Username' tidak ditemukan")
	}

	if (WebUI.verifyElementText(findTestObject('Login/password_label'), findTestData('TestDataLogin').getValue('Lable', 3), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Password'")
	} else {
		KeywordUtil.markFailed("Teks 'Password' tidak ditemukan")
	}
	
	if (WebUI.verifyElementAttributeValue(findTestObject('Login/input_Password'), 'type', 'password', 3, FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Type 'Password' sesuai ")
	} else {
		KeywordUtil.markFailed("Type'Password' tidak disesuai")
	}

	if (WebUI.verifyElementText(findTestObject('Login/button_Login'), findTestData('TestDataLogin').getValue('Lable', 1), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Login' pada button")
	} else {
		KeywordUtil.markFailed("Teks 'Login' pada button tidak ditemukan")
	}

	if (WebUI.verifyElementText(findTestObject('Login/forgotpass_link'), findTestData('TestDataLogin').getValue('Lable', 4), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Forgot your password?'")
	} else {
		KeywordUtil.markFailed("Teks 'Forgot your password?' tidak ditemukan")
	}

	if (WebUI.verifyElementVisible(findTestObject('Login/input_Username'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan field 'Username'")
	} else {
		KeywordUtil.markFailed("Field 'Username' tidak ditemukan")
	}

	if (WebUI.verifyElementVisible(findTestObject('Login/input_Password'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan field 'Password'")
	} else {
		KeywordUtil.markFailed("Field 'Password' tidak ditemukan")
	}

	if (WebUI.verifyElementVisible(findTestObject('Login/button_Login'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan button 'Login'")
	} else {
		KeywordUtil.markFailed("Button 'Login' tidak terlihat")
	}

	if (WebUI.verifyElementVisible(findTestObject('Login/forgotpass_link'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Halaman login menampilkan link 'Forgot your password?'")
	} else {
		KeywordUtil.markFailed("Link 'Forgot your password?' tidak terlihat")
	}

} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat verifikasi halaman login: " + e.message)
}

// Verifikasi sosial media
try {
	if(WebUI.verifyElementVisible(findTestObject('Login/icon_Linkedin'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Logo 'LinkedIn' tampil pada halaman login.")
	} else {
		KeywordUtil.markFailed("Logo 'LinkedIn' tidak tampil")
	}
	
	if(WebUI.verifyElementVisible(findTestObject('Login/icon_Facebook'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Logo 'Facebook' tampil pada halaman login.")
	} else {
		KeywordUtil.markFailed("Logo 'Facebook' tidak tampil")
	}
	
	if(WebUI.verifyElementVisible(findTestObject('Login/icon_Twitter'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Logo 'Twitter' tampil pada halaman login.")
	} else {
		KeywordUtil.markFailed("Logo 'Twitter' tidak tampil")
	}
	
	if(WebUI.verifyElementVisible(findTestObject('Login/icon_Youtube'), FailureHandling.CONTINUE_ON_FAILURE)) {
		KeywordUtil.markPassed("Logo 'Youtube' tampil pada halaman login.")
	} else {
		KeywordUtil.markFailed("Logo 'Youtube' tidak tampil")
	}

} catch (Exception e) {
	KeywordUtil.markFailed("Error saat verifikasi sosial media: " + e.message)
}

WebUI.delay(3)