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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

try {
	// Assertion Halaman Login
	if (WebUI.verifyTextPresent('Login', true, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("Halaman login menampilkan teks 'Login'")
	} else {
		KeywordUtil.markFailed("Teks 'Login' tidak ditemukan")
	}
	
	if (WebUI.verifyElementPresent(findTestObject('Login/input_Username_username'), 3, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("Field Username tampil dihalaman login")
	} else {
		KeywordUtil.markFailed("Field Username tidak ditemukan")
	}
	
	if (WebUI.verifyElementPresent(findTestObject('Login/input_Password_password'), 3, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("Field Password tampil dihalaman login")
	} else {
		KeywordUtil.markFailed("Field Password tidak ditemukan")
	}
	
	if (WebUI.verifyElementPresent(findTestObject('Login/button_Login'), 3, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("Button login tampil dihalaman login")
	} else {
		KeywordUtil.markFailed("Button login tidak ditemukan")
	}
	
	if (WebUI.verifyElementPresent(findTestObject('Login/password_label'), 3, FailureHandling.OPTIONAL)) {
		KeywordUtil.markPassed("Label Forgot Your Password tampil dihalaman login")
	} else {
		KeywordUtil.markFailed("Label Forgot Your Password tidak ditemukan")
	}
	
} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat verifikasi halaman login: " + e.message)
}

WebUI.click(findTestObject('Login/input_Username_username'))

WebUI.setText(findTestObject('Login/input_Username_username'), findTestData('TestDataLogin').getValue('Username', 1))

WebUI.click(findTestObject('Login/input_Password_password'))

WebUI.setText(findTestObject('Login/input_Password_password'), findTestData('TestDataLogin').getValue('Password', 1))

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(5)

try {
	// Assertion Halaman Dashboard
	if (WebUI.verifyTextPresent('Dashboard', true, FailureHandling.OPTIONAL) ) {
		KeywordUtil.markPassed("Halaman dashboard menampilkan teks 'Dashboard'")
	} else {
		KeywordUtil.markFailed("Teks 'Dashboard' tidak ditemukan")
	}
} catch (Exception e) {
	KeywordUtil.markFailed("Terjadi error saat verifikasi halaman dashboard: " + e.message)
}

WebUI.delay(5)

// Ambil nama akun dari UI
accountname = WebUI.getText(findTestObject('Dashboard/accountname'))
// Menyimpan nama akun yang diambil ke dalam file teks
CustomKeywords.'dashboard_getnamaakun.CreateFileAccountName.generatedFileAccount'(accountname)

WebUI.closeBrowser()