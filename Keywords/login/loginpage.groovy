package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RC
import java.text.SimpleDateFormat


public class loginpage {

	@Keyword
	def screenshoot () {
		// Ambil folder project
		String projectDir = RC.getProjectDir()

		// Buat timestamp
		String timestamp = new Date().format("dd-MM-yyyy_HH-mm-ss")

		// Buat path penyimpanan
		String screenshotPath = projectDir + "/Screenshots/Login/login_page_" + timestamp + ".png"

		// Ambil screenshot full page
		WebUI.takeFullPageScreenshot(screenshotPath)

		// Tampilkan log informasi di console
		println("Screenshot disimpan di: " + screenshotPath)
	}
}
