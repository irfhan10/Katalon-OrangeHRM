package dashboard_getnamaakun

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
import org.apache.commons.io.FileUtils as FileUtils
import java.io.File as File

public class CreateFileAccountName {

	@Keyword
	def generatedFileAccount(String nama) {
		try {
			File myObj = new File("C://Katalon Studio//OrangeHRM//NamaUser//"+nama+".txt");
			if (myObj.createNewFile()) {
				FileWriter myWriter = new FileWriter("C://Katalon Studio//OrangeHRM//NamaUser//"+nama+".txt");
				myWriter.write(nama);
				myWriter.close();
			} else {
				System.out.println("File already exist.");
			}
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}

	@Keyword
	def readFileAccount(String nama) {
		try {
			File myObj = new File("C://Katalon Studio//OrangeHRM//NamaUser//"+nama+".txt");
			String data = FileUtils.readFileToString(myObj)
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}
