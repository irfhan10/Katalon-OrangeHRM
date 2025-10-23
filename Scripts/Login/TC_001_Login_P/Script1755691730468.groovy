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

WebUI.delay(3)

WebUI.refresh()

// Input username & password
try {
    // Username
    username = findTestData('TestDataLogin').getValue('Username', 1)

    if ((username != null) && (username.trim() != '')) {
        WebUI.click(findTestObject('Login/input_Username'))

        WebUI.setText(findTestObject('Login/input_Username'), username)

        KeywordUtil.markPassed('Berhasil input Username')
    } else {
        KeywordUtil.markFailed('Gagal input Username')
    }
    
    // Password
    encryptedPassword = findTestData('TestDataLogin').getValue('Password', 1)

    if ((encryptedPassword != null) && (encryptedPassword.trim() != '')) {
        WebUI.click(findTestObject('Login/input_Password'))

        WebUI.setEncryptedText(findTestObject('Login/input_Password'), encryptedPassword)

        KeywordUtil.markPassed('Berhasil input Password')
    } else {
        KeywordUtil.markFailed('Gagal input Password')
    }
}
catch (Exception e) {
    KeywordUtil.markFailed('Terjadi error saat login: ' + e.message)
} 

WebUI.click(findTestObject('Login/button_Login'))

WebUI.delay(3)

// Verifikasi URL
dashboard_link = WebUI.getUrl()

try {
    String expectedUrl = findTestData('TestDataLogin').getValue('url', 2)

    String actualUrl = dashboard_link

    WebUI.comment('Expected: ' + expectedUrl)

    WebUI.comment('Actual: ' + actualUrl)

    if (WebUI.verifyMatch(actualUrl, expectedUrl, false, FailureHandling.CONTINUE_ON_FAILURE)) {
        KeywordUtil.markPassed('URL sesuai dengan data test.')
    } else {
        KeywordUtil.markFailed('URL tidak sesuai dengan data test.')
    }
}
catch (Exception e) {
    KeywordUtil.markFailed('Terjadi error saat verifikasi URL: ' + e.message)
} 

WebUI.delay(3)

// Screenshoot
CustomKeywords.'login.loginpage.screenshoot'()

WebUI.closeBrowser()

