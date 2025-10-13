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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.callTestCase(findTestCase('Registration/RegistrationScreen/RegistrationScreen'), [:], FailureHandling.OPTIONAL)

WebUI.delay(3)

def data = findTestData('TestDataStudentRegistration')

String firstName = data.getValue('first_name', 1)

CustomKeywords.'registration.student_registrationform.InputField'(firstName, 'Registration/FirstName')

String lastName = data.getValue('last_name', 1)

CustomKeywords.'registration.student_registrationform.InputField'(lastName, 'Registration/LastName')

String email = data.getValue('email_user', 1)

CustomKeywords.'registration.student_registrationform.InputField'(email, 'Registration/UserEmail')

String gender = data.getValue('gender_user', 1)

CustomKeywords.'registration.student_registrationform.SelectGender'(gender)

String mobile = data.getValue('mobile_user', 1)

CustomKeywords.'registration.student_registrationform.InputField'(mobile, 'Registration/UserNumber')

//String dateofBirth = data.getValue('dateofbirth_user', 1)
//
//CustomKeywords.'registration.student_registrationform.setDate'(dateofBirth, 'Registration/DateofBirth', 'dd MMM yyyy')
WebUI.click(findTestObject('Registration/Subjects'))

String subjects = data.getValue('subjects_user', 5)

CustomKeywords.'registration.student_registrationform.selectSubjects'(subjects, 'Registration/Subjects')

String hobbies = data.getValue('hobbies_user', 4)

CustomKeywords.'registration.student_registrationform.selectHobby'(hobbies)

def filePath = findTestData('TestDataStudentRegistration').getValue('picture_user', 1)

CustomKeywords.'registration.student_registrationform.uploadFile'(findTestObject('Registration/UploadPicture'), filePath)

String address = data.getValue('address_user', 1)

CustomKeywords.'registration.student_registrationform.InputField'(address, 'Registration/CurrentAddress')

String state = data.getValue('state_user', 1)

CustomKeywords.'registration.student_registrationform.selectDropdown'(state, 'Registration/State')

String city = data.getValue('city_user', 1)

CustomKeywords.'registration.student_registrationform.selectDropdown'(city, 'Registration/City')

WebUI.delay(3)

CustomKeywords.'registration.student_registrationform.takeScreenshotWithTimestamp'()

WebUI.click(findTestObject('Registration/button_Submit'))

WebUI.verifyTextPresent('Thanks for submitting the form', true)

WebUI.delay(3)

CustomKeywords.'registration.student_registrationform.takeScreenshotWithTimestamp'()

WebUI.click(findTestObject('Registration/button_closeModal'))

