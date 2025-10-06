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
import com.kms.katalon.core.testobject.TestObject

WebUI.openBrowser(GlobalVariable.urlRegist)

WebUI.maximizeWindow()

List<TestObject> elements = [
	findTestObject('Registration/FirstName'),
	findTestObject('Registration/LastName'),
	findTestObject('Registration/UserEmail'),
	findTestObject('Registration/gender_Male'),
	findTestObject('Registration/gender_Female'),
	findTestObject('Registration/UserNumber'),
	findTestObject('Registration/DateofBirth'),
	findTestObject('Registration/Subjects'),
	findTestObject('Registration/hobbies_Sport'),
	findTestObject('Registration/hobbies_Reading'),
	findTestObject('Registration/hobbies_Music'),
	findTestObject('Registration/UploadPicture'),
	findTestObject('Registration/CurrentAddress'),
	findTestObject('Registration/State'),
	findTestObject('Registration/City'),
	findTestObject('Registration/button_Submit')
]

// Looping untuk verifikasi semua elemen
for (TestObject element : elements) {
	if (WebUI.verifyElementVisible(element, FailureHandling.OPTIONAL)) {
		KeywordUtil.logInfo("Element ${element.getObjectId()} Terlihat")
	} else {
		KeywordUtil.logInfo("Element ${element.getObjectId()} Tidak Terlihat")
	}
}
